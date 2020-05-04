public class Sportsman {
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private final String role = "Sportsman";

    public Sportsman (){

    }

    public String getRole() {
        return role;
    }
    public Sportsman(String firstName, String lastName, String email, String password){
        this.firstName = firstName;
        this.email = email;
        this.lastName = lastName;
        this.password = password;
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

    public String toString(){
        return "Role: " + this.getRole() + " FirstName: " + this.getFirstName() + " LastName: " + this.getLastName() + " Email: " + this.getEmail() + " Password: " + this.getPassword();
    }
}
