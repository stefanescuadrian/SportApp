import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import javax.swing.*;
import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.Array;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class SportsmanHomePage implements Initializable {
    Inregistrare I;
    private static String eventPlannerName;////////////////////////////////////////////

    public static String sportsmanEmail;
    public static String sportsmanFirstName;
    public static String sportsmanLastName;
    private static int[] checkList = new int[5];
    private static ArrayList<Eveniment> List = new ArrayList();
    private static ArrayList List1 = new ArrayList();
    @FXML
    private TableColumn<?, ?> firstColumn;

    @FXML
    private TableColumn<?, ?> secondColumn;

    @FXML
    private TableColumn<?, ?> thirdColumn;

    @FXML
    private TableColumn<?, ?> fourthColumn;
    @FXML
    private TableView<Eveniment> table;

    @FXML
    private Button goBackButton;

    private Button[] buttons = new Button[100];
    private boolean[] buttons_disable_status = new boolean[100];
    private String[] textButtons = new String[100];

    @FXML
    private TitledPane filters;

    @FXML
    private Pane checkPane;

    @FXML
    private CheckBox basketFilter;

    @FXML
    private CheckBox joggingFilter;

    @FXML
    private CheckBox tennisFilter;

    @FXML
    private CheckBox rugbyFilter;

    @FXML
    private CheckBox footballFilter;
    @FXML
    private Button myEventsButton;
    @FXML
    private Button cancelButton;

    public Pane getCheckPane() {
        return checkPane;
    }



    @FXML
    void changeScreenButtonPushed(ActionEvent event) {

    }
    public SportsmanHomePage(){

    }
    public SportsmanHomePage(String sportsmanFirstName, String sportsmanLastName, String sportsmanEmail) {
        this.sportsmanFirstName = sportsmanFirstName;
        this.sportsmanLastName  = sportsmanLastName;
        this.sportsmanEmail = sportsmanEmail;
    }

    public static String getSportsmanFirstName() {
        return sportsmanFirstName;
    }

    public static void setSportsmanFirstName(String sportsmanFirstName) {
        SportsmanHomePage.sportsmanFirstName = sportsmanFirstName;
    }

    public static String getSportsmanLastName() {
        return sportsmanLastName;
    }

    public static void setSportsmanLastName(String sportsmanLastName) {
        SportsmanHomePage.sportsmanLastName = sportsmanLastName;
    }

    public static String getSportsmanEmail() {
        return sportsmanEmail;
    }

    public static void setSportsmanEmail(String sportsmanEmail) {
        SportsmanHomePage.sportsmanEmail = sportsmanEmail;
    }

    private void verificareInregistrareaExista(String eventName, String eventplannerMail, String sportsmanMail) {
        //O inregistrare e caracterizata in principiu de numele evenimentului, email-ul eventplanner-ului si email-ul sportsman-ului

        //Decodificare xml Registrations
        ArrayList<Inregistrare> Lista = new ArrayList();
        ArrayList<Eveniment> Lista1 = new ArrayList();
        try{
            FileInputStream fis = new FileInputStream("./Registrations.xml");
            XMLDecoder decoder = new XMLDecoder(fis);
            ArrayList A = new ArrayList();
            A = (ArrayList) decoder.readObject();
            Lista =A;
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        }

        //Decodificare xml Events
        try{
            FileInputStream fis = new FileInputStream("./Events.xml");
            XMLDecoder decoder = new XMLDecoder(fis);
            ArrayList A = new ArrayList();
            A = (ArrayList) decoder.readObject();
            Lista1 =A;
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        }


        for (int i=0;i<Lista.size();i++){
            if(Lista.get(i) instanceof Inregistrare){
                if (Lista.get(i).getSportsmanEmail().equals(sportsmanMail) && Lista.get(i).getE().getEventPlannerMail().equals(eventplannerMail) && Lista.get(i).getE().getEventName().equals(eventName)){
                    for(int j=0;j<Lista1.size();j++){
                        if (Lista1.get(j) instanceof Eveniment){
                            if (Lista1.get(j).getEventName().equals(eventName) && Lista1.get(j).getEventPlannerMail().equals(eventplannerMail)){
                                buttons_disable_status[j] = true;
                                textButtons[j] = "Joined";
                            }
                        }
                    }
                }

            }
        }

    }
    private void initializare_status_butoane(){
        for(int i=0; i<buttons_disable_status.length;i++){
            buttons_disable_status[i] = false;
            textButtons[i] = "Join";

        }
    }
    private void initializare_butoane(){
        for (int i=0; i<buttons.length; i++){
            buttons[i].setDisable(buttons_disable_status[i]);
            buttons[i].setText(textButtons[i]);
        }
    }

    public void initialize(URL location, ResourceBundle resources) {

        checkList[0] = 1;
        checkList[1] = 1;
        checkList[2] = 1;
        checkList[3] = 1;
        checkList[4] = 1;

        for(int i=0; i<buttons.length; i++) {
            buttons[i] = new Button();
            buttons[i].setOnAction(this::handleButtonAction);
            buttons[i].setStyle("-fx-font-weight: normal;");
        }
        initializare_status_butoane();
        initializare_butoane();
        ObservableList<Eveniment> data = FXCollections.observableArrayList();

        firstColumn.setCellValueFactory(new PropertyValueFactory<>("photo"));
        secondColumn.setCellValueFactory(new PropertyValueFactory<>("eNC"));
        thirdColumn.setCellValueFactory(new PropertyValueFactory<>("eD"));
        fourthColumn.setCellValueFactory(new PropertyValueFactory<>("button"));


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
                verificareInregistrareaExista(List.get(i).getEventName(), List.get(i).getEventPlannerMail(), sportsmanEmail);
                initializare_butoane();
                data.add(new Eveniment(List.get(i).getEventCategory(), List.get(i).getEventDescription(), List.get(i).getEventName(), List.get(i).getEventDifficulty(), List.get(i).getEventLocation(), List.get(i).getEventMaxNumberParticipants(), List.get(i).getEventDate(),buttons[i]));
            }
        }

        table.setItems(data);
