import java.time.Instant;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Institution {
    private List<Student> students;
    private List<Exam> exams;
    private List<Grade> grades;
    private List<Course> courses;

    public Institution() {
        students = new ArrayList<>();
        exams = new ArrayList<>();
        grades = new ArrayList<>();
        courses = new ArrayList<>();
    }

    public List<Student> getStudents() {
        return students;
    }

    public List<Exam> getExams() {
        return exams;
    }

    public List<Course> getCourses() {
        return courses;
    }

    public List<Grade> getGrades() {
        return grades;
    }

    public void addStudent(Student student) {
        students.add(student);
    }

    public void addExam(Exam exam) {
        exams.add(exam);
    }

    public void addGrade(Grade grade) {
        grades.add(grade);
    }

    public void addCourse(Course course) {
        courses.add(course);
    }

    public double getExamGrade(Exam exam, Student student, Instant t) {
        Grade targetGrade = null;

        for (Grade g : grades) {
            if (g.getExam().equals(exam) && g.getStudent().equals(student)) {
                targetGrade = g;
                break;
            }
        }

        if (targetGrade == null) {
            return 0.0;
        }

        double result = targetGrade.getGrade();

        for (GradeHistory h : targetGrade.getGradeHistory()) {
            Instant changeInstant = h.getChangedAt()
                    .atZone(ZoneId.systemDefault())
                    .toInstant();

            if (!changeInstant.isAfter(t)) {
                result = h.getNewGrade();
            }
        }

        return result;
    }
}
