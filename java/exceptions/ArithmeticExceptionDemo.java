// ─────────────────────────────────────────────
//  ArithmeticException
//  Thrown when an illegal arithmetic operation
//  is performed, most commonly integer divide-by-zero.
// ─────────────────────────────────────────────

public class ArithmeticExceptionDemo {

    public static void main(String[] args) {

        // ── Example 1: Integer divide by zero ──────────────────────────
        System.out.println("=== Example 1: Divide by zero ===");
        try {
            int a = 10;
            int b = 0;
            int result = a / b;  // throws ArithmeticException
            System.out.println("Result: " + result);
        } catch (ArithmeticException e) {
            System.out.println("Caught: " + e.getMessage());
            // Output: Caught: / by zero
        }

        // ── Example 2: Modulo by zero ───────────────────────────────────
        System.out.println("\n=== Example 2: Modulo by zero ===");
        try {
            int remainder = 10 % 0;  // also throws ArithmeticException
            System.out.println("Remainder: " + remainder);
        } catch (ArithmeticException e) {
            System.out.println("Caught: " + e.getMessage());
        }

        // ── Note: floating-point does NOT throw, returns Infinity / NaN ─
        System.out.println("\n=== Note: Double divide by zero (no exception!) ===");
        double x = 10.0 / 0.0;
        double y = 0.0 / 0.0;
        System.out.println("10.0 / 0.0 = " + x);  // Infinity
        System.out.println("0.0  / 0.0 = " + y);   // NaN

        // ── Example 3: Safe division with guard ────────────────────────
        System.out.println("\n=== Example 3: Safe division ===");
        System.out.println("10 / 2  = " + safeDivide(10, 2));
        System.out.println("10 / 0  = " + safeDivide(10, 0));
    }

    // Guard against divide-by-zero before it happens
    static int safeDivide(int numerator, int denominator) {
        if (denominator == 0) {
            System.out.println("[Guard] Denominator is zero — returning 0.");
            return 0;
        }
        return numerator / denominator;
    }
}
