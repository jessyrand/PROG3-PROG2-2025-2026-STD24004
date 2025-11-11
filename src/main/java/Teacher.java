import java.time.LocalDate;

public class Teacher extends User{
    private String speciality;

    public Teacher(int id, String firstName, String lastName, LocalDate dateOfBirth, String email, String phoneNumber, String speciality) {
        super(id, firstName, lastName, dateOfBirth, email, phoneNumber);
        this.speciality = speciality;
    }

    public String getSpeciality() {
        return speciality;
    }
}
