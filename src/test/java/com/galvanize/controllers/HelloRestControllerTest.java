package com.galvanize.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.galvanize.entities.Person;
import jdk.vm.ci.code.site.Call;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;

import static org.hamcrest.Matchers.containsString;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc

public class HelloRestControllerTest {
    String robName = "rob";
    String robEmail = "rob.wing@galvanize.com";

    @Autowired
    MockMvc mvc;

    ObjectMapper mapper = new ObjectMapper();
    {
        // This is how to get java.time.LocalDate to parse and deserialize properly
        mapper.registerModule(new JavaTimeModule());
        mapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
    }

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

    @Test
    public void TestHelloRegGetReturnsAPerson() throws Exception {
        //Setup
        String url = "/hello?name=rob&birthDate=11/16/1962&email=rob.wing@galvanize.com";
        //Exercise
        mvc.perform(get(url))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("rob.wing@galvanize.com")))
                .andExpect(jsonPath("$.age").value(57));
        //Assert
        //Teardown
    }

    @Test
    void TestHelloRegPostReturnsPerson() throws Exception {
        String body = "{\"name\":\"Rob\",\"birthDate\":\"11/16/1962\",\"email\":\"rob.wing@galvanize.com\"}";
        //Person person = new Person("Rob", "rob.wing@galvanize.com", LocalDate.now());
        //String body = mapper.writeValueAsString(person);
        mvc.perform(post("/hello")
                .content(body)
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
        )
                .andExpect(status().isOk())
                .andDo(print())
                .andExpect(content().string(containsString("rob.wing@galvanize.com")))
                .andExpect(jsonPath("$.age").value(57));
    }
}
