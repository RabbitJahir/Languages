try:
    name = str(input("Name: ").strip())
    age = int(input("Age: ").strip())
    dep = str(input("Dep: ").strip())

    print(f"{name} is {age} years old and studies in the {dep} department.")

except:
    print("Enter valid data bruh")