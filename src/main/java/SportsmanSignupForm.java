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


public class SportsmanSignupForm {

    private ArrayList List = new ArrayList();
    @FXML
    private TextField firstName;
    @FXML
    private TextField lastName;
    @FXML
    private TextField emailAddress;
    @FXML
    private PasswordField password;


    @FXML
    private Label signupLabel;

    @FXML
    private Button signupButtonForm;
    @FXML
    private Button goBackButton;
    private Alert alert = new Alert(Alert.AlertType.INFORMATION);

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

    public void saveSportsmanData(ActionEvent e) throws IOException, NoSuchAlgorithmException {

        if (firstName.getText().isEmpty()) {
            alert.setTitle("ERROR");
            alert.setHeaderText(null);
            alert.setContentText("Please enter your first name!");
            alert.showAndWait();
            return;
        }
        if (lastName.getText().isEmpty()) {
            alert.setTitle("ERROR");
            alert.setHeaderText(null);
            alert.setContentText("Please enter your last name!");

            alert.showAndWait();
            return;
        }
        if (emailAddress.getText().isEmpty()) {
            alert.setTitle("ERROR");
            alert.setHeaderText(null);
            alert.setContentText("Please enter your email!");

            alert.showAndWait();
            return;
        }

        if (password.getText().isEmpty()) {
            alert.setTitle("ERROR");
            alert.setHeaderText(null);
            alert.setContentText("Please enter a password!");
            alert.showAndWait();
            return;
        }


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
                if ( ((Sportsman) List.get(i)).getEmail().equals(this.emailAddress.getText())){
                    alert.setTitle("ERROR");
                    alert.setHeaderText(null);
                    alert.setContentText("Account already exists! Please enter another email address!");
                    alert.showAndWait();
                    emailAddress.clear();
                    return;
                }
            }
            if(List.get(i) instanceof Eventplanner){
                if ( ((Eventplanner) List.get(i)).getEmail().equals(this.emailAddress.getText())){
                    alert.setTitle("ERROR");
                    alert.setHeaderText(null);
                    alert.setContentText("Account already exists! Please enter another email address!");
                    alert.showAndWait();
                    emailAddress.clear();
                    return;
                }
            }
        }

        alert.setTitle("Registration Successfull!");
        alert.setHeaderText(null);
        alert.setContentText("Welcome " + firstName.getText() + " " + lastName.getText() + "!");
        alert.showAndWait();
        byte[] salt = CodificareParola.getSalt();
        String T = CodificareParola.getSHA512Password(password.getText(),salt);
        //Codificare xml file
        try{
            Sportsman S = new Sportsman(firstName.getText(), lastName.getText(), emailAddress.getText(), T,salt);
            List.add(S);
            FileOutputStream fos = new FileOutputStream("./Signupuri.xml");
            XMLEncoder encoder = new XMLEncoder(fos);
            encoder.writeObject(List);
            encoder.close();
            fos.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }


        try (BufferedWriter bw = new BufferedWriter(new FileWriter("Sportsman_signupuriInfo.txt", true))) {
            bw.write("Role: Sportsman ");
            bw.newLine();
            bw.write("First Name: " + firstName.getText() + " ");
            bw.newLine();
            bw.write("Last Name: " + lastName.getText() + " ");
            bw.newLine();
            bw.write("Email: " + emailAddress.getText() + " ");
            bw.newLine();
            bw.write("Password: " + password.getText());
            bw.newLine();
            bw.newLine();
        } catch (IOException e1) {
            e1.printStackTrace();
        }

        try (BufferedWriter bw2 = new BufferedWriter(new FileWriter("Sportsman_firstName.txt", true))) {
            bw2.write(firstName.getText());
            bw2.newLine();
        } catch (IOException e1) {
            e1.printStackTrace();
        }

        try (BufferedWriter bw2 = new BufferedWriter(new FileWriter("Sportsman_lastName.txt", true))) {
            bw2.write(lastName.getText());
            bw2.newLine();
        } catch (IOException e1) {
            e1.printStackTrace();
        }

        try (BufferedWriter bw2 = new BufferedWriter(new FileWriter("Sportsman_email.txt", true))) {
            bw2.write(emailAddress.getText());
            bw2.newLine();
        } catch (IOException e1) {
            e1.printStackTrace();
        }

        try (BufferedWriter bw2 = new BufferedWriter(new FileWriter("Sportsman_passwords.txt", true))) {
            bw2.write(password.getText());
            bw2.newLine();
        } catch (IOException e1) {
            e1.printStackTrace();
        }

        firstName.clear();
        lastName.clear();
        emailAddress.clear();
        password.clear();

        Parent signupView= FXMLLoader.load(getClass().getResource("/login.fxml"));
        Scene signupScene=new Scene(signupView);
        Stage window=(Stage)((Node)e.getSource()).getScene().getWindow();
        window.setScene(signupScene);
        window.show();
    }
}


