import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class EventplannerHomePage {

    @FXML
    private Button myEventsButton;

    @FXML
    private Button addEventsButton;

    @FXML
    void goToMyEventsPage(ActionEvent event) {

    }

    @FXML
    void addEvents(ActionEvent event) {

    }
    @FXML
    void logoutOnAction(ActionEvent event) throws IOException {
        Parent loginView= FXMLLoader.load(getClass().getResource("/login.fxml"));
        Scene loginScene=new Scene(loginView);
        Stage window=(Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(loginScene);
        window.show();
    }


}
