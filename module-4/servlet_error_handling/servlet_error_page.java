import java.io.IOException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/servlet-error-page")
public class servlet_error_page extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html;charset=UTF-8");
        Object error = request.getAttribute("jakarta.servlet.error.exception");
        String message = error instanceof Throwable ? ((Throwable) error).getMessage() : "The requested page could not be displayed.";
        response.getWriter().println("<h1>Sorry, an error occurred</h1><p>" + escape(message == null ? "An unexpected error occurred." : message) + "</p>");
    }

    private String escape(String value) {
        return value.replace("&", "&amp;").replace("<", "&lt;").replace(">", "&gt;").replace("\"", "&quot;").replace("'", "&#39;");
    }
}