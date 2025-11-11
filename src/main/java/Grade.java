import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Grade {
    private Student student;
    private Exam exam;
    private double grade;
    private List<GradeHistory> gradeHistory;

    public Grade(Student student, Exam exam, double initialGrade) {
        this.student = student;
        this.exam = exam;
        this.grade = initialGrade;
        this.gradeHistory = new ArrayList<>();
    }

    public Student getStudent() {
        return student;
    }
    public Exam getExam() {
        return exam;
    }
    public double getGrade() {
        return grade;
    }
    public List<GradeHistory> getGradeHistory() {
        return gradeHistory;
    }

    public void editGrade(double newGrade, String editReason, LocalDateTime changedAt) {
        GradeHistory history = new GradeHistory(this.grade, newGrade, editReason, changedAt);
        this.gradeHistory.add(history);
        this.grade = newGrade;
    }
}
