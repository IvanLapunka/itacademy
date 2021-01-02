<html>
<head>
    <title>Login page</title>
</head>
<body>
<h1 align="center">Login page</h1>
<form method="POST" action='${pageContext.request.contextPath}/login' >
    <table border="0" cellspacing="5">
        <tr>
            <th align="right">Login:</th>
            <td align="left"><input type="text" name="param_login"></td>
        </tr>
        <tr>
            <th align="right">Password:</th>
            <td align="left"><input type="password" name="param_password"></td>
        </tr>
        <tr>
            <td align="right"><input type="submit" value="Log In"></td>
            <td align="left"><input type="reset"></td>
        </tr>
    </table>
    <p>
        <% String message = (String)request.getAttribute("error_message");
            if (message == null) {message = "";}
        %>
        <span style="color: red;"><% out.println(message) ;%></span>
    </p>
    <p>Login: admin, password: qwerty</p>
</form>
</body>
</html>