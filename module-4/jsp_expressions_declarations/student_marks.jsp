<%-- Create a JSP page that uses declarations and expressions to calculate and display student marks, total and average. --%>
<%@ page contentType="text/html; charset=UTF-8" %>
<%!
    private final String studentName = "Rohan";
    private final int[] marks = {86, 91, 78, 95, 88};

    private int calculateTotal() {
        int total = 0;
        for (int mark : marks) {
            total += mark;
        }
        return total;
    }

    private double calculateAverage() {
        return (double) calculateTotal() / marks.length;
    }
%>
<!DOCTYPE html>
<html>
<head><title>Student Marks</title></head>
<body>
    <h1>Marks for <%= studentName %></h1>
    <ul>
        <% for (int subject = 0; subject < marks.length; subject++) { %>
            <li>Subject <%= subject + 1 %>: <%= marks[subject] %></li>
        <% } %>
    </ul>
    <p>Total: <%= calculateTotal() %></p>
    <p>Average: <%= String.format("%.2f", calculateAverage()) %></p>
</body>
</html>
