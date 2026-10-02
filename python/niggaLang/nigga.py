import sys

if len(sys.argv)!=2:
    print("usage: python3 nigga.py <file.nigga>")
    sys.exit(1)

filename = sys.argv[1]

with open(filename, "r") as file:
    code = file.read()

variables = {}

lines = code.splitlines()

for line in lines:
    line = line.strip()

    if not line:
        continue

    if line.startswith('#'):
        continue

    if line.startswith('Nigga '):
        declaration = line[6:]

        name, value = declaration.split("=",1)

        name = name.strip()
        value = value.strip()

        if value.startswith('"') and value.endswith('"'):
            value = value[1:-1]

        variables[name] = value

    elif line.startswith("niggaSay "):
        value = line[9:].strip()

        if value.startswith('"') and value.endswith('"'):
            value = value[1:-1]
        elif value in variables:
            value = variables[value]
        
        print(value)