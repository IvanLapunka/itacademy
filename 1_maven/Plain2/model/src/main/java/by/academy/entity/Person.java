package by.academy.entity;

import java.awt.*;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.io.Serializable;

public class Person implements Serializable {

    private static long maxId = 0;

    private Long id;
    private String name;
    private String surname;
    private int age;

    public Person() {
        
    }

    public Person(String name, String surname, int age) {
        this.id = ++maxId;
        this.name = name;
        this.surname = surname;
        this.age = age;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

}
