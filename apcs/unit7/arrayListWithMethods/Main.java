package apcs.unit7.arrayListWithMethods;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<Student> students1 = new ArrayList<Student>();
        students1.add(new Student("Qadry", 12, 88.7));
        for(int i = 1; i < 5; i++) {
            students1.add(new Student("Example" + i, i, i * 30));
        }

        ArrayList<Student> students2 = new ArrayList<Student>();
        students2.add(new Student("Rodgi", 0, 100));
        for(int i = 1; i < 5; i++) {
            students2.add(new Student("Example" + i, i, i * 30));
        }

        Classroom cs1 = new Classroom("Computer Science 1", "Mr. Sarbacker", students1);
        Classroom apcs = new Classroom("AP Computer Science", "Mr. Sarbacker", students2);

        System.out.println(cs1.generateEnrichmentList());
        System.out.println(apcs.generateEnrichmentList());
        System.out.println(cs1.mostMissing().getName());
        System.out.println(apcs.mostMissing().getName());
        System.out.println(cs1.numberOfAs());
        System.out.println(apcs.numberOfAs());
    }
}
