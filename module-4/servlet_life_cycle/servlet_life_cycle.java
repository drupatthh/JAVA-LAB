/* Create a Servlet demonstrating the init(), service() and destroy() life-cycle methods and display messages showing when each method is executed. */
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(value = "/servlet-lifecycle", loadOnStartup = 1)
public class servlet_life_cycle extends HttpServlet {
    @Override
    public void init() throws ServletException {
        super.init();
        getServletContext().log("init() executed");
    }

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        getServletContext().log("service() executed");
        super.service(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html;charset=UTF-8");
        response.getWriter().println("<h1>Servlet life cycle</h1><p>init() runs once when the servlet is initialized.</p><p>service() runs for each request; check the Tomcat log for its message.</p><p>destroy() runs when the servlet is taken out of service; check the Tomcat log.</p>");
    }

    @Override
    public void destroy() {
        getServletContext().log("destroy() executed");
        super.destroy();
    }
}
