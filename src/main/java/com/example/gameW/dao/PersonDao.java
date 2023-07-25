package com.example.gameW.dao;

import com.example.gameW.models.Person;
import org.springframework.stereotype.Component;


import java.util.ArrayList;
import java.util.List;
@Component
public class PersonDao {
    private List<Person> people;

    private List<String> result = new ArrayList<>();

    private static int NUMBER_ID;

    {
        people = new ArrayList<>();
        people.add(new Person(NUMBER_ID++,"bob"));
        people.add(new Person(NUMBER_ID++,"sam"));
        people.add(new Person(NUMBER_ID++,"marge"));
    }
    public List<Person> index(){
        return people;
    }

    public Person show(int id){
        return people.stream().filter(person -> person.getId() == id).findAny().orElse(null);
    }

    public void save(Person person){
        person.setId(NUMBER_ID++);
        people.add(person);
    }
    public void update(int id, Person updatedPerson) {
        Person personToBeUpdated = show(id);

        personToBeUpdated.setName(updatedPerson.getName());
    }

    public void delete(int id) {
        people.removeIf(p -> p.getId() == id);
    }



}
