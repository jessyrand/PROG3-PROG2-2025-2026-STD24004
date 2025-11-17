import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

public class Grade {
    private Student student;
    private Exam exam;
    private double initialGrade;
    private List<GradeHistory> gradeHistory;

    public Grade(Student student, Exam exam, double initialGrade) {
        this.student = student;
        this.exam = exam;
        this.initialGrade = initialGrade;
        this.gradeHistory = new ArrayList<>();
    }

    public Student getStudent() {
        return student;
    }
    public Exam getExam() {
        return exam;
    }
    public double getInitialGrade() {
        return initialGrade;
    }
    public List<GradeHistory> getGradeHistory() {
        return gradeHistory;
    }

    public double getGradeAt(Instant t) {
        double g = initialGrade;
        for (GradeHistory h : gradeHistory) {
            if (!h.getChangedAt().isAfter(t)) {
                g = h.getNewGrade();
            }
        }
        return g;
    }

    public void editGrade(double newGrade, String editReason, Instant changedAt) {
        gradeHistory.add(new GradeHistory(getGradeAt(changedAt), newGrade, editReason, changedAt));
    }
}

