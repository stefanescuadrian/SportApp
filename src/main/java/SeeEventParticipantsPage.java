import com.sun.org.apache.xerces.internal.impl.xs.SchemaNamespaceSupport;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
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

public class SeeEventParticipantsPage implements Initializable {
    private static ArrayList<Inregistrare> List = new ArrayList();
    private static String eventPlannerMail;
    private static int eventMaxParticipants;
    private static  String eName;
    private static int numberOfAcceptedSportsman;


    @FXML
    TableColumn<?, ?> pendingImage;   ///////////////////////////////////////////
    @FXML
    TableColumn<?, ?> acceptedImage;
    @FXML
    TableColumn<?, ?> declinedImage;   ////////////////////////////////////////

    @FXML
    Button acceptButton;

    @FXML
    TableView<Inregistrare> pendingTable;

    @FXML
    TableView<Inregistrare> acceptedTable;

    @FXML
    Button backButton;



    @FXML
    TableView<Inregistrare> declinedTable;

    @FXML
    TableColumn<?, ?> declinedColumn;

    @FXML
    TableColumn<?, ?> pendingColumn;

    @FXML
    TableColumn<?, ?> acceptedColumn;

    private SceneChanger scene=new SceneChanger();

    public SceneChanger getScene() {
        return scene;
    }

    public void setScene(SceneChanger scene) {
        this.scene = scene;
    }

    public SeeEventParticipantsPage(){

    }

    public SeeEventParticipantsPage(String eventPlannerMail, String eName, String eventMaxParticipants) {
        this.eventPlannerMail = eventPlannerMail;
        this.eName = eName;
        this.eventMaxParticipants = Integer.parseInt(eventMaxParticipants);
    }

    public String getEventPlannerMail() {
        return eventPlannerMail;
    }

    public void setEventPlannerMail(String eventPlannerMail) {
        this.eventPlannerMail = eventPlannerMail;
    }

    @FXML
    void goBack(ActionEvent event) throws IOException {
        scene.changeScenes(event,"/eventplannerHomePage.fxml");
    }

    public  int getEventMaxParticipants() {
        return eventMaxParticipants;
    }

    public  void setEventMaxParticipants(int eventMaxParticipants) {
        SeeEventParticipantsPage.eventMaxParticipants = eventMaxParticipants;
    }

    public  String geteName() {
        return eName;
    }

    public  void seteName(String eName) {
        SeeEventParticipantsPage.eName = eName;
    }

    public void initialize(URL location, ResourceBundle resources) {
        numberOfAcceptedSportsman=0;
        System.out.println(eventMaxParticipants);
        ObservableList<Inregistrare> data1 = FXCollections.observableArrayList(); //for pendingTable
        ObservableList<Inregistrare> data2 = FXCollections.observableArrayList(); //for acceptedTable
        ObservableList<Inregistrare> data3 = FXCollections.observableArrayList(); //for declinedTable

        pendingColumn.setText("Pending");
        acceptedColumn.setText("Accepted");
        declinedColumn.setText("Declined");

        pendingColumn.setCellValueFactory(new PropertyValueFactory<>("sportsmanFNLN"));
        acceptedColumn.setCellValueFactory(new PropertyValueFactory<>("sportsmanFNLN"));
        declinedColumn.setCellValueFactory(new PropertyValueFactory<>("sportsmanFNLN"));

        //Decodificare xml
        List = XMLDE.XMLDecoder("./Registrations.xml");

        for (int i=0; i<List.size(); i++){
            if (List.get(i) != null && List.get(i).getE().getEventPlannerMail().equals(getEventPlannerMail()) && List.get(i).getE().getEventName().equals(eName)) {
                if (List.get(i).getStatus().equals("Pending")) {
                    data1.add(new Inregistrare(List.get(i).getE(), List.get(i).getSportsmanFirstName(), List.get(i).getSportsmanLastName(), List.get(i).getSportsmanEmail(), List.get(i).getStatus()));
                }
                if (List.get(i).getStatus().equals("Accepted")) {
                    data2.add(new Inregistrare(List.get(i).getE(), List.get(i).getSportsmanFirstName(), List.get(i).getSportsmanLastName(), List.get(i).getSportsmanEmail(), List.get(i).getStatus()));
                    numberOfAcceptedSportsman++;
                }
                if (List.get(i).getStatus().equals("Declined")) {
                    data3.add(new Inregistrare(List.get(i).getE(), List.get(i).getSportsmanFirstName(), List.get(i).getSportsmanLastName(), List.get(i).getSportsmanEmail(), List.get(i).getStatus()));

                }
            }
        }
        if (numberOfAcceptedSportsman == eventMaxParticipants)
            acceptButton.setDisable(true);

        pendingTable.setItems(data1);
        acceptedTable.setItems(data2);
        declinedTable.setItems(data3);
        System.out.println(numberOfAcceptedSportsman);
    }

