<%-- Create a JSP page that displays dynamic student information and demonstrate the JSP translation, compilation and execution process. --%>
<%@ page contentType="text/html; charset=UTF-8" %>
<%
    String studentName = request.getParameter("name");
    if (studentName == null || studentName.isBlank()) {
        studentName = "Ananya";
    }
    String studentId = "JSP101";
    String course = "Java Web Programming";
%>
<!DOCTYPE html>
<html>
<head><title>Basic JSP Student Information</title></head>
<body>
    <h1>Student Information</h1>
    <p>Name: <%= studentName %></p>
    <p>Student ID: <%= studentId %></p>
    <p>Course: <%= course %></p>
    <p>Generated at: <%= new java.util.Date() %></p>
    <h2>JSP execution process</h2>
    <ol>
        <li>Tomcat translates this JSP into a servlet.</li>
        <li>Tomcat compiles the generated servlet.</li>
        <li>The servlet executes for the request and returns this dynamic page.</li>
    </ol>
</body>
</html>
