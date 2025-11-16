import java.time.LocalDateTime;

public class GradeHistory {
    private double oldGrade;
    private double newGrade;
    private String editReason;
    private LocalDateTime changedAt;

    public GradeHistory(double oldGrade, double newGrade, String editReason, LocalDateTime changedAt) {
        this.oldGrade = oldGrade;
        this.newGrade = newGrade;
        this.editReason = editReason;
        this.changedAt = changedAt;
    }

    public double getOldGrade() {
        return oldGrade;
    }

    public double getNewGrade() {
        return newGrade;
    }

    public String getEditReason() {
        return editReason;
    }

    public LocalDateTime getChangedAt() {
        return changedAt;
    }
}
