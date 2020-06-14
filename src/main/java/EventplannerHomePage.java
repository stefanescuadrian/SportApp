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


    private static ArrayList List = new ArrayList();
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
                data.add(new Eveniment(((Eveniment) List.get(i)).getEventCategory(),((Eveniment) List.get(i)).getEventDescription(),((Eveniment) List.get(i)).getEventName(),
                        ((Eveniment) List.get(i)).getEventDifficulty(),((Eveniment) List.get(i)).getEventLocation(),((Eveniment) List.get(i)).getEventMaxNumberParticipants(),((Eveniment) List.get(i)).getEventDate()));
            }
        }
        table.setItems(data);
    }
    public EventplannerHomePage(String eventPlannerName) {
       this.eventPlannerName = eventPlannerName;
    }

    public static String getEventPlannerName() {
        return eventPlannerName;
    }


    @FXML
    void goToMyEventsPage(ActionEvent event) throws IOException {
        EventplannerMyEventsPage E = new EventplannerMyEventsPage(eventPlannerName);
        Parent eventplannerMyEventsPageView= FXMLLoader.load(getClass().getResource("/eventplannerMyEventsPage.fxml"));
        Scene loginScene=new Scene(eventplannerMyEventsPageView);
        Stage window=(Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(loginScene);
        window.show();
    }

    @FXML
    void addEvents(ActionEvent event) throws IOException {
        Parent loginView= FXMLLoader.load(getClass().getResource("/eventForm.fxml"));
        Scene loginScene=new Scene(loginView);
        Stage window=(Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(loginScene);
        window.show();
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
