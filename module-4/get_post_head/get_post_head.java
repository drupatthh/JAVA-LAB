/* Create an HTML form and Servlet that handles GET and POST requests. Implement a response for a HEAD request and demonstrate the differences. */
import java.io.IOException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/get-post-head")
public class get_post_head extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        writeResponse(request, response, "GET");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        writeResponse(request, response, "POST");
    }

    @Override
    protected void doHead(HttpServletRequest request, HttpServletResponse response) {
        response.setContentType("text/html;charset=UTF-8");
        response.setHeader("X-Request-Method", "HEAD");
        response.setHeader("X-Response-Note", "HEAD returns headers without a response body");
    }

    private void writeResponse(HttpServletRequest request, HttpServletResponse response, String method) throws IOException {
        response.setContentType("text/html;charset=UTF-8");
        String name = request.getParameter("name");
        response.getWriter().println("<h1>" + method + " request</h1><p>Name: " + escape(name == null ? "not supplied" : name) + "</p>");
    }

    private String escape(String value) {
        return value.replace("&", "&amp;").replace("<", "&lt;").replace(">", "&gt;").replace("\"", "&quot;").replace("'", "&#39;");
    }
}
