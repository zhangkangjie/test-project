package demo.junit;

import junit.framework.TestCase;
import org.junit.Test;

/**
 * @author kangjie.zhang
 * @date 2020/5/27 11:09
 */


public class MyTest extends TestCase {


    @Test

    public void test() {
        System.out.println("run test");
    }

    @Override
    protected void setUp() throws Exception {
        System.out.println("set up");
    }

    @Override
    protected void tearDown() throws Exception {
        System.out.println("tearDown");
    }
}
