package by.academy.entity;

public class Teacher extends Person{

    private double salary;

    public double getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public Teacher(String name, String surname, int age) {
        super(name, surname, age);
    }

    public Teacher() {

    }

    public Teacher(String name, String surname, int age, double salary) {
        super(name, surname, age);
        this.salary = salary;
    }
}
