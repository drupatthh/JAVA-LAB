/*
2. MySQL CRUD Using JDBC
Create a student table and implement INSERT, UPDATE, DELETE
and SELECT operations using JDBC Statement.
*/

import java.sql.*;

class jdbc2 {
    public static void main(String[] args) throws Exception {
        Connection con = DriverManager.getConnection(
            "jdbc:mysql://localhost:3306/student_db", "root", "password");

        Statement st = con.createStatement();

        st.executeUpdate("CREATE TABLE IF NOT EXISTS student(id INT PRIMARY KEY, name VARCHAR(30))");
        st.executeUpdate("INSERT INTO student VALUES(1,'Aman')");
        st.executeUpdate("UPDATE student SET name='Rahul' WHERE id=1");
        st.executeUpdate("DELETE FROM student WHERE id=1");

        ResultSet rs = st.executeQuery("SELECT * FROM student");

        while (rs.next())
            System.out.println(rs.getInt(1) + " " + rs.getString(2));

        con.close();
    }
}
