<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>
    <jsp:include page="inline/menu.jsp"></jsp:include>
    <h3>Home Page</h3>
    <p>
        <a href="${pageContext.request.contextPath}/averageSalary">
            Average salary of teachers
        </a>
    </p>
    <p>
        <a href="${pageContext.request.contextPath}/teacher-insertion">
            Teacher Manager
        </a>
    </p>
</body>
</html>