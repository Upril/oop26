import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args){
        CustomList<String> list = new CustomList<>();

        list.addLast("ala");
        list.addLast("ma");
        list.addLast("kota");

        list.addFirst("Mala");

        System.out.println(list.getFirst());
        System.out.println(list.removeLast());
        System.out.println(list.removeLast());

    }
}
