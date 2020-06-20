import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import javax.jws.soap.SOAPBinding;
import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.*;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;


public class SportsmanSignupForm {
    //public Alert alert = new Alert(Alert.AlertType.INFORMATION);
    private ArrayList<User> List = new ArrayList();
    @FXML
    TextField firstName;
    @FXML
    TextField lastName;
    @FXML
    TextField emailAddress;
    @FXML
    PasswordField password;

    public ArrayList<User> getList() {
        return List;
    }

    public SportsmanSignupForm() throws FileNotFoundException {
    }

    @FXML
    public void changeScreenButtonPushed(ActionEvent event) throws IOException {
        Parent signupView= FXMLLoader.load(getClass().getResource("/signup.fxml"));
        Scene signupScene=new Scene(signupView);
        Stage window=(Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(signupScene);
        window.show();
    }


    public boolean checkIfAllFieldsCompleted(){
        if (firstName.getText().isEmpty()) {
            return false;
        }
        if (lastName.getText().isEmpty()) {
            return false;
        }
        if (emailAddress.getText().isEmpty()) {
            return false;
        }

        if (password.getText().isEmpty()) {
            return false;
        }
        return true;
    }

    public boolean addSportsmanAccount() throws NoSuchAlgorithmException {
        //Decodificare XML File
        List = XMLDE.XMLDecoder("./Signupuri.xml");

        //ACCOUNT ALREADY EXISTS CHECK
        for(int i = 0; i< List.size(); i++){
            if(List.get(i) instanceof Sportsman){
                if (List.get(i).getEmail().equals(this.emailAddress.getText())){
                    emailAddress.clear();
                    emailAddress.setPromptText("Please enter another email !");
                    emailAddress.setStyle("-fx-prompt-text-fill:red;");
                    return false;
                }
            }
            if(List.get(i) instanceof Eventplanner){
                if (List.get(i).getEmail().equals(this.emailAddress.getText())){
                    emailAddress.clear();
                    emailAddress.setPromptText("Please enter another email !");
                    emailAddress.setStyle("-fx-prompt-text-fill:red;");
                    return false;
                }
            }
        }


        byte[] salt = CodificareParola.getSalt();
        String T = CodificareParola.getSHA512Password(password.getText(),salt);

        Sportsman S = new Sportsman(firstName.getText(), lastName.getText(), emailAddress.getText(), T, salt);
        List.add(S);

        //Codificare XML File
        XMLDE.XMLEncoder("./Signupuri.xml",List);

        return true;
    }

    private void loadNewPage(String NewPage, ActionEvent e) throws IOException {
        Parent signupView= FXMLLoader.load(getClass().getResource(NewPage));
        Scene signupScene=new Scene(signupView);
        Stage window=(Stage)((Node)e.getSource()).getScene().getWindow();
        window.setScene(signupScene);
        window.show();
    }

    public void saveSportsmanData(ActionEvent e) throws IOException, NoSuchAlgorithmException {

        if (!checkIfAllFieldsCompleted()){
            return;
        }

        if (!addSportsmanAccount()){
            return;
        }

        firstName.clear();
        lastName.clear();
        emailAddress.clear();
        password.clear();

        loadNewPage("/login.fxml", e);
    }
}


