import java.io.FileInputStream;
import java.io.IOException;

public class FileInputStreamDemo {
    public static void main(String[] args) {
        try (FileInputStream input = new FileInputStream("input.txt")) {
            int value;
            while ((value = input.read()) != -1) {
                System.out.print((char) value);
            }
        } catch (IOException e) {
            System.out.println("Could not read input.txt: " + e.getMessage());
        }
    }
}
