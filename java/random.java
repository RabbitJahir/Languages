import java.util.HashMap;

public class random {
    public static void main(String[] args) {

        int[] numbers = {101, 201, 201, 301, 101, 401, 201, 301};

        HashMap<Integer, Integer> countMap = new HashMap<>();

        for (int num : numbers) {

            if (countMap.containsKey(num)) {
                countMap.put(num, countMap.get(num) + 1);
            } else {
                countMap.put(num, 1);
            }
        }

        System.out.println(countMap);
    }
}