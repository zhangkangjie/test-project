package com.example.demo.junit;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.List;

/**
 * @author kangjie.zhang@ttpai.cn
 * @date 2020/5/27 13:44
 */
@RunWith(Parameterized.class)
public class ParameterizedTest {

    public ParameterizedTest(String o) {
        System.out.println(o);
    }

    @Parameterized.Parameters
    public static List<String> data() {
        return Arrays.asList("1", "a", "2", "b");
    }

    @Test
    public void test() {

    }

}
