package java8;

import java.util.stream.IntStream;

public class StreamGenerate {
    public static void main(String[] args) {
        Integer integer =1;
        IntStream.generate(integer::intValue).limit(5).forEach(i-> System.out.println("i = " + i));
    }
}
