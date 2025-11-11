import java.util.Date;

public class Tutor extends User {
    private String linkWithStudent;

    public Tutor(int id, String firstName, String lastName, Date dateOfBirth, String email, String phoneNumber, String linkWithStudent) {
        super(id, firstName, lastName, dateOfBirth, email, phoneNumber);
        this.linkWithStudent = linkWithStudent;
    }

    public String getLinkWithStudent() {
        return linkWithStudent;
    }
}
