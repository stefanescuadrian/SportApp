public class Sportsman extends User{

    private final String role = "Sportsman";

    public Sportsman (){
super();
    }

    public String getRole() {
        return role;
    }
    public Sportsman(String firstName, String lastName, String email, String password){
    super(firstName,lastName,email,password);
    }

    public String toString() {
        return super.toString();
    }
}
