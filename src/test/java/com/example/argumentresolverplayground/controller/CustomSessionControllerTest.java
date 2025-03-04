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

        MockHttpSession session = (MockHttpSession) setResult.getRequest().getSession();
        
        // 세션에 "hello" = "world!" 가 저장되었는지 확인
        System.out.println("Session attribute 'hello': " + session.getAttribute("hello"));

        // 세션 호출
        MvcResult getResult = mockMvc.perform(get("/session").session(session))
                .andExpect(status().isOk())
                .andReturn();

        String content = getResult.getResponse().getContentAsString();
        System.out.println("Response: " + content);
        
        // ArgumentResolver가 동작했다면 "hello=world!"를 반환해야 함
        assert content.equals("hello=world!") : 
            "Expected 'hello=world!' but got '" + content + "'";
    }
}
