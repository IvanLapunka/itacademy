package by.academy.repository;

import by.academy.entity.Person;

import java.util.List;
import java.util.Optional;

public interface PersonRepository {
    List<Person> findAll();
    Optional<Person> findById(long id);
    Person save(Person person);
    Person remove(Person person);
}
