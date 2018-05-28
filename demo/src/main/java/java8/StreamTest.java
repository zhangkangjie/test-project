package java8;

import com.zkj.java8.Person;

import java.util.Arrays;
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
                new Person("li", "", 21)
        );

        //list.stream().map(Person::getFirstName).forEach(System.out::println);
        List<String> collect = list.stream().map(Person::getFirstName).collect(Collectors.toList());
        System.out.println(collect);

        List<List<Person>> lists = Arrays.asList(list, list2);
        //List<Person> collect1 = lists.stream().flatMap(personList -> personList.stream()).collect(Collectors.toList());
        List<Person> collect1 = lists.stream().flatMap(List::stream).collect(Collectors.toList());
        collect1.forEach(person -> System.out.println(person.getFirstName()));

        //list to map
        Map<String, Person> companyMap = list.stream().collect(Collectors.toMap(Person::getFirstName, person -> person));

    }
}
