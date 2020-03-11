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

    public ArrayList<Person> getPersonList() {
        return this.personList;
    }

    public void updatePersonInList (int index, Person person){
        personList.set(index, person);
    }
    public Person findById(Long id) {
        for (Person person : personList){
            if(person.getId() == id ) {
                return person;
            }
        }
        return null;
    }

    public Person findByName(String name) {
        for (Person person : personList){
            if(person.getName() == name ) return person;
        }
        return null;
    }

    public Person updateEmail(Long id, String email) {
        int index;
        for (Person person : personList){
            if(person.getId() == id ) {
                index  = personList.indexOf(person);
                person.setEmail(email);
                this.updatePersonInList(index, person);
                return person;
            }
        }
        return null;
    }

    //CREATE

    //READ

    //UPDATE

    //DELETE
}
