<%-- Create a custom JSP tag that performs a reusable operation such as displaying student information, formatting text or generating a message, using a custom tag handler and TLD file. Develop a JSP application using Expression Language (EL) to access JavaBean properties, request parameters, and request attributes. Display the retrieved values on a JSP page. --%>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="student" uri="/WEB-INF/student_tags.tld" %>
<jsp:useBean id="student" class="lab.custom.student_info_tag" scope="request" />
<jsp:setProperty name="student" property="name" value="Nila" />
<jsp:setProperty name="student" property="course" value="Information Technology" />
<%
    request.setAttribute("studentNote", "This value was set as a request attribute.");
%>
<!DOCTYPE html>
<html>
<head><title>Custom JSP Tag and Expression Language</title></head>
<body>
    <h1>Custom JSP Tag and EL</h1>
    <student:studentInfo name="${student.name}" course="${student.course}" />
    <p>JavaBean name through EL: ${student.name}</p>
    <p>JavaBean course through EL: ${student.course}</p>
    <form action="custom_tag_el.jsp" method="get">
        <label>Request parameter:
            <input type="text" name="studentName" value="${param.studentName}" />
        </label>
        <button type="submit">Display</button>
    </form>
    <p>Request parameter through EL: ${param.studentName}</p>
    <p>Request attribute through EL: ${studentNote}</p>
</body>
</html>
