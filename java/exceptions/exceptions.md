# Java Exception & Error Reference

> **Quick Rule:**
> - `Error` — JVM-level, **don't catch**
> - `RuntimeException` (Unchecked) — optional to catch, usually a **bug**
> - `Exception` subclasses (Checked) — **must** be caught or declared with `throws`

---

## `java.lang` — Errors (Unchecked, JVM-level)

| Class | Description |
|---|---|
| `Error` | Base class for all JVM-level errors. Not meant to be caught. |
| `AssertionError` | Thrown when an `assert` statement fails. |
| `ThreadDeath` | Thrown when a thread is forcibly stopped via deprecated `Thread.stop()`. |
| `StackOverflowError` | Thrown when the call stack exceeds its limit, usually from infinite recursion. |
| `OutOfMemoryError` | Thrown when the JVM can't allocate memory (heap full). |
| `VirtualMachineError` | Base class for JVM internal errors like `StackOverflowError` and `OutOfMemoryError`. |
| `InternalError` | Thrown for unexpected internal JVM errors. |
| `UnknownError` | Thrown for unknown JVM errors. |
| `ExceptionInInitializerError` | Thrown when a static initializer block throws an exception. |
| `AssertionError` | Thrown when an `assert` expression evaluates to `false`. |

---

## `java.lang` — LinkageError (Unchecked)

These occur during class loading or linking.

| Class | Description |
|---|---|
| `LinkageError` | Base class for errors in class linking. |
| `NoClassDefFoundError` | Class was found at compile time but is missing at runtime. |
| `UnsatisfiedLinkError` | Native library required by `native` method cannot be found. |
| `ClassCircularityError` | Circular class inheritance detected during loading. |
| `ClassFormatError` | Class file is malformed or corrupted. |
| `IncompatibleClassChangeError` | Class definition has changed incompatibly after compilation. |
| `AbstractMethodError` | Application tries to call an abstract method directly. |
| `IllegalAccessError` | Tries to access a field or method it doesn't have permission to. |
| `InstantiationError` | Tries to instantiate an abstract class or interface via bytecode. |
| `NoSuchFieldError` | Field referenced no longer exists in the class. |
| `NoSuchMethodError` | Method referenced no longer exists in the class. |
| `VerifyError` | Bytecode fails JVM verification. |

---

## `java.lang` — RuntimeException (Unchecked)

These are programming bugs. Compiler doesn't require you to handle them.

| Class | Description |
|---|---|
| `RuntimeException` | Base class for all unchecked exceptions. |
| `ArithmeticException` | Illegal arithmetic, e.g. dividing an integer by zero. |
| `NullPointerException` | Attempting to use a `null` reference. |
| `ClassCastException` | Casting an object to an incompatible type. |
| `ArrayIndexOutOfBoundsException` | Accessing an array with an index outside its bounds. |
| `StringIndexOutOfBoundsException` | Accessing a `String` character with an invalid index. |
| `IndexOutOfBoundsException` | Base class for index-related out-of-bounds exceptions. |
| `NegativeArraySizeException` | Trying to create an array with a negative size. |
| `ArrayStoreException` | Storing the wrong object type into a typed array. |
| `NumberFormatException` | Parsing a string into a number when the format is invalid. |
| `IllegalArgumentException` | A method receives an illegal or inappropriate argument. |
| `IllegalStateException` | Method called at an inappropriate time or invalid object state. |
| `IllegalThreadStateException` | Thread operation attempted in an illegal state (e.g. starting a dead thread). |
| `UnsupportedOperationException` | Calling a method that is not implemented or not supported. |
| `ConcurrentModificationException` | A collection is modified while being iterated. |
| `EmptyStackException` | Calling `pop()` or `peek()` on an empty stack. |
| `NoSuchElementException` | Iterator or scanner has no more elements to return. |
| `InputMismatchException` | `Scanner` input doesn't match the expected type. |
| `FormatterClosedException` | Using a `Formatter` after it has been closed. |
| `IllegalFormatException` | Invalid format string passed to `String.format()` or similar. |
| `SecurityException` | Security manager denies the requested operation. |
| `TypeNotPresentException` | An annotation references a type that isn't available at runtime. |
| `EnumConstantNotPresentException` | Annotation references an enum constant that doesn't exist. |
| `CloneNotSupportedException` | `clone()` called on an object that doesn't implement `Cloneable`. *(Actually checked)* |
| `AnnotationTypeMismatchException` | Annotation type has changed since being compiled. |
| `IncompleteAnnotationException` | Annotation element has no default and no value was provided. |

