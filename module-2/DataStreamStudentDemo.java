import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class DataStreamStudentDemo {
    public static void main(String[] args) {
        String fileName = "student.dat";
        int rollNumber = 101;
        String name = "Riley";
        double marks = 91.5;

        try (DataOutputStream output = new DataOutputStream(new FileOutputStream(fileName))) {
            output.writeInt(rollNumber);
            output.writeUTF(name);
            output.writeDouble(marks);
        } catch (IOException e) {
            System.out.println("Could not write student data: " + e.getMessage());
            return;
        }

        try (DataInputStream input = new DataInputStream(new FileInputStream(fileName))) {
            System.out.println("Roll number: " + input.readInt());
            System.out.println("Name: " + input.readUTF());
            System.out.println("Marks: " + input.readDouble());
        } catch (EOFException e) {
            System.out.println("Student data file is incomplete");
        } catch (IOException e) {
            System.out.println("Could not read student data: " + e.getMessage());
        }
    }
}
