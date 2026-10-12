<%@ page contentType="text/html; charset=UTF-8" %>
<jsp:useBean id="student" class="lab.actions.student_bean" scope="session" />
<!DOCTYPE html>
<html>
<head><title>Forward Destination</title></head>
<body>
    <h1>Forward Destination</h1>
    <p>The jsp:forward action sent the request to this page.</p>
    <p>Student: <jsp:getProperty name="student" property="name" /></p>
    <p>Course: <jsp:getProperty name="student" property="course" /></p>
</body>
</html>
