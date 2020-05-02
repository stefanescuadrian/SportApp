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

public class SportsmanSignupForm {

    @FXML
    private Label signupLabel;

    @FXML
    private Button signupButtonForm;
    @FXML
    private Button goBackButton;
    @FXML
    void saveSportsmanData(ActionEvent event) {

    }
    public void changeScreenButtonPushed(ActionEvent event) throws IOException {
        Parent signupView= FXMLLoader.load(getClass().getResource("/signup.fxml"));
        Scene signupScene=new Scene(signupView);
        Stage window=(Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(signupScene);
        window.show();
    }
}
