import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TitledPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;

public class SportsmanMyEventsPage {

    @FXML
    private TableColumn<?, ?> secondColumn;

    @FXML
    private CheckBox basketFilter;

    @FXML
    private TitledPane filters;

    @FXML
    private CheckBox footballFilter;

    @FXML
    private Pane checkPane;

    @FXML
    private CheckBox joggingFilter;

    @FXML
    private CheckBox rugbyFilter;

    @FXML
    private TableColumn<?, ?> firstColumn;

    @FXML
    private CheckBox tennisFilter;

    @FXML
    private Button backButton;

    @FXML
    private TableColumn<?, ?> thirdColumn;

    @FXML
    private TableView<?> table;

    @FXML
    private TableColumn<?, ?> fourthColumn;

    @FXML
    void actionBasket(ActionEvent event) {

    }

    @FXML
    void actionTennis(ActionEvent event) {

    }

    @FXML
    void actionJogging(ActionEvent event) {

    }

    @FXML
    void actionRugby(ActionEvent event) {

    }

    @FXML
    void actionFootball(ActionEvent event) {

    }

    @FXML
    void goBack(ActionEvent event) throws IOException {
        Parent goBackPageView= FXMLLoader.load(getClass().getResource("/sportsmanHomePage.fxml"));
        Scene loginScene=new Scene(goBackPageView);
        Stage window=(Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(loginScene);
        window.show();
    }

}