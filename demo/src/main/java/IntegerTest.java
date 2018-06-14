/**
 * @author kerain
 * @date 2018/2/8
 */
public class IntegerTest {

    static final int i ;
    static {
        // init value in static block
        i = 200;
        System.out.println(i);
    }

    public static void main(String[] args) {
        Integer i1 = 1; // 相当于 Integer.value(1)  may use IntegerCache ;
        Integer i2 = Integer.valueOf(1);
        Integer i3 = new Integer(1);
        Integer i4 = new Integer(1);
        System.out.println(i1 == i2);//result true
        System.out.println(i1 == i3);// false
        System.out.println(i3 == i4); //false
        System.out.println(i3 == i4.intValue()); //true

        int i = 5;
        Byte b = 5;
        System.out.println(i == b);
    }


}
