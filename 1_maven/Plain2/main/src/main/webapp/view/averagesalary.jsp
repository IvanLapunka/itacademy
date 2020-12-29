<%@ page contentType="text/html" language="java"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="by.academy.entity.Teacher" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>Average Salary of employees</title>
</head>
<body>
<jsp:include page="inline/menu.jsp"></jsp:include>
<h3>Teachers</h3>
<%@ List teachers = (List)request.getAttribute("teachers") %>

</body>
</html>