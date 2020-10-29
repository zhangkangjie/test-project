package demo.testng;

import org.testng.annotations.Test;

public class TestMultipleThreads {

    @Test(invocationCount = 1)
    public void loadTestThisWebsite() {

        System.out.println(1111);

    }
}

