/* Create two Servlets where the first Servlet processes a request and forwards or includes the request to the second Servlet using RequestDispatcher. */
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/servlet-chaining/first")
public class first_servlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String mode = request.getParameter("mode");
        request.setAttribute("processedMessage", "The first servlet processed this request.");
        RequestDispatcher dispatcher = request.getRequestDispatcher("/servlet-chaining/second");
        response.setContentType("text/html;charset=UTF-8");
        if ("include".equals(mode)) {
            response.getWriter().println("<h1>Include example</h1><p>The first servlet keeps control and includes this content:</p>");
            dispatcher.include(request, response);
        } else {
            dispatcher.forward(request, response);
        }
    }
}
