<%@ page contentType="text/html; charset=UTF-8" isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head><title>JSP Exception Object</title></head>
<body>
    <h1>JSP Error Page</h1>
    <p>The exception implicit object contains: <%= exception.getMessage() %></p>
    <p><a href="jsp_implicit_objects.jsp">Return to implicit objects</a></p>
</body>
</html>
