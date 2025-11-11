import java.time.LocalDateTime;

public class Exam {
    private int id;
    private String title;
    private Course course;
    private LocalDateTime dateOfExam;
    private int examCoefficient;

    public Exam(int id, String title, Course course, LocalDateTime dateOfExam, int examCoefficient) {
        this.id = id;
        this.title = title;
        this.course = course;
        this.dateOfExam = dateOfExam;
        this.examCoefficient = examCoefficient;
    }
}
