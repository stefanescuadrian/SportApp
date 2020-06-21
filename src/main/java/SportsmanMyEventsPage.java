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
import javafx.scene.control.CheckBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TitledPane;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class SportsmanMyEventsPage implements Initializable {
    Inregistrare I;
    public static String sportsmanEmail;
    public static String sportsmanFirstName;
    public static String sportsmanLastName;
    private static int[] checkList = new int[5];
    private static ArrayList<Inregistrare> List = new ArrayList();

private Text t;

    @FXML
    TableColumn<?, ?> secondColumn;

    @FXML
     CheckBox basketFilter;

    @FXML
     TitledPane filters;

    @FXML
     CheckBox footballFilter;

    @FXML
     Pane checkPane;

    @FXML
     CheckBox joggingFilter;

    @FXML
    CheckBox rugbyFilter;

    @FXML
     TableColumn<?, ?> firstColumn;

    @FXML
     CheckBox tennisFilter;

    @FXML
     Button backButton;

    @FXML
    Button cancelButton;

    @FXML
     TableColumn<?, ?> thirdColumn;

    @FXML
     TableView<Inregistrare> table;

    @FXML
     TableColumn<?, ?> fourthColumn;
    private SceneChanger scene=new SceneChanger();
    private ArrayList Lista = new ArrayList();

    public SportsmanMyEventsPage(){

    }
    public SportsmanMyEventsPage(String sportsmanEmail) {
        this.sportsmanEmail = sportsmanEmail;
    }

    public static String getSportsmanEmail() {
        return sportsmanEmail;
    }

    public static String getSportsmanFirstName() {
        return sportsmanFirstName;
    }

    public static void setSportsmanFirstName(String sportsmanFirstName) {
        SportsmanMyEventsPage.sportsmanFirstName = sportsmanFirstName;
    }

    public static String getSportsmanLastName() {
        return sportsmanLastName;
    }

    public static void setSportsmanLastName(String sportsmanLastName) {
        SportsmanMyEventsPage.sportsmanLastName = sportsmanLastName;
    }

    public static void setSportsmanEmail(String sportsmanEmail) {
        SportsmanMyEventsPage.sportsmanEmail = sportsmanEmail;
    }

    public void initialize(URL location, ResourceBundle resources) {
        checkList[0] = 1;
        checkList[1] = 1;
        checkList[2] = 1;
        checkList[3] = 1;
        checkList[4] = 1;


        ObservableList<Inregistrare> data = FXCollections.observableArrayList();

        firstColumn.setCellValueFactory(new PropertyValueFactory<>("photo"));
        secondColumn.setCellValueFactory(new PropertyValueFactory<>("eNC"));
        thirdColumn.setCellValueFactory(new PropertyValueFactory<>("eD"));
        fourthColumn.setCellValueFactory(new PropertyValueFactory<>("status"));

        List = XMLDE.XMLDecoder("./Registrations.xml");
        //Decodificare xml

        for(int i=0; i<List.size();i++){
            if (List.get(i) != null && List.get(i).getSportsmanEmail().equals(sportsmanEmail)) {
                data.add(new Inregistrare(List.get(i).getE(),sportsmanFirstName,sportsmanLastName,sportsmanEmail, List.get(i).getStatus()));
            }
        }
        table.setItems(data);

    }
    public void reinitializare(){
        ObservableList<Inregistrare> data = FXCollections.observableArrayList();

        firstColumn.setCellValueFactory(new PropertyValueFactory<>("photo"));
        secondColumn.setCellValueFactory(new PropertyValueFactory<>("eNC"));
        thirdColumn.setCellValueFactory(new PropertyValueFactory<>("eD"));
        fourthColumn.setCellValueFactory(new PropertyValueFactory<>("status"));

        List = XMLDE.XMLDecoder("./Registrations.xml");


        for(int i=0; i<List.size();i++){
            if (List.get(i) != null && List.get(i).getSportsmanEmail().equals(sportsmanEmail) ) {
                if(List.get(i).getE().getEventCategory().equals("Basketball") && checkList[0] == 1)
                    data.add(new Inregistrare(List.get(i).getE(),sportsmanFirstName,sportsmanLastName,sportsmanEmail, List.get(i).getStatus()));
                if(List.get(i).getE().getEventCategory().equals("Tennis") && checkList[1] == 1)
                    data.add(new Inregistrare(List.get(i).getE(),sportsmanFirstName,sportsmanLastName,sportsmanEmail, List.get(i).getStatus()));
                if(List.get(i).getE().getEventCategory().equals("Jogging") && checkList[2] == 1)
                    data.add(new Inregistrare(List.get(i).getE(),sportsmanFirstName,sportsmanLastName,sportsmanEmail, List.get(i).getStatus()));
                if(List.get(i).getE().getEventCategory().equals("Rugby") && checkList[3] == 1)
                    data.add(new Inregistrare(List.get(i).getE(),sportsmanFirstName,sportsmanLastName,sportsmanEmail, List.get(i).getStatus()));
                if(List.get(i).getE().getEventCategory().equals("Football") && checkList[4] == 1)
                    data.add(new Inregistrare(List.get(i).getE(),sportsmanFirstName,sportsmanLastName,sportsmanEmail, List.get(i).getStatus()));
            }
        }

        table.setItems(data);
    }

    @FXML
    void actionBasket() {

        if (!basketFilter.isSelected())
            checkList[0] = 0;
        else checkList[0] = 1;
        reinitializare();

    }

    @FXML
    void actionTennis() {
        if(!tennisFilter.isSelected())
            checkList[1] = 0;
        else
            checkList[1] = 1;
        reinitializare();
    }

    @FXML
    void actionJogging() {
        if(!joggingFilter.isSelected()){
            checkList[2] = 0;
        }
        else
            checkList[2] = 1;
        reinitializare();
    }

    @FXML
    void actionRugby() {
        if(!rugbyFilter.isSelected()){
            checkList[3] = 0;
        }
        else
            checkList[3] = 1;
        reinitializare();
    }

    @FXML
    void actionFootball() {
        if(!footballFilter.isSelected()){
            checkList[4] = 0;
        }
        else
            checkList[4] = 1;
        reinitializare();
    }

    @FXML
    void goBack(ActionEvent event) throws IOException {
        scene.changeScenes(event,"/sportsmanHomePage.fxml");
    }

    @FXML
    void cancelAction(ActionEvent event) {
        List = XMLDE.XMLDecoder("./Registrations.xml");

        if (table.getSelectionModel().getSelectedItem() != null){
            Inregistrare r = table.getSelectionModel().getSelectedItem();
            for (int i=0; i<List.size(); i++){
                if (List.get(i) != null){
                    if (!(List.get(i).getE().getEventName().equals(r.getE().getEventName()) && List.get(i).getSportsmanEmail().equals(r.getSportsmanEmail()))){
                        //List.remove(i);
                        Lista.add(List.get(i));
                    }
                }
            }
        }
        XMLDE.XMLEncoder("./Registrations.xml",Lista);
        reinitializare();

    }

}