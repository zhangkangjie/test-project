package demo.testng;

import org.testng.annotations.Test;

public class TestMultipleThreads2 {

    @Test(invocationCount = 3, threadPoolSize = 3)
    public void testThreadPools() {

        System.out.printf("Thread Id : %s%n", Thread.currentThread().getId());

    }
}

