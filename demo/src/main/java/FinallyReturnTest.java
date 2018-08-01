import com.zkj.java8.Person;

public class FinallyReturnTest {
    public static void main(String[] args) {
        System.out.println(getInt());
        System.out.println(getObject().getAge());

    }
    static int getInt(){
        int i = 0;
        try {
            i++;
            return i;
        }finally {
            i++;//never used
        }

    }
    static int getInt2(){
        int i = 0;
        try {
            i++;
        }finally {
            i++;
        }
        return i;

    }
    static Person getObject(){
        Person person = new Person("x", "y", 20);
        try {

            person.setAge(21);
            return person;
        }finally {
            person.setAge(22);
        }
    }
}
