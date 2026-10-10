/*
5. ResultSet Navigation
Demonstrate next(), previous(), first(), last() and absolute().
*/

import java.sql.*;

class jdbc5 {
    public static void main(String[] args) throws Exception {
        Connection con = DriverManager.getConnection(
            "jdbc:mysql://localhost:3306/student_db", "root", "password");

        Statement st = con.createStatement(
            ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);

        ResultSet rs = st.executeQuery("SELECT * FROM student");

        if (rs.next())
            System.out.println(rs.getString(2));

        if (rs.last())
            System.out.println(rs.getString(2));

        if (rs.first())
            System.out.println(rs.getString(2));

        if (rs.absolute(2))
            System.out.println(rs.getString(2));

        if (rs.next() && rs.previous())
            System.out.println(rs.getString(2));

        con.close();
    }
}
