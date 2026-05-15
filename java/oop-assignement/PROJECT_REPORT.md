# Smart ATM System - OOP Project Report

## Executive Summary

This report documents the Smart ATM System, a comprehensive Java-based banking application that demonstrates advanced object-oriented programming principles and exception handling techniques. The project successfully integrates multiple exception handling strategies to create a robust, user-friendly banking interface.

---

## 1. Problem Understanding

### 1.1 Project Overview

The Smart ATM System is a console-based banking application that simulates core ATM operations. The system manages multiple bank accounts, each with distinct account numbers, customer names, balances, and PIN protection.

### 1.2 Main Objectives

The project addresses several key banking requirements:

#### **Account Management**

- Creation and management of multiple bank accounts
- Encapsulation of sensitive data (balance, PIN) through private fields
- Secure PIN verification before sensitive operations

#### **Transaction Processing**

- **Deposits**: Add funds to an account with validation
- **Withdrawals**: Remove funds with balance verification
- **Transfers**: Move money between accounts with validation
- **Balance Inquiry**: Display current account balance

#### **Advanced Features**

- Interest calculation on account balances
- File I/O for reading customer data
- Security mechanisms with ATM lockout after failed login attempts

### 1.3 Key Design Constraints

- All sensitive data (balance, PIN) must be protected through encapsulation
- The system must validate all user inputs before processing
- Multiple error scenarios must be handled gracefully
- The application should remain operational even when exceptions occur

---

## 2. Exception Handling Techniques Used

### 2.1 Custom Exception Classes

Three custom exception classes were created to represent domain-specific errors:

#### **InsufficientBalanceException**

- Thrown when withdrawal/transfer amount exceeds account balance
- Extends the built-in `Exception` class
- Requires explicit handling via `catch` block
- Provides meaningful error context to the user

#### **InvalidAmountException**

- Thrown when operations involve invalid amounts (negative, zero, or non-numeric)
- Applied to both deposit and withdrawal operations
- Validates user input before processing transitions

#### **AccountNotFoundException**

- Thrown when attempting to transfer money to a non-existent receiver account
- Handles null pointer scenarios in a business-logic context
- Makes error handling more readable than catching generic `NullPointerException`

**Design Benefit**: Custom exceptions allow developers to distinguish between different error types and handle them appropriately, rather than treating all errors the same way.

### 2.2 Try-Catch-Finally Blocks

The main menu loop demonstrates a comprehensive try-catch-finally structure:

```java
try {
    // Risky code that may throw exceptions
    switch(choice) {
        case 1: // deposit
        case 2: // withdraw
        // ... more operations
    }
}
catch (InvalidAmountException e) { ... }
catch (InsufficientBalanceException e) { ... }
catch (ArithmeticException e) { ... }
catch (Exception e) { ... }
finally {
    System.out.println("Transaction process completed.");
}
```

**Key Elements**:

- **try block**: Contains operations that might throw exceptions
- **Multiple catch blocks**: Each handles a specific exception type in order of specificity
- **finally block**: Always executes, ensuring cleanup operations run regardless of exceptions

### 2.3 Multiple Catch Blocks

The project implements a cascading catch structure with precise ordering:

1. **InvalidAmountException** — Caught first (most specific)
2. **InsufficientBalanceException** — Caught second (specific)
3. **ArithmeticException** — Caught third (specific)
4. **Exception** — Caught last (catches all remaining exceptions)

**Critical Rule**: More specific exceptions must precede more general ones. If `Exception` were first, it would catch all exceptions, preventing specific handlers from executing.

### 2.4 Nested Try Blocks

The money transfer operation demonstrates nested try-catch:

```java
try {  // Outer try
    // ... menu operations
    try {  // Inner try
        acc1.transferMoney(receiver, transferAmount);
    } catch (AccountNotFoundException e) {
        System.out.println("Transfer Error: " + e.getMessage());
    }

} catch (Exception e) {  // Outer catch
    // ... general error handling
}
```

