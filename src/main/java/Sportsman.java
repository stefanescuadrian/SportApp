public class Sportsman extends User{

    private final String role = "Sportsman";

    public Sportsman (){
        super();
    }

    public String getRole() {
        return role;
    }
    public Sportsman(String firstName, String lastName, String email, String password, byte[] salt){
    super(firstName,lastName,email,password,salt);
    }

    public String toString() {
        return super.toString();
    }
}
