import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class FileOutputStreamDemo {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Enter text to append to output.txt: ");
            String text = scanner.nextLine();

            try (FileOutputStream output = new FileOutputStream("output.txt", true)) {
                output.write((text + System.lineSeparator()).getBytes(StandardCharsets.UTF_8));
                System.out.println("Text appended to output.txt");
            } catch (IOException e) {
                System.out.println("Could not write output.txt: " + e.getMessage());
            }
        }
    }
}
