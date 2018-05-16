public class ExtendsTest {
    static class Human {
        protected void sayHello() {
            System.out.println("Human say hello");
        }

    }

    static class Man extends Human {

//        @Override
//        protected void sayHello() {
//            System.out.println("Man say hello");
//        }

    }

    public static void main(String[] args) {

        Human man = new Man();
        man.sayHello();
        System.out.println(man.getClass().getName());

        Object object = new int[]{};
        int[] arr = {};

    }
}


