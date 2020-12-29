<html>
<head>
    <title>Login page</title>
</head>
<body>
<h1 align="center">Login page</h1>

<form action="${pageContext.request.contextPath}/login" method="post">
    Login: <input type="text" name="param_login"/><br/>
    Password: <input type="password" name="param_password"/><br/><br/>
    <input type="submit"/>
    <input type="reset"/>
</form>
</body>
</html>