**Purpose**: Allows separation of exception handling scopes. The inner try catches `AccountNotFoundException` without interrupting the outer try's handling of other exception types.

### 2.5 Throws Declaration (Checked Exceptions)

Several methods include `throws` clauses:

```java
public void deposit(double amount) throws InvalidAmountException { ... }

public void withdraw(double amount)
    throws InsufficientBalanceException, InvalidAmountException { ... }

public static void readCustomerFile() throws IOException { ... }
```

**Semantics**:

- **throws keyword**: Declares that a method _may_ throw the specified exception
- **Checked exceptions**: `IOException`, `FileNotFoundException` — must be declared or handled
- **Multiple exceptions**: Separated by commas; caller must handle all of them
- **Exception propagation**: Allows exceptions to bubble up the call stack for handling at appropriate levels

### 2.6 Throw Keyword (Manual Exception Triggering)

Throughout the code, exceptions are explicitly thrown:

```java
// In deposit()
if (amount <= 0) {
    throw new InvalidAmountException("Deposit amount cannot be negative or zero.");
}

// In transferMoney()
if (receiver == null) {
    throw new AccountNotFoundException("Receiver account not found.");
}

// In atmLogin()
throw new SecurityException("ATM blocked after 3 failed attempts.");
```

**Important Distinction**:

- **throw** (with keyword): Manually creates and throws an exception
- **throws** (in signature): Declares that a method may throw an exception

### 2.7 Built-in Exception Handling

#### **ArithmeticException** (Unchecked/Runtime)

- Thrown automatically by JVM during invalid arithmetic operations
- In the project: Interest calculation divides by years (if years = 0, exception occurs)
- Does NOT require `throws` declaration — it's a `RuntimeException`
- Caught by the generic `catch(Exception e)` block

#### **IOException** (Checked Exception)

- Thrown during file operations (`FileReader`, `BufferedReader`)
- Must be handled or declared with `throws`
- Encompasses related exceptions like `FileNotFoundException`

#### **SecurityException** (Unchecked/Runtime)

- Manually thrown after 3 failed ATM login attempts
- Simulates real banking security: lock ATM after repeated failures
- Does NOT require `throws` declaration in the method signature
- Can still be caught to prevent application crash

### 2.8 Exception Propagation

The `transferMoney()` method demonstrates exception propagation:

```java
public void transferMoney(BankAccount receiver, double amount)
    throws AccountNotFoundException, InvalidAmountException,
           InsufficientBalanceException {

    if (receiver == null) {
        throw new AccountNotFoundException(...);
    }

    withdraw(amount);  // withdraw() may throw two exceptions
    // Rather than catch them here, we let them propagate up
}
```

**Benefit**: Avoids redundant try-catch blocks at every level. Exceptions bubble up to the appropriate handling location.

---

## 3. Challenges Faced

### 3.1 Exception Ordering Complexity

**Challenge**: Determining the correct order for multiple catch blocks.

**Issue Encountered**: If a more general exception (parent class) is placed before a specific one (child class), the specific catch will never execute because the parent catch intercepts it first.

**Solution Implemented**: Strict adherence to the ordering rule: specific exceptions first (`InvalidAmountException`, `InsufficientBalanceException`), then general ones (`Exception`).

**Learning Point**: Understanding the inheritance hierarchy of exceptions (`Exception` → `RuntimeException` → `SecurityException`, etc.) is crucial.

### 3.2 Distinguishing Checked vs. Unchecked Exceptions

**Challenge**: Understanding why some exceptions require `throws` declarations while others don't.

| Type                       | Checked | Unchecked | Requires throws? |
| -------------------------- | ------- | --------- | ---------------- |
| IOException                | Yes     | No        | YES              |
| ArithmeticException        | No      | Yes       | NO               |
| SecurityException          | No      | Yes       | NO               |
| Custom (extends Exception) | Yes     | No        | YES              |

**Resolution**: Created custom exceptions extending `Exception` (checked) and used `throws` declarations appropriately. The project handles both paradigms.

