<%@ page contentType= "text/html; UTF-8" language="java" %>
<html>
<body>
The page count is:
<%! int counter = 1; %>
<%! int doubleCount() {
        counter *= 2;
        return counter;
    }
%>
<%= doubleCount() %>
</body>
</html>