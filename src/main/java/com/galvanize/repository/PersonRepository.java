package com.galvanize.repository;

import com.galvanize.entities.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public class PersonRepository {
    ArrayList<Person> personList = new ArrayList<>();

    public Person save(Person person) {
        personList.add(person);
        return person;
    }
}
