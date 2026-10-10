/*
8. ResultSet Metadata
Display column names, count and data types using ResultSetMetaData.
*/

import java.sql.*;

class jdbc8 {
    public static void main(String[] args) throws Exception {
        Connection con = DriverManager.getConnection(
            "jdbc:mysql://localhost:3306/student_db", "root", "password");

        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery("SELECT * FROM student");

        ResultSetMetaData rm = rs.getMetaData();

        System.out.println("Columns: " + rm.getColumnCount());

        for (int i = 1; i <= rm.getColumnCount(); i++) {
            System.out.println(rm.getColumnName(i));
            System.out.println(rm.getColumnTypeName(i));
        }

        con.close();
    }
}
