package by.academy.app;

import by.academy.constants.ServletPaths;
import by.academy.entity.Teacher;
import by.academy.repository.PersonRepository;
import by.academy.repository.PersonRepositoryInMemory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(value="/teacherManager")
public class TeacherManager extends HttpServlet {
    private PersonRepository repository;

    @Override
    public void init() throws ServletException {
        repository = PersonRepositoryInMemory.getInstance();
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            String name = req.getParameter("param_name");
            String surname = req.getParameter("param_surname");
            int age = Integer.parseInt((String) req.getParameter("param_age"));
            Double salary = Double.parseDouble(req.getParameter("param_salary"));
            Teacher teacher = new Teacher(name, surname, age, salary);
            repository.save(teacher);
        } catch (NumberFormatException e) {
            req.setAttribute("error_message", "The you have entered wrong age or salary. Age should be the natural value, salary should be real.");
        }
        req.getRequestDispatcher(ServletPaths.TEACHER_MANAGER_VIEW).forward(req, resp);
    }
}
