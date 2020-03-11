package com.galvanize.controllers;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.galvanize.entities.Person;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;

@RestController
public class HelloRestController {
    private long id = 0L;

    @GetMapping("/hello")
    public Person hello(@RequestParam (required = false) String name,
                        @RequestParam (required = false) String email,
                        @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate birthDate
                        ){

        //LocalDate birthDate = new LocalDate();
        Person person = new Person(id, name, email, birthDate);
        id += 1L;
        return person;
    }
}
