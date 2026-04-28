package array;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.List;

public class array_list_1 {
  public static void main(String[] args){
    Scanner input = new Scanner(System.in);

    int total = input.nextInt();
    List<Integer> numbers = new ArrayList<>();

    for(int i=0; i<total; i++){
      numbers.add(input.nextInt());
    }

    int target = input.nextInt();

    for(int i=0; i<numbers.size(); i++){
      for(int j=i+1; j<numbers.size(); j++){
        if(numbers.get(i) + numbers.get(j) == target){
          System.out.println(i +", " + j);
        }
      }
    }
    input.close();
  }
}
