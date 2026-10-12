import java.io.IOException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/servlet-chaining/second")
public class second_servlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        boolean included = request.getAttribute("jakarta.servlet.include.request_uri") != null;
        Object message = request.getAttribute("processedMessage");
        if (!included) response.getWriter().println("<h1>Forward example</h1>");
        response.getWriter().println("<p>" + (message == null ? "Request received by the second servlet." : message) + "</p>");
        response.getWriter().println("<p>Second servlet response.</p>");
    }
}
