// ─────────────────────────────────────────────
//  NullPointerException (NPE)
//  Thrown when you try to use a null reference
//  as if it were a real object.
// ─────────────────────────────────────────────

public class NullPointerExceptionDemo {

    static class User {
        String name;
        String email;

        User(String name, String email) {
            this.name  = name;
            this.email = email;
        }
    }

    public static void main(String[] args) {

        // ── Example 1: Calling method on null ──────────────────────────
        System.out.println("=== Example 1: Method call on null ===");
        try {
            String text = null;
            int len = text.length();  // throws NullPointerException
            System.out.println("Length: " + len);
        } catch (NullPointerException e) {
            System.out.println("Caught NPE: cannot call .length() on null");
        }

        // ── Example 2: Accessing field of null object ───────────────────
        System.out.println("\n=== Example 2: Field access on null object ===");
        try {
            User user = null;
            System.out.println(user.name);  // throws NullPointerException
        } catch (NullPointerException e) {
            System.out.println("Caught NPE: user object is null");
        }

        // ── Example 3: Null element in array ───────────────────────────
        System.out.println("\n=== Example 3: Null element in array ===");
        try {
            String[] names = new String[3];  // all elements default to null
            System.out.println(names[0].toUpperCase());  // throws NPE
        } catch (NullPointerException e) {
            System.out.println("Caught NPE: array element is null");
        }

        // ── Fix 1: Null check before use ────────────────────────────────
        System.out.println("\n=== Fix 1: Null check ===");
        String value = null;
        if (value != null) {
            System.out.println(value.length());
        } else {
            System.out.println("Value is null — skipping.");
        }

        // ── Fix 2: Using a default value ────────────────────────────────
        System.out.println("\n=== Fix 2: Default fallback ===");
        String input = null;
        String safe = (input != null) ? input : "default";
        System.out.println("Safe value: " + safe);

        // ── Fix 3: String comparison — always call on the literal ───────
        System.out.println("\n=== Fix 3: Safe String comparison ===");
        String status = null;
        // BAD:  status.equals("active")  → NPE
        // GOOD: put the known non-null on the left
        boolean isActive = "active".equals(status);
        System.out.println("Is active? " + isActive);  // false, no exception
    }
}
