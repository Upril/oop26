import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args){
//        try {
//            List<Person> people = Person.fromCsv("family.csv");
//            Person.toBinaryFile(people,"data.bin");
//
//            List<Person> people2 = Person.fromBinaryFile("data.bin");
//            System.out.println(people2);
//        } catch (IOException e){
//            System.err.println("Błąd dostępu do pliku" + e.getMessage());
//        } catch (ClassNotFoundException e) {
//            throw new RuntimeException(e);
//        }
        PlantUmlRunner.setJarPath("C:/Users/student/Downloads/plantuml-java8-SNAPSHOT.jar");
        String umlData = "@startuml\n" +
                "Alice -> Bob: Authentication Request\n" +
                "Bob --> Alice: Authentication Response\n" +
                "\n" +
                "Alice -> Bob: Another authentication Request\n" +
                "Alice <-- Bob: Another authentication Response\n" +
                "@enduml\n";

//        https://plantuml.com/sequence-diagram

        PlantUmlRunner.generate(umlData, "output","test");

    }
}
