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


}
