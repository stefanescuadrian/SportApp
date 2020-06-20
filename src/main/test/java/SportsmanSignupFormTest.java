import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import org.assertj.core.util.introspection.FieldUtils;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.testfx.framework.junit.ApplicationTest;
import sun.reflect.misc.FieldUtil;

import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.nio.file.Files;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class SportsmanSignupFormTest extends ApplicationTest {
    private static final String email = "t";
    private static final String password = "o";
    private static final String firstName = "o";
    private static final String lastName = "o";
    private static ArrayList List = new ArrayList();
    private SportsmanSignupForm S;


    @BeforeClass
    public static void setupClass() throws Exception{

    }

    @Before
    public void setUp() throws Exception {
        XMLDE.XMLCreate("./SignupuriTest.xml");
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
        S.addSportsmanAccount("./SignupuriTest.xml");
        assertEquals(1 , S.getList().size());
    }

    @Test
    public void testCheckIfAllFieldsCompleted(){
        assertTrue(S.checkIfAllFieldsCompleted());
    }

    @Test
    public void testAddTwoTimesSportsmanAccount()throws NoSuchAlgorithmException{
          assertEquals(true, S.addSportsmanAccount("./SignupuriTest.xml"));
          assertEquals(false, S.addSportsmanAccount("./SignupuriTest.xml"));
    }
}
