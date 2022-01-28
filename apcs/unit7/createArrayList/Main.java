package apcs.unit7.createArrayList;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
    ArrayList<Doggie> dog = new ArrayList<Doggie>();

    Doggie bailey = new Doggie(12, "Bailey");

    dog.add(new Doggie(4, "Campi"));
    dog.add(new Doggie(2, "Norah"));
    dog.add(bailey);
    }
}
