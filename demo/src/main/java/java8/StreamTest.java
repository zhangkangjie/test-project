package java8;

import com.zkj.java8.Person;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class StreamTest {

    public static void main(String[] args) {
        List<Person> list = Arrays.asList(
                new Person("zhang", "", 20),
                new Person("wong", "", 21),
                new Person("lee", "", 22),
                new Person("li", "", 21)
        );
        List<Person> list2 = Arrays.asList(
                new Person("zh", "", 20),
                new Person("wo", "", 21),
                new Person("le", "", 22),
                new Person("li", "", 23),
                new Person("li", "", 22)
        );
        /*
         * map 映射  a -> b
         */
        //list.stream().map(Person::getFirstName).forEach(System.out::println);
        List<String> collect = list.stream().map(Person::getFirstName).collect(Collectors.toList());
        System.out.println(collect);

        List<List<Person>> lists = Arrays.asList(list, list2);
        //List<Person> collect1 = lists.stream().flatMap(personList -> personList.stream()).collect(Collectors.toList());
        List<Person> collect1 = lists.stream().flatMap(List::stream).collect(Collectors.toList());
        collect1.forEach(person -> System.out.println(person.getFirstName()));

        //list to map
        Map<String, Person> companyMap = list.stream().collect(Collectors.toMap(Person::getFirstName, person -> person));
        Map<String, List<Person>> collect2 = list2.stream().collect(Collectors.groupingBy(Person::getFirstName));
        System.out.println(collect2);

        //sorted
        System.out.println("before sort list 2");
        list2.stream().forEach(person -> System.out.print(person.getAge()+" "));
        System.out.println();
        System.out.println("after sorted");
        list2.stream().sorted(Comparator.comparing(Person::getAge)).forEach(person -> System.out.print(person.getAge()+" "));
        System.out.println();
        System.out.println("reverse order");
        list2.stream().sorted(Comparator.comparing(Person::getAge).reversed()).forEach(person -> System.out.print(person.getAge()+" "));
        System.out.println();

        //min or max
        Person minPerson = list2.stream().min(Comparator.comparing(Person::getAge)).get();
        System.out.println("min age "+minPerson.getAge());
        //remove min person
        List<Person> list22 = new ArrayList<>(list2);
        list22.remove(minPerson);
        System.out.println(list22);


    }
}
