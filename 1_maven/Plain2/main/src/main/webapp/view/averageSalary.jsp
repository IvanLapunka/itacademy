<%@ page contentType="text/html" language="java"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="by.academy.entity.Teacher" %>
<%@ page import="java.util.List" %>
<!DOCTYPE html>
<html lang="en">
<head>
</head>
<body>
<jsp:include page="inline/menu.jsp"></jsp:include>
<h3>Teachers</h3>
<p>Average Salary of teachers: <b><%=request.getAttribute("averageSalary")%></b></p>
<c:set scope="page" var="teachers" value="${requstScope.teachers}"/>
<p>
    <c:forEach var="teacher" items="${teachers}">
        <p>
            <c:out value="${teacher.name} ${teacher.surname} has ${teacher.salary} salary"/>
        </p>
    </c:forEach>
</p>
</body>
</html>