/* Develop a simple login application with protected resources where only authenticated users can access a particular Servlet or page. */
import java.io.IOException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/servlet-security/login")
public class login_servlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html;charset=UTF-8");
        String action = response.encodeURL(request.getContextPath() + "/servlet-security/login");
        response.getWriter().println("<h1>Student login</h1><form method='post' action='" + action + "'><label>Username: <input name='username' required></label><br><label>Password: <input type='password' name='password' required></label><br><button type='submit'>Log in</button></form><p>Demo credentials: student / secret</p>");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        if ("student".equals(request.getParameter("username")) && "secret".equals(request.getParameter("password"))) {
            HttpSession session = request.getSession();
            session.setAttribute("username", "student");
            response.sendRedirect(response.encodeURL(request.getContextPath() + "/servlet-security/protected"));
        } else {
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            response.setContentType("text/html;charset=UTF-8");
            response.getWriter().println("<h1>Login failed</h1><p>Check the demo credentials and try again.</p><a href='" + request.getContextPath() + "/servlet-security/login'>Back to login</a>");
        }
    }
}
