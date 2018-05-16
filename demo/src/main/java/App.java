import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

/**
 * Hello world!
 *
 */
public class App {
    private final static Pattern decorateStoreUrlPattern = Pattern.compile("369\\.com/(\\d+)/index\\.html");

    public static void main( String[] args )
    {

//        double a = 5.50;
//        DecimalFormat decimalFormat = new DecimalFormat("0.0#");
//        String s = decimalFormat.format(a);
//
//        System.out.println( s );

//        String url = "http://www.i369.com/s/30.html";
//        url ="http://www.i369.com/63/index.html";

//        Matcher matcher = decorateStoreUrlPattern.matcher(url);
//        if (matcher.find()) {
//            int i = matcher.groupCount();
//            for (int j = 0; j <= i; j++) {
//                System.out.println(j+" - "+matcher.group(j));
//            }
//        }

        //System.out.println("http://111.1".matches("http://\\w*\\.\\w*"));

//        ResourceBundle resourceBundle = ResourceBundle.getBundle("t.test");
//        String url = resourceBundle.getString("url");
//        System.out.println(url);
//        Enumeration<String> keys = resourceBundle.getKeys();
//        while (keys.hasMoreElements()){
//            System.out.println(resourceBundle.getString(keys.nextElement()));
//        }

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
