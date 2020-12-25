package by.academy.app;

import javax.servlet.*;
import javax.servlet.http.HttpServlet;
import java.io.IOException;
import java.io.PrintWriter;

public class Redirect extends HttpServlet {

    @Override
    public void service(ServletRequest req, ServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter writer = resp.getWriter();
        String param_login = req.getParameter("param_login");
        String param_password = req.getParameter("param_password");
        writer.println("<p><span style='color: blue;'>Deploy на сервер" + param_login + ":" + param_password + "</span></p>");
    }

}
