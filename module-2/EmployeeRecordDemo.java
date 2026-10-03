import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class EmployeeRecordDemo {
    public static void main(String[] args) {
        String fileName = "employees.dat";

        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Employee ID: ");
            int id = Integer.parseInt(scanner.nextLine());
            System.out.print("Employee name: ");
            String name = scanner.nextLine();
            System.out.print("Salary: ");
            double salary = Double.parseDouble(scanner.nextLine());

            try (DataOutputStream output = new DataOutputStream(
                    new FileOutputStream(fileName, true))) {
                output.writeInt(id);
                output.writeUTF(name);
                output.writeDouble(salary);
            }

            System.out.println("Stored employee records:");
            try (DataInputStream input = new DataInputStream(new FileInputStream(fileName))) {
                while (true) {
                    int savedId = input.readInt();
                    String savedName = input.readUTF();
                    double savedSalary = input.readDouble();
                    System.out.println("ID: " + savedId + ", Name: " + savedName
                            + ", Salary: " + savedSalary);
                }
            } catch (EOFException e) {
                System.out.println("End of employee records");
            }
        } catch (NumberFormatException e) {
            System.out.println("Enter a valid numeric ID and salary");
        } catch (IOException e) {
            System.out.println("Could not process employee records: " + e.getMessage());
        }
    }
}
