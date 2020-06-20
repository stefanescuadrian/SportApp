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
    private static String eName;
    private static ArrayList<Eveniment> List = new ArrayList();////////////////////////////////////////
    private static ArrayList<Inregistrare> List1 = new ArrayList();
    private static ArrayList Lista = new ArrayList();
    private static ArrayList Lista1 = new ArrayList();

    @FXML
    private ChoiceBox eventCategory;
    @FXML
    private ChoiceBox eventDifficulty;
    @FXML
    private Button deleteButton;
    @FXML
    private Button participantsButton;
    @FXML
    private TextField eventLocation;
    @FXML
    private Button backButton;
    @FXML
    private TextArea eventDescription;

    public static String getEventPlannerMail() {
        return eventPlannerMail;
    }

    public static void setEventPlannerMail(String eventPlannerMail) {
        EditEvents.eventPlannerMail = eventPlannerMail;
    }

    public static String geteName() {
        return eName;
    }

    public static void seteName(String eName) {
        EditEvents.eName = eName;
    }

    public ChoiceBox getEventCategory() {
        return eventCategory;
    }

    public void setEventCategory(ChoiceBox eventCategory) {
        this.eventCategory = eventCategory;
    }

    public ChoiceBox getEventDifficulty() {
        return eventDifficulty;
    }

    public void setEventDifficulty(ChoiceBox eventDifficulty) {
        this.eventDifficulty = eventDifficulty;
    }

    public TextField getEventLocation() {
        return eventLocation;
    }

    public void setEventLocation(TextField eventLocation) {
        this.eventLocation = eventLocation;
    }

    public TextArea getEventDescription() {
        return eventDescription;
    }

    public void setEventDescription(TextArea eventDescription) {
        this.eventDescription = eventDescription;
    }

    public TextField getEventName() {
        return eventName;
    }

    public void setEventName(TextField eventName) {
        this.eventName = eventName;
    }

    public TextField getEventMaxNumberParticipants() {
        return eventMaxNumberParticipants;
    }

    public void setEventMaxNumberParticipants(TextField eventMaxNumberParticipants) {
        this.eventMaxNumberParticipants = eventMaxNumberParticipants;
    }

    public TextField getEventDate() {
        return eventDate;
    }

    public void setEventDate(TextField eventDate) {
        this.eventDate = eventDate;
    }

    public Eveniment getEvent() {
        return event;
    }

    public void setEvent(Eveniment event) {
        this.event = event;
    }

    @FXML
    private TextField eventName;
    @FXML
    private Button editButton;
    @FXML
    private TextField eventMaxNumberParticipants;
    @FXML
    private TextField eventDate;

    private Eveniment event;
    private SceneChanger scene=new SceneChanger();


    ObservableList<String> categoryList= FXCollections.observableArrayList("Category","------------","Basketball","Tennis","Rugby","Jogging","Football");
    ObservableList<String> difficultyList=FXCollections.observableArrayList("Difficulty","----------","Beginner","Medium","Advanced");

    public EditEvents() {}

    public EditEvents(String eventPlannerMail) {
        this.eventPlannerMail = eventPlannerMail;
    }

    public EditEvents(String eventName, String eventPlannerMail) {
        this.eName = eventName;
        this.eventPlannerMail = eventPlannerMail;
    }

    public String getEName() {
        return eName;
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
        this.eventName.setText(event.geteN());
        this.eventCategory.setValue(event.geteC());
        this.eventDifficulty.setValue(event.geteDif());
        this.eventDescription.setText(event.geteD());
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
                if (!(List.get(i).getEventName().equals(eName) && List.get(i).getEventPlannerMail().equals(eventPlannerMail))) {
                   // List.remove(i);
                    Lista.add(List.get(i));
                }
        }

        try {
            FileOutputStream fos = new FileOutputStream("./Events.xml");
            XMLEncoder encoder = new XMLEncoder(fos);
            encoder.writeObject(Lista);
            encoder.close();
            fos.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        for (int i=0; i < List1.size(); i++){
            if (List1.get(i) instanceof Inregistrare){
            if (!(List1.get(i).getE().getEventName().equals(eName) && List1.get(i).getE().getEventPlannerMail().equals(eventPlannerMail))) {
                //List1.remove(i);
                Lista1.add(List1.get(i));
            }
            }
        }
        try {
            FileOutputStream fos = new FileOutputStream("./Registrations.xml");
            XMLEncoder encoder = new XMLEncoder(fos);
            encoder.writeObject(Lista1);
            encoder.close();
            fos.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        scene.changeScenes(event,"/eventplannerMyEventsPage.fxml");

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
                if (List.get(i).getEventName().equals(eName)) {

                    try {
                        List.get(i).setEventName(this.eventName.getText());
                        List.get(i).setEventCategory(this.eventCategory.getValue().toString());
                        List.get(i).setEventDifficulty(this.eventDifficulty.getValue().toString());
                        List.get(i).setEventLocation(this.eventLocation.getText());
                        List.get(i).setEventLocation(this.eventLocation.getText());
                        List.get(i).setEventMaxNumberParticipants(Integer.parseInt(this.eventMaxNumberParticipants.getText()));
                        List.get(i).setEventDate(this.eventDate.getText());
                        List.get(i).setEventDescription(this.eventDescription.getText());


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
        SeeEventParticipantsPage eventPP = new SeeEventParticipantsPage(this.eventPlannerMail,eName,eventMaxNumberParticipants.getText());
        scene.changeScenes(event,"/seeEventParticipantsPage.fxml");
    }

    @FXML
    void goBack(ActionEvent event) throws IOException {
        SceneChanger sc=new SceneChanger();
        sc.changeScenes(event,"/eventplannerMyEventsPage.fxml");
    }
}