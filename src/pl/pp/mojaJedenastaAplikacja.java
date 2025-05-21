package pl.pp;
import java.util.*;
import java.util.stream.Collectors;
import java.util.Locale;
class Student {
    private String indexNumber;
    private String firstName;
    private String lastName;
    private List<Integer> grades;

    public Student(String indexNumber, String firstName, String lastName, List<Integer> grades) {
        this.indexNumber = indexNumber;
        this.firstName = firstName;
        this.lastName = lastName;
        this.grades = grades;
    }

    public String getIndexNumber() {
        return indexNumber;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public List<Integer> getGrades() {
        return grades;
    }

    public double getAverageGrade() {
        return grades.stream().mapToInt(Integer::intValue).average().orElse(0.0);
    }
}

public class mojaJedenastaAplikacja {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);

        List<Student> students = Arrays.asList(
                new Student("92303", "Grzegosz", "Nowak", Arrays.asList(4, 5, 3, 5)),
                new Student("34213", "Anna", "Mudryk", Arrays.asList(5, 5, 4, 4)),
                new Student("54721", "Katarzyna", "Wiśniewska", Arrays.asList(2, 3, 2, 4)),
                new Student("09816", "Msteysz", "Kowalczyk", Arrays.asList(5, 4, 4, 5))
        );

        Student topStudent = students.stream()
                .max(Comparator.comparingDouble(Student::getAverageGrade))
                .orElse(null);

        if (topStudent != null) {
            System.out.printf("Student z najwyższą średnią: %s %s (%s) - Average: %.2f\n",
                    topStudent.getFirstName(),
                    topStudent.getLastName(),
                    topStudent.getIndexNumber(),
                    topStudent.getAverageGrade()
            );
        }

        List<Student> sortedStudents = students.stream()
                .sorted(Comparator.comparing(Student::getLastName))
                .collect(Collectors.toList());

        System.out.println("Studenci posortowani według nazwisk:");
        for (Student s : sortedStudents) {
            System.out.printf("%s %s (%s) - Average: %.2f\n",
                    s.getFirstName(),
                    s.getLastName(),
                    s.getIndexNumber(),
                    s.getAverageGrade()
            );
        }
    }
}





