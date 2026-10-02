package core;

import java.util.ArrayList;
import java.util.List;

/**
 * Hand-written sorting and searching algorithms applied to a user's
 * transaction history. Deliberately not using Collections.sort/Stream
 * so the algorithm itself (and its complexity) is explicit for the report.
 */
public class TransactionAlgorithms {

    // ---------- MERGE SORT by amount, ascending. O(n log n) time, O(n) space. ----------
    public static List<Transaction> mergeSortByAmount(List<Transaction> list) {
        List<Transaction> copy = new ArrayList<>(list);
        if (copy.size() <= 1) return copy;
        int mid = copy.size() / 2;
        List<Transaction> left = mergeSortByAmount(copy.subList(0, mid));
        List<Transaction> right = mergeSortByAmount(copy.subList(mid, copy.size()));
        return mergeByAmount(left, right);
    }

    private static List<Transaction> mergeByAmount(List<Transaction> left, List<Transaction> right) {
        List<Transaction> result = new ArrayList<>(left.size() + right.size());
        int i = 0, j = 0;
        while (i < left.size() && j < right.size()) {
            if (left.get(i).amount <= right.get(j).amount) result.add(left.get(i++));
            else result.add(right.get(j++));
        }
        while (i < left.size()) result.add(left.get(i++));
        while (j < right.size()) result.add(right.get(j++));
        return result;
    }

    // ---------- MERGE SORT by date, ascending (chronological). O(n log n). ----------
    public static List<Transaction> mergeSortByDate(List<Transaction> list) {
        List<Transaction> copy = new ArrayList<>(list);
        if (copy.size() <= 1) return copy;
        int mid = copy.size() / 2;
        List<Transaction> left = mergeSortByDate(copy.subList(0, mid));
        List<Transaction> right = mergeSortByDate(copy.subList(mid, copy.size()));
        return mergeByDate(left, right);
    }

    private static List<Transaction> mergeByDate(List<Transaction> left, List<Transaction> right) {
        List<Transaction> result = new ArrayList<>(left.size() + right.size());
        int i = 0, j = 0;
        while (i < left.size() && j < right.size()) {
            if (!left.get(i).time.isAfter(right.get(j).time)) result.add(left.get(i++));
            else result.add(right.get(j++));
        }
        while (i < left.size()) result.add(left.get(i++));
        while (j < right.size()) result.add(right.get(j++));
        return result;
    }

    // ---------- BINARY SEARCH for an exact amount. Requires list sorted by amount. O(log n). ----------
    // Returns every transaction matching the amount (there can be duplicates), or empty list.
    public static List<Transaction> binarySearchByAmount(List<Transaction> sortedByAmount, double target) {
        List<Transaction> matches = new ArrayList<>();
        int lo = 0, hi = sortedByAmount.size() - 1;
        int foundIndex = -1;

        while (lo <= hi) {
            int mid = (lo + hi) / 2;
            double midVal = sortedByAmount.get(mid).amount;
            if (midVal == target) { foundIndex = mid; break; }
            else if (midVal < target) lo = mid + 1;
            else hi = mid - 1;
        }

        if (foundIndex == -1) return matches; // not found

        // duplicates may sit on either side of foundIndex - sweep outwards
        matches.add(sortedByAmount.get(foundIndex));
        for (int i = foundIndex - 1; i >= 0 && sortedByAmount.get(i).amount == target; i--) {
            matches.add(0, sortedByAmount.get(i));
        }
        for (int i = foundIndex + 1; i < sortedByAmount.size() && sortedByAmount.get(i).amount == target; i++) {
            matches.add(sortedByAmount.get(i));
        }
        return matches;
    }

    // ---------- LINEAR SEARCH by transaction type. O(n). No pre-sort needed. ----------
    public static List<Transaction> linearSearchByType(List<Transaction> list, String type) {
        List<Transaction> matches = new ArrayList<>();
        for (Transaction t : list) {
            if (t.type.equalsIgnoreCase(type)) matches.add(t);
        }
        return matches;
    }
}
