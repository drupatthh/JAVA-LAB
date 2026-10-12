<%@ page import="java.util.List" %>
<%@ page import="simplemvc.student_model" %>
<html>
<body>
<h2>Student List</h2>
<%
List<student_model> students = (List<student_model>) request.getAttribute("students");
for (student_model student : students) {
%>
<p><%= student.getName() %> - <%= student.getCourse() %></p>
<%
}
%>
</body>
</html>
