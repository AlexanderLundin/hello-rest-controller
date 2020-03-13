package com.galvanize.controllers;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.galvanize.entities.Person;
import com.galvanize.repository.PersonRepository;
import jdk.jfr.internal.Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;

@RestController
public class HelloRestController {
    private long id = 0L;
    ObjectMapper objectMapper = new ObjectMapper();

    @Autowired
    private PersonRepository personRepository;

//    @GetMapping("/hello")
//    public Person hello(@RequestParam (required = false) String name,
//                        @RequestParam (required = false) String email,
//                        @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate birthDate
//                        ){
//
//        //LocalDate birthDate = new LocalDate();
//        Person person = new Person(id, name, email, birthDate);
//        id += 1L;
//        return person;
//    }


    //CREATE


    @PostMapping("/person")
    public Person helloPerson(@RequestBody Person person){
        return personRepository.save(person);
    }


    //READ


    @GetMapping("/person")
    public ArrayList<Person> getPersonList(){
        return personRepository.getPersonList();
    }

    @GetMapping("/person/{id}")
    public Person getPerson(@PathVariable Long id){
        return personRepository.findById(id);
    }


    //UPDATE


    @PatchMapping("/person/{id}")
    public Person updatePerson(@RequestParam String email, @PathVariable Long id){
        return personRepository.updateEmail(id, email);
    }


    // DELETE


    @DeleteMapping("person/{id}")
    public void deletePerson( @PathVariable Long id){
        personRepository.deletePerson(id);
    }


    @GetMapping("/hello")
    public Person helloRegistration(String name, Date birthDate, String email) {
        Person person = new Person(id, name, email, birthDate);
        id += 1L;
        return person;
    }


    @PostMapping("/hello")
    public Person helloRegistrationPost(@RequestBody Person person) throws IOException {
        return personRepository.save(person);
    }
}
