import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class BufferedFileCopyDemo {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Source file: ");
            String source = scanner.nextLine();
            System.out.print("Destination file: ");
            String destination = scanner.nextLine();

            try (BufferedInputStream input = new BufferedInputStream(new FileInputStream(source));
                 BufferedOutputStream output = new BufferedOutputStream(new FileOutputStream(destination))) {
                byte[] buffer = new byte[4096];
                int bytesRead;
                while ((bytesRead = input.read(buffer)) != -1) {
                    output.write(buffer, 0, bytesRead);
                }
                System.out.println("File copied successfully");
            } catch (IOException e) {
                System.out.println("File copy failed: " + e.getMessage());
            }
        }
    }
}
