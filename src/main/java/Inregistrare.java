import javafx.beans.property.SimpleStringProperty;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Inregistrare {
    private Eveniment E;
    private String sportsmanFirstName;
    private String sportsmanLastName;
    private String sportsmanEmail;
    private String status = "Pending";
    private ImageView photo;

    private Label L;
    private SimpleStringProperty eNC;
    private SimpleStringProperty eD;
    private SimpleStringProperty eC;
    private SimpleStringProperty sportsmanFNLN;



    public Inregistrare(){

    }

    public Inregistrare(Eveniment e, String sportsmanFirstName, String sportsmanLastName, String sportsmanEmail, String status) {
        E = e;
        this.sportsmanFirstName = sportsmanFirstName;
        this.sportsmanLastName = sportsmanLastName;
        this.sportsmanEmail = sportsmanEmail;
        this.status = status;

        if (E.getEventCategory().equals("Basketball")) {
            photo = new ImageView(new Image(this.getClass().getResourceAsStream("x1.png")));
            photo.setFitWidth(50);
            photo.setFitHeight(50);
        } else if (E.getEventCategory().equals("Rugby")) {
            photo = new ImageView(new Image(this.getClass().getResourceAsStream("x2.png")));
            photo.setFitWidth(50);
            photo.setFitHeight(50);
        } else if (E.getEventCategory().equals("Jogging")) {
            photo = new ImageView(new Image(this.getClass().getResourceAsStream("x3.png")));
            photo.setFitWidth(50);
            photo.setFitHeight(50);
        } else if (E.getEventCategory().equals("Tennis")) {
            photo = new ImageView(new Image(this.getClass().getResourceAsStream("x4.png")));
            photo.setFitWidth(50);
            photo.setFitHeight(50);
        } else if (E.getEventCategory().equals("Football")) {
            photo = new ImageView(new Image(this.getClass().getResourceAsStream("x5.png")));
            photo.setFitWidth(50);
            photo.setFitHeight(50);
        }
        L = new Label();
        L.setText(E.getEventCategory());

        eNC = new SimpleStringProperty(E.getEventName() + '\n' + L.getText());
        eD = new SimpleStringProperty(E.getEventDescription());
        eC = new SimpleStringProperty(E.getEventCategory());
        sportsmanFNLN = new SimpleStringProperty(sportsmanFirstName + " " +sportsmanLastName);
    }

    public Inregistrare(String sportsmanFirstName, String sportsmanLastName) {
        sportsmanFNLN = new SimpleStringProperty(sportsmanFirstName + sportsmanLastName);
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
        return this.status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public ImageView getPhoto() {
        return photo;
    }

    public void setPhoto(ImageView photo) {
        this.photo = photo;
    }

    public Label getL() {
        return L;
    }

    public void setL(Label l) {
        L = l;
    }

    public String geteNC() {
        return eNC.get();
    }

    public SimpleStringProperty eNCProperty() {
        return eNC;
    }

    public void seteNC(String eNC) {
        this.eNC.set(eNC);
    }

    public String geteD() {
        return eD.get();
    }

    public SimpleStringProperty eDProperty() {
        return eD;
    }

    public void seteD(String eD) {
        this.eD.set(eD);
    }

    public String geteC() {
        return eC.get();
    }

    public SimpleStringProperty eCProperty() {
        return eC;
    }

    public void seteC(String eC) {
        this.eC.set(eC);
    }

    public String getSportsmanFNLN() {
        return sportsmanFNLN.get();
    }

    public SimpleStringProperty sportsmanFNLNProperty() {
        return sportsmanFNLN;
    }

    public void setSportsmanFNLN(String sportsmanFNLN) {
        this.sportsmanFNLN.set(sportsmanFNLN);
    }
}


