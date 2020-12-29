package by.academy.app;

import by.academy.entity.Teacher;
import by.academy.repository.PersonRepository;
import by.academy.repository.PersonRepositoryInMemory;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.io.IOException;

@WebServlet(value="/employeemanager")
public class EmployeeManager extends HttpServlet {
    private PersonRepository repository;

    @Override
    public void init() throws ServletException {
        repository = PersonRepositoryInMemory.getInstance();
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("param_name");
        String surname = req.getParameter("param_surname");
        int age = Integer.parseInt((String)req.getParameter("param_age"));
        Double salary = Double.parseDouble(req.getParameter("param_salary"));
        Teacher teacher = new Teacher(name, surname, age, salary);
        repository.save(teacher);
        resp.sendRedirect(req.getContextPath() + "/employeeinsertion");
    }
}
