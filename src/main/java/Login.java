
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

private SceneChanger scene=new SceneChanger();
    private static ArrayList<User> List = new ArrayList();
    boolean ok1=false, ok2=false;
    @FXML
    TextField usernameField;

    @FXML
    TextField passwordField;

   // private Alert alert = new Alert(Alert.AlertType.INFORMATION);
    @FXML
    private Button loginButton;

    @FXML
    private Hyperlink signupHyperlink;


    public void changeScreenButtonPushed(ActionEvent event) throws IOException {
        scene.changeScenes(event,"/signup.fxml");
    }

    public void initialize(URL location, ResourceBundle resources) {}

    public String returnCurrentEmail(String email){
        return email;}

    public boolean checkIfAllFieldsCompleted(){
        if (usernameField.getText().isEmpty()) {
            return false;
        }

        if (passwordField.getText().isEmpty()) {
            return false;
        }
        return true;
    }

    public int login(){
        List = XMLDE.XMLDecoder("./Signupuri.xml");
        //Check Credentials
        for(int i =0; i<List.size();i++) {
            if (List.get(i).getRole().equals("Sportsman")) {
                if ( List.get(i).getEmail().equals(this.usernameField.getText())) {
                    ok1=true;
                    String Parola = CodificareParola.getSHA512Password(this.passwordField.getText(),List.get(i).getSalt());
                    if (List.get(i).getPassword().equals(Parola)) {
                        ok2=true;
                        return i;
                    }
                    else {
                        this.passwordField.clear();
                        return -1;
                    }
                }
            }
            if (List.get(i).getRole().equals("Eventplanner")){
                if(List.get(i).getEmail().equals(this.usernameField.getText())){
                    ok1=true;
                    String Parola = CodificareParola.getSHA512Password(this.passwordField.getText(),List.get(i).getSalt());
                    if(List.get(i).getPassword().equals(Parola)){
                        ok2=true;
                        return i;
                    }
                    else {
                        this.passwordField.clear();
                        return -1;
                    }
                }
            }
        }
        this.usernameField.clear();
        this.passwordField.clear();
        return -1;
    }

   public void loginAction(ActionEvent e) throws IOException {
        if (!checkIfAllFieldsCompleted()){
            return;
        }
        int i = login();
        if (ok1 && ok2 && i>=0 && List.get(login()).getRole().equals("Sportsman")) {
            SportsmanHomePage T = new SportsmanHomePage(List.get(i).getFirstName(), List.get(i).getLastName() ,List.get(i).getEmail());
            scene.changeScenes(e, "/sportsmanHomePage.fxml");
        }
       if (ok1 && ok2 && i>=0 && List.get(login()).getRole().equals("Eventplanner")) {
           EventplannerHomePage T = new EventplannerHomePage(List.get(i).getEmail());
           scene.changeScenes(e, "/eventplannerHomePage.fxml");
       }
    }
}
