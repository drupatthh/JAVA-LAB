<%-- Create JSP pages demonstrating important page directive attributes such as import, contentType and errorPage. --%>
<%@ page import="java.time.LocalDate" contentType="text/html; charset=UTF-8" errorPage="directive_error.jsp" %>
<!DOCTYPE html>
<html>
<head><title>JSP Page Directives</title></head>
<body>
    <h1>Page Directive Attributes</h1>
    <p>Today's date from the imported LocalDate class: <%= LocalDate.now() %></p>
    <p>The content type is set to HTML with UTF-8 encoding by the page directive.</p>
    <p><a href="jsp_directives.jsp?error=true">Open the error page demonstration</a></p>
    <%
        if ("true".equals(request.getParameter("error"))) {
            throw new IllegalArgumentException("This error demonstrates the errorPage attribute.");
        }
    %>
</body>
</html>
