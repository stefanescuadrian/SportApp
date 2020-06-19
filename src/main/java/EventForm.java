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
    private ChoiceBox eventCategory;

    @FXML
    private ChoiceBox eventDifficulty;

    @FXML
    private TextField eventLocation;

    @FXML
    private TextArea eventDescription;

    @FXML
    private Button backButton;

    @FXML
    private TextField eventName;

    @FXML
    private Button addButton;

    @FXML
    private TextField eventMaxNumberParticipants;

    @FXML
    private DatePicker eventDate;




    @FXML
    void goBack(ActionEvent event) throws IOException {
        Parent loginView= FXMLLoader.load(getClass().getResource("/eventplannerHomePage.fxml"));
        Scene loginScene=new Scene(loginView);
        Stage window=(Stage)((Node)event.getSource()).getScene().getWindow();
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
            alert.setTitle("Warning");
            alert.setHeaderText(null);
            alert.setContentText("Please select a category!");
            alert.showAndWait();
            return;
        }

        if(eventDifficulty.getValue().equals("Difficulty")){
            alert.setTitle("Warning");
            alert.setHeaderText(null);
            alert.setContentText("Please select a difficulty!");
            alert.showAndWait();
            return;
        }

        if (eventName.getText().isEmpty()){
            alert.setTitle("Warning");
            alert.setHeaderText(null);
            alert.setContentText("Event's name is empty!");
            alert.showAndWait();
            return;
        }

        if (eventLocation.getText().isEmpty()){
            alert.setTitle("Warning");
            alert.setHeaderText(null);
            alert.setContentText("Location is empty!");
            alert.showAndWait();
            return;
        }

        if (eventMaxNumberParticipants.getText().isEmpty()){
            alert.setTitle("Warning");
            alert.setHeaderText(null);
            alert.setContentText("Number of maximum participants is empty!");
            alert.showAndWait();
            return;
        }

        if (eventDate.getValue()==null){
            alert.setTitle("Warning");
            alert.setHeaderText(null);
            alert.setContentText("Please select a date!");
            alert.showAndWait();
            return;
        }

        //Decodificare xml file
        try{
            FileInputStream fis = new FileInputStream("./Events.xml");
            XMLDecoder decoder = new XMLDecoder(fis);
            ArrayList A = new ArrayList();
            A = (ArrayList) decoder.readObject();
            List =A;
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        }

        //Codificare xml file
        try{
            int x = Integer.parseInt(eventMaxNumberParticipants.getText());
            Eveniment E = new Eveniment(EventplannerHomePage.getEventPlannerName(),eventCategory.getValue().toString(),eventDifficulty.getValue().toString(),eventName.getText(),eventLocation.getText(), x,eventDate.getValue().toString(),eventDescription.getText());
            //System.out.println(E);
            List.add(E);
            FileOutputStream fos = new FileOutputStream("./Events.xml");
            XMLEncoder encoder = new XMLEncoder(fos);
            encoder.writeObject(List);
            encoder.close();
            fos.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }


        Parent loginView= FXMLLoader.load(getClass().getResource("/eventplannerHomePage.fxml"));
        Scene loginScene=new Scene(loginView);
        Stage window=(Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(loginScene);
        window.show();
    }

}


