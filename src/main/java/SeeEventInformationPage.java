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
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;
import java.time.LocalDate;

public class SeeEventInformationPage {
    private static String  eventPlannerMail;
    private static String eName;
    private Eveniment event;

    @FXML
    Label eventLocationLabel;
    @FXML
    ImageView imageViewLocation;

    @FXML
    ImageView imageView;

    @FXML
     Label eventDifficultyLabel;

    @FXML
    Label eventMaxParticipantsLabel;

    @FXML
    Label eventDateLabel;

private SceneChanger scene=new SceneChanger();

    @FXML
     ImageView imageViewCat;

    @FXML
     Label eventCategoryLabel;

    @FXML
     Label eventDescriptionLabel;

    @FXML
     Label eventNameLabel;


    public Eveniment getEvent() {
        return event;
    }

    public void setEvent(Eveniment event) {
        this.event = event;
    }

    public static String getEventPlannerMail() {////////////////////////////////
        return eventPlannerMail;
    }

    public static void setEventPlannerMail(String eventPlannerMail) {
        SeeEventInformationPage.eventPlannerMail = eventPlannerMail;
    }

    public static String geteName() {///////////////////
        return eName;
    }

    public static void seteName(String eName) {
        SeeEventInformationPage.eName = eName;
    }

    public SeeEventInformationPage(){

    }
    public SeeEventInformationPage(String eventName,String eventPlannerMail) {
        this.eName = eventName;
        this.eventPlannerMail=eventPlannerMail;

    }

    @FXML
    void goBack(ActionEvent event) throws IOException {
        scene.changeScenes(event,"/sportsmanHomePage.fxml");
    }

    void check_category(Eveniment event){
        this.event=event;
        if(event.geteC().equals("Jogging")){
            Image img=new Image("/jogging_photo.jpg");
            Image img1=new Image("/x3.png");
            imageViewCat.setImage(img1);
            imageView.setImage(img);
            eventCategoryLabel.setStyle("-fx-background-color: #c9ecf0; ");
            Image img2=new Image("/g6.png");
            imageViewLocation.setImage(img2);

        }
        else if(event.geteC().equals("Basketball")){
            Image img=new Image("/basketball_photo.jpg");
            imageView.setImage(img);
            Image img1=new Image("/x1.png");
            imageViewCat.setImage(img1);
            eventCategoryLabel.setStyle("-fx-background-color: #f1d1c6;");
            Image img2=new Image("/g5.png");
            imageViewLocation.setImage(img2);

        }
        else if(event.geteC().equals("Tennis")){
            Image img=new Image("/tennis_photo.jpg");
            imageView.setImage(img);
            Image img1=new Image("/x4.png");
            imageViewCat.setImage(img1);
            eventCategoryLabel.setStyle("-fx-background-color: #c1ebc7;");
            Image img2=new Image("/g2.png");
            imageViewLocation.setImage(img2);
        }
        else if(event.geteC().equals("Football")){
            Image img=new Image("/football_photo.jpg");
            imageView.setImage(img);
            Image img1=new Image("/x5.png");
            imageViewCat.setImage(img1);
            eventCategoryLabel.setStyle("-fx-background-color: #f1d1c6 ;");
            Image img2=new Image("/g1.png");
            imageViewLocation.setImage(img2);
        }
        else if(event.geteC().equals("Rugby")){
            Image img=new Image("/rugby_photo.jpg");
            imageView.setImage(img);
            Image img1=new Image("/x2.png");
            imageViewCat.setImage(img1);
            eventCategoryLabel.setStyle("-fx-background-color: #d1c3c0;");
            Image img2=new Image("/g4.png");
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
        this.eventMaxParticipantsLabel.setText(event.geteP()+" participants");
        this.eventDateLabel.setText(event.geteDate());

    }


}

