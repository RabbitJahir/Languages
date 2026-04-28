package basic;
import java.util.Scanner;

public class if_else{
    public static void main(String[] args){
     
        Scanner input = new Scanner(System.in);

        System.out.print("Enter any name: ");
        String name = input.nextLine();

        int length = name.length();
        String upper = name.toUpperCase();
        String lower = name.toLowerCase();
        String trim = name.trim();
        System.out.println();
        System.out.println("Length of " + name + (" is " + length));
        System.out.println(name + " to upper case: " + upper + ", to lower case: " + lower);
        System.out.println("java can remove unnecessary spaces: " + trim);
        System.out.println();

        // finding the letter at given number
        System.out.print("Enter any number between " + (length -1)+ " :");
        int find_char = input.nextInt();

        char letter = name.charAt(find_char);
        System.out.println("The letter in position " + find_char + " is: " + letter);
        System.out.println();

        //finding the index at given chracter
        //Java has no given method to directly take character as input
        System.out.print("Enter any letter or symbol from " + name + ": ");
        String find_index = input.next();

        int index = name.indexOf(find_index);
        int last_index = name.lastIndexOf(find_index);

        System.out.println("Starting from the beginning, " + find_index + " found in index: " + index + "\nStaring from the end, " + find_index + " found in index: "+ last_index);
        System.out.println();
        input.nextLine();
        //empty or not

        System.out.print("Enter a new name or keep it empty: ");
        String new_name = input.nextLine();

        if(new_name.isEmpty()){
            System.out.println("You entered: " + new_name + ". Now try again but keep enter nothing.");
        }
        else{
            System.out.print("How do i know its empty? Magic! Just joking, java has name.isEmpty(), like a boolean. ");
        }

        
        
        input.close();
    }
}