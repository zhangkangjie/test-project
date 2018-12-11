import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class StreamTest2 {
    public static void main(String[] args) {
        IntStream range = IntStream.range(0, 5);
        range.forEach(System.out::print);
        System.out.println("-------");
        //IllegalStateException: stream has already been operated upon or closed
        //range.filter(i->i>2).forEach(System.out::print);

        List<Integer> list = Arrays.asList(0, 1, 2, 3);
        list.stream().forEach(System.out::print);
        System.out.println("-------");
        list.stream().filter(i->i>2).forEach(System.out::print);


    }
}
