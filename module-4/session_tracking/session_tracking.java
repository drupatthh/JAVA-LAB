/* Develop a simple shopping cart/session-based application using HttpSession to maintain user information across multiple requests. */
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/session-cart")
public class session_tracking extends HttpServlet {
    @Override
    @SuppressWarnings("unchecked")
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        HttpSession session = request.getSession();
        List<String> cart = (List<String>) session.getAttribute("cart");
        if (cart == null) {
            cart = new ArrayList<>();
            session.setAttribute("cart", cart);
        }
        response.setContentType("text/html;charset=UTF-8");
        response.getWriter().println("<h1>Shopping cart</h1><form method='post' action='" + response.encodeURL(request.getContextPath() + "/session-cart") + "'><label>Item: <input name='item' required></label><button type='submit'>Add item</button></form><h2>Items in your session</h2><ul>");
        for (String item : cart) response.getWriter().println("<li>" + escape(item) + "</li>");
        response.getWriter().println("</ul><p>Items are kept in an HttpSession across requests.</p>");
    }

    @Override
    @SuppressWarnings("unchecked")
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        request.setCharacterEncoding("UTF-8");
        String item = request.getParameter("item");
        HttpSession session = request.getSession();
        List<String> cart = (List<String>) session.getAttribute("cart");
        if (cart == null) {
            cart = new ArrayList<>();
            session.setAttribute("cart", cart);
        }
        if (item != null && !item.trim().isEmpty()) cart.add(item.trim());
        response.sendRedirect(response.encodeRedirectURL(request.getContextPath() + "/session-cart"));
    }

    private String escape(String value) {
        return value.replace("&", "&amp;").replace("<", "&lt;").replace(">", "&gt;").replace("\"", "&quot;").replace("'", "&#39;");
    }
}
