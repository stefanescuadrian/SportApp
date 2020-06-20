import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.testfx.framework.junit.ApplicationTest;
import sun.reflect.misc.FieldUtil;

import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import static org.junit.Assert.assertEquals;

public class SportsmanSignupFormTest extends ApplicationTest {
    private static final String email = "owqq";
    private static final String password = "o";
    private static final String firstName = "o";
    private static final String lastName = "o";
    private static ArrayList List = new ArrayList();
    private SportsmanSignupForm S;
    //private Alert alert = new Alert(Alert.AlertType.INFORMATION);


    @BeforeClass
    public static void setupClass() throws Exception{
       List =  XMLDE.XMLDecoder("./Signupuri.xml");
       XMLDE.XMLEncoder("./SignupuriTest",List);
    }

    @Before
    public void setUp() throws Exception {

        S = new SportsmanSignupForm();
        S.emailAddress = new TextField();
        S.lastName = new TextField();
        S.firstName = new TextField();
        S.password = new PasswordField();

        S.emailAddress.setText(email);
        S.lastName.setText(lastName);
        S.firstName.setText(firstName);
        S.password.setText(password);
    }

    @Test
    public void testAddSportsmanAccount() throws NoSuchAlgorithmException {
        int i = List.size();
        S.addSportsmanAccount();
        List.add(S);
        assertEquals(1 , List.size()- i);

    }


}
