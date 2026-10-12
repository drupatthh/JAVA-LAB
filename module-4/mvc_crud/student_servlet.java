/*
Develop an MVC-based application to add, view, update and delete student records using JSP, Servlet and JDBC.
*/
package mvccrud;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/students")
public class student_servlet extends HttpServlet {
    private Connection connect() throws SQLException {
        return DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/student_db", "root", "root");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try (Connection connection = connect();
             PreparedStatement statement = connection.prepareStatement(
                     "SELECT id, name, course FROM students");
             ResultSet result = statement.executeQuery()) {
            List<student_record> students = new ArrayList<>();
            while (result.next()) {
                students.add(new student_record(
                        result.getInt("id"), result.getString("name"), result.getString("course")));
            }
            request.setAttribute("students", students);
            request.getRequestDispatcher("/student_list.jsp").forward(request, response);
        } catch (SQLException e) {
            throw new ServletException(e);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");
        String sql;
        if ("add".equals(action)) {
            sql = "INSERT INTO students (name, course) VALUES (?, ?)";
        } else if ("update".equals(action)) {
            sql = "UPDATE students SET name = ?, course = ? WHERE id = ?";
        } else if ("delete".equals(action)) {
            sql = "DELETE FROM students WHERE id = ?";
        } else {
            throw new ServletException("Unknown action");
        }

        try (Connection connection = connect();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            if ("add".equals(action)) {
                statement.setString(1, request.getParameter("name"));
                statement.setString(2, request.getParameter("course"));
            } else if ("update".equals(action)) {
                statement.setString(1, request.getParameter("name"));
                statement.setString(2, request.getParameter("course"));
                statement.setInt(3, Integer.parseInt(request.getParameter("id")));
            } else {
                statement.setInt(1, Integer.parseInt(request.getParameter("id")));
            }
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new ServletException(e);
        }
        response.sendRedirect(request.getContextPath() + "/students");
    }
}
