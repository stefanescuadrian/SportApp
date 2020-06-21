import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Signup{
private SceneChanger sc=new SceneChanger();

    public void changeScreenButtonPushed(ActionEvent event) throws IOException {
        sc.changeScenes(event,"/login.fxml");
    }
    public void goToSportsmanForm(ActionEvent event) throws IOException {
        sc.changeScenes(event,"/sportsmanSignupForm.fxml");
    }
    public void goToEventplannerForm(ActionEvent event) throws IOException {

        sc.changeScenes(event,"/eventplannerSignupForm.fxml");
    }



}
