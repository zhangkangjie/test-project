package com.example.demo.testng;

import org.testng.annotations.Test;

public class TestMultipleThreads3 {

    @Test(invocationCount = 10, threadPoolSize = 3)
    public void testThreadPools() {

        System.out.printf("Thread Id : %s%n", Thread.currentThread().getId());

    }
}

