
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.beans.XMLDecoder;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;



public class Login implements Initializable {


    private static ArrayList<User> List = new ArrayList();

    @FXML
    private TextField usernameField;

    @FXML
    private TextField passwordField;

    private Alert alert = new Alert(Alert.AlertType.INFORMATION);
    @FXML
    private Button loginButton;

    @FXML
    private Hyperlink signupHyperlink;


    public void changeScreenButtonPushed(ActionEvent event) throws IOException {
        Parent signupView= FXMLLoader.load(getClass().getResource("/signup.fxml"));
        Scene signupScene=new Scene(signupView);
        Stage window=(Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(signupScene);
        window.show();
    }
    public void initialize(URL location, ResourceBundle resources) {

    }

    public String returnCurrentEmail(String email){
        return email;
    }

   public void loginAction(ActionEvent e) throws IOException {
        if (usernameField.getText().isEmpty()) {
            alert.setTitle("ERROR");
            alert.setHeaderText(null);
            alert.setContentText("Please enter your email address!");
            alert.showAndWait();
            return;
        }

        if (passwordField.getText().isEmpty()) {
            alert.setTitle("ERROR");
            alert.setHeaderText(null);
            alert.setContentText("Please enter your password!");
            alert.showAndWait();
            return;
        }

        try{
            FileInputStream fis = new FileInputStream("./Signupuri.xml");
            XMLDecoder decoder = new XMLDecoder(fis);
            ArrayList A = new ArrayList();
            A = (ArrayList) decoder.readObject();
            List = A;
        } catch (
                FileNotFoundException ex) {
            ex.printStackTrace();
        }
        boolean ok1=false, ok2=false;
        //Check Credentials
        for(int i =0; i<List.size();i++) {
            if (List.get(i).getRole().equals("Sportsman")) {
                if ( List.get(i).getEmail().equals(this.usernameField.getText())) {
                    ok1=true;
                    String Parola = CodificareParola.getSHA512Password(this.passwordField.getText(),List.get(i).getSalt());
                    //System.out.println(Parola);
                    if (List.get(i).getPassword().equals(Parola)) {
                        ok2=true;
                        SportsmanHomePage T = new SportsmanHomePage(List.get(i).getFirstName(), List.get(i).getLastName() ,List.get(i).getEmail());
                        Parent sportsmanHomePageView= FXMLLoader.load(getClass().getResource("/sportsmanHomePage.fxml"));
                        Scene sportsmanHomePageScene=new Scene(sportsmanHomePageView);
                        Stage window=(Stage)((Node)e.getSource()).getScene().getWindow();
                        window.setScene(sportsmanHomePageScene);
                        window.show();
                        returnCurrentEmail( List.get(i).getEmail());
                        break;
                    }
                    else {
                        alert.setTitle("ERROR");
                        alert.setHeaderText(null);
                        alert.setContentText("The password is incorrect!");
                        alert.showAndWait();
                        this.passwordField.clear();
                        return;
                    }
                }
            }
            if (List.get(i).getRole().equals("Eventplanner")){
                if( List.get(i).getEmail().equals(this.usernameField.getText())){
                    ok1=true;
                    String Parola = CodificareParola.getSHA512Password(this.passwordField.getText(),List.get(i).getSalt());
                    //System.out.println(Parola);
                    if(List.get(i).getPassword().equals(Parola)){
                        ok2=true;
                        EventplannerHomePage T = new EventplannerHomePage(List.get(i).getEmail());
                        Parent eventplannerHomePageView= FXMLLoader.load(getClass().getResource("/eventplannerHomePage.fxml"));
                        Scene eventplannerHomePageScene=new Scene(eventplannerHomePageView);
                        Stage window=(Stage)((Node)e.getSource()).getScene().getWindow();
                        window.setScene(eventplannerHomePageScene);
                        window.show();
                        returnCurrentEmail( List.get(i).getEmail());
                        break;
                    }
                    else {
                        alert.setTitle("ERROR");
                        alert.setHeaderText(null);
                        alert.setContentText("The password is incorrect!");
                        alert.showAndWait();
                        this.passwordField.clear();
                        return;
                    }
                }
            }
        }
        if (!ok1){
            alert.setTitle("ERROR");
            alert.setHeaderText(null);
            alert.setContentText("This account doesn't exist!");
            alert.showAndWait();
            this.usernameField.clear();
            this.passwordField.clear();
            return;
        }
    }
}
