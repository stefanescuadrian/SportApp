import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.testfx.framework.junit.ApplicationTest;
import sun.rmi.runtime.Log;

import java.awt.event.ActionEvent;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class LoginTest extends ApplicationTest {
    private static final String emailSportsman = "q";
    private static final String passwordSportsman ="e";
    private static final String emailIncorrect = "nuexista";
    private static final String passwordIncorrect = "nuexista";
    private static final String emailEventplanner = "d";
    private static final String passwordEventplanner = "asd";


    private Login L;

    @BeforeClass
    public static void setupClass() throws Exception{

    }

    @Before
    public void setUp() throws Exception {
        L = new Login();
        L.usernameField = new TextField();
        L.passwordField = new PasswordField();
        L.usernameField.setText(emailSportsman);
        L.passwordField.setText(passwordSportsman);
    }

    @Test
    public void testLoginSportsman(){
        int i = L.login();
        assertTrue(i>=0);
    }

    @Test
    public void testCheckIfAllFieldsCompleted(){
        assertTrue(L.checkIfAllFieldsCompleted());
    }

    @Test
    public void testLoginWithIncorrectInput(){
        L.usernameField.setText(emailIncorrect);
        L.passwordField.setText(passwordIncorrect);
        int i = L.login();
        assertEquals(-1,i);
    }

    @Test
    public void testLoginWithIncorrectPassword(){
        L.usernameField.setText("d");
        L.passwordField.setText("as");
        assertEquals(-1, L.login());
    }

    @Test
    public void testLoginEventplanner(){
        L.usernameField.setText(emailEventplanner);
        L.passwordField.setText(passwordEventplanner);
        int i = L.login();
        assertTrue(i>=0);
    }

    @Test
    public void testLoginWrongPassword() {
        L.usernameField.setText(emailSportsman);
        L.passwordField = new PasswordField();
        int j = L.login();
        assertTrue(j == -1);
        assertEquals(false, L.checkIfAllFieldsCompleted());
    }

    @Test
    public void testCheckIfAllFieldsCompletedEmptyMail(){
        L.usernameField = new TextField();
        assertEquals(false, L.checkIfAllFieldsCompleted());
    }

    @Test
    public void testReturnCurrentEmail(){
        assertEquals(L.returnCurrentEmail(L.usernameField.getText()),L.usernameField.getText());

    }
}

