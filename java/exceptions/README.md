# Java Exception Demo Files

A collection of well-commented Java files, each demonstrating one exception:
how it's triggered, why it happens, and how to fix it.

---

## Files

| File | Exception | Type |
|---|---|---|
| `ArithmeticExceptionDemo.java` | `ArithmeticException` | Unchecked |
| `NullPointerExceptionDemo.java` | `NullPointerException` | Unchecked |
| `ArrayIndexOutOfBoundsDemo.java` | `ArrayIndexOutOfBoundsException` | Unchecked |
| `NumberFormatExceptionDemo.java` | `NumberFormatException` | Unchecked |
| `ClassCastExceptionDemo.java` | `ClassCastException` | Unchecked |
| `StackOverflowDemo.java` | `StackOverflowError` | Error |
| `IllegalArgumentExceptionDemo.java` | `IllegalArgumentException` | Unchecked |
| `FileNotFoundExceptionDemo.java` | `FileNotFoundException` / `IOException` | Checked |
| `ConcurrentModificationExceptionDemo.java` | `ConcurrentModificationException` | Unchecked |
| `InterruptedExceptionDemo.java` | `InterruptedException` | Checked |
| `CustomExceptionDemo.java` | Custom checked & unchecked exceptions | Both |

---

## How to Compile & Run

Each file is standalone. Compile and run individually:

```bash
# Compile
javac ArithmeticExceptionDemo.java

# Run
java ArithmeticExceptionDemo
```

To compile all at once:
```bash
javac *.java
```

> Requires Java 16+ for `instanceof` pattern matching in `ClassCastExceptionDemo`.
> All others work with Java 8+.

---

## What Each File Covers

### `ArithmeticExceptionDemo.java`
- Integer and modulo divide-by-zero
- Why `double / 0.0` returns `Infinity` instead of throwing
- Safe division helper method

### `NullPointerExceptionDemo.java`
- Method call on null, field access on null, null array elements
- Null check guard, default value fallback
- Safe `String.equals()` pattern (literal on the left)

### `ArrayIndexOutOfBoundsDemo.java`
- Index too high, negative index, classic off-by-one loop bug
- Manual bounds check, enhanced for-loop, correct `<` boundary

### `NumberFormatExceptionDemo.java`
- Non-numeric strings, float string into `parseInt`, empty string
- Strings with spaces (fix: `.trim()`), integer overflow
- `safeParseInt()` helper with null and format handling

### `ClassCastExceptionDemo.java`
- Wrong downcast in class hierarchy, raw `List` with mixed types
- `instanceof` check before casting
- Pattern matching `instanceof` (Java 16+)
- Typed generics to prevent the issue at compile time

### `StackOverflowDemo.java`
- Simple infinite recursion, indirect A→B→A cycle
- Circular `toString()` via linked nodes
- Proper base case in recursion, iterative alternative

### `IllegalArgumentExceptionDemo.java`
- Throwing manually to enforce method contracts
- `BankAccount` class with validated deposit, withdraw, balance
- Age range validation, `Thread.sleep()` with negative millis

### `FileNotFoundExceptionDemo.java`
- `FileReader` and `BufferedReader` on missing files
- Check `file.exists()` before opening
- Full write → read cycle with `BufferedWriter`
- Modern `java.nio.file.Files` API

### `ConcurrentModificationExceptionDemo.java`
- Removing and adding inside a for-each loop
- Five fixes: `Iterator.remove()`, `removeIf()`, collect-then-remove,
  stream filter, `CopyOnWriteArrayList`

### `InterruptedExceptionDemo.java`
- Interrupting `Thread.sleep()`, a counting loop, and `Object.wait()`
- Restoring the interrupt flag with `Thread.currentThread().interrupt()`
- Why you must never silently swallow `InterruptedException`

### `CustomExceptionDemo.java`
- Checked exception extending `Exception` (with extra fields)
- Unchecked exception extending `RuntimeException`
- App-level exception hierarchy with error codes
- Cause chaining, catching by parent type
