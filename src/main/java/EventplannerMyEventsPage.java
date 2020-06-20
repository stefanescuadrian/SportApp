import com.sun.org.apache.xerces.internal.impl.xs.SchemaNamespaceSupport;
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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
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
    private static ArrayList<Eveniment> List = new ArrayList();
    private SceneChanger scene=new SceneChanger();
    @FXML
    private TableColumn<?, ?> firstColumn;
    @FXML
    private Button add;
    @FXML
    private TableColumn<?, ?> secondColumn;

    @FXML
    private Button backButton;

    @FXML
    private TableColumn<?, ?> thirdColumn;

    @FXML
    private TableView<Eveniment> table;
private static String nume;//////////////////
    @FXML
    void goBack(ActionEvent event) throws IOException {
        scene.changeScenes(event,"/eventplannerHomePage.fxml");
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
//am modificat aici
        for (int i=0; i<List.size(); i++){
            if (List.get(i) instanceof Eveniment)
            if (List.get(i).getEventPlannerMail().equals(eventPlannerName)){
                data.add(new Eveniment(List.get(i).getEventCategory(), List.get(i).getEventDescription(), List.get(i).getEventName(),
                        List.get(i).getEventDifficulty(), List.get(i).getEventLocation(), List.get(i).getEventMaxNumberParticipants(), List.get(i).getEventDate()));

            }
        }
        table.setItems(data);

        table.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                EditEvents edit = new EditEvents(table.getSelectionModel().getSelectedItem().getN(), eventPlannerName); //e, de fapt, email-ul eventPlanner-ului
                FXMLLoader loader = new FXMLLoader();
                loader.setLocation(getClass().getResource("/editEvents.fxml"));
                Parent tableView = null;
                try {
                    tableView = tableView = loader.load();
                } catch (IOException e) {
                    e.printStackTrace();
                }

                Scene tableViewScene = new Scene(tableView);
                EditEvents controller = loader.getController();
                controller.showDetails(table.getSelectionModel().getSelectedItem());
                Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
                window.setScene(tableViewScene);
                window.show();
            }
        });

    }



}