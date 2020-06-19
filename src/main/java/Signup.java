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

    @FXML
    private Label signupLabel;

    @FXML
    private Label roleLabel;

    @FXML
    private Button goBackButton;

    @FXML
    private Button sportsmanForm;

    public void changeScreenButtonPushed(ActionEvent event) throws IOException {
        Parent signupView= FXMLLoader.load(getClass().getResource("/login.fxml"));
        Scene signupScene=new Scene(signupView);
        Stage window=(Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(signupScene);
        window.show();
    }
    public void goToSportsmanForm(ActionEvent event) throws IOException {
        Parent signupView= FXMLLoader.load(getClass().getResource("/sportsmanSignupForm.fxml"));
        Scene signupScene=new Scene(signupView);
        Stage window=(Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(signupScene);
        window.show();
    }
    public void goToEventplannerForm(ActionEvent event) throws IOException {
        Parent signupView= FXMLLoader.load(getClass().getResource("/eventplannerSignupForm.fxml"));
        Scene signupScene=new Scene(signupView);
        Stage window=(Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(signupScene);
        window.show();
    }

    public void initialize(URL location, ResourceBundle resources) {

    }

}
