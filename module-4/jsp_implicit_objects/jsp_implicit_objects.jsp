<%-- Develop a JSP page demonstrating commonly used implicit objects such as request, response, session, application, out, config, pageContext and exception. --%>
<%@ page contentType="text/html; charset=UTF-8" errorPage="exception_page.jsp" %>
<%
    session.setAttribute("labSessionValue", "Stored in the current session");
    application.setAttribute("labApplicationValue", "Stored in the web application");
    pageContext.setAttribute("labPageValue", "Stored in page scope");
    if ("true".equals(request.getParameter("error"))) {
        throw new IllegalStateException("This exception demonstrates JSP error handling.");
    }
%>
<!DOCTYPE html>
<html>
<head><title>JSP Implicit Objects</title></head>
<body>
    <h1>JSP Implicit Objects</h1>
    <p>request parameter: <%= request.getParameter("message") == null ? "No message supplied" : request.getParameter("message") %></p>
    <p>response content type: <%= response.getContentType() %></p>
    <p>session ID: <%= session.getId() %>; value: <%= session.getAttribute("labSessionValue") %></p>
    <p>application value: <%= application.getAttribute("labApplicationValue") %></p>
    <p>out writes this line to the response.</p>
    <% out.write("<p>config servlet name: " + config.getServletName() + "</p>"); %>
    <p>pageContext value: <%= pageContext.getAttribute("labPageValue") %></p>
    <p><a href="jsp_implicit_objects.jsp?error=true">Demonstrate the exception implicit object on the error page</a></p>
</body>
</html>
