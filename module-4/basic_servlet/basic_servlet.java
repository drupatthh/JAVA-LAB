/* Create a Servlet that displays student information and deploy it on a servlet container such as Apache Tomcat. */
import java.io.IOException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/basic-servlet")
public class basic_servlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html;charset=UTF-8");
        response.getWriter().println("<!DOCTYPE html><html><head><title>Student Information</title></head><body>");
        response.getWriter().println("<h1>Student Information</h1><p>Name: Alex Student</p><p>Roll Number: 24</p><p>Course: Computer Science</p></body></html>");
    }
}
