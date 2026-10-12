/*
Develop a simple Student Management application following Model-View-Controller architecture.
*/
package simplemvc;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

@WebServlet("/students")
public class student_controller extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<student_model> students = Arrays.asList(
                new student_model("Asha", "Computer Science"),
                new student_model("Ravi", "Information Technology"));
        request.setAttribute("students", students);
        request.getRequestDispatcher("/student_list.jsp").forward(request, response);
    }
}
