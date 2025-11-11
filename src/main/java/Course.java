public class Course {
    private int id;
    private String label;
    private int credit;
    private Teacher teacher;

    public Course(int id, String label, int credit, Teacher teacher) {
        this.id = id;
        this.label = label;
        this.credit = credit;
        this.teacher = teacher;
    }

    public int getId() {
        return id;
    }

    public int getCredit() {
        return credit;
    }

    public String getLabel() {
        return label;
    }

    public Teacher getTeacher() {
        return teacher;
    }
}
