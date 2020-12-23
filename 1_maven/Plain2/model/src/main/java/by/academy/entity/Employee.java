package by.academy.entity;
import java.util.List;

public class Employee {
    private String name;
    private String surname;
    private List<Integer> salaries;

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public List<Integer> getSalaries() {
        return salaries;
    }

    public Employee(String name, String surname, List<Integer> salaries) {
        this.name = name;
        this.surname = surname;
        this.salaries = salaries;
    }

    @Override
    public String toString() {
        return "Employee " + name + " " + surname;
    }
}
