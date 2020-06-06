import javafx.event.ActionEvent;
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
    private static ArrayList List = new ArrayList();

    @FXML
    private TextField usernameField;

    @FXML
    private TextField passwordField;

    private Alert alert = new Alert(Alert.AlertType.INFORMATION);
    @FXML
    private Button loginButton;

    @FXML
    private Hyperlink signupHyperlink;



    //public void buttonClicked(){
      //  System.out.println("eee");
   // }
    public void changeScreenButtonPushed(ActionEvent event) throws IOException {
        Parent signupView= FXMLLoader.load(getClass().getResource("/signup.fxml"));
        Scene signupScene=new Scene(signupView);
        Stage window=(Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(signupScene);
        window.show();
    }
    public void initialize(URL location, ResourceBundle resources) {

    }

   /* public void loginAction(ActionEvent e){
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

            for(int i=0; i < List.size(); i++){
                //System.out.println(List.get(i).toString());
            }
        } catch (
                FileNotFoundException ex) {
            ex.printStackTrace();
        }
        //Check Credentials
        for(int i =0; i<List.size();i++) {
            if (List.get(i) instanceof Sportsman) {
                if (((Sportsman) List.get(i)).getEmail().equals(this.usernameField.getText())) {
                    System.out.println("Accept");
                    if (((Sportsman) List.get(i)).getPassword().equals((this.passwordField.getText()))) {
                        System.out.println("Accept");
                        break;
                    }

                }
            }
            if(List.get(i) instanceof Eventplanner){
                if(((Eventplanner) List.get(i)).getEmail().equals(this.usernameField.getText())){
                    System.out.println("Accept");
                    if(((Eventplanner) List.get(i)).getEmail().equals(this.passwordField.getText())){
                        System.out.println("Accept");
                        break;
                    }
                }
            }
        }

    }*/
    //go to Sportsman Homepage
    /*public void loginAction(ActionEvent event) throws IOException {
        System.out.println("eee");
        Parent sportsmanHomePageView= FXMLLoader.load(getClass().getResource("/sportsmanHomePage.fxml"));
        Scene sportsmanHomePageScene=new Scene(sportsmanHomePageView);
        Stage window=(Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(sportsmanHomePageScene);
        window.show();
    }
*/
 //go to Event Planner Homepage
    public void loginAction(ActionEvent event) throws IOException {
        //System.out.println("eee");
          Parent eventplannerHomePageView= FXMLLoader.load(getClass().getResource("/eventplannerHomePage.fxml"));
          Scene eventplannerHomePageScene=new Scene(eventplannerHomePageView);
          Stage window=(Stage)((Node)event.getSource()).getScene().getWindow();
         window.setScene(eventplannerHomePageScene);
          window.show();
         }


}
