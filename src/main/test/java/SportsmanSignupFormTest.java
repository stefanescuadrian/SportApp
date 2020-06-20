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
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import static org.junit.Assert.assertEquals;

public class SportsmanSignupFormTest extends ApplicationTest {
    private static final String email = "ow";
    private static final String password = "o";
    private static final String firstName = "o";
    private static final String lastName = "o";
    private SportsmanSignupForm S;
    private ArrayList List = new ArrayList();


    public void decodificareSignupuriXML(){
        try{
            FileInputStream fis = new FileInputStream("./Signupuri.xml");
            XMLDecoder decoder = new XMLDecoder(fis);
            ArrayList A;
            A = (ArrayList) decoder.readObject();
            List =A;
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        }
    }

    @BeforeClass
    public static void setupClass() throws Exception{

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
    public void testaddSportsmanAccount() throws NoSuchAlgorithmException {

        decodificareSignupuriXML();
        int nrSignupuriInitiale = List.size();
        S.addSportsmanAccount();
        decodificareSignupuriXML();
        int nrSignupuriDupaAdaugare = List.size();

        assertEquals(1,nrSignupuriDupaAdaugare-nrSignupuriInitiale);

    }

}
