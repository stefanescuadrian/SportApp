import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.IOException;


public class SeePlannerEventInformationPage {

    private static String eventPlannerMail;
    private static String eName;
    private Eveniment event;
    @FXML
    ImageView imageViewLocation;

    @FXML
    Label eventLocationLabel;

    @FXML
    Label eventCategoryLabel;

    @FXML
    Button backButton;

    @FXML
    Label eventDifficultyLabel;

    @FXML
    ImageView imageView;

    @FXML
    Label eventDateLabel;

    @FXML
    Label eventMaxParticipantsLabel;

    @FXML
    ImageView imageViewCat;

    @FXML
    Label eventNameLabel1;

    @FXML
    Label eventDescriptionLabel;
    public SceneChanger scene = new SceneChanger();

    @FXML
    Label eventNameLabel;

    public SeePlannerEventInformationPage() {

    }

    public SeePlannerEventInformationPage(String eventName, String eventPlannerMail) {
        this.eName = eventName;
        this.eventPlannerMail = eventPlannerMail;
    }

    @FXML
    void goBack(ActionEvent event) throws IOException {
        scene.changeScenes(event, "/eventPlannerHomePage.fxml");

    }

    void check_category(Eveniment event) {
        this.event = event;
        if (event.geteC().equals("Jogging")) {
            Image img = new Image("/jogging_photo.jpg");
            Image img1 = new Image("/x3.png");
            imageViewCat.setImage(img1);
            imageView.setImage(img);
            eventCategoryLabel.setStyle("-fx-background-color: #c9ecf0; ");
            Image img2 = new Image("/g6.png");
            imageViewLocation.setImage(img2);

        } else if (event.geteC().equals("Basketball")) {
            Image img = new Image("/basketball_photo.jpg");
            imageView.setImage(img);
            Image img1 = new Image("/x1.png");
            imageViewCat.setImage(img1);
            eventCategoryLabel.setStyle("-fx-background-color: #f1d1c6;");
            Image img2 = new Image("/g5.png");
            imageViewLocation.setImage(img2);

        } else if (event.geteC().equals("Tennis")) {
            Image img = new Image("/tennis_photo.jpg");
            imageView.setImage(img);
            Image img1 = new Image("/x4.png");
            imageViewCat.setImage(img1);
            eventCategoryLabel.setStyle("-fx-background-color: #c1ebc7;");
            Image img2 = new Image("/g2.png");
            imageViewLocation.setImage(img2);
        } else if (event.geteC().equals("Football")) {
            Image img = new Image("/football_photo.jpg");
            imageView.setImage(img);
            Image img1 = new Image("/x5.png");
            imageViewCat.setImage(img1);
            eventCategoryLabel.setStyle("-fx-background-color: #f1d1c6 ;");
            Image img2 = new Image("/g1.png");
            imageViewLocation.setImage(img2);
        } else if (event.geteC().equals("Rugby")) {
            Image img = new Image("/rugby_photo.jpg");
            imageView.setImage(img);
            Image img1 = new Image("/x2.png");
            imageViewCat.setImage(img1);
            eventCategoryLabel.setStyle("-fx-background-color: #d1c3c0;");
            Image img2 = new Image("/g4.png");
            imageViewLocation.setImage(img2);
        }
    }

    void showDetails(Eveniment event) {
        this.event = event;
        this.eventNameLabel.setText(event.geteN());
        this.eventCategoryLabel.setText(event.geteC());
        this.eventDescriptionLabel.setText(event.geteD());
        check_category(event);
        this.eventDifficultyLabel.setText(event.geteDif());
        this.eventLocationLabel.setText(event.geteL());
        this.eventMaxParticipantsLabel.setText(event.geteP() + " participants");
        this.eventDateLabel.setText(event.geteDate());
    }

   // public static String getEventPlannerMail() {
   //     return eventPlannerMail;
   // }

    //public static void setEventPlannerMail(String eventPlannerMail) {
    //    SeePlannerEventInformationPage.eventPlannerMail = eventPlannerMail;
   // }

    //public static String geteName() {
        //return eName;
   // }

   // public static void seteName(String eName) {
    //    SeePlannerEventInformationPage.eName = eName;
   // }

    public Eveniment getEvent() {
        return event;
    }

    public void setEvent(Eveniment event) {
        this.event = event;
    }

    public Label getEventLocationLabel() {
        return eventLocationLabel;
    }

    public void setEventLocationLabel(Label eventLocationLabel) {
        this.eventLocationLabel = eventLocationLabel;
    }

    public Label getEventCategoryLabel() {
        return eventCategoryLabel;
    }

    public void setEventCategoryLabel(Label eventCategoryLabel) {
        this.eventCategoryLabel = eventCategoryLabel;
    }

    public Label getEventDifficultyLabel() {
        return eventDifficultyLabel;
    }

    public void setEventDifficultyLabel(Label eventDifficultyLabel) {
        this.eventDifficultyLabel = eventDifficultyLabel;
    }

    public Label getEventDateLabel() {
        return eventDateLabel;
    }

    public void setEventDateLabel(Label eventDateLabel) {
        this.eventDateLabel = eventDateLabel;
    }

    public Label getEventMaxParticipantsLabel() {
        return eventMaxParticipantsLabel;
    }

    public void setEventMaxParticipantsLabel(Label eventMaxParticipantsLabel) {
        this.eventMaxParticipantsLabel = eventMaxParticipantsLabel;
    }


    public Label getEventDescriptionLabel() {
        return eventDescriptionLabel;
    }

    public void setEventDescriptionLabel(Label eventDescriptionLabel) {
        this.eventDescriptionLabel = eventDescriptionLabel;
    }

    public Label getEventNameLabel() {
        return eventNameLabel;
    }

    public void setEventNameLabel(Label eventNameLabel) {
        this.eventNameLabel = eventNameLabel;
    }
}
