<%-- Create a JSP application using JSTL tags for conditions, iteration and formatting, including c:if, c:forEach, c:choose, c:when and c:otherwise. --%>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="fmt" uri="jakarta.tags.fmt" %>
<%
    request.setAttribute("students", java.util.Arrays.asList("Asha", "Dev", "Ishan"));
    request.setAttribute("score", 84);
    request.setAttribute("fee", 1250.50);
    request.setAttribute("today", new java.util.Date());
%>
<fmt:setLocale value="en_US" />
<!DOCTYPE html>
<html>
<head><title>JSTL Conditions, Iteration and Formatting</title></head>
<body>
    <h1>Student List</h1>
    <ul>
        <c:forEach var="studentName" items="${students}">
            <li><c:out value="${studentName}" /></li>
        </c:forEach>
    </ul>
    <c:if test="${score >= 40}">
        <p>The student has passed with a score of <c:out value="${score}" />.</p>
    </c:if>
    <c:choose>
        <c:when test="${score >= 80}"><p>Result: Distinction</p></c:when>
        <c:when test="${score >= 60}"><p>Result: First class</p></c:when>
        <c:otherwise><p>Result: Pass</p></c:otherwise>
    </c:choose>
    <p>Course fee: <fmt:formatNumber value="${fee}" type="currency" /></p>
    <p>Date: <fmt:formatDate value="${today}" dateStyle="long" /></p>
</body>
</html>