---

## `java.lang` — Checked Exceptions

Must be handled with `try/catch` or declared with `throws`.

| Class | Description |
|---|---|
| `Exception` | Root class for all checked exceptions. |
| `CloneNotSupportedException` | `clone()` called but `Cloneable` is not implemented. |
| `InterruptedException` | A sleeping or waiting thread is interrupted by another thread. |
| `ClassNotFoundException` | Class can't be found when loading dynamically (e.g. `Class.forName()`). |
| `InstantiationException` | Trying to instantiate an abstract class or interface via reflection. |
| `IllegalAccessException` | Reflection tries to access a field or method without permission. |
| `NoSuchFieldException` | Reflection can't find the specified field. |
| `NoSuchMethodException` | Reflection can't find the specified method. |
| `ReflectiveOperationException` | Base class for reflection-related checked exceptions. |

---

## `java.io` — IOException (Checked)

| Class | Description |
|---|---|
| `IOException` | Base class for I/O failures. |
| `FileNotFoundException` | File does not exist or cannot be opened. |
| `EOFException` | Reached end of file unexpectedly during read. |
| `SyncFailedException` | `FileDescriptor.sync()` couldn't flush to hardware. |
| `UnsupportedEncodingException` | Specified character encoding is not supported. |
| `UTFDataFormatException` | Malformed UTF-8 data encountered during read. |
| `NotSerializableException` | Object being serialized doesn't implement `Serializable`. |
| `InvalidClassException` | Serialized class is incompatible with current class definition. |
| `StreamCorruptedException` | Control data in the object stream is inconsistent. |
| `OptionalDataException` | Unexpected primitive data found when reading an object. |
| `WriteAbortedException` | Serialization stream was closed due to an exception during write. |
| `ObjectStreamException` | Base class for object serialization exceptions. |
| `InvalidObjectException` | Object read from stream fails validation. |
| `NotActiveException` | Called a serialization method outside of a valid serialization context. |
| `CharConversionException` | Error during character encoding/decoding conversion. |
| `InterruptedIOException` | I/O operation was interrupted by `Thread.interrupt()`. |
| `ClosedChannelException` | I/O operation on a closed NIO channel. *(java.nio.channels)* |
| `FileLockInterruptionException` | Thread interrupted while waiting for a file lock. *(java.nio.channels)* |

---

## `java.net` — Networking Exceptions (Checked)

| Class | Description |
|---|---|
| `MalformedURLException` | A string is not a valid URL. |
| `UnknownHostException` | Hostname can't be resolved to an IP address. |
| `ConnectException` | Connection refused by the remote host. |
| `SocketException` | General socket-level error. |
| `SocketTimeoutException` | Socket operation timed out. |
| `NoRouteToHostException` | Network route to the host doesn't exist. |
| `BindException` | Socket can't bind to the local address/port. |
| `PortUnreachableException` | ICMP port unreachable message received. |
| `HttpRetryException` | HTTP request needs to be retried but auto-retry isn't possible. |
| `URISyntaxException` | String can't be parsed as a valid URI. |

---

## `java.sql` — SQL Exceptions (Checked)

