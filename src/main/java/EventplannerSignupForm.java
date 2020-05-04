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
import java.util.ArrayList;


public class EventplannerSignupForm {
    private Alert alert = new Alert(Alert.AlertType.INFORMATION);
    private ArrayList List = new ArrayList();
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
    public void saveEventPlannerData(ActionEvent e) throws IOException {

        if (firstNameEP.getText().isEmpty()) {
            alert.setTitle("ERROR");
            alert.setHeaderText(null);
            alert.setContentText("Please enter your first name!");
            alert.showAndWait();
            return;
        }
        if (lastNameEP.getText().isEmpty()) {
            alert.setTitle("ERROR");
            alert.setHeaderText(null);
            alert.setContentText("Please enter your last name!");

            alert.showAndWait();
            return;
        }
        if (emailAddressEP.getText().isEmpty()) {
            alert.setTitle("ERROR");
            alert.setHeaderText(null);
            alert.setContentText("Please enter your email!");

            alert.showAndWait();
            return;
        }
        if (passwordEP.getText().isEmpty()) {
            alert.setTitle("ERROR");
            alert.setHeaderText(null);
            alert.setContentText("Please enter a password!");
            alert.showAndWait();
            return;
        }
        if (phoneNumberEP.getText().isEmpty()) {
            alert.setTitle("ERROR");
            alert.setHeaderText(null);
            alert.setContentText("Please enter your phone number!");
            alert.showAndWait();
            return;
        }

        if (dateOfBirthEP.getValue()==null){
            alert.setTitle("ERROR");
            alert.setHeaderText(null);
            alert.setContentText("Please select your birthdate!");
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
                if ( ((Sportsman) List.get(i)).getEmail().equals(this.emailAddressEP.getText())){
                    alert.setTitle("ERROR");
                    alert.setHeaderText(null);
                    alert.setContentText("Account already exists! Please enter another email address!");
                    alert.showAndWait();
                    emailAddressEP.clear();
                    return;
                }
            }
            if(List.get(i) instanceof Eventplanner){
                if ( ((Eventplanner) List.get(i)).getEmail().equals(this.emailAddressEP.getText())){
                    alert.setTitle("ERROR");
                    alert.setHeaderText(null);
                    alert.setContentText("Account already exists! Please enter another email address!");
                    alert.showAndWait();
                    emailAddressEP.clear();
                    return;
                }
            }

        }

        alert.setTitle("Registration Successfull");
        alert.setHeaderText(null);
        alert.setContentText("Welcome " + firstNameEP.getText() + " " + lastNameEP.getText() + "!");
        alert.showAndWait();


        //Codificare xml file
        try{
            Eventplanner S = new Eventplanner(firstNameEP.getText(), lastNameEP.getText(), emailAddressEP.getText(), passwordEP.getText(),phoneNumberEP.getText(),dateOfBirthEP.getValue().toString());
            List.add(S);
            FileOutputStream fos = new FileOutputStream("./Signupuri.xml");
            XMLEncoder encoder = new XMLEncoder(fos);
            encoder.writeObject(List);
            encoder.close();
            fos.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        try (BufferedWriter bw = new BufferedWriter(new FileWriter("EventPlanner_signupuriInfo.txt", true))) {
            bw.write("Role: Sportsman ");
            bw.newLine();
            bw.write("First Name: " + firstNameEP.getText() + " ");
            bw.newLine();
            bw.write("Last Name: " + lastNameEP.getText() + " ");
            bw.newLine();
            bw.write("Email: " + emailAddressEP.getText() + " ");
            bw.newLine();
            bw.write("Password: " + passwordEP.getText());
            bw.newLine();
            bw.write("Phone Number: " + phoneNumberEP.getText());
            bw.newLine();
            bw.write("BirthDate: " + dateOfBirthEP.getValue().toString());
            bw.newLine();
            bw.newLine();
        } catch (IOException e1) {
            e1.printStackTrace();
        }

        try (BufferedWriter bw2 = new BufferedWriter(new FileWriter("EventPlanner_firstName.txt", true))) {
            bw2.write(firstNameEP.getText());
            bw2.newLine();
        } catch (IOException e1) {
            e1.printStackTrace();
        }

        try (BufferedWriter bw2 = new BufferedWriter(new FileWriter("EventPlanner_lastName.txt", true))) {
            bw2.write(lastNameEP.getText());
            bw2.newLine();
        } catch (IOException e1) {
            e1.printStackTrace();
        }

        try (BufferedWriter bw2 = new BufferedWriter(new FileWriter("EventPlanner_email.txt", true))) {
            bw2.write(emailAddressEP.getText());
            bw2.newLine();
        } catch (IOException e1) {
            e1.printStackTrace();
        }

        try (BufferedWriter bw2 = new BufferedWriter(new FileWriter("EventPlanner_passwords.txt", true))) {
            bw2.write(passwordEP.getText());
            bw2.newLine();
        } catch (IOException e1) {
            e1.printStackTrace();
        }

        try (BufferedWriter bw2 = new BufferedWriter(new FileWriter("EventPlanner_phoneNumbers.txt", true))) {
            bw2.write(phoneNumberEP.getText());
            bw2.newLine();
        } catch (IOException e1) {
            e1.printStackTrace();
        }

        try (BufferedWriter bw2 = new BufferedWriter(new FileWriter("EventPlanner_birthDates.txt", true))) {
            bw2.write(dateOfBirthEP.getValue().toString());
            bw2.newLine();
        } catch (IOException e1) {
            e1.printStackTrace();
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
