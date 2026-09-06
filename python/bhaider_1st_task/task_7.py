try:
    num1 = float(input("Enter first number: "))
    num2 = float(input("Enter second number: "))

    print(f"Sum: {num1 + num2}")
    print(f"Difference: {num1 - num2}")
    print(f"Product: {num1 * num2}")
    print(f"Division: {(num1 / num2) if num2 != 0 else 'no'}") 
except:
    print("error bro")