import java.time.Instant;
import java.time.ZoneId;
import java.util.ArrayList;
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
        for (Grade g : grades) {
            if (g.getExam().equals(exam) && g.getStudent().equals(student)) {
                return g.getGradeAt(t);
            }
        }
        return 0.0;
    }
    public double getCourseGrade(Course course, Student student, Instant t) {
        double weightedSum = 0.0;
        double totalCoefficient = 0.0;

        for (Exam exam : exams) {
            if (exam.getCourse().equals(course)) {
                double examGrade = getExamGrade(exam, student, t);
                double coef = exam.getExamCoefficient();
                weightedSum += examGrade * coef;
                totalCoefficient += coef;
            }
        }

        if (totalCoefficient == 0.0) {
            return 0.0;
        }

        return weightedSum / totalCoefficient;
    }

}