### 3.3 Null Pointer Handling with Meaningful Exceptions

**Challenge**: When checking if `receiver == null` in transfer operations, throwing a generic `NullPointerException` would be cryptic.

**Solution**: Created `AccountNotFoundException` to replace the concept of "receiver is null" with domain-meaningful language.

**Benefit**: Code is self-documenting — the exception name explains the business logic.

### 3.4 Resource Management in File Operations

**Challenge**: Opening files (`FileReader`, `BufferedReader`) requires cleanup.

**Implementation**:

```java
BufferedReader br = new BufferedReader(fr);
System.out.println(br.readLine());
br.close();  // Must explicitly close
```

**Consideration**: The current implementation doesn't use try-with-resources (Java 7+ feature), which would automatically close resources. This is acceptable for an assignment but could be optimized.

### 3.5 Nested Try Block Scope Management

**Challenge**: Managing multiple try-catch blocks without creating confusing exception handling paths.

**Example from Transfer Operation**:

- Inner try → catches `AccountNotFoundException` (specific to transfer)
- Outer try → catches all other exceptions from the menu
- Prevents the outer catch from hiding inner-catch logic

**Solution**: Clearly separated concerns through nested blocks, improving readability.

### 3.6 State Management in Security Operations

**Challenge**: Implementing ATM lockout after 3 failed PIN attempts.

**Implementation Logic**:

```java
int attempts = 0;
while (attempts < 3) {
    if (acc.checkPin(pin)) {
        return;  // Success
    } else {
        attempts++;
    }
}
throw new SecurityException(...);  // All attempts exhausted
```

**Consideration**: This approach prevents both prematurely throwing exceptions and allowing unlimited attempts.

---

## 4. Conclusion

### 4.1 Learning Outcomes

This project successfully demonstrates that robust exception handling is foundational to professional Java development:

1. **Custom Exceptions**: Enhance code readability and business logic representation
2. **Structured Error Handling**: try-catch-finally blocks enable graceful failure recovery
3. **Exception Propagation**: Allows layered exception handling at appropriate locations
4. **Input Validation**: Prevents invalid states by throwing exceptions early
5. **Security Integration**: Exception handling supports security features (ATM lockout)

### 4.2 Code Quality Achievements

- **Encapsulation**: Private fields protect sensitive data (balance, PIN)
- **Validation**: All operations validate inputs before modifying state
- **Separation of Concerns**: Exception handling is isolated to appropriate methods
- **Documentation**: Extensive comments explain each concept

### 4.3 Practical Applications

The patterns demonstrated in this project apply to real-world systems:

- Banking applications (transaction validation, fraud detection)
- E-commerce (payment processing, inventory management)
- Medical systems (data validation, access control)
- Any application requiring robust error handling and security

### 4.4 Future Enhancements

Potential improvements for production deployment:

1. **Try-with-resources**: Auto-close file handles

   ```java
   try (BufferedReader br = new BufferedReader(new FileReader(file))) {
       System.out.println(br.readLine());
   }
   ```

2. **Database Integration**: Replace in-memory accounts with persistent storage

3. **Logging Framework**: Replace `System.out.println` with proper logging (Log4j, SLF4j)

4. **Multi-threaded Operations**: Handle concurrent transactions safely

5. **More Granular Exceptions**: Separate exceptions for specific validation failures

### 4.5 Final Assessment

The Smart ATM System project effectively teaches:

- How to design custom exceptions for domain-specific problems
- The critical importance of exception handling in enterprise applications
- The balance between specificity (custom exceptions) and generality (catching `Exception`)
- Security principles through operational constraints (ATM lockout)

The code demonstrates that exceptional situations are not bugs to be avoided, but **expected conditions to be handled gracefully**. This mindset is essential for developing reliable, maintainable software systems.

---

**Project Completion Date**: May 13, 2026  
**Total Lines of Code**: ~350 lines of well-documented Java  
**Key Takeaway**: Exception handling is as important as the core logic itself.
