import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.beans.XMLDecoder;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class EventplannerMyEventsPage implements Initializable {
    private static String eventPlannerName;
    private static ArrayList List = new ArrayList();

    @FXML
    private TableColumn<?, ?> firstColumn;

    @FXML
    private TableColumn<?, ?> secondColumn;

    @FXML
    private Button backButton;

    @FXML
    private TableColumn<?, ?> thirdColumn;

    @FXML
    private TableView<Eveniment> table;

    @FXML
    void goBack(ActionEvent event) throws IOException {
        Parent goBackPageView= FXMLLoader.load(getClass().getResource("/eventplannerHomePage.fxml"));
        Scene loginScene=new Scene(goBackPageView);
        Stage window=(Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(loginScene);
        window.show();
    }

    public EventplannerMyEventsPage() {
    }
    public EventplannerMyEventsPage(String eventPlannerName) {
        this.eventPlannerName = eventPlannerName;
    }

    public static String getEventPlannerName() {
        return eventPlannerName;
    }

    public static void setEventPlannerName(String eventPlannerName) {
        EventplannerMyEventsPage.eventPlannerName = eventPlannerName;
    }

    public void initialize(URL location, ResourceBundle resources){
        ObservableList<Eveniment> data = FXCollections.observableArrayList();

        firstColumn.setCellValueFactory(new PropertyValueFactory<>("photo"));

        secondColumn.setCellValueFactory(new PropertyValueFactory<>("eNC"));

        thirdColumn.setCellValueFactory(new PropertyValueFactory<>("eD"));

        //Decodificare xml
        try{
            FileInputStream fis = new FileInputStream("./Events.xml");
            XMLDecoder decoder = new XMLDecoder(fis);
            ArrayList A = new ArrayList();
            A = (ArrayList) decoder.readObject();
            List =A;
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        }

        for (int i=0; i<List.size(); i++){
            if (List.get(i) instanceof Eveniment)
            if (((Eveniment) List.get(i)).getEventPlannerMail().equals(eventPlannerName)){
                data.add(new Eveniment(((Eveniment) List.get(i)).getEventCategory(),((Eveniment) List.get(i)).getEventDescription(),((Eveniment) List.get(i)).getEventName()));
            }
        }
        table.setItems(data);
    }

}