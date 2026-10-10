/*
1. JDBC Architecture & Basic Database Connection
Write a Java program to connect to a MySQL database using JDBC
and display a successful connection message.
*/

import java.sql.*;

class jdbc1 {
    public static void main(String[] args) {
        try {
            Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/student_db", "root", "password");

            System.out.println("Connection Successful");
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