//////////////////////////////////////////////////////////////////////////////////////////////////////////
        table.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
               SeeEventInformationPage edit = new SeeEventInformationPage(table.getSelectionModel().getSelectedItem().getN(),eventPlannerName); //e, de fapt, email-ul eventPlanner-ului

                FXMLLoader loader = new FXMLLoader();
                loader.setLocation(getClass().getResource("/seeEventInformationPage.fxml"));
                Parent tableView = null;
                try {
                    tableView = tableView = loader.load();
                } catch (IOException e) {
                    e.printStackTrace();
                }


                Scene tableViewScene = new Scene(tableView);
                SeeEventInformationPage controller = loader.getController();
                controller.showDetails(table.getSelectionModel().getSelectedItem());
                Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
                window.setScene(tableViewScene);
                window.show();
            }
        });


    }
    public void reinitializare(){
        for(int i=0; i<buttons.length; i++) {
            buttons[i] = new Button();
            buttons[i].setOnAction(this::handleButtonAction);
            buttons[i].setStyle("-fx-font-weight: normal;");
        }
        initializare_butoane();
        ObservableList<Eveniment> data = FXCollections.observableArrayList();

        firstColumn.setCellValueFactory(new PropertyValueFactory<>("photo"));
        secondColumn.setCellValueFactory(new PropertyValueFactory<>("eNC"));
        thirdColumn.setCellValueFactory(new PropertyValueFactory<>("eD"));
        fourthColumn.setCellValueFactory(new PropertyValueFactory<>("button"));


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
            if (List.get(i) instanceof Eveniment ) {
                verificareInregistrareaExista(List.get(i).getEventName(), List.get(i).getEventPlannerMail(), sportsmanEmail);
                initializare_butoane();
                if(List.get(i).getEventCategory().equals("Basketball") && checkList[0] == 1)///////////////////////////////////////////
                data.add(new Eveniment(List.get(i).getEventCategory(), List.get(i).getEventDescription(), List.get(i).getEventName(), List.get(i).getEventDifficulty(), List.get(i).getEventLocation(), List.get(i).getEventMaxNumberParticipants(), List.get(i).getEventDate(),buttons[i]));
                if(List.get(i).getEventCategory().equals("Tennis") && checkList[1] == 1)
                    data.add(new Eveniment(List.get(i).getEventCategory(), List.get(i).getEventDescription(), List.get(i).getEventName(), List.get(i).getEventDifficulty(), List.get(i).getEventLocation(), List.get(i).getEventMaxNumberParticipants(), List.get(i).getEventDate(),buttons[i]));
                if(List.get(i).getEventCategory().equals("Jogging") && checkList[2] == 1)
                    data.add(new Eveniment(List.get(i).getEventCategory(), List.get(i).getEventDescription(), List.get(i).getEventName(), List.get(i).getEventDifficulty(), List.get(i).getEventLocation(), List.get(i).getEventMaxNumberParticipants(), List.get(i).getEventDate(),buttons[i]));
                if(List.get(i).getEventCategory().equals("Rugby") && checkList[3] == 1)
                    data.add(new Eveniment(List.get(i).getEventCategory(), List.get(i).getEventDescription(), List.get(i).getEventName(), List.get(i).getEventDifficulty(), List.get(i).getEventLocation(), List.get(i).getEventMaxNumberParticipants(), List.get(i).getEventDate(),buttons[i]));
                if(List.get(i).getEventCategory().equals("Football") && checkList[4] == 1)
                    data.add(new Eveniment(List.get(i).getEventCategory(), List.get(i).getEventDescription(), List.get(i).getEventName(), List.get(i).getEventDifficulty(), List.get(i).getEventLocation(), List.get(i).getEventMaxNumberParticipants(), List.get(i).getEventDate(),buttons[i]));

            }
        }

        table.setItems(data);
    }

    private void handleButtonAction(ActionEvent actionEvent) {
        for (int i=0; i<buttons.length; i++)
            if (actionEvent.getSource() == buttons[i] && List.get(i) instanceof Eveniment) {
                I = new Inregistrare(List.get(i), SportsmanHomePage.getSportsmanFirstName(), SportsmanHomePage.getSportsmanLastName(), SportsmanHomePage.getSportsmanEmail(), "Pending");
            }
        //Decodificare xml
        try{
            FileInputStream fis = new FileInputStream("./Registrations.xml");
            XMLDecoder decoder = new XMLDecoder(fis);
            ArrayList A = new ArrayList();
            A = (ArrayList) decoder.readObject();
            List1 =A;
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        }

        //Codificare xml file
        try{
            List1.add(I);
            FileOutputStream fos = new FileOutputStream("./Registrations.xml");
            XMLEncoder encoder = new XMLEncoder(fos);
            encoder.writeObject(List1);
            encoder.close();
            fos.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        reinitializare();
    }

    @FXML
    void logoutOnAction(ActionEvent event) throws IOException {
        Parent loginView= FXMLLoader.load(getClass().getResource("/login.fxml"));
        Scene loginScene=new Scene(loginView);
        Stage window=(Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(loginScene);
        window.show();
    }
    @FXML
    void goToMyEventsPage(ActionEvent event) throws IOException {
        SportsmanMyEventsPage S = new SportsmanMyEventsPage(sportsmanEmail);
        Parent sportsmanMyEventsPage= FXMLLoader.load(getClass().getResource("/sportsmanMyEventsPage.fxml"));
        Scene loginScene=new Scene(sportsmanMyEventsPage);
        Stage window=(Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(loginScene);
        window.show();
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

}
