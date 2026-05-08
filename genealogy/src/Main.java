import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args){
        try {
            List<Person> people = Person.fromCsv("family.csv");
            PlantUmlRunner.setJarPath("C:/Users/student/Downloads/plantuml-java8-SNAPSHOT.jar");
            //PlantUmlRunner.generate(Person.generateTree(people), "output", "test");
            List<Person> filtered = Person.filterPersonbySubstring(people, "ska");

            filtered.stream()
                    .map(Person::name)
                    .forEach(System.out::println);

        } catch (IOException e) {
            System.err.println("Błąd dostępu do pliku" + e.getMessage());
        }



//        https://plantuml.com/sequence-diagram



    }
}
