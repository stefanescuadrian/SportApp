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
    //private static Alert alert = new Alert(Alert.AlertType.INFORMATION);

    private ArrayList<User> List = new ArrayList();
    @FXML
    TextField firstName;
    @FXML
    TextField lastName;
    @FXML
    TextField emailAddress;
    @FXML
    PasswordField password;


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

    public void alertSet(String Title, String ContentText){
        //alert.setTitle(Title);
       // alert.setHeaderText(null);
        //alert.setContentText(ContentText);
        //alert.showAndWait();
    }

    public boolean checkIfAllFieldsCompleted(){
        if (firstName.getText().isEmpty()) {
           // alertSet("Warning","Please enter your first name!");
            return false;
        }
        if (lastName.getText().isEmpty()) {
          //  alertSet("Warning","Please enter your last name!");
            return false;
        }
        if (emailAddress.getText().isEmpty()) {
          //  alertSet("Warning","Please enter your email!");
            return false;
        }

        if (password.getText().isEmpty()) {
          //  alertSet("Warning","Please enter a password!");
            return false;
        }
        return true;
    }

    public boolean addSportsmanAccount() throws NoSuchAlgorithmException {
        //Decodificare xml file
        try{
            FileInputStream fis = new FileInputStream("./Signupuri.xml");
            XMLDecoder decoder = new XMLDecoder(fis);
            ArrayList A = new ArrayList();
            A = (ArrayList) decoder.readObject();
            List =A;
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        }

        //ACCOUNT ALREADY EXISTS CHECK
        for(int i = 0; i< List.size(); i++){
            if(List.get(i) instanceof Sportsman){
                if (List.get(i).getEmail().equals(this.emailAddress.getText())){
                 //alertSet("Warning","Account already exists! Please enter another email address!");
                    emailAddress.clear();
                    return false;
                }
            }
            if(List.get(i) instanceof Eventplanner){
                if (List.get(i).getEmail().equals(this.emailAddress.getText())){
                 //alertSet("Warning","Account already exists! Please enter another email address!");
                    emailAddress.clear();
                    return false;
                }
            }
        }

        //alertSet("Registration Successfull!","Welcome " + firstName.getText() + " " + lastName.getText() + "!");

        byte[] salt = CodificareParola.getSalt();
        String T = CodificareParola.getSHA512Password(password.getText(),salt);

        //Codificare xml file
        try{
            Sportsman S = new Sportsman(firstName.getText(), lastName.getText(), emailAddress.getText(), T, salt);
            List.add(S);
            FileOutputStream fos = new FileOutputStream("./Signupuri.xml");
            XMLEncoder encoder = new XMLEncoder(fos);
            encoder.writeObject(List);
            encoder.close();
            fos.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
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


