<%@ page import="java.util.List" %>
<%@ page import="mvccrud.student_record" %>
<html>
<body>
<h2>Students</h2>
<form action="students" method="post">
    <input type="hidden" name="action" value="add">
    Name: <input name="name">
    Course: <input name="course">
    <button type="submit">Add</button>
</form>
<%
List<student_record> students = (List<student_record>) request.getAttribute("students");
for (student_record student : students) {
%>
<form action="students" method="post">
    <input type="hidden" name="id" value="<%= student.getId() %>">
    Name: <input name="name" value="<%= student.getName() %>">
    Course: <input name="course" value="<%= student.getCourse() %>">
    <button name="action" value="update">Update</button>
    <button name="action" value="delete">Delete</button>
</form>
<%
}
%>
</body>
</html>
