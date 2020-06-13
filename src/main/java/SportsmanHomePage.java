import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

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
    public static String sportsmanEmail;
    public static String sportsmanFirstName;
    public static String sportsmanLastName;
    private static int[] checkList = new int[5];
    private static ArrayList List = new ArrayList();
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

    public void initialize(URL location, ResourceBundle resources) {
        checkList[0] = 1;
        checkList[1] = 1;
        checkList[2] = 1;
        checkList[3] = 1;
        checkList[4] = 1;

        for(int i=0; i<buttons.length; i++) {
            buttons[i] = new Button();
            buttons[i].setOnAction(this::handleButtonAction);
            buttons[i].setStyle("-fx-background-color: transparent;-fx-border-color: black; -fx-padding: 5 20 5 20;");

        }

        ObservableList<Eveniment> data = FXCollections.observableArrayList();


        //firstColumn.setMinWidth(60);
      //  firstColumn.setMaxWidth(60);
        firstColumn.setCellValueFactory(new PropertyValueFactory<>("photo"));


       // secondColumn.setMinWidth(277);
       // secondColumn.setMaxWidth(277);
        secondColumn.setCellValueFactory(new PropertyValueFactory<>("eNC"));


       // thirdColumn.setMinWidth(277);
      //  thirdColumn.setMaxWidth(277);
        thirdColumn.setCellValueFactory(new PropertyValueFactory<>("eD"));

      //  fourthColumn.setMinWidth(277);
       // fourthColumn.setMaxWidth(277);
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
                data.add(new Eveniment(((Eveniment) List.get(i)).getEventCategory(),((Eveniment) List.get(i)).getEventDescription(),((Eveniment) List.get(i)).getEventName(),buttons[i]));
            }
        }

        table.setItems(data);
    }
    public void reinitializare(){
        for(int i=0; i<buttons.length; i++) {
            buttons[i] = new Button();
            buttons[i].setOnAction(this::handleButtonAction);
        }

        ObservableList<Eveniment> data = FXCollections.observableArrayList();

        firstColumn.setMinWidth(60);
        firstColumn.setMaxWidth(60);
        firstColumn.setCellValueFactory(new PropertyValueFactory<>("photo"));


        secondColumn.setMinWidth(277);
        secondColumn.setMaxWidth(277);
        secondColumn.setCellValueFactory(new PropertyValueFactory<>("eNC"));


        thirdColumn.setMinWidth(277);
        thirdColumn.setMaxWidth(277);
        thirdColumn.setCellValueFactory(new PropertyValueFactory<>("eD"));

        fourthColumn.setMinWidth(277);
        fourthColumn.setMaxWidth(277);
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
                if(((Eveniment) List.get(i)).getEventCategory().equals("Basketball") && checkList[0] == 1)
                data.add(new Eveniment(((Eveniment) List.get(i)).getEventCategory(),((Eveniment) List.get(i)).getEventDescription(),((Eveniment) List.get(i)).getEventName(),buttons[i]));
                if(((Eveniment) List.get(i)).getEventCategory().equals("Tennis") && checkList[1] == 1)
                    data.add(new Eveniment(((Eveniment) List.get(i)).getEventCategory(),((Eveniment) List.get(i)).getEventDescription(),((Eveniment) List.get(i)).getEventName(),buttons[i]));
                if(((Eveniment) List.get(i)).getEventCategory().equals("Jogging") && checkList[2] == 1)
                    data.add(new Eveniment(((Eveniment) List.get(i)).getEventCategory(),((Eveniment) List.get(i)).getEventDescription(),((Eveniment) List.get(i)).getEventName(),buttons[i]));
                if(((Eveniment) List.get(i)).getEventCategory().equals("Rugby") && checkList[3] == 1)
                    data.add(new Eveniment(((Eveniment) List.get(i)).getEventCategory(),((Eveniment) List.get(i)).getEventDescription(),((Eveniment) List.get(i)).getEventName(),buttons[i]));
                if(((Eveniment) List.get(i)).getEventCategory().equals("Football") && checkList[4] == 1)
                    data.add(new Eveniment(((Eveniment) List.get(i)).getEventCategory(),((Eveniment) List.get(i)).getEventDescription(),((Eveniment) List.get(i)).getEventName(),buttons[i]));

            }
        }

        table.setItems(data);
    }

    private void handleButtonAction(ActionEvent actionEvent) {
        for (int i=0; i<buttons.length; i++)
            if (actionEvent.getSource() == buttons[i] && List.get(i) instanceof Eveniment)
            I = new Inregistrare((Eveniment) List.get(i), SportsmanHomePage.getSportsmanFirstName(), SportsmanHomePage.getSportsmanLastName(), SportsmanHomePage.getSportsmanEmail());

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
