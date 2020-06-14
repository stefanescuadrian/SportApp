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

    public String getEName() {
        return eName;
    }

    @FXML
    private TextField eventMaxNumberParticipants;

    private static ArrayList List = new ArrayList();////////////////////////////////////////
    @FXML
    private TextField eventDate;

    private Eveniment event;


    public EditEvents(String eventName) {
        this.eName = eventName;
    }

    public EditEvents() {

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

        for (int i = 0; i < List.size(); i++) {
            if (List.get(i) instanceof Eveniment)
                if (((Eveniment) List.get(i)).getEventName().equals(eName)) {

                    try {
                       List.remove(i);

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

    @FXML
    void seeEventParticipants(ActionEvent event) throws IOException {
        Parent eventParticipantsPage = FXMLLoader.load(getClass().getResource("/seeEventParticipantsPage.fxml"));
        Scene loginScene = new Scene(eventParticipantsPage);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
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