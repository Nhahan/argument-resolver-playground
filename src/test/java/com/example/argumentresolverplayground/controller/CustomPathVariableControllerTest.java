package com.example.argumentresolverplayground.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class CustomPathVariableControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testCustomPathVariable() throws Exception {
        String pathVariable = "testuser";

        MvcResult result = mockMvc.perform(get("/custom/path/" + pathVariable))
                .andReturn();

        String content = result.getResponse().getContentAsString();
        System.out.println("Status: " + result.getResponse().getStatus());
        System.out.println("Response: " + content);
        System.out.println("Error: " + result.getResponse().getErrorMessage());
    }
}
