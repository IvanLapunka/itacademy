package by.academy.listener.example;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class MyServletContextListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        ServletContext sc = servletContextEvent.getServletContext();
        String dogBread = sc.getInitParameter("breed");
        Dog d = new Dog(dogBread);
        sc.setAttribute("dog", d);
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {

    }
}
