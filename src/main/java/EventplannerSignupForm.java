import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.*;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;


public class EventplannerSignupForm {
    private Alert alert = new Alert(Alert.AlertType.INFORMATION);
    private ArrayList<User> List = new ArrayList();
    @FXML
    private TextField firstNameEP;
    @FXML
    private TextField lastNameEP;
    @FXML
    private TextField emailAddressEP;
    @FXML
    private PasswordField passwordEP;
    @FXML
    private TextField phoneNumberEP;
    @FXML
    private DatePicker dateOfBirthEP;


    @FXML
    private Label signupLabel;

    @FXML
    private Button goBackButton;

    @FXML
    private Button signupButtonForm;


    @FXML
    void changeScreenButtonPushed(ActionEvent event) throws IOException {
        Parent signupView= FXMLLoader.load(getClass().getResource("/signup.fxml"));
        Scene signupScene=new Scene(signupView);
        Stage window=(Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(signupScene);
        window.show();
    }

    public boolean checkIfAllFieldsCompleted(){

        if (firstNameEP.getText().isEmpty()) {
            return false;
        }
        if (lastNameEP.getText().isEmpty()) {
            return false;
        }
        if (emailAddressEP.getText().isEmpty()) {
            return false;
        }
        if (passwordEP.getText().isEmpty()) {
            return false;
        }
        if (phoneNumberEP.getText().isEmpty()) {
            return false;
        }
        if (dateOfBirthEP.getValue()==null){
            return false;
        }
        return true;
    }

    public boolean addEventPlannerAccount() throws NoSuchAlgorithmException {
        List = XMLDE.XMLDecoder("./Signupuri.xml");
        //ACCOUNT ALREADY EXISTS CHECK
        for(int i = 0; i< List.size(); i++){
            if(List.get(i) instanceof Sportsman){
                if ( List.get(i).getEmail().equals(this.emailAddressEP.getText())){
                    emailAddressEP.clear();
                    emailAddressEP.setPromptText("Please enter another email !");
                    emailAddressEP.setStyle("-fx-prompt-text-fill:red;");
                    return false;
                }
            }
            if(List.get(i) instanceof Eventplanner){
                if ( List.get(i).getEmail().equals(this.emailAddressEP.getText())){
                    emailAddressEP.clear();
                    emailAddressEP.setPromptText("Please enter another email !");
                    emailAddressEP.setStyle("-fx-prompt-text-fill:red;");
                    return false;
                }
            }

        }

        byte[] salt = CodificareParola.getSalt();
        String T = CodificareParola.getSHA512Password(passwordEP.getText(),salt);

        Eventplanner S = new Eventplanner(firstNameEP.getText(), lastNameEP.getText(), emailAddressEP.getText(), T,phoneNumberEP.getText(),dateOfBirthEP.getValue().toString(),salt);
        List.add(S);
        XMLDE.XMLEncoder("./Signupuri.xml",List);
        return true;
    }

    public void saveEventPlannerData(ActionEvent e) throws IOException, NoSuchAlgorithmException {
        if (!checkIfAllFieldsCompleted()){
            return;
        }
        if (!addEventPlannerAccount()){
            return;
        }

        firstNameEP.clear();
        lastNameEP.clear();
        emailAddressEP.clear();
        passwordEP.clear();
        phoneNumberEP.clear();
        dateOfBirthEP.setValue(null);

        Parent signupView= FXMLLoader.load(getClass().getResource("/login.fxml"));
        Scene signupScene=new Scene(signupView);
        Stage window=(Stage)((Node)e.getSource()).getScene().getWindow();
        window.setScene(signupScene);
        window.show();

    }


}
