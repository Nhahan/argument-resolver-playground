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
public class CustomRequestParamControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testCustomRequestParam() throws Exception {
        String paramValue = "testuser";
        
        MvcResult result = mockMvc.perform(get("/custom/request")
                        .param("name", paramValue))
                .andExpect(status().isOk())
                .andReturn();

        String content = result.getResponse().getContentAsString();
        System.out.println("Response: " + content);
        
        // ArgumentResolver가 동작했다면 "Custom Request Param: testuser"를 반환해야 함
        assert content.equals("Custom Request Param: " + paramValue) : 
            "Expected 'Custom Request Param: " + paramValue + "' but got '" + content + "'";
    }
}
