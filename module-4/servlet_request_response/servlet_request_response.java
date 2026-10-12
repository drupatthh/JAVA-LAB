/* Create a Servlet that reads parameters from an HTML form and generates an appropriate HTML response using HttpServletRequest and HttpServletResponse. */
import java.io.IOException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/request-response")
public class servlet_request_response extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html;charset=UTF-8");
        response.getWriter().println("<h1>Student form</h1><form method='post' action='" + response.encodeURL(request.getContextPath() + "/request-response") + "'>"
                + "<label>Name: <input name='name' required></label><br><label>Course: <input name='course' required></label><br><button type='submit'>Submit</button></form>");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        String name = escape(request.getParameter("name"));
        String course = escape(request.getParameter("course"));
        response.getWriter().println("<h1>Form response</h1><p>Welcome, " + name + ".</p><p>Your course is " + course + ".</p>");
    }

    private String escape(String value) {
        if (value == null) return "";
        return value.replace("&", "&amp;").replace("<", "&lt;").replace(">", "&gt;").replace("\"", "&quot;").replace("'", "&#39;");
    }
}