    @FXML
    void acceptParticipant() throws IOException {
        if (pendingTable.getSelectionModel().getSelectedItem() != null && numberOfAcceptedSportsman < eventMaxParticipants){
            numberOfAcceptedSportsman++;
            System.out.println(numberOfAcceptedSportsman);
            //Decodificare xml
            List = XMLDE.XMLDecoder("./Registrations.xml");

            for(int i=0; i<List.size();i++){
                if(List.get(i) != null){
                if (List.get(i).getSportsmanEmail().equals(pendingTable.getSelectionModel().getSelectedItem().getSportsmanEmail()) && List.get(i).getE().getEventName().equals((pendingTable.getSelectionModel().getSelectedItem().getE().getEventName()))) {
                    if (List.get(i).getSportsmanEmail().equals(pendingTable.getSelectionModel().getSelectedItem().getSportsmanEmail()) && List.get(i).getE().getEventName().equals((pendingTable.getSelectionModel().getSelectedItem().getE().getEventName()))) {
                        List.get(i).setStatus("Accepted");
                    }
                }
                }
            }
            //Codificare xml file
            XMLDE.XMLEncoder("./Registrations.xml",List);
        }
        else if (pendingTable.getSelectionModel().getSelectedItem() != null && numberOfAcceptedSportsman == eventMaxParticipants) {
            acceptButton.setDisable(true);
        }
        reinitialize();
    }

    private void reinitialize() {
        ObservableList<Inregistrare> data1 = FXCollections.observableArrayList(); //for pendingTable
        ObservableList<Inregistrare> data2 = FXCollections.observableArrayList(); //for acceptedTable
        ObservableList<Inregistrare> data3 = FXCollections.observableArrayList(); //for declinedTable
        pendingColumn.setText("Pending");
        acceptedColumn.setText("Accepted");
        declinedColumn.setText("Declined");


        pendingColumn.setCellValueFactory(new PropertyValueFactory<>("sportsmanFNLN"));
        acceptedColumn.setCellValueFactory(new PropertyValueFactory<>("sportsmanFNLN"));
        declinedColumn.setCellValueFactory(new PropertyValueFactory<>("sportsmanFNLN"));

        List = XMLDE.XMLDecoder("./Registrations.xml");

        for (int i=0; i<List.size(); i++){
            if (List.get(i) != null && List.get(i).getE().getEventPlannerMail().equals(getEventPlannerMail()) && List.get(i).getE().getEventName().equals(eName)) {
                if (List.get(i).getStatus().equals("Pending")) {
                    data1.add(new Inregistrare(List.get(i).getE(), List.get(i).getSportsmanFirstName(), List.get(i).getSportsmanLastName(), List.get(i).getSportsmanEmail(), List.get(i).getStatus()));
                }
                if (List.get(i).getStatus().equals("Accepted")) {
                    data2.add(new Inregistrare(List.get(i).getE(), List.get(i).getSportsmanFirstName(), List.get(i).getSportsmanLastName(), List.get(i).getSportsmanEmail(), List.get(i).getStatus()));

                }
                if (List.get(i).getStatus().equals("Declined")) {
                    data3.add(new Inregistrare(List.get(i).getE(), List.get(i).getSportsmanFirstName(), List.get(i).getSportsmanLastName(), List.get(i).getSportsmanEmail(), List.get(i).getStatus()));

                }
            }
        }
        pendingTable.setItems(data1);
        acceptedTable.setItems(data2);
        declinedTable.setItems(data3);
    }

    @FXML
    void declineParticipant() {
        if (pendingTable.getSelectionModel().getSelectedItem() != null){
            List = XMLDE.XMLDecoder("./Registrations.xml");


            for(int i=0; i<List.size();i++){
                if(List.get(i) != null){
                if (List.get(i).getSportsmanEmail().equals(pendingTable.getSelectionModel().getSelectedItem().getSportsmanEmail()) && List.get(i).getE().getEventName().equals((pendingTable.getSelectionModel().getSelectedItem().getE().getEventName()))) {
                    if (List.get(i).getSportsmanEmail().equals(pendingTable.getSelectionModel().getSelectedItem().getSportsmanEmail()) && List.get(i).getE().getEventName().equals((pendingTable.getSelectionModel().getSelectedItem().getE().getEventName()))) {
                        List.get(i).setStatus("Declined");
                    }
                }
                }
            }
            XMLDE.XMLEncoder("./Registrations.xml",List);

        }
        reinitialize();
    }
}
