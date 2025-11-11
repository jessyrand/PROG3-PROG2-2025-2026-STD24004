import java.util.Date;

public class Student extends User{
    private String group;
    private Tutor tutor;

    public Student(int id, String firstName, String lastName, Date dateOfBirth, String email, String phoneNumber, String group, Tutor tutor) {
        super(id, firstName, lastName, dateOfBirth, email, phoneNumber);
        this.group = group;
        this.tutor = tutor;
    }

    public String getGroup() {
        return group;
    }

    public Tutor getTutor() {
        return tutor;
    }
}