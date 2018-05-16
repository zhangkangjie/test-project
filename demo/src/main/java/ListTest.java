import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ListTest {
    public static void main(String[] args) {
        List<Object> list = new ArrayList<>();

        list.add(0, 1);
        list.add(1, 1);
        list.add(1, 2);
        System.out.println(Arrays.toString(list.toArray()));
        System.out.println(list);

    }
}
