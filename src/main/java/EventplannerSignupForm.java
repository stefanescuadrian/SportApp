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
import java.time.LocalDate;
import java.util.ArrayList;


public class EventplannerSignupForm {

    private ArrayList<User> List = new ArrayList();
    @FXML
     TextField firstNameEP;
    @FXML
    TextField lastNameEP;
    @FXML
     TextField emailAddressEP;
    @FXML
     PasswordField passwordEP;
    @FXML
     TextField phoneNumberEP;
    @FXML
     DatePicker dateOfBirthEP;

private SceneChanger scene=new SceneChanger();
    @FXML
    private Label signupLabel;

    @FXML
    private Button goBackButton;

    @FXML
    private Button signupButtonForm;

    public ArrayList<User> getList() {
        return List;
    }

    public void setList(ArrayList<User> list) {
        List = list;
    }

    @FXML
    void changeScreenButtonPushed(ActionEvent event) throws IOException {
        scene.changeScenes(event,"/signup.fxml");
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

    public boolean addEventPlannerAccount(String filePath) throws NoSuchAlgorithmException {
        try {
            List = XMLDE.XMLDecoder(filePath);
        } catch (ArrayIndexOutOfBoundsException e){
            System.out.println(e);
        }
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
        XMLDE.XMLEncoder(filePath,List);
        return true;
    }

    public void saveEventPlannerData(ActionEvent e) throws IOException, NoSuchAlgorithmException {
        if (!checkIfAllFieldsCompleted()){
            return;
        }
        if (!addEventPlannerAccount("./Signupuri.xml")){
            return;
        }

        firstNameEP.clear();
        lastNameEP.clear();
        emailAddressEP.clear();
        passwordEP.clear();
        phoneNumberEP.clear();
        dateOfBirthEP.setValue(null);


       scene.changeScenes(e,"/login.fxml");

    }


}
