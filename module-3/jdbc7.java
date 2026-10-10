/*
7. Database Metadata
Display database information and available tables using DatabaseMetaData.
*/

import java.sql.*;

class jdbc7 {
    public static void main(String[] args) throws Exception {
        Connection con = DriverManager.getConnection(
            "jdbc:mysql://localhost:3306/student_db", "root", "password");

        DatabaseMetaData dm = con.getMetaData();

        System.out.println(dm.getDatabaseProductName());
        System.out.println(dm.getDatabaseProductVersion());
        System.out.println(dm.getDriverName());
        System.out.println(dm.supportsTransactions());

        ResultSet rs = dm.getTables("student_db", null, "%", new String[]{"TABLE"});

        while (rs.next())
            System.out.println(rs.getString("TABLE_NAME"));

        con.close();
    }
}
