import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

public class InstitutionTest {

    private static Institution inst;
    private static Student s;
    private static Course math;
    private static Exam e1;
    private static Exam e2;
    private static Instant t1, t2, t3, t4;

    @BeforeAll
    static void setup() {
        inst = new Institution();

        s = new Student(1, "Alice", "Smith", LocalDate.of(2000,1,1), "alice@email.com", "123456789", "G1", null);
        math = new Course(1, "Math", 5, null);
        e1 = new Exam(1, "Math Exam 1", math, LocalDateTime.of(2024,1,1,10,0), 2);
        e2 = new Exam(2, "Math Exam 2", math, LocalDateTime.of(2024,1,2,10,0), 3);

        inst.addStudent(s);
        inst.addCourse(math);
        inst.addExam(e1);
        inst.addExam(e2);

        t1 = Instant.parse("2024-01-01T09:00:00Z");
        t2 = Instant.parse("2024-01-01T10:30:00Z");
        t3 = Instant.parse("2024-01-02T11:00:00Z");
        t4 = Instant.parse("2024-01-03T12:00:00Z");

        Grade g1 = new Grade(s, e1, 10.0);
        g1.editGrade(12.0, "Correction 1", Instant.parse("2024-01-01T10:30:00Z"));
        inst.addGrade(g1);

        Grade g2 = new Grade(s, e2, 15.0);
        g2.editGrade(18.0, "Correction 2", Instant.parse("2024-01-02T11:00:00Z"));
        inst.addGrade(g2);
    }

    @Test
    void getExamGrade_test() {
        assertEquals(10.0, inst.getExamGrade(e1, s, t1));
        assertEquals(12.0, inst.getExamGrade(e1, s, t2));
        assertEquals(12.0, inst.getExamGrade(e1, s, t3));
        assertEquals(12.0, inst.getExamGrade(e1, s, t4));

        assertEquals(15.0, inst.getExamGrade(e2, s, t1));
        assertEquals(15.0, inst.getExamGrade(e2, s, t2));
        assertEquals(18.0, inst.getExamGrade(e2, s, t3));
        assertEquals(18.0, inst.getExamGrade(e2, s, t4));
    }

    @Test
    void getCourseGrade_test() {
        double gradeAtT1 = (10.0*2 + 15.0*3) / 5.0;
        double gradeAtT2 = (12.0*2 + 15.0*3) / 5.0;
        double gradeAtT3 = (12.0*2 + 18.0*3) / 5.0;
        double gradeAtT4 = gradeAtT3;

        assertEquals(gradeAtT1, inst.getCourseGrade(math, s, t1));
        assertEquals(gradeAtT2, inst.getCourseGrade(math, s, t2));
        assertEquals(gradeAtT3, inst.getCourseGrade(math, s, t3));
        assertEquals(gradeAtT4, inst.getCourseGrade(math, s, t4));
    }
}
