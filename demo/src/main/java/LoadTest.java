public class LoadTest {
    static int anInt = print(1);
    {
        System.out.println("代码块");
    }
    static int int2 = print(2);
    static {
        System.out.println("静态代码块");
    }
    static int int3 = print(3);
    static int print(int i){
        System.out.println("print "+i);
        return i;
    }

    public static void main(String[] args) {
        System.out.println("test static");
        new LoadTest();
    }
}
