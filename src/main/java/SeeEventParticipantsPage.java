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
    private static ArrayList List = new ArrayList();
    private static String eventPlannerMail;
    private static int eventMaxParticipants;
    private static  String eName;
    private static int numberOfAcceptedSportsman;
    private Alert alert = new Alert(Alert.AlertType.INFORMATION);
    @FXML
    private TableView<Inregistrare> pendingTable;

    @FXML
    private TableView<Inregistrare> acceptedTable;

    @FXML
    private Button backButton;

    @FXML
    private TableView<Inregistrare> declinedTable;

    @FXML
    private TableColumn<?, ?> declinedColumn;

    @FXML
    private TableColumn<?, ?> pendingColumn;

    @FXML
    private TableColumn<?, ?> acceptedColumn;



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
        Parent goBackPageView= FXMLLoader.load(getClass().getResource("/editEvents.fxml"));
        Scene loginScene=new Scene(goBackPageView);
        Stage window=(Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(loginScene);
        window.show();
    }

    public void initialize(URL location, ResourceBundle resources) {
        numberOfAcceptedSportsman=0;
        System.out.println(eventMaxParticipants);
        ObservableList<Inregistrare> data1 = FXCollections.observableArrayList(); //for pendingTable
        ObservableList<Inregistrare> data2 = FXCollections.observableArrayList(); //for acceptedTable
        ObservableList<Inregistrare> data3 = FXCollections.observableArrayList(); //for declinedTable

        pendingColumn.setCellValueFactory(new PropertyValueFactory<>("sportsmanFNLN"));
        acceptedColumn.setCellValueFactory(new PropertyValueFactory<>("sportsmanFNLN"));
        declinedColumn.setCellValueFactory(new PropertyValueFactory<>("sportsmanFNLN"));

        //Decodificare xml
        try{
            FileInputStream fis = new FileInputStream("./Registrations.xml");
            XMLDecoder decoder = new XMLDecoder(fis);
            ArrayList A = new ArrayList();
            A = (ArrayList) decoder.readObject();
            List = A;
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        }

        for (int i=0; i<List.size(); i++){
            if (List.get(i) instanceof Inregistrare && ((Inregistrare) List.get(i)).getE().getEventPlannerMail().equals(getEventPlannerMail()) && ((Inregistrare) List.get(i)).getE().getEventName().equals(eName)) {
                if (((Inregistrare) List.get(i)).getStatus().equals("Pending")) {
                    data1.add(new Inregistrare(((Inregistrare) List.get(i)).getE(),((Inregistrare) List.get(i)).getSportsmanFirstName(),((Inregistrare) List.get(i)).getSportsmanLastName(),((Inregistrare) List.get(i)).getSportsmanEmail(),((Inregistrare) List.get(i)).getStatus()));
                }
                if (((Inregistrare) List.get(i)).getStatus().equals("Accepted")) {
                    data2.add(new Inregistrare(((Inregistrare) List.get(i)).getE(),((Inregistrare) List.get(i)).getSportsmanFirstName(),((Inregistrare) List.get(i)).getSportsmanLastName(),((Inregistrare) List.get(i)).getSportsmanEmail(),((Inregistrare) List.get(i)).getStatus()));
                    numberOfAcceptedSportsman++;
                }
                if (((Inregistrare) List.get(i)).getStatus().equals("Declined")) {
                    data3.add(new Inregistrare(((Inregistrare) List.get(i)).getE(),((Inregistrare) List.get(i)).getSportsmanFirstName(),((Inregistrare) List.get(i)).getSportsmanLastName(),((Inregistrare) List.get(i)).getSportsmanEmail(),((Inregistrare) List.get(i)).getStatus()));

                }
            }
        }
        pendingTable.setItems(data1);
        acceptedTable.setItems(data2);
        declinedTable.setItems(data3);
        System.out.println(numberOfAcceptedSportsman);
    }

    @FXML
    void acceptParticipant(ActionEvent event) throws IOException {
        if (pendingTable.getSelectionModel().getSelectedItem() instanceof Inregistrare && numberOfAcceptedSportsman < eventMaxParticipants){
            numberOfAcceptedSportsman++;
            System.out.println(numberOfAcceptedSportsman);
            //Decodificare xml
            try{
                FileInputStream fis = new FileInputStream("./Registrations.xml");
                XMLDecoder decoder = new XMLDecoder(fis);
                ArrayList A = new ArrayList();
                A = (ArrayList) decoder.readObject();
                List = A;
            } catch (FileNotFoundException ex) {
                ex.printStackTrace();
            }

            for(int i=0; i<List.size();i++){
                if(List.get(i) instanceof Inregistrare){
                if (((Inregistrare) List.get(i)).getSportsmanEmail().equals(pendingTable.getSelectionModel().getSelectedItem().getSportsmanEmail()) && ((Inregistrare) List.get(i)).getE().getEventName().equals((pendingTable.getSelectionModel().getSelectedItem().getE().getEventName()))) {
                    if (((Inregistrare) List.get(i)).getSportsmanEmail().equals(pendingTable.getSelectionModel().getSelectedItem().getSportsmanEmail()) && ((Inregistrare) List.get(i)).getE().getEventName().equals((pendingTable.getSelectionModel().getSelectedItem().getE().getEventName()))) {
                        ((Inregistrare) List.get(i)).setStatus("Accepted");
                    }
                }
                }
            }

            //Codificare xml file
            try{
                FileOutputStream fos = new FileOutputStream("./Registrations.xml");
                XMLEncoder encoder = new XMLEncoder(fos);
                encoder.writeObject(List);
                encoder.close();
                fos.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        else {
            alert.setTitle("ERROR");
            alert.setHeaderText(null);
            alert.setContentText("Number of maximum participants was reached !");
            alert.showAndWait();
        }
        reinitialize();
    }

    private void reinitialize() {
        ObservableList<Inregistrare> data1 = FXCollections.observableArrayList(); //for pendingTable
        ObservableList<Inregistrare> data2 = FXCollections.observableArrayList(); //for acceptedTable
        ObservableList<Inregistrare> data3 = FXCollections.observableArrayList(); //for declinedTable

        pendingColumn.setCellValueFactory(new PropertyValueFactory<>("sportsmanFNLN"));
        acceptedColumn.setCellValueFactory(new PropertyValueFactory<>("sportsmanFNLN"));
        declinedColumn.setCellValueFactory(new PropertyValueFactory<>("sportsmanFNLN"));

        //Decodificare xml
        try{
            FileInputStream fis = new FileInputStream("./Registrations.xml");
            XMLDecoder decoder = new XMLDecoder(fis);
            ArrayList A = new ArrayList();
            A = (ArrayList) decoder.readObject();
            List = A;
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        }

        for (int i=0; i<List.size(); i++){
            if (List.get(i) instanceof Inregistrare && ((Inregistrare) List.get(i)).getE().getEventPlannerMail().equals(getEventPlannerMail()) && ((Inregistrare) List.get(i)).getE().getEventName().equals(eName)) {
                if (((Inregistrare) List.get(i)).getStatus().equals("Pending")) {
                    data1.add(new Inregistrare(((Inregistrare) List.get(i)).getE(),((Inregistrare) List.get(i)).getSportsmanFirstName(),((Inregistrare) List.get(i)).getSportsmanLastName(),((Inregistrare) List.get(i)).getSportsmanEmail(),((Inregistrare) List.get(i)).getStatus()));
                }
                if (((Inregistrare) List.get(i)).getStatus().equals("Accepted")) {
                    data2.add(new Inregistrare(((Inregistrare) List.get(i)).getE(),((Inregistrare) List.get(i)).getSportsmanFirstName(),((Inregistrare) List.get(i)).getSportsmanLastName(),((Inregistrare) List.get(i)).getSportsmanEmail(),((Inregistrare) List.get(i)).getStatus()));

                }
                if (((Inregistrare) List.get(i)).getStatus().equals("Declined")) {
                    data3.add(new Inregistrare(((Inregistrare) List.get(i)).getE(),((Inregistrare) List.get(i)).getSportsmanFirstName(),((Inregistrare) List.get(i)).getSportsmanLastName(),((Inregistrare) List.get(i)).getSportsmanEmail(),((Inregistrare) List.get(i)).getStatus()));

                }
            }
        }
        pendingTable.setItems(data1);
        acceptedTable.setItems(data2);
        declinedTable.setItems(data3);
    }

    @FXML
    void declineParticipant(ActionEvent event) {
        if (pendingTable.getSelectionModel().getSelectedItem() instanceof Inregistrare){
            //Decodificare xml
            try{
                FileInputStream fis = new FileInputStream("./Registrations.xml");
                XMLDecoder decoder = new XMLDecoder(fis);
                ArrayList A = new ArrayList();
                A = (ArrayList) decoder.readObject();
                List = A;
            } catch (FileNotFoundException ex) {
                ex.printStackTrace();
            }


            for(int i=0; i<List.size();i++){
                if(List.get(i) instanceof Inregistrare){
                if (((Inregistrare) List.get(i)).getSportsmanEmail().equals(pendingTable.getSelectionModel().getSelectedItem().getSportsmanEmail()) && ((Inregistrare) List.get(i)).getE().getEventName().equals((pendingTable.getSelectionModel().getSelectedItem().getE().getEventName()))) {
                    if (((Inregistrare) List.get(i)).getSportsmanEmail().equals(pendingTable.getSelectionModel().getSelectedItem().getSportsmanEmail()) && ((Inregistrare) List.get(i)).getE().getEventName().equals((pendingTable.getSelectionModel().getSelectedItem().getE().getEventName()))) {
                        ((Inregistrare) List.get(i)).setStatus("Declined");

                    }
                }
                }
            }

            //Codificare xml file
            try{
                FileOutputStream fos = new FileOutputStream("./Registrations.xml");
                XMLEncoder encoder = new XMLEncoder(fos);
                encoder.writeObject(List);
                encoder.close();
                fos.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        reinitialize();
    }
}
