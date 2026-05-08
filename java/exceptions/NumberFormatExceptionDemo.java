// ─────────────────────────────────────────────
//  NumberFormatException
//  Thrown when converting a String to a number
//  but the string doesn't represent a valid number.
// ─────────────────────────────────────────────

public class NumberFormatExceptionDemo {

    public static void main(String[] args) {

        // ── Example 1: Parsing a non-numeric string ─────────────────────
        System.out.println("=== Example 1: Non-numeric string ===");
        try {
            int num = Integer.parseInt("hello");  // throws NumberFormatException
            System.out.println("Parsed: " + num);
        } catch (NumberFormatException e) {
            System.out.println("Caught: " + e.getMessage());
            // Output: For input string: "hello"
        }

        // ── Example 2: Float value string into parseInt ─────────────────
        System.out.println("\n=== Example 2: Float string into parseInt ===");
        try {
            int num = Integer.parseInt("3.14");  // throws NFE (use parseDouble instead)
            System.out.println("Parsed: " + num);
        } catch (NumberFormatException e) {
            System.out.println("Caught: " + e.getMessage());
        }

        // ── Example 3: Empty string ─────────────────────────────────────
        System.out.println("\n=== Example 3: Empty string ===");
        try {
            int num = Integer.parseInt("");  // throws NFE
            System.out.println("Parsed: " + num);
        } catch (NumberFormatException e) {
            System.out.println("Caught: empty string can't be parsed");
        }

        // ── Example 4: String with spaces ──────────────────────────────
        System.out.println("\n=== Example 4: String with extra spaces ===");
        try {
            int num = Integer.parseInt(" 42 ");  // throws NFE
            System.out.println("Parsed: " + num);
        } catch (NumberFormatException e) {
            System.out.println("Caught: leading/trailing spaces cause NFE");
            // Fix: use .trim() first
            int fixed = Integer.parseInt(" 42 ".trim());
            System.out.println("Fixed with .trim(): " + fixed);
        }

        // ── Example 5: Overflow (too large for int) ─────────────────────
        System.out.println("\n=== Example 5: Value too large for int ===");
        try {
            int num = Integer.parseInt("99999999999");  // max int is ~2.1 billion
            System.out.println("Parsed: " + num);
        } catch (NumberFormatException e) {
            System.out.println("Caught: value exceeds int range. Use Long.parseLong()");
            long bigNum = Long.parseLong("99999999999");
            System.out.println("As long: " + bigNum);
        }

        // ── Fix: Safe parsing with a helper method ──────────────────────
        System.out.println("\n=== Fix: Safe parsing helper ===");
        System.out.println(safeParseInt("42"));       // 42
        System.out.println(safeParseInt("abc"));      // -1
        System.out.println(safeParseInt("  100 "));   // 100
        System.out.println(safeParseInt(null));        // -1
    }

    // Returns a default of -1 if parsing fails
    static int safeParseInt(String input) {
        if (input == null) return -1;
        try {
            return Integer.parseInt(input.trim());
        } catch (NumberFormatException e) {
            System.out.println("[safeParseInt] Invalid input: \"" + input + "\"");
            return -1;
        }
    }
}
