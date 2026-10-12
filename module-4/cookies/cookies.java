/* Create a Servlet application that stores the user's name or preferences in a cookie and retrieves the information during subsequent requests. */
import java.io.IOException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/cookies")
public class cookies extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String name = null;
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if ("visitorName".equals(cookie.getName())) name = cookie.getValue();
            }
        }
        response.setContentType("text/html;charset=UTF-8");
        if (name == null) {
            response.getWriter().println("<h1>Cookie example</h1><p>No saved name yet.</p>");
        } else {
            response.getWriter().println("<h1>Welcome back, " + escape(name) + "</h1><p>Your name was read from a cookie.</p>");
        }
        response.getWriter().println("<form method='post' action='" + response.encodeURL(request.getContextPath() + "/cookies") + "'><label>Your name: <input name='name' required></label><button type='submit'>Save name</button></form>");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        request.setCharacterEncoding("UTF-8");
        String name = request.getParameter("name");
        if (name == null || name.trim().isEmpty()) {
            response.sendRedirect(response.encodeRedirectURL(request.getContextPath() + "/cookies"));
            return;
        }
        Cookie cookie = new Cookie("visitorName", name.trim());
        cookie.setMaxAge(60 * 60 * 24 * 30);
        cookie.setPath(request.getContextPath().isEmpty() ? "/" : request.getContextPath() + "/");
        cookie.setHttpOnly(true);
        response.addCookie(cookie);
        response.sendRedirect(response.encodeRedirectURL(request.getContextPath() + "/cookies"));
    }

    private String escape(String value) {
        return value.replace("&", "&amp;").replace("<", "&lt;").replace(">", "&gt;").replace("\"", "&quot;").replace("'", "&#39;");
    }
}
