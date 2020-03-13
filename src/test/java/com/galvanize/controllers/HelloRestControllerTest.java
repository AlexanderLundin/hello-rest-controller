package com.galvanize.controllers;

import com.galvanize.entities.Person;
import jdk.vm.ci.code.site.Call;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HelloRestControllerTest {
    String robName = "rob";
    String robEmail = "rob.wing@galvanize.com";


    //1
    //Acceptance criteria for helloregistration with person object
    @Test
    public void TestHelloRegistration() {
        //Setup
        HelloRestController hrc = new HelloRestController();
        Person p = hrc.helloRegistration(robName, getTestDob(10), robEmail);
        //Exercise
        int actual = p.getAge();
        int expected = 10;
        //Assert
        assertEquals(expected, actual);
        //Teardown
    }

    // Method to create a date in past for testing
    private Date getTestDob(int years){
        LocalDate ld = LocalDate.now();
        ld.minusYears(11);

        Calendar ci = Calendar.getInstance();
        ci.add(Calendar.YEAR, - years);
        return ci.getTime();
    }
}
