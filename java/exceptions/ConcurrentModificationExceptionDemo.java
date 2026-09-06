// ─────────────────────────────────────────────
//  ConcurrentModificationException
//  Thrown when a collection is structurally
//  modified while it is being iterated using
//  a standard Iterator or for-each loop.
// ─────────────────────────────────────────────

import java.util.*;
import java.util.stream.Collectors;

public class ConcurrentModificationExceptionDemo {

    public static void main(String[] args) {

        // ── Example 1: Removing inside for-each ─────────────────────────
        System.out.println("=== Example 1: Remove inside for-each ===");
        List<String> fruits = new ArrayList<>(
            Arrays.asList("apple", "banana", "cherry", "date", "elderberry")
        );
        try {
            for (String fruit : fruits) {
                System.out.println("Checking: " + fruit);
                if (fruit.startsWith("b")) {
                    fruits.remove(fruit);  // throws ConcurrentModificationException
                }
            }
        } catch (ConcurrentModificationException e) {
            System.out.println("Caught ConcurrentModificationException!");
        }

        // ── Example 2: Adding inside for-each ───────────────────────────
        System.out.println("\n=== Example 2: Add inside for-each ===");
        List<Integer> numbers = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));
        try {
            for (int n : numbers) {
                if (n % 2 == 0) {
                    numbers.add(n * 10);  // throws ConcurrentModificationException
                }
            }
        } catch (ConcurrentModificationException e) {
            System.out.println("Caught: can't add to list while iterating!");
        }

        // ── Fix 1: Iterator.remove() ────────────────────────────────────
        System.out.println("\n=== Fix 1: Use Iterator.remove() ===");
        List<String> fixList1 = new ArrayList<>(
            Arrays.asList("apple", "banana", "cherry", "blueberry")
        );
        Iterator<String> it = fixList1.iterator();
        while (it.hasNext()) {
            String s = it.next();
            if (s.startsWith("b")) {
                it.remove();  // safe removal via the iterator itself
                System.out.println("Removed: " + s);
            }
        }
        System.out.println("Remaining: " + fixList1);

        // ── Fix 2: removeIf (Java 8+, cleanest) ─────────────────────────
        System.out.println("\n=== Fix 2: removeIf() ===");
        List<String> fixList2 = new ArrayList<>(
            Arrays.asList("apple", "banana", "cherry", "blueberry")
        );
        fixList2.removeIf(s -> s.startsWith("b"));
        System.out.println("After removeIf: " + fixList2);

        // ── Fix 3: Collect to remove later ──────────────────────────────
        System.out.println("\n=== Fix 3: Collect then remove ===");
        List<String> fixList3 = new ArrayList<>(
            Arrays.asList("apple", "banana", "cherry", "blueberry")
        );
        List<String> toRemove = new ArrayList<>();
        for (String s : fixList3) {
            if (s.startsWith("b")) toRemove.add(s);
        }
        fixList3.removeAll(toRemove);
        System.out.println("After batch remove: " + fixList3);

        // ── Fix 4: Stream filter (creates a new list) ───────────────────
        System.out.println("\n=== Fix 4: Stream filter ===");
        List<String> original = Arrays.asList("apple", "banana", "cherry", "blueberry");
        List<String> filtered = original.stream()
            .filter(s -> !s.startsWith("b"))
            .collect(Collectors.toList());
        System.out.println("Filtered: " + filtered);

        // ── Fix 5: CopyOnWriteArrayList (thread-safe, for-each safe) ────
        System.out.println("\n=== Fix 5: CopyOnWriteArrayList ===");
        List<String> cowList = new java.util.concurrent.CopyOnWriteArrayList<>(
            Arrays.asList("apple", "banana", "cherry")
        );
        for (String s : cowList) {
            if (s.startsWith("b")) {
                cowList.remove(s);  // safe — iterates a snapshot copy
                System.out.println("Removed safely: " + s);
            }
        }
        System.out.println("Result: " + cowList);
    }
}
