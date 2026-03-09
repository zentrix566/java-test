package com.example.javatest.service;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class HelloServiceTest {
    private final HelloService helloService = new HelloService();

    @Test
    void sayHello_WithValidName_ReturnsGreeting() {
        String result = helloService.sayHello("Claude");
        assertEquals("Hello Claude!", result);
    }

    @Test
    void sayHello_WithNullName_ReturnsDefaultGreeting() {
        String result = helloService.sayHello(null);
        assertEquals("Hello World!", result);
    }

    @Test
    void sayHello_WithEmptyName_ReturnsDefaultGreeting() {
        String result = helloService.sayHello("   ");
        assertEquals("Hello World!", result);
    }

    @Test
    void sayHello_WithNameWithWhitespace_TrimsWhitespace() {
        String result = helloService.sayHello("  Test User  ");
        assertEquals("Hello Test User!", result);
    }
}
