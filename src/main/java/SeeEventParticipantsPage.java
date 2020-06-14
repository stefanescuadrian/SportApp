import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javafx.stage.Stage;

import java.io.IOException;

public class SeeEventParticipantsPage {
    @FXML
    private TableView<?> pendingTable;

    @FXML
    private TableView<?> AcceptedTable;

    @FXML
    private Button backButton;

    @FXML
    private TableView<?> DeclinedTable;

    @FXML
    void goBack(ActionEvent event) throws IOException {
        Parent goBackPageView= FXMLLoader.load(getClass().getResource("/editEvents.fxml"));
        Scene loginScene=new Scene(goBackPageView);
        Stage window=(Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(loginScene);
        window.show();
    }
}
