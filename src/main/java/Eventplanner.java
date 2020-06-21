public class Eventplanner extends User {
    private String phoneNumber;
    private String birthDate;
    private final String role = "Eventplanner";

    public Eventplanner(){
    super();
    }
    public Eventplanner(String firstName, String lastName, String email, String password, String phoneNumber, String birthDate, byte[] salt) {
        super(firstName,lastName,email,password,salt);
        this.phoneNumber = phoneNumber;
        this.birthDate = birthDate;

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
       return super.toString() +"Phone Number: "+this.getPhoneNumber()+"BirthDate: "+this.getBirthDate();
    }
}
