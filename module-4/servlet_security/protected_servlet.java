import java.io.IOException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/servlet-security/protected")
public class protected_servlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        HttpSession session = request.getSession(false);
        if (session == null || session.getAttribute("username") == null) {
            response.sendRedirect(response.encodeRedirectURL(request.getContextPath() + "/servlet-security/login"));
            return;
        }
        response.setContentType("text/html;charset=UTF-8");
        response.getWriter().println("<h1>Protected resource</h1><p>Welcome, " + session.getAttribute("username") + ". You are authenticated.</p>");
    }
}
