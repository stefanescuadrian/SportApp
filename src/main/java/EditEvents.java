import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;

public class EditEvents {

    private static String  eventPlannerMail;
    // @FXML
   // private ChoiceBox<?> eventDifficulty;
   //@FXML
   //private TextField eventDifficulty;
    // @FXML
    // private ChoiceBox<?> eventDifficulty;
    @FXML
    private ChoiceBox eventCategory;////////////////
    @FXML
    private ChoiceBox eventDifficulty;
    ObservableList<String> categoryList= FXCollections.observableArrayList("Category","------------","Basketball","Tennis","Rugby","Jogging","Football");
    ObservableList<String> difficultyList=FXCollections.observableArrayList("Difficulty","----------","Beginner","Medium","Advanced");
    //@FXML
   // private TextField eventDifficulty;
    @FXML
    private Button deleteButton;
    @FXML
    private Button participantsButton;

    //@FXML
    // private ChoiceBox<?> eventCategory;
   // @FXML
    //private TextField eventCategory;

    @FXML
    private TextField eventLocation;

    @FXML
    private Button backButton;

    @FXML
    private TextArea eventDescription;

    @FXML
    private TextField eventName;
    private static String eName;
    @FXML
    private Button editButton;

    public EditEvents(String eventName, String eventPlannerMail) {
        this.eName = eventName;
        this.eventPlannerMail = eventPlannerMail;
    }

    public String getEName() {
        return eName;
    }

    @FXML
    private TextField eventMaxNumberParticipants;

    @FXML
    private TextField eventDate;

    private static ArrayList List = new ArrayList();////////////////////////////////////////
    private static ArrayList List1 = new ArrayList();
    private Eveniment event;


    public EditEvents() {

    }


    public EditEvents(String eventPlannerMail) {
        this.eventPlannerMail = eventPlannerMail;
    }

    @FXML
    void goBack(ActionEvent event) throws IOException {
        Parent goBackView = FXMLLoader.load(getClass().getResource("/eventplannerMyEventsPage.fxml"));
        Scene loginScene = new Scene(goBackView);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(loginScene);
        window.show();
    }

    @FXML
    private void initialize(){
        eventCategory.setValue("Category");
        eventCategory.setItems(categoryList);
        eventDifficulty.setValue("Difficulty");
        eventDifficulty.setItems(difficultyList);
    }

    void showDetails(Eveniment event) {
        this.event = event;
        this.eventName.setText(event.getN());
       // this.eventCategory.setText(event.geteC());
        this.eventCategory.setValue(event.geteC());
        this.eventDifficulty.setValue(event.geteDif());
        this.eventDescription.setText(event.geteD());
       // this.eventDifficulty.setText(event.geteDif());
        this.eventLocation.setText(event.geteL());
        this.eventMaxNumberParticipants.setText(event.geteP());
        //this.eventDate.setValue(LocalDate.parse(event.getEventDate()));
        this.eventDate.setText(event.geteDate());

    }



    @FXML
    void deleteEvent(ActionEvent event) throws IOException {
        try {
            FileInputStream fis = new FileInputStream("./Events.xml");
            XMLDecoder decoder = new XMLDecoder(fis);
            ArrayList A = new ArrayList();
            A = (ArrayList) decoder.readObject();
            List = A;
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        }

        try {
            FileInputStream fis1 = new FileInputStream("./Registrations.xml");
            XMLDecoder decoder1 = new XMLDecoder(fis1);
            ArrayList A = new ArrayList();
            A = (ArrayList) decoder1.readObject();
            List1 = A;
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        }

        for (int i = 0; i < List.size(); i++) {
            if (List.get(i) instanceof Eveniment)
                if (((Eveniment) List.get(i)).getEventName().equals(eName) && ((Eveniment) List.get(i)).getEventPlannerMail().equals(eventPlannerMail)) {
                    List.remove(i);
                }
            System.out.println(List.size());
        }

        try {
            FileOutputStream fos = new FileOutputStream("./Events.xml");
            XMLEncoder encoder = new XMLEncoder(fos);
            encoder.writeObject(List);
            encoder.close();
            fos.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        for (int i=0; i < List1.size(); i++){
            if (List1.get(i) instanceof Inregistrare && ((Inregistrare) List1.get(i)).getE().getEventName().equals(eName) && ((Inregistrare) List1.get(i)).getE().getEventPlannerMail().equals(eventPlannerMail)){
                List1.remove(i);
            }
        }
        try {
            FileOutputStream fos = new FileOutputStream("./Registrations.xml");
            XMLEncoder encoder = new XMLEncoder(fos);
            encoder.writeObject(List1);
            encoder.close();
            fos.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }

    }

    @FXML
    void seeEventParticipants(ActionEvent event) throws IOException {
        SeeEventParticipantsPage eventPP = new SeeEventParticipantsPage(this.eventPlannerMail,eName,eventMaxNumberParticipants.getText());
        Parent eventParticipantsPage= FXMLLoader.load(getClass().getResource("/seeEventParticipantsPage.fxml"));
        Scene loginScene=new Scene(eventParticipantsPage);
        Stage window=(Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(loginScene);
        window.show();
    }

    @FXML
    void editEvent(ActionEvent event) {
        try {
            FileInputStream fis = new FileInputStream("./Events.xml");
            XMLDecoder decoder = new XMLDecoder(fis);
            ArrayList A = new ArrayList();
            A = (ArrayList) decoder.readObject();
            List = A;
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        }

        for (int i = 0; i < List.size(); i++) {
            if (List.get(i) instanceof Eveniment)
                if (((Eveniment) List.get(i)).getEventName().equals(eName)) {

                    try {
                        ((Eveniment) List.get(i)).setEventName(this.eventName.getText());
                        ((Eveniment) List.get(i)).setEventCategory(this.eventCategory.getValue().toString());
                        ((Eveniment) List.get(i)).setEventDifficulty(this.eventDifficulty.getValue().toString());
                        ((Eveniment) List.get(i)).setEventLocation(this.eventLocation.getText());
                        ((Eveniment) List.get(i)).setEventLocation(this.eventLocation.getText());
                        ((Eveniment) List.get(i)).setEventMaxNumberParticipants(Integer.parseInt(this.eventMaxNumberParticipants.getText()));
                        ((Eveniment) List.get(i)).setEventDate(this.eventDate.getText());
                        ((Eveniment) List.get(i)).setEventDescription(this.eventDescription.getText());


                        FileOutputStream fos = new FileOutputStream("./Events.xml");
                        XMLEncoder encoder = new XMLEncoder(fos);
                        encoder.writeObject(List);
                        encoder.close();
                        fos.close();
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }

                }

        }
    }
}