import java.util.Scanner;

public class MultipleExceptionsFinally {
    public static void main(String[] args) {
        int[] numbers = {10, 0, 30};
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.print("Enter an array index (0-2): ");
            int index = scanner.nextInt();
            System.out.println("100 divided by the array value: " + 100 / numbers[index]);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("The index is outside the array");
        } catch (ArithmeticException e) {
            System.out.println("Cannot divide by zero");
        } finally {
            System.out.println("Exception handling completed");
            scanner.close();
        }
    }
}
