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
    private Button cancelButton;

    @FXML
    private TableColumn<?, ?> thirdColumn;

    @FXML
    private TableView<Inregistrare> table;

    @FXML
    private TableColumn<?, ?> fourthColumn;
    private SceneChanger scene=new SceneChanger();
    private ArrayList Lista = new ArrayList();

    public SportsmanMyEventsPage(){

    }
    public SportsmanMyEventsPage(String sportsmanEmail) {
        this.sportsmanEmail = sportsmanEmail;
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
    void actionBasket(ActionEvent event) {

        if (!basketFilter.isSelected())
            checkList[0] = 0;
        else checkList[0] = 1;
        reinitializare();

    }

    @FXML
    void actionTennis(ActionEvent event) {
        if(!tennisFilter.isSelected())
            checkList[1] = 0;
        else
            checkList[1] = 1;
        reinitializare();
    }

    @FXML
    void actionJogging(ActionEvent event) {
        if(!joggingFilter.isSelected()){
            checkList[2] = 0;
        }
        else
            checkList[2] = 1;
        reinitializare();
    }

    @FXML
    void actionRugby(ActionEvent event) {
        if(!rugbyFilter.isSelected()){
            checkList[3] = 0;
        }
        else
            checkList[3] = 1;
        reinitializare();
    }

    @FXML
    void actionFootball(ActionEvent event) {
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