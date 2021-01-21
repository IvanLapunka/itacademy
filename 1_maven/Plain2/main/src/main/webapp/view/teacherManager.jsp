<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Teacher's manager</title>
</head>
<body>
<jsp:include page="inline/menu.jsp"></jsp:include>
<form method="POST" action='${pageContext.request.contextPath}/teacherManager' >
<table>
    <tr>
        <th>
            Name
        </th>
        <td>
            <input type="text" name="param_name">
        </td>
    </tr>
    <tr>
        <th>
            Surname
        </th>
        <td>
            <input type="text" name="param_surname">
        </td>
    </tr>
    <tr>
        <th>
            Age
        </th>
        <td>
            <input type="text" name="param_age">
        </td>
    </tr>
    <tr>
        <th>
            Salaries
        </th>
        <td>
            <input type="text" name="param_salary">
        </td>
    </tr>
    <tr>
        <td align="right"><input type="submit" value="Insert"></td>
        <td align="left"><input type="reset"></td>
    </tr>
</table>
<% String message = (String)request.getAttribute("error_message");
            if (message == null) {message = "";}
%>
<span style="color: red;"><% out.println(message) ;%></span>
</form>
</body>
</html>