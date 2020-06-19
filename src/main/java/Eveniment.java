import javafx.beans.property.SimpleStringProperty;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import sun.java2d.pipe.SpanShapeRenderer;
import sun.plugin2.util.ColorUtil;

import java.awt.*;
import java.io.File;

public class Eveniment {
    private ImageView photo;
    private ImageView photo1;////////////////////////////////////
    private String eventPlannerMail;
    private String eventCategory;
    private String eventDifficulty;
    private String eventName;
    private String eventLocation;
    private int eventMaxNumberParticipants;
    private String eventDate;  //.getValue().toString()
    private String eventDescription;
    private Button button;

    private Label status;
    private Label L;

    private Text t;
    private SimpleStringProperty eNC;
    private SimpleStringProperty eD;
    private SimpleStringProperty eC;
    private SimpleStringProperty eL;
    private SimpleStringProperty eN;
    private SimpleStringProperty eDif;
    private SimpleStringProperty eP;
    private SimpleStringProperty eDate;
    private SimpleStringProperty eM;

private File ImageFile;

    public File getImageFile() {
        return ImageFile;
    }

    public void setImageFile(File imageFile) {
        ImageFile = imageFile;
    }

    public ImageView getPhoto() {
        return photo;
    }

    public void setPhoto(ImageView photo) {
        this.photo = photo;
    }

    public Eveniment(){

    }

    public Eveniment(String eventPlannerMail, String eventCategory, String eventDifficulty, String eventName, String eventLocation, int eventMaxNumberParticipants, String eventDate, String eventDescription) {
        this.eventPlannerMail = eventPlannerMail;
        this.eventCategory = eventCategory;
        this.eventDifficulty = eventDifficulty;
        this.eventName = eventName;
        this.eventLocation = eventLocation;
        this.eventMaxNumberParticipants = eventMaxNumberParticipants;
        this.eventDate = eventDate;
        this.eventDescription = eventDescription;
    }

    public Eveniment( String eventCategory, String eventDescription, String eventName,String eventDifficulty,String eventLocation,int eventMaxNumberParticipants,String eventDate){
        if (eventCategory.equals("Basketball")){
            photo = new ImageView(new Image(this.getClass().getResourceAsStream("x1.png")));
            photo.setFitWidth(50);
            photo.setFitHeight(50);
            setImageFile(new File("x1.png"));
        }
        else if (eventCategory.equals("Rugby")){
            photo = new ImageView(new Image(this.getClass().getResourceAsStream("x2.png")));
            photo.setFitWidth(50);
            photo.setFitHeight(50);
        }
        else if (eventCategory.equals("Jogging")){
            photo = new ImageView(new Image(this.getClass().getResourceAsStream("x3.png")));
            photo.setFitWidth(50);
            photo.setFitHeight(50);
        }
        else if (eventCategory.equals("Tennis")){
            photo = new ImageView(new Image(this.getClass().getResourceAsStream("x4.png")));
            photo.setFitWidth(50);
            photo.setFitHeight(50);
        }
        else if (eventCategory.equals("Football")){
            photo = new ImageView(new Image(this.getClass().getResourceAsStream("x5.png")));
            photo.setFitWidth(50);
            photo.setFitHeight(50);
        }
       L = new Label();

L.setText(eventCategory);

        eNC = new SimpleStringProperty(eventName + '\n' + L.getText());
        eD = new SimpleStringProperty(eventDescription);
        eC = new SimpleStringProperty(eventCategory);
        eN=new SimpleStringProperty(eventName);
        eL=new SimpleStringProperty(eventLocation);
        eDif=new SimpleStringProperty(eventDifficulty);
        eDate=new SimpleStringProperty(eventDate);
        eP=new SimpleStringProperty(Integer.toString(eventMaxNumberParticipants));


    }
//////////////////////////////////////////////////////////////////////////////////////////////modificat constructor
    public Eveniment( String eventCategory, String eventDescription, String eventName,String eventDifficulty,String eventLocation,int eventMaxNumberParticipants,String eventDate, Button button){
        if (eventCategory.equals("Basketball")){
            photo = new ImageView(new Image(this.getClass().getResourceAsStream("x1.png")));
            photo.setFitWidth(50);
            photo.setFitHeight(50);
        }
        else if (eventCategory.equals("Rugby")){
            photo = new ImageView(new Image(this.getClass().getResourceAsStream("x2.png")));
            photo.setFitWidth(50);
            photo.setFitHeight(50);
        }
        else if (eventCategory.equals("Jogging")){
            photo = new ImageView(new Image(this.getClass().getResourceAsStream("x3.png")));
            photo.setFitWidth(50);
            photo.setFitHeight(50);
        }
        else if (eventCategory.equals("Tennis")){
            photo = new ImageView(new Image(this.getClass().getResourceAsStream("x4.png")));
            photo.setFitWidth(50);
            photo.setFitHeight(50);
        }
        else if (eventCategory.equals("Football")){
            photo = new ImageView(new Image(this.getClass().getResourceAsStream("x5.png")));
            photo.setFitWidth(50);
            photo.setFitHeight(50);
        }
        eNC = new SimpleStringProperty(eventName   +  "\n" + eventCategory);
        eD = new SimpleStringProperty(eventDescription);
        eN=new SimpleStringProperty(eventName);/////////////////////////////////////////////////////////////////
        eC = new SimpleStringProperty(eventCategory);
        eL=new SimpleStringProperty(eventLocation);
        eDif=new SimpleStringProperty(eventDifficulty);
        eDate=new SimpleStringProperty(eventDate);
        eP=new SimpleStringProperty(Integer.toString(eventMaxNumberParticipants));
        this.button = button;
        this.button.setText("Join");
    }

