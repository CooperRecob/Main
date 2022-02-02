package apcs.unit7.arrayListWithMethods;
import java.util.ArrayList;

public class Classroom {
    private String subject;
    private String teacher;
    private ArrayList<Student> students = new ArrayList<Student>();

    public Classroom(String subject, String teacher, ArrayList<Student> students) {
        this.subject = subject;
        this.teacher = teacher;
        this.students = students;
    }

    public void addStudent(Student studentName) {
        students.add(studentName);
    }

    public Student mostMissing() {
        Student mostMissing = students.get(0);

        for(int i = 0; i < students.size(); i++) {
            if(students.get(i).getMissingAssingments() > mostMissing.getMissingAssingments()) {
                mostMissing = students.get(i);
            }
        }
        return mostMissing;
    }

    public int numberOfAs() {
        int numberOfAs = 0;

        for(int i = 0; i < students.size(); i++) {
            if(students.get(i).getGradePercentage() >= 90) {
                numberOfAs++;
            }
        }
        return numberOfAs;
    }

    public ArrayList<String> generateEnrichmentList() {
        ArrayList<String> studentsGoingToDaHole = new ArrayList<String>();

        for(int i = 0; i < students.size(); i++) {
            if(students.get(i).getMissingAssingments() >= 3 || students.get(i).getGradePercentage() < 65) {
                studentsGoingToDaHole.add(students.get(i).getName());
            }
        }
        return studentsGoingToDaHole;
    }
}
