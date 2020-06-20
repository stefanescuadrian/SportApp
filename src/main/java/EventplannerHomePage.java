import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;


import javax.swing.text.html.ImageView;
import java.beans.XMLDecoder;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class EventplannerHomePage implements Initializable {
    @FXML
    private Button myEventsButton;

    @FXML
    private Button addEventsButton;
    @FXML
    private TableView<Eveniment> table;

    @FXML
    private TableColumn<?, ?> firstColumn;

    @FXML
    private TableColumn<?, ?> secondColumn;

    @FXML
    private TableColumn<?, ?> thirdColumn;

private SceneChanger scene=new SceneChanger();
    private static ArrayList<Eveniment> List = new ArrayList();
    private static String eventPlannerName;
    public EventplannerHomePage(){

    }

    public void initialize(URL location, ResourceBundle resources) {

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


        for(int i=0; i<List.size();i++){
            if (List.get(i) instanceof Eveniment) {
                data.add(new Eveniment(List.get(i).getEventCategory(), List.get(i).getEventDescription(), List.get(i).getEventName(),
                        List.get(i).getEventDifficulty(), List.get(i).getEventLocation(), List.get(i).getEventMaxNumberParticipants(), List.get(i).getEventDate()));
            }
        }
        table.setItems(data);

        table.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                SeePlannerEventInformationPage edit = new SeePlannerEventInformationPage(table.getSelectionModel().getSelectedItem().getN(),eventPlannerName); //e, de fapt, email-ul eventPlanner-ului
                FXMLLoader loader = new FXMLLoader();
                loader.setLocation(getClass().getResource("/seePlannerEventInformationPage.fxml"));
                Parent tableView = null;
                try {
                    tableView = tableView = loader.load();
                } catch (IOException e) {
                    e.printStackTrace();
                }

                Scene tableViewScene = new Scene(tableView);
                SeePlannerEventInformationPage controller = loader.getController();
                controller.showDetails(table.getSelectionModel().getSelectedItem());
                Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
                window.setScene(tableViewScene);
                window.show();
            }
        });
    }
    public EventplannerHomePage(String eventPlannerName) {
       EventplannerHomePage.eventPlannerName = eventPlannerName;
    }

    public static String getEventPlannerName() {
        return eventPlannerName;
    }

    public static void setEventPlannerName(String eventPlannerName) {
        EventplannerHomePage.eventPlannerName = eventPlannerName;
    }

    @FXML
    void goToMyEventsPage(ActionEvent event) throws IOException {
        EventplannerMyEventsPage E = new EventplannerMyEventsPage(eventPlannerName);
        scene.changeScenes(event,"/eventplannerMyEventsPage.fxml");

    }

    @FXML
    void addEvents(ActionEvent event) throws IOException {
        scene.changeScenes(event,"/eventForm.fxml");
    }
    @FXML
    void logoutOnAction(ActionEvent event) throws IOException {
        scene.changeScenes(event,"/login.fxml");
    }


}
