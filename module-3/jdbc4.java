/*
4. CallableStatement & Stored Procedures
Create and invoke a MySQL stored procedure using CallableStatement.
*/

import java.sql.*;

class jdbc4 {
    public static void main(String[] args) throws Exception {
        Connection con = DriverManager.getConnection(
            "jdbc:mysql://localhost:3306/student_db", "root", "password");

        Statement st = con.createStatement();

        st.execute("DROP PROCEDURE IF EXISTS getStudents");
        st.execute("CREATE PROCEDURE getStudents() SELECT * FROM student");

        CallableStatement cs = con.prepareCall("{call getStudents()}");
        ResultSet rs = cs.executeQuery();

        while (rs.next())
            System.out.println(rs.getInt(1) + " " + rs.getString(2));

        con.close();
    }
}
