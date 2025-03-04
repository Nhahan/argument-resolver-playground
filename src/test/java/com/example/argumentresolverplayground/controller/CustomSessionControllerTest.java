package com.example.argumentresolverplayground.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
class CustomSessionControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testCustomSessionAttribute() throws Exception {
        // 세션 저장
        MvcResult setResult = mockMvc.perform(post("/session"))
                .andExpect(status().isOk())
                .andReturn();

        MockHttpSession session = (MockHttpSession) setResult.getRequest().getSession(false);

        // 세션 호출
        mockMvc.perform(get("/session").session(session))
                .andExpect(status().isOk())
                .andDo(result ->
                        System.out.println(result.getResponse().getContentAsString())
                );
    }
}
