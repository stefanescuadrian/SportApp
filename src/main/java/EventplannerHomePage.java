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


    private static ArrayList List = new ArrayList();
    private static String eventPlannerName;
    public EventplannerHomePage(){

    }

    public void initialize(URL location, ResourceBundle resources) {

        ObservableList<Eveniment> data = FXCollections.observableArrayList();

        //ImageView img1 = new ImageView(new Image(this.getClass().getResourceAsStream("x1.png")));

        TableColumn firstColumn = new TableColumn();
        firstColumn.setMinWidth(277);
        firstColumn.setMaxWidth(277);
        firstColumn.setCellValueFactory(new PropertyValueFactory<>("eC"));

        TableColumn secondColumn = new TableColumn();
        secondColumn.setMinWidth(277);
        secondColumn.setMaxWidth(277);
        secondColumn.setCellValueFactory(new PropertyValueFactory<>("eD"));

        TableColumn thirdColumn = new TableColumn();
        thirdColumn.setMinWidth(277);
        thirdColumn.setMaxWidth(277);
        thirdColumn.setCellValueFactory(new PropertyValueFactory<>("eN"));

        table.getColumns().addAll(firstColumn,secondColumn,thirdColumn);

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
                data.add(new Eveniment(((Eveniment) List.get(i)).getEventCategory(),((Eveniment) List.get(i)).getEventDifficulty(),((Eveniment) List.get(i)).getEventName()));

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
    void goToMyEventsPage(ActionEvent event) {

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
