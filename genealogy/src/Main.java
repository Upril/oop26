import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args){
        try {
            List<Person> people = Person.fromCsv("family.csv");

            List<Person> sortedDead = Person.getDeceasedByLifespan(people);

            PlantUmlRunner.setJarPath("C:/Users/student/Downloads/plantuml-java8-SNAPSHOT.jar");
            PlantUmlRunner.generate(Person.generateTree(
                                                people,
                                                text -> String.format("%s #FFFF00", text),
                                                sortedDead::contains),
                    "output",
                    "test");
            //List<Person> sorted = Person.sorted(people);
            //
            Person p = Person.getOldestLiving(people);
            System.out.println(p);

//            sortedDead.stream()
//                    .map(Person::name)
//                    .forEach(System.out::println);

        } catch (IOException e) {
            System.err.println("Błąd dostępu do pliku" + e.getMessage());
        }



//        https://plantuml.com/sequence-diagram



    }
}
