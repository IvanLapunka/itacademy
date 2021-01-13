<%@ page contentType= "text/html; UTF-8" language="java" import="java.util.*" %>
<html>
<body>
The page count is:
<%
    out.println(by.academy.jsp.example.Counter.getCount());
%>
</body>
</html>