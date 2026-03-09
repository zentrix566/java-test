package com.example.javatest.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class HelloControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @Test
    void hello_WithoutName_ReturnsDefaultGreeting() throws Exception {
        mockMvc.perform(get("/hello"))
                .andExpect(status().isOk())
                .andExpect(content().string("Hello World!"));
    }

    @Test
    void hello_WithName_ReturnsCustomGreeting() throws Exception {
        mockMvc.perform(get("/hello").param("name", "CI Pipeline"))
                .andExpect(status().isOk())
                .andExpect(content().string("Hello CI Pipeline!"));
    }

    @Test
    void hello_WithEmptyName_ReturnsDefaultGreeting() throws Exception {
        mockMvc.perform(get("/hello").param("name", "   "))
                .andExpect(status().isOk())
                .andExpect(content().string("Hello World!"));
    }
}
