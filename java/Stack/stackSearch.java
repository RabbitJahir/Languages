package Stack;
import java.util.Stack;
import java.util.Arrays;
public class stackSearch {
  public static void main(String[] args){

    Stack<Integer> searching = new Stack<>();
    searching.addAll(Arrays.asList(10, 20, 30, 40)); //addAll method from stack, adds all elements to stack in order
    //Arrays: utilities, asList: converts elements passed to lists
    //Arrays.addList(): makes a list
    //search.addAll(): Adds everything


    System.out.print(searching.search(10)); //index + 1

  }
}
