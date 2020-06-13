public class Inregistrare {
    private Eveniment E;
    private String sportsmanFirstName;
    private String sportsmanLastName;
    private String sportsmanEmail;
    private String status;

    public Inregistrare(){

    }

    public Inregistrare(Eveniment e, String sportsmanFirstName, String sportsmanLastName, String sportsmanEmail) {
        E = e;
        this.sportsmanFirstName = sportsmanFirstName;
        this.sportsmanLastName = sportsmanLastName;
        this.sportsmanEmail = sportsmanEmail;
        this.status = "Pending";
    }

    public Eveniment getE() {
        return E;
    }

    public void setE(Eveniment e) {
        E = e;
    }

    public String getSportsmanFirstName() {
        return sportsmanFirstName;
    }

    public void setSportsmanFirstName(String sportsmanFirstName) {
        this.sportsmanFirstName = sportsmanFirstName;
    }

    public String getSportsmanLastName() {
        return sportsmanLastName;
    }

    public void setSportsmanLastName(String sportsmanLastName) {
        this.sportsmanLastName = sportsmanLastName;
    }

    public String getSportsmanEmail() {
        return sportsmanEmail;
    }

    public void setSportsmanEmail(String sportsmanEmail) {
        this.sportsmanEmail = sportsmanEmail;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