    public Eveniment(String eventCategory, String eventDescription, String eventName, String status){
        if (eventCategory.equals("Basketball")){
            photo = new ImageView(new Image(this.getClass().getResourceAsStream("x1.png")));
            photo.setFitWidth(50);
            photo.setFitHeight(50);
        }
        else if (eventCategory.equals("Rugby")){
            photo = new ImageView(new Image(this.getClass().getResourceAsStream("x2.png")));
            photo.setFitWidth(50);
            photo.setFitHeight(50);
        }
        else if (eventCategory.equals("Jogging")){
            photo = new ImageView(new Image(this.getClass().getResourceAsStream("x3.png")));
            photo.setFitWidth(50);
            photo.setFitHeight(50);
        }
        else if (eventCategory.equals("Tennis")){
            photo = new ImageView(new Image(this.getClass().getResourceAsStream("x4.png")));
            photo.setFitWidth(50);
            photo.setFitHeight(50);
        }
        else if (eventCategory.equals("Football")){
            photo = new ImageView(new Image(this.getClass().getResourceAsStream("x5.png")));
            photo.setFitWidth(50);
            photo.setFitHeight(50);
        }
        eNC = new SimpleStringProperty(eventName   +  "\n" + eventCategory);
        eD = new SimpleStringProperty(eventDescription);

        this.status.setText(status);


    }

    public Label getStatus() {
        return status;
    }

    public void setStatus(Label status) {
        this.status = status;
    }

    public String geteC() {
        return eC.get();
    }
    public String getN() {
        return eN.get();
    }

    public SimpleStringProperty eCProperty() {
        return eC;
    }


    public void seteC(String eC) {
        this.eC.set(eC);
    }

    public Button getButton() {
        return button;
    }

    public void setButton(Button button) {
        this.button = button;
    }

    public String getEventPlannerMail() {
        return eventPlannerMail;
    }

    public void setEventPlannerMail(String eventPlannerMail) {
        this.eventPlannerMail = eventPlannerMail;
    }

    public int getEventMaxNumberParticipants() {
        return eventMaxNumberParticipants;
    }

    public void setEventMaxNumberParticipants(int eventMaxNumberParticipants) {
        this.eventMaxNumberParticipants = eventMaxNumberParticipants;
    }

    public String getEventCategory() {
        return eventCategory;
    }

    public void setEventCategory(String eventCategory) {
        this.eventCategory = eventCategory;
    }

    public String getEventDifficulty() {
        return eventDifficulty;
    }

    public void setEventDifficulty(String eventDifficulty) {
        this.eventDifficulty = eventDifficulty;
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public String getEventLocation() {
        return eventLocation;
    }

    public void setEventLocation(String eventLocation) {
        this.eventLocation = eventLocation;
    }

    public int getMaxNumberParticipants() {
        return eventMaxNumberParticipants;
    }

    public void setMaxNumberParticipants(int maxNumberParticipants) {
        this.eventMaxNumberParticipants = maxNumberParticipants;
    }

    public String getEventDate() {
        return eventDate;
    }

    public String geteL() {
        return eL.get();
    }

    public SimpleStringProperty eLProperty() {
        return eL;
    }

    public void seteL(String eL) {
        this.eL.set(eL);
    }

    public String geteN() {
        return eN.get();
    }

    public SimpleStringProperty eNProperty() {
        return eN;
    }

    public void seteN(String eN) {
        this.eN.set(eN);
    }

    public String geteDif() {
        return eDif.get();
    }

    public SimpleStringProperty eDifProperty() {
        return eDif;
    }

    public void seteDif(String eDif) {
        this.eDif.set(eDif);
    }

    public String geteP() {
        return eP.get();
    }

    public SimpleStringProperty ePProperty() {
        return eP;
    }

    public void seteP(String eP) {
        this.eP.set(eP);
    }

    public String geteDate() {
        return eDate.get();
    }

    public SimpleStringProperty eDateProperty() {
        return eDate;
    }

    public void seteDate(String eDate) {
        this.eDate.set(eDate);
    }

    public void setEventDate(String eventDate) {
        this.eventDate = eventDate;
    }

    public String getEventDescription() {
        return eventDescription;
    }

    public void setEventDescription(String eventDescription) {
        this.eventDescription = eventDescription;
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

    public String toString(){
        return this.eventPlannerMail;
    }
}
