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

import java.io.IOException;
import java.time.LocalDate;

public class EditEvents {

    private static String  eventPlannerMail;
    // @FXML
   // private ChoiceBox<?> eventDifficulty;
   @FXML
   private TextField eventDifficulty;
    @FXML
    private Button deleteButton;
    @FXML
    private Button participantsButton;

    //@FXML
   // private ChoiceBox<?> eventCategory;
    @FXML
    private TextField eventCategory;

    @FXML
    private TextField eventLocation;

    @FXML
    private Button backButton;

    @FXML
    private TextArea eventDescription;

    @FXML
    private TextField eventName;

    @FXML
    private Button addButton;

    @FXML
    private TextField eventMaxNumberParticipants;


    @FXML
    private TextField eventDate;



    private Eveniment event;

    public EditEvents(){

    }
    public EditEvents(String eventPlannerMail) {
        this.eventPlannerMail = eventPlannerMail;
    }

    @FXML
    void goBack(ActionEvent event) throws IOException {
        Parent goBackView= FXMLLoader.load(getClass().getResource("/eventplannerMyEventsPage.fxml"));
        Scene loginScene=new Scene(goBackView);
        Stage window=(Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(loginScene);
        window.show();
    }

    @FXML
    void add(ActionEvent event) {

    }

    void showDetails(Eveniment event){
        this.event=event;
        this.eventName.setText(event.getN());
        this.eventCategory.setText(event.geteC());
        this.eventDescription.setText(event.geteD());
        this.eventDifficulty.setText(event.geteDif());
        this.eventLocation.setText(event.geteL());
        this.eventMaxNumberParticipants.setText(event.geteP());
        //this.eventDate.setValue(LocalDate.parse(event.getEventDate()));
        this.eventDate.setText(event.geteDate());
    }



    @FXML
    void deleteEvent(ActionEvent event) throws IOException {

    }

    @FXML
    void seeEventParticipants(ActionEvent event) throws IOException {
        SeeEventParticipantsPage eventPP = new SeeEventParticipantsPage(this.eventPlannerMail);
        Parent eventParticipantsPage= FXMLLoader.load(getClass().getResource("/seeEventParticipantsPage.fxml"));
        Scene loginScene=new Scene(eventParticipantsPage);
        Stage window=(Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(loginScene);
        window.show();
    }


}