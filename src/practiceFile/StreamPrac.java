package practiceFile;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.stream.Collectors;

public class StreamPrac {
    public static void main(String[] args) {

        List<Person> people = getPeople();

        List<Person> peo = new ArrayList<Person>(people);
        List<Person> peo2 = new ArrayList<Person>();

        Collections.copy(peo, people);
        peo2.addAll(peo);

        System.out.println("peo :" + peo.toString());
        System.out.println("peo2 :" + peo2.toString());

        int sum = people.stream().mapToInt(s -> s.getAge()).sum();

        System.out.println(sum);

        OptionalDouble avg = people.stream().mapToInt(s -> s.getAge()).average();

        

        int c = (int) people.stream().count();

        System.out.println(c);

        Optional<String> oldestFemaleAge = people.stream()
        .filter(person -> person.getGender().equals(Gender.FEMALE))
        .max(Comparator.comparing(Person::getAge))
        .map(Person::getName);

        oldestFemaleAge.ifPresent(System.out::println);
        System.out.println();
        
    // Group
        Map<Gender, List<Person>> groupByGender = people.stream()
            .collect(Collectors.groupingBy(Person::getGender));

        groupByGender.forEach((gender, people1) -> {
        System.out.println(gender);
        people1.forEach(System.out::println);
        System.out.println();
    });

    List<String> names = people.stream().map(name -> name.getName()).collect(Collectors.toList());

    names.forEach(System.out::println);

    List<Integer> ages = people.stream().map(age -> age.getAge()).collect(Collectors.toList());

    }

    private static List<Person> getPeople() {
        return List.of(
            new Person("Antonio", 20, Gender.MALE),
            new Person("Alina Smith", 33, Gender.FEMALE),
            new Person("Helen White", 57, Gender.FEMALE),
            new Person("Alex Boz", 14, Gender.MALE),
            new Person("Jamie Goa", 99, Gender.MALE),
            new Person("Anna Cook", 7, Gender.FEMALE),
            new Person("Zelda Brown", 120, Gender.FEMALE)
        );
      }


      

      
}
