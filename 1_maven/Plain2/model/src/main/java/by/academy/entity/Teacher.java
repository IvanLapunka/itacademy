package by.academy.entity;

public class Teacher extends Person{
    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    private int salary;

    public Teacher(Long id, String name, String surname, int age) {
        super(id, name, surname, age);
    }

    public Teacher() {

    }

    public Teacher(Long id, String name, String surname, int age, int salary) {
        super(id, name, surname, age);
        this.salary = salary;
    }
}
