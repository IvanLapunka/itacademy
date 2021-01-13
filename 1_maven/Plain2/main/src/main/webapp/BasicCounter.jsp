<%@ page contentType= "text/html; UTF-8" language="java" %>
<%@ page import="java.util.*,by.academy.jsp.example.Counter" %>
<html>
<body>
The page count is:
<%
    out.println(Counter.getCount());
%>
</body>
</html>