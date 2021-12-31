package com.example.demo.junit;

import org.junit.Test;

public class TestJunit2 {

    String message = "Robert";


    @Test
    public void testSalutationMessage() {
        System.out.println("Inside testSalutationMessage()");
        message = "Hi!" + "Robert";

    }
}
