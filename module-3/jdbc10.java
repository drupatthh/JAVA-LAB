/*
10. JDBC Exception & Error Handling
Handle connection errors, invalid SQL, duplicate records and invalid input.
*/

import java.sql.*;
import java.util.Scanner;

class jdbc10 {
    public static void main(String[] args) {
        try {
            Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/student_db", "root", "password");

            Scanner sc = new Scanner(System.in);

            System.out.print("Enter student ID: ");
            int id = Integer.parseInt(sc.nextLine());

            PreparedStatement ps = con.prepareStatement(
                "INSERT INTO student VALUES(?,?)");

            ps.setInt(1, id);
            ps.setString(2, "Aman");
            ps.executeUpdate();

            System.out.println("Record Inserted");
            con.close();
        } catch (NumberFormatException e) {
            System.out.println("Invalid Input");
        } catch (SQLIntegrityConstraintViolationException e) {
            System.out.println("Duplicate Record");
        } catch (SQLException e) {
            System.out.println("Database Error: " + e.getMessage());
        }
    }
}
