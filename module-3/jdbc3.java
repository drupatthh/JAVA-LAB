/*
3. PreparedStatement for Parameterized Operations
Insert and search student records using PreparedStatement.
*/

import java.sql.*;
import java.util.Scanner;

class jdbc3 {
    public static void main(String[] args) throws Exception {
        Connection con = DriverManager.getConnection(
            "jdbc:mysql://localhost:3306/student_db", "root", "password");

        Scanner sc = new Scanner(System.in);

        Statement st = con.createStatement();
        st.executeUpdate("CREATE TABLE IF NOT EXISTS student2(id INT PRIMARY KEY, name VARCHAR(30))");

        System.out.print("Enter ID and name: ");
        int id = sc.nextInt();
        String name = sc.next();

        PreparedStatement ps = con.prepareStatement(
            "INSERT INTO student2 VALUES(?,?)");
        ps.setInt(1, id);
        ps.setString(2, name);
        ps.executeUpdate();

        ps = con.prepareStatement("SELECT * FROM student2 WHERE id=?");
        ps.setInt(1, id);

        ResultSet rs = ps.executeQuery();

        while (rs.next())
            System.out.println(rs.getInt(1) + " " + rs.getString(2));

        con.close();
    }
}
