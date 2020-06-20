import javafx.beans.value.ObservableBooleanValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;


import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

public class EventForm {
    private Alert alert = new Alert(Alert.AlertType.INFORMATION);
    private ArrayList List = new ArrayList();
    ObservableList<String> categoryList= FXCollections.observableArrayList("Category","------------","Basketball","Tennis","Rugby","Jogging","Football");
    ObservableList<String> difficultyList=FXCollections.observableArrayList("Difficulty","----------","Beginner","Medium","Advanced");
    @FXML
    ChoiceBox eventCategory;

    @FXML
    ChoiceBox eventDifficulty;

    @FXML
    TextField eventLocation;

    @FXML
    TextArea eventDescription;

    @FXML
    Button backButton;

    @FXML
    TextField eventName;

    @FXML
    Button addButton;

    @FXML
    TextField eventMaxNumberParticipants;

    @FXML
    DatePicker eventDate;

    private SceneChanger scene=new SceneChanger();


    @FXML
    void goBack(ActionEvent event) throws IOException {
        scene.changeScenes(event,"/eventplannerHomePage.fxml");
    }


    @FXML
    private void initialize(){
        eventCategory.setValue("Category");
        eventCategory.setItems(categoryList);
        eventDifficulty.setValue("Difficulty");
        eventDifficulty.setItems(difficultyList);
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

    public DatePicker getEventDate() {
        return eventDate;
    }

    public void setEventDate(DatePicker eventDate) {
        this.eventDate = eventDate;
    }

    @FXML
    void add(ActionEvent event) throws IOException {
        if(eventCategory.getValue().equals("Category")) {
            return;
        }

        if(eventDifficulty.getValue().equals("Difficulty")){
            return;
        }

        if (eventName.getText().isEmpty()){
            return;
        }

        if (eventLocation.getText().isEmpty()){
            return;
        }

        if (eventMaxNumberParticipants.getText().isEmpty()){
            return;
        }

        if (eventDate.getValue()==null){
            return;
        }

        List = XMLDE.XMLDecoder("./Events.xml");
        int x = Integer.parseInt(eventMaxNumberParticipants.getText());
        Eveniment E = new Eveniment(EventplannerHomePage.getEventPlannerName(),eventCategory.getValue().toString(),eventDifficulty.getValue().toString(),eventName.getText(),eventLocation.getText(), x,eventDate.getValue().toString(),eventDescription.getText());
        List.add(E);
        XMLDE.XMLEncoder("./Events.xml",List);

        scene.changeScenes(event,"/eventplannerHomePage.fxml");

    }

}


