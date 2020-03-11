package com.galvanize.entities;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;

import static org.junit.jupiter.api.Assertions.*;

class PersonTest {

    Person person;
    Long id;
    String name;
    String email;
    LocalDate birthDate;

    @BeforeEach
    public void Setup() {
        //Setup
        person = new Person();
        id = 258L;
        name = "Storm trooper";
        email = "youknowit@yahoo.com";
        birthDate = LocalDate.of(2017, 1, 15);

    }

    @Test
    void SettersAndGetters() {
        person.setId(id);
        person.setName(name);
        person.setEmail(email);
        person.setBirthDate(birthDate);
        long actualId = person.getId();
        assertEquals(id, actualId);
        String actualName = person.getName();
        assertEquals(name, actualName);
        String actualEmail = person.getEmail();
        assertEquals(email, actualEmail);
        LocalDate actualBirthDate = person.getBirthDate();
        assertEquals(birthDate, actualBirthDate);
        LocalDate today = LocalDate.now();
        int expectedAge = Period.between(birthDate, today).getYears();
        int actualAge = person.getAge();
        assertEquals(expectedAge, actualAge);
    }






}