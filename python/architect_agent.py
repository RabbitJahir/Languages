"""
Starter Architectural Agent (residential)
-----------------------------------------
Tools:
  1. calculate_area       -> plot/room area hishab
  2. check_building_code  -> coverage, FAR, setback check (PLACEHOLDER rules)

Setup:
  pip install anthropic
  export ANTHROPIC_API_KEY="your-key"
  python architect_agent.py
"""

import json
import anthropic

client = anthropic.Anthropic()  # ANTHROPIC_API_KEY env variable theke key nibe
MODEL = "claude-sonnet-5-5"
MAX_TURNS = 10  # infinite loop ropdhe

SQFT_PER_KATHA = 720  # 1 katha ~ 720 sq ft (Dhaka standard)

SYSTEM_PROMPT = """You are an experienced residential architect assistant working in Bangladesh.

Rules:
- Ask for missing key inputs first: plot size, road width, number of floors, bedrooms, budget, facing direction.
- ALWAYS use the calculate_area tool for area math. Never calculate by hand.
- ALWAYS use check_building_code before saying a design is compliant.
- The building code values from the tool may be placeholders. If the tool says so,
  clearly tell the user to verify against official BNBC / RAJUK / CDA rules.
- Give room-wise area breakdowns, practical layout suggestions, and short reasoning.
- Reply in the same language style the user uses (Bangla, English, or Banglish).
"""

# ---------------------------------------------------------------------------
# Tool definitions (Claude ke bole dey kon tool ache)
# ---------------------------------------------------------------------------
TOOLS = [
    {
        "name": "calculate_area",
        "description": (
            "Calculate plot area (sq ft and katha) from length and width in feet. "
            "Optionally calculate each room's area and the total room area."
        ),
        "input_schema": {
            "type": "object",
            "properties": {
                "plot_length_ft": {"type": "number", "description": "Plot length in feet"},
                "plot_width_ft": {"type": "number", "description": "Plot width in feet"},
                "rooms": {
                    "type": "array",
                    "description": "Optional list of rooms",
                    "items": {
                        "type": "object",
                        "properties": {
                            "name": {"type": "string"},
                            "length_ft": {"type": "number"},
                            "width_ft": {"type": "number"},
                        },
                        "required": ["name", "length_ft", "width_ft"],
                    },
                },
            },
            "required": ["plot_length_ft", "plot_width_ft"],
        },
    },
    {
        "name": "check_building_code",
        "description": (
            "Check basic building rules (ground coverage, FAR, setbacks) for a residential plot. "
            "Returns allowed limits and whether the proposed design fits."
        ),
        "input_schema": {
            "type": "object",
            "properties": {
                "plot_area_sqft": {"type": "number"},
                "road_width_ft": {"type": "number", "description": "Adjacent road width in feet"},
                "floors": {"type": "integer", "description": "Number of floors"},
                "proposed_ground_floor_sqft": {
                    "type": "number",
                    "description": "Proposed ground floor footprint in sq ft",
                },
            },
            "required": ["plot_area_sqft", "road_width_ft", "floors"],
        },
    },
]


# ---------------------------------------------------------------------------
# Tool implementations
# ---------------------------------------------------------------------------
def calculate_area(plot_length_ft, plot_width_ft, rooms=None):
    plot_area = plot_length_ft * plot_width_ft
    result = {
        "plot_area_sqft": round(plot_area, 2),
        "plot_area_katha": round(plot_area / SQFT_PER_KATHA, 2),
    }
    if rooms:
        room_list = []
        total = 0.0
        for r in rooms:
            area = r["length_ft"] * r["width_ft"]
            total += area
            room_list.append({"name": r["name"], "area_sqft": round(area, 2)})
        result["rooms"] = room_list
        result["total_room_area_sqft"] = round(total, 2)
    return result


def check_building_code(plot_area_sqft, road_width_ft, floors,
                        proposed_ground_floor_sqft=None):
    # !!! PLACEHOLDER VALUES !!!
    # Eigulo sudhu example. Nijer shohor (RAJUK/CDA/etc.) er official niyom
    # diye replace korun, ba ekta JSON file theke load korun.
    max_coverage_ratio = 0.60 if plot_area_sqft <= 3600 else 0.55
    far = 2.5 if road_width_ft < 24 else 3.5
    min_front_setback_ft = 5 if road_width_ft < 24 else 10
    min_side_setback_ft = 3.5
    min_rear_setback_ft = 3.5

    max_ground = plot_area_sqft * max_coverage_ratio
    max_total_builtup = plot_area_sqft * far

    result = {
        "WARNING": "Placeholder rules, not official. Verify with BNBC / local authority.",
        "max_ground_coverage_sqft": round(max_ground, 2),
        "max_total_builtup_sqft": round(max_total_builtup, 2),
        "far": far,
        "min_setbacks_ft": {
            "front": min_front_setback_ft,
            "side": min_side_setback_ft,
            "rear": min_rear_setback_ft,
        },
    }

    if proposed_ground_floor_sqft is not None:
        result["ground_coverage_ok"] = proposed_ground_floor_sqft <= max_ground
        total = proposed_ground_floor_sqft * floors
        result["total_builtup_ok"] = total <= max_total_builtup
        result["proposed_total_builtup_sqft"] = round(total, 2)

    return result


TOOL_FUNCTIONS = {
    "calculate_area": calculate_area,
    "check_building_code": check_building_code,
}


def run_tool(name, tool_input):
    func = TOOL_FUNCTIONS.get(name)
    if func is None:
        return json.dumps({"error": f"Unknown tool: {name}"}), True
    try:
        return json.dumps(func(**tool_input), ensure_ascii=False), False
    except Exception as e:  # tool fail korle Claude ke error ta bole dao
        return json.dumps({"error": str(e)}), True


# ---------------------------------------------------------------------------
# Agent loop
# ---------------------------------------------------------------------------
def run_agent(messages):
    """messages list update kore; final text uttor return kore."""
    for _ in range(MAX_TURNS):
        response = client.messages.create(
            model=MODEL,
            max_tokens=2000,
            system=SYSTEM_PROMPT,
            tools=TOOLS,
            messages=messages,
        )
        messages.append({"role": "assistant", "content": response.content})

        # Claude tool chaile na, mane final uttor ready
        if response.stop_reason != "tool_use":
            return "".join(b.text for b in response.content if b.type == "text")

        # Tool call gulo chalao, result ferot pathao
        tool_results = []
        for block in response.content:
            if block.type == "tool_use":
                print(f"  [tool] {block.name}({json.dumps(block.input, ensure_ascii=False)})")
                output, is_error = run_tool(block.name, block.input)
                tool_results.append({
                    "type": "tool_result",
                    "tool_use_id": block.id,
                    "content": output,
                    "is_error": is_error,
                })
        messages.append({"role": "user", "content": tool_results})

    return "Agent onek bar tool chalalo kintu final uttor dite parlo na. Abar try korun."


def main():
    print("Architect Agent ready. 'exit' likhle bondho hobe.\n")
    messages = []
    while True:
        user_input = input("Apni: ").strip()
        if user_input.lower() in {"exit", "quit"}:
            break
        if not user_input:
            continue
        messages.append({"role": "user", "content": user_input})
        print("\nAgent:", run_agent(messages), "\n")


if __name__ == "__main__":
    main()