| Class | Description |
|---|---|
| `SQLException` | Base class for database access errors. |
| `SQLWarning` | Non-fatal database warning. |
| `DataTruncation` | Data was truncated unexpectedly during read or write. |
| `BatchUpdateException` | Error during a batch SQL update operation. |
| `SQLClientInfoException` | Failure when setting client info properties on a connection. |
| `SQLIntegrityConstraintViolationException` | Constraint (e.g. unique, foreign key) violated. |
| `SQLInvalidAuthorizationSpecException` | Invalid authorization credentials. |
| `SQLNonTransientException` | SQL error that won't succeed on retry without fixing the cause. |
| `SQLTransientException` | SQL error that may succeed if retried. |
| `SQLFeatureNotSupportedException` | JDBC driver doesn't support the called feature. |
| `SQLDataException` | Problem with data values (type mismatch, overflow, etc.). |
| `SQLSyntaxErrorException` | SQL statement has a syntax error. |
| `SQLTransactionRollbackException` | Transaction was rolled back, possibly due to a deadlock. |
| `SQLTimeoutException` | SQL operation exceeded the timeout period. |

---

## `java.util` — Utility Exceptions

| Class | Description |
|---|---|
| `NoSuchElementException` | Iterator or `Optional` has no element to return. |
| `EmptyStackException` | `Stack.pop()` or `peek()` called on empty stack. |
| `MissingResourceException` | `ResourceBundle` can't find a required resource. |
| `ConcurrentModificationException` | Collection modified during iteration. |
| `InputMismatchException` | `Scanner` token doesn't match expected type. |
| `FormatterClosedException` | `Formatter` used after being closed. |
| `IllegalFormatException` | Invalid format string argument. |
| `TooManyListenersException` | More than one listener registered where only one is allowed. |
| `ServiceConfigurationError` | Error loading a service provider. *(technically an Error)* |
| `InvalidPropertiesFormatException` | Properties XML is malformed. |

---

## `java.util.concurrent` — Concurrency Exceptions

| Class | Description |
|---|---|
| `TimeoutException` | Blocking operation timed out waiting for a result. |
| `ExecutionException` | Exception thrown during async task execution in `Future.get()`. |
| `RejectedExecutionException` | `Executor` can't accept a new task (e.g. thread pool is full). |
| `BrokenBarrierException` | A thread waiting at a `CyclicBarrier` barrier was broken. |
| `CancellationException` | Result of a cancelled task was accessed. |
| `CompletionException` | Wraps an exception that occurred in a `CompletableFuture`. |

---

## `java.lang.reflect` — Reflection Exceptions

| Class | Description |
|---|---|
| `InvocationTargetException` | Wraps exception thrown by a reflectively-invoked method. |
| `MalformedParameterizedTypeException` | Parameterized type is malformed or invalid. |
| `MalformedParametersException` | Method parameter metadata is malformed. |
| `InaccessibleObjectException` | Module system denies reflective access to a member. |

---

## `java.text` — Text/Parsing Exceptions

| Class | Description |
|---|---|
| `ParseException` | Parsing error at a specific position in a string. |

---

## `java.security` — Security Exceptions

| Class | Description |
|---|---|
| `GeneralSecurityException` | Base class for security-related exceptions. |
| `NoSuchAlgorithmException` | Requested cryptographic algorithm is unavailable. |
| `KeyException` | Base class for key-related exceptions. |
| `InvalidKeyException` | Key is invalid or inappropriate for the operation. |
| `KeyManagementException` | Error in key management operations. |
| `SignatureException` | Error during signing or signature verification. |
| `CertificateException` | Certificate error during encoding/decoding. |
| `NoSuchProviderException` | Security provider is not available. |
| `InvalidAlgorithmParameterException` | Algorithm parameter is invalid. |
| `DigestException` | Error in message digest operations. |

---

## `javax.naming` — JNDI Exceptions

| Class | Description |
|---|---|
| `NamingException` | Base class for naming/directory service errors. |
| `NameNotFoundException` | Name can't be found in the naming service. |
| `AuthenticationException` | Authentication failure when accessing naming service. |
| `CommunicationException` | Communication failure with the naming service. |

---

*Reference: [Java SE API Documentation](https://docs.oracle.com/en/java/docs/api/)*