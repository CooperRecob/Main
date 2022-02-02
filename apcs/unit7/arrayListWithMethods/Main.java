package apcs.unit7.arrayListWithMethods;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<Student> students1 = new ArrayList<Student>();
        students1.add(new Student("Qadry", 12, 88.7));
        for(int i = 0; i < 4; i++) {
            students1.add(new Student("Example" + i, i, i * 30));
        }

        ArrayList<Student> students2 = new ArrayList<Student>();
        students1.add(new Student("Rodgi", 0, 100));
        for(int i = 0; i < 4; i++) {
            students1.add(new Student("Example" + i, i, i * 30));
        }

        Classroom cs1 = new Classroom("Computer Science 1", "Mr. Sarbacker", students1);
        Classroom apcs = new Classroom("AP Computer Science", "Mr. Sarbacker", students2);

        cs1.generateEnrichmentList();
        apcs.generateEnrichmentList();
        cs1.mostMissing();
        apcs.mostMissing();
        cs1.numberOfAs();
        apcs.numberOfAs();
    }
}
