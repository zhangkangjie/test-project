package java8;

import com.zkj.java8.Person;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class Java8Test {
    public static void main(String[] args) {
        String string = "lambda string";
        LambdaInteface lambdaInteface = (s)-> System.out.println("lambda1 print->"+s);
        LambdaInteface lambdaInteface2 = System.out::println;
        lambdaInteface.doSomething(string);
        lambdaInteface2.doSomething(string);

        List<Person> persons = Arrays.asList(
                new Person("zhao","yixing",25),
                new Person("li","yanggui",25),
                new Person("ma","chao",25)
        );

//        checkAndExecute(persons,
//                person -> person.getFirstName().startsWith("z"),
//                System.out::println
//                );

        persons.stream().filter(p -> p.getFirstName().startsWith("z")).forEach(person -> {person.setFirstName("change first name");
            System.out.println(person);});

        Person person = new Person("1","2",3);
        Optional<Person> personOptional = Optional.ofNullable(person);
        personOptional.ifPresent(p -> System.out.println(p));
//        personOptional.map();
        //System.out.println(personOptional.map());


    }

    static void checkAndExecute(List<Person> personList, Predicate<Person> nameChecker, Consumer<Person> executor){
        personList.forEach(person -> { if(nameChecker.test(person) ){executor.accept(person);}  });
    }
}


@FunctionalInterface
interface NameChecker{
    boolean check(Person person);
}

@FunctionalInterface
interface Executor{
    void execute(Person person);
}

@FunctionalInterface
interface LambdaInteface{
    void doSomething(String s);
}