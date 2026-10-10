/*
9. JDBC Transactions
Transfer money using commit() and rollback().
*/

import java.sql.*;

class jdbc9 {
    public static void main(String[] args) throws Exception {
        Connection con = DriverManager.getConnection(
            "jdbc:mysql://localhost:3306/student_db", "root", "password");

        Statement st = con.createStatement();

        st.executeUpdate("CREATE TABLE IF NOT EXISTS bank(id INT PRIMARY KEY, balance INT)");
        st.executeUpdate("INSERT IGNORE INTO bank VALUES(1,1000),(2,500)");

        try {
            con.setAutoCommit(false);

            st.executeUpdate("UPDATE bank SET balance=balance-100 WHERE id=1");
            st.executeUpdate("UPDATE bank SET balance=balance+100 WHERE id=2");

            con.commit();
            System.out.println("Transfer Successful");
        } catch (Exception e) {
            con.rollback();
            System.out.println("Transfer Failed");
        }

        con.close();
    }
}
