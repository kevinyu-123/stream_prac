package practiceFile;

import java.util.ArrayList;
import java.util.List;

public class CollectionPrac {
    public static void main(String[] args) {

        List<Person> people = getPeople();

        List<PersonExtraInfo> peopleExtraInfo = new ArrayList<PersonExtraInfo>();
        
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
