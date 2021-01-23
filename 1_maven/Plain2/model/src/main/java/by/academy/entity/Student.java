package by.academy.entity;

import java.util.ArrayList;
import java.util.List;

public class Student extends Person{

    private List<Integer> marks;

    {
        marks = new ArrayList<>();
    }

    public Student(Long id, String name, String surname, int age) {
        super(name, surname, age);
    }

    public Student() {

    }
}
