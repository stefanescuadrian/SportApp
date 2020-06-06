import javafx.beans.value.ObservableBooleanValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.IOException;

public class EventForm {
    ObservableList<String> categoryList= FXCollections.observableArrayList("Category","------------","Basketball","Volleyball","Rugby","Yoga","Jogging","Football");
    ObservableList<String> difficultyList=FXCollections.observableArrayList("Difficulty","----------","Beginner","Medium","Advanced");
    @FXML
    private ChoiceBox difficulty;
    @FXML
    private Button addButton;
    @FXML
    private Button backButton;
    @FXML
    private ChoiceBox category;
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
        category.setValue("Category");
    category.setItems(categoryList);
    difficulty.setValue("Difficulty");
    difficulty.setItems(difficultyList);
    }
}


