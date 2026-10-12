<%-- Create a JSP application demonstrating standard JSP actions such as jsp:include, jsp:forward, jsp:useBean, jsp:setProperty and jsp:getProperty. --%>
<%@ page contentType="text/html; charset=UTF-8" %>
<jsp:useBean id="student" class="lab.actions.student_bean" scope="session" />
<jsp:setProperty name="student" property="name" value="Mira" />
<jsp:setProperty name="student" property="course" value="Web Application Development" />
<%
    if ("true".equals(request.getParameter("forward"))) {
%>
    <jsp:forward page="forward_result.jsp" />
<%
    }
%>
<!DOCTYPE html>
<html>
<head><title>JSP Standard Actions</title></head>
<body>
    <h1>JSP Standard Actions</h1>
    <jsp:include page="included_content.jsp" />
    <p>Student: <jsp:getProperty name="student" property="name" /></p>
    <p>Course: <jsp:getProperty name="student" property="course" /></p>
    <p><a href="jsp_actions.jsp?forward=true">Demonstrate jsp:forward</a></p>
</body>
</html>
