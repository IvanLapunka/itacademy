package by.academy.repository;

import by.academy.entity.Person;
import by.academy.entity.Teacher;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class PersonRepositoryInMemory implements PersonRepository{
    private static volatile PersonRepositoryInMemory instance;

    private Map<Long, Person> map;

    private PersonRepositoryInMemory() {
        map = new ConcurrentHashMap<>();
        initModel().forEach(teacher -> map.put(teacher.getId(), teacher));
    }

    public static PersonRepositoryInMemory getInstance() {
        if (instance == null) {
            synchronized (PersonRepositoryInMemory.class) {
                if (instance == null){
                    instance = new PersonRepositoryInMemory();
                }
            }
        }
        return instance;
    }

    private List<Teacher> initModel() {
        return List.of(
                new Teacher("Petr", "Petrov", 40),
                new Teacher("Sidr", "Sidorov", 45),
                new Teacher("Ivan", "Ivanov", 50)
        );
    }

    @Override
    public List<Person> findAll() {
        return new LinkedList<>(map.values());
    }

    @Override
    public Optional<Person> findById(long id) {
        return Optional.ofNullable(map.get(id));
    }

    @Override
    public Person save(Person person) {
        if (person.getId() == null) {
            person.setId(new Random().nextLong());
        }
        return map.put(person.getId(), person);
    }

    @Override
    public Person remove(Person person) {
        return map.remove(person.getId());
    }
}
