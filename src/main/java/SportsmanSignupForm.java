import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;


public class SportsmanSignupForm {


    public TextField firstName;
    public TextField lastName;
    public TextField emailAddress;
    public PasswordField password;

    @FXML
    private Label signupLabel;

    @FXML
    private Button signupButtonForm;
    @FXML
    private Button goBackButton;
    private Alert alert = new Alert(Alert.AlertType.INFORMATION);

    @FXML

    public void changeScreenButtonPushed(ActionEvent event) throws IOException {
        Parent signupView= FXMLLoader.load(getClass().getResource("/signup.fxml"));
        Scene signupScene=new Scene(signupView);
        Stage window=(Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(signupScene);
        window.show();
    }

    public void saveSportsmanData(ActionEvent e) throws IOException {

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

        alert.setTitle("Registration Successfull");
        alert.setHeaderText(null);
        alert.setContentText("Welcome " + firstName.getText() + " " + lastName.getText() + "!");
        alert.showAndWait();


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

