// ─────────────────────────────────────────────
//  ArrayIndexOutOfBoundsException
//  Thrown when accessing an array with an index
//  that is negative or >= the array's length.
// ─────────────────────────────────────────────

public class ArrayIndexOutOfBoundsDemo {

    public static void main(String[] args) {

        // ── Example 1: Index too high ───────────────────────────────────
        System.out.println("=== Example 1: Index too high ===");
        try {
            int[] numbers = {10, 20, 30};  // valid indices: 0, 1, 2
            System.out.println(numbers[5]); // throws AIOOBE
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Caught: " + e.getMessage());
            // Output: Index 5 out of bounds for length 3
        }

        // ── Example 2: Negative index ───────────────────────────────────
        System.out.println("\n=== Example 2: Negative index ===");
        try {
            int[] numbers = {10, 20, 30};
            System.out.println(numbers[-1]);  // throws AIOOBE
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Caught: " + e.getMessage());
        }

        // ── Example 3: Off-by-one in a loop (classic bug) ──────────────
        System.out.println("\n=== Example 3: Off-by-one loop ===");
        int[] scores = {85, 90, 78, 92, 88};
        try {
            // BUG: should be i < scores.length, not i <= scores.length
            for (int i = 0; i <= scores.length; i++) {
                System.out.println("Score[" + i + "] = " + scores[i]);
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Caught off-by-one: " + e.getMessage());
        }

        // ── Fix 1: Bounds check before access ──────────────────────────
        System.out.println("\n=== Fix 1: Manual bounds check ===");
        int[] data = {1, 2, 3};
        int index = 5;
        if (index >= 0 && index < data.length) {
            System.out.println("data[" + index + "] = " + data[index]);
        } else {
            System.out.println("Index " + index + " is out of bounds (length=" + data.length + ")");
        }

        // ── Fix 2: Use enhanced for-loop to avoid index issues ─────────
        System.out.println("\n=== Fix 2: Enhanced for-loop (safest) ===");
        String[] fruits = {"apple", "banana", "cherry"};
        for (String fruit : fruits) {
            System.out.println(fruit);
        }

        // ── Fix 3: Correct loop boundary ───────────────────────────────
        System.out.println("\n=== Fix 3: Correct loop (<, not <=) ===");
        for (int i = 0; i < scores.length; i++) {
            System.out.println("Score[" + i + "] = " + scores[i]);
        }
    }
}
