/*
6. BLOB and CLOB Handling
Store and retrieve an image using BLOB and text using CLOB.
*/

import java.sql.*;
import java.io.*;

class jdbc6 {
    public static void main(String[] args) throws Exception {
        Connection con = DriverManager.getConnection(
            "jdbc:mysql://localhost:3306/student_db", "root", "password");

        Statement st = con.createStatement();
        st.executeUpdate("CREATE TABLE IF NOT EXISTS files(id INT PRIMARY KEY, img LONGBLOB, txt LONGTEXT)");

        PreparedStatement ps = con.prepareStatement(
            "INSERT INTO files VALUES(1,?,?)");

        ps.setBinaryStream(1, new FileInputStream("image.jpg"));
        ps.setCharacterStream(2, new FileReader("document.txt"));
        ps.executeUpdate();

        ResultSet rs = st.executeQuery("SELECT * FROM files WHERE id=1");

        if (rs.next()) {
            InputStream in = rs.getBinaryStream("img");
            FileOutputStream out = new FileOutputStream("output.jpg");
            in.transferTo(out);
            out.close();
            in.close();

            Reader r = rs.getCharacterStream("txt");
            FileWriter w = new FileWriter("output.txt");

            int ch;
            while ((ch = r.read()) != -1)
                w.write(ch);

            r.close();
            w.close();
            System.out.println("Files retrieved");
        }

        con.close();
    }
}
