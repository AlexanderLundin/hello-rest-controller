package com.galvanize.repository;

import com.galvanize.entities.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Iterator;

@Repository
public class PersonRepository {
    ArrayList<Person> personList = new ArrayList<>();

    //CREATE


    public Person save(Person person) {
        personList.add(person);
        return person;
    }


    //READ


    public ArrayList<Person> getPersonList() {
        return this.personList;
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

    //UPDATE


    public void updatePersonInList (int index, Person person){
        personList.set(index, person);
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


    //DELETE


    public void deletePerson(Long id) {
        int index;
        // have to use iterator pattern because we can't explicitly modify the personList as we iterate though
        for (Iterator<Person> it = personList.iterator(); it.hasNext();) {
            Person person = it.next();
            if(person.getId() == id ) {
                it.remove();
            }
        }
    }
}
