import java.time.Instant;

public class GradeHistory {
    private double oldGrade;
    private double newGrade;
    private String editReason;
    private Instant changedAt;

    public GradeHistory(double oldGrade, double newGrade, String editReason, Instant changedAt) {
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

    public Instant getChangedAt() {
        return changedAt;
    }
}
