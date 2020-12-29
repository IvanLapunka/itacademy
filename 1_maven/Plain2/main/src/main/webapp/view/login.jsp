<html>
<head>
    <title>Login page</title>
</head>
<body>
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
</form>
</body>
</html>