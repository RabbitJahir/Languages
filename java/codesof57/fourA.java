public class fourA {

    public static void main(String[] args) {

        int[] numbers = {10, 20, 30};
        String str = null;
        int result = 10 / 0;

        try {
            System.out.println("Number: " + numbers[5]);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Error: Array index is out of bounds.");
        }

        try {
            System.out.println("Length of string: " + str.length());
        } catch (NullPointerException e) {
            System.out.println("Error: String is null.");
        }


        try {
            System.out.println("Result: " + result);
        } catch (ArithmeticException e) {
            System.out.println("Error: Cannot divide by zero.");
        }

        try {
            System.out.println("Program completed successfully!");
        } finally {
            System.out.println("hudai");
        }
    }
}