package Stack;

import java.util.Scanner;
import java.util.Stack;

class Solution {
    public void rotate(int[] nums, int k) {
      Scanner input = new Scanner(System.in);
      k = input.nextInt();

      Stack<Integer> numbers = new Stack<>();
      nums = toStack();
        for(int i=0; i<k; i++){
          nums.push();
        }
        input.close();
    }
}
