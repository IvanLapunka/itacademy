<%@ page contentType= "text/html; UTF-8" language="java" import="java.util.*" %>
<html>
<body>
<h1 align="center">Beer recomendations JSP</h1>
<p>
<%
    List<String> styles = (ArrayList<String>)request.getAttribute("styles");
    for(String style: styles){
        out.println("<br> try it now: " + style);
    }
%>
</body>
</html>