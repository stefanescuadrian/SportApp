public abstract  class User {
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String role;

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public String getRole() {return role; }

    public User(){

 }
    public User(String firstName, String lastName, String email, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
    }
    public String toString(){
        return "Role: "  + " FirstName: " + this.getFirstName() + " LastName: " + this.getLastName() + " Email: " + this.getEmail() + " Password: " + this.getPassword() + " PhoneNumber: " ;
    }
}

