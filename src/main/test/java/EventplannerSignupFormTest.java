import javafx.scene.control.DatePicker;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.testfx.framework.junit.ApplicationTest;

import java.security.NoSuchAlgorithmException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import javafx.scene.control.DatePicker;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class EventplannerSignupFormTest extends ApplicationTest {
    private static final String email = "owqq";
    private static final String password = "o";
    private static final String firstName = "o";
    private static final String lastName = "o";
    private static final String phoneNumber="123";
    // private static  DatePicker d = null;


    private EventplannerSignupForm E;

    @BeforeClass
    public static void setupClass() throws Exception{


    }

    @Before
    public void setUp() throws Exception {
        XMLDE.XMLCreate("./SignupuriTest.xml");
        E = new EventplannerSignupForm();
        E.emailAddressEP = new TextField();
        E.lastNameEP = new TextField();
        E.firstNameEP = new TextField();
        E.passwordEP = new PasswordField();
        E.phoneNumberEP=new TextField();
        E.dateOfBirthEP=new DatePicker();
        E.emailAddressEP.setText(email);
        E.lastNameEP.setText(lastName);
        E.firstNameEP.setText(firstName);
        E.passwordEP.setText(password);
        E.phoneNumberEP.setText(phoneNumber);
        E.dateOfBirthEP.setValue(LocalDate.now());

    }

    @Test
    public void testAddEventplannerAccount() throws NoSuchAlgorithmException {

        E.addEventPlannerAccount("./SignupuriTest.xml");
        assertEquals(1 , E.getList().size());

    }
    @Test
    public void testCheckIfAllFieldsCompleted() throws NoSuchAlgorithmException {

        assertTrue(E.checkIfAllFieldsCompleted());
    }

    @Test
    public void testAddTwoEventplannerAccout() throws NoSuchAlgorithmException {
        assertEquals(true,E.addEventPlannerAccount("./SignupuriTest.xml"));
        assertEquals(false,E.addEventPlannerAccount("./SignupuriTest.xml"));
    }


}
