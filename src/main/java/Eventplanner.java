import java.util.ArrayList;

public class Eventplanner {
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String phoneNumber;
    private String birthDate;
    private ArrayList<Eveniment> Events = new ArrayList<Eveniment>();
    private static ArrayList<Eveniment> allEvents = new ArrayList<Eveniment>();
    private final String role = "Eventplanner";

    public Eventplanner(){

    }
    public Eventplanner(String firstName, String lastName, String email, String password, String phoneNumber, String birthDate) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.phoneNumber = phoneNumber;
        this.birthDate = birthDate;

    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public String getRole() {
        return role;
    }

    public String toString(){
        return "Role: " + this.getRole() + " FirstName: " + this.getFirstName() + " LastName: " + this.getLastName() + " Email: " + this.getEmail() + " Password: " + this.getPassword() + " PhoneNumber: " + this.getPhoneNumber() + " BirthDate: " + this.getBirthDate();
    }
}
