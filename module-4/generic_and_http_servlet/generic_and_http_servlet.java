/* Create one Servlet using GenericServlet and another using HttpServlet, and demonstrate their differences. */
import java.io.IOException;
import jakarta.servlet.GenericServlet;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;

@WebServlet("/generic-servlet")
public class generic_and_http_servlet extends GenericServlet {
    @Override
    public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        response.getWriter().println("<h1>GenericServlet</h1><p>GenericServlet is protocol-independent and provides one service method.</p>");
    }
}
