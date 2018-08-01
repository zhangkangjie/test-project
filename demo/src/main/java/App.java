import java.util.ArrayList;
import java.util.List;

/**
 * Hello world!
 *
 */
public class App {


    public static void main( String[] args )
    {

//        double a = 5.50;
//        DecimalFormat decimalFormat = new DecimalFormat("0.0#");
//        String s = decimalFormat.format(a);
//
//        System.out.println( s );


//        System.out.println(String.valueOf(null));

        //val(null);

        List list = new ArrayList();
        String a = new String("a");
        String b = new String("b");
        String c = new String("c");
        //list.addAll(Arrays.asList(1,2,3));
        list.add(a);
        list.add(b);
        list.add(c);

        List list1 = new ArrayList();
        list1.addAll(list);
        list1.remove(a);
        System.out.println(list);
        System.out.println(list1);

        ArrayList arr = new ArrayList();

        Object arr2 = new Integer[1];

        System.out.println(arr.toString());
        Object object = (Object)arr;
        System.out.println(object.toString());

    }

    public static void val(Object object){
        System.out.println("object");
    }
    public static void val(int i){
        System.out.println("int");
    }
    public static void val(char[] chars){
        System.out.println("char[]");
    }
    public static void val(int[] chars){
        System.out.println("char[]");
    }


}
