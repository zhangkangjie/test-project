import java.util.LinkedHashSet;
import java.util.Set;

public class LinkedHashSetTest {
    public static void main(String[] args) {

        //LinkedHashSet  order unsort
        Set set = new LinkedHashSet();
        set.add("1");
        set.add("1");
        set.add("2");

        for (Object o : set) {
            System.out.println(o);
        }
    }
}
