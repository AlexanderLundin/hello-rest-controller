package com.galvanize.entities;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDate;
import java.time.Period;

public class Person {
    private Long id;
    private String name;
    private String email;
    @JsonFormat(pattern = "MM/dd/yyyy")
    private LocalDate birthDate;

    public Person(Long id, String name, String email, LocalDate birthDate) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.birthDate = birthDate;
    }

    public Person() {
    }

    public int getAge(){
        LocalDate today = LocalDate.now();
        Period period = Period.between(birthDate, today);
        int age = period.getYears();
        return age;
    }
    public Long getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public String getEmail() {
        return this.email;
    }

    @JsonFormat(pattern = "MM/dd/yyyy")
    public LocalDate getBirthDate() {
        return this.birthDate;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @JsonFormat(pattern = "MM/dd/yyyy")
    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }
}
