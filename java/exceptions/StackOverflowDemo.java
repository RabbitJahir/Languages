// ─────────────────────────────────────────────
//  StackOverflowError
//  Thrown when the call stack runs out of space,
//  almost always caused by infinite recursion.
// ─────────────────────────────────────────────

public class StackOverflowDemo {

    // ── Example 1: Simple infinite recursion ───────────────────────────
    static void infiniteRecursion() {
        System.out.println("Going deeper...");
        infiniteRecursion();  // calls itself with no base case
    }

    // ── Example 2: Indirect recursion (A → B → A) ──────────────────────
    static void methodA() { methodB(); }
    static void methodB() { methodA(); }  // ping-pong with no exit

    // ── Example 3: Mutual toString() loop ──────────────────────────────
    static class Node {
        String value;
        Node next;

        Node(String value) { this.value = value; }

        @Override
        public String toString() {
            // BUG: if next points back to this node, infinite recursion!
            return "Node(" + value + " -> " + next + ")";
        }
    }

    // ── FIXED: Recursive factorial with a proper base case ─────────────
    static long factorial(int n) {
        if (n <= 1) return 1;     // base case — stops the recursion
        return n * factorial(n - 1);
    }

    // ── FIXED: Iterative version (safer for large n) ───────────────────
    static long factorialIterative(int n) {
        long result = 1;
        for (int i = 2; i <= n; i++) {
            result *= i;
        }
        return result;
    }

    public static void main(String[] args) {

        // ── Trigger StackOverflowError ──────────────────────────────────
        System.out.println("=== Example 1: Infinite recursion ===");
        try {
            infiniteRecursion();
        } catch (StackOverflowError e) {
            System.out.println("Caught StackOverflowError: call stack exhausted!");
        }

        // ── Trigger indirect recursion ──────────────────────────────────
        System.out.println("\n=== Example 2: Indirect recursion (A→B→A) ===");
        try {
            methodA();
        } catch (StackOverflowError e) {
            System.out.println("Caught StackOverflowError from indirect cycle!");
        }

        // ── toString() circular reference ──────────────────────────────
        System.out.println("\n=== Example 3: Circular toString() ===");
        try {
            Node n1 = new Node("first");
            Node n2 = new Node("second");
            n1.next = n2;
            n2.next = n1;  // circular! n1→n2→n1→n2...
            System.out.println(n1);  // toString() recurses infinitely
        } catch (StackOverflowError e) {
            System.out.println("Caught StackOverflowError from circular toString()!");
        }

        // ── Safe recursive factorial ────────────────────────────────────
        System.out.println("\n=== Fix: Proper recursive factorial ===");
        for (int i = 0; i <= 10; i++) {
            System.out.println(i + "! = " + factorial(i));
        }

        // ── Iterative alternative ───────────────────────────────────────
        System.out.println("\n=== Fix: Iterative factorial (handles large n) ===");
        System.out.println("20! = " + factorialIterative(20));
    }
}
