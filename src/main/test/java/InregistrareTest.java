import javafx.scene.control.Label;
import org.junit.Before;
import org.junit.Test;
import org.testfx.framework.junit.ApplicationTest;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import javax.swing.text.html.ImageView;

public class InregistrareTest extends ApplicationTest {
    private Inregistrare I;
    private Eveniment E;
    private Label l;

    @Before
    public void setUp(){
        l= new Label();
    I = new Inregistrare();
    E = new Eveniment();
    E.seteDate("data");
    E.seteD("eD");
    E.setMaxNumberParticipants(10);
    E.seteL("eL");
    E.seteC("eC");
    E.setEventCategory("Basketball");
    E.setEventLocation("location");
    E.seteDif("difficulty");
    E.setEventDate("data");
    E.setEventDescription("descriprion");
    E.setEventDifficulty("difficulty");
    E.setEventMaxNumberParticipants(15);
    E.setEventName("name");
    l.setText("Pending");
    E.setStatus(l);
    I.seteC("eC");
    I.seteD("eD");
    I.setSportsmanFirstName("firstname");
    I.setSportsmanLastName("lastname");
    I.setSportsmanEmail("email");
    I.setSportsmanFNLN("string");

    }

    @Test
    public void testConstructorBasketballCategory(){
        E.setEventCategory("Basketball");
        I = new Inregistrare(E,"firstnameSportsman","lastnameSportsman","emailSportsman","Pending");
    }
    @Test
    public void testConstructorRugbyCategory() {
        E.setEventCategory("Rugby");
        I = new Inregistrare(E,"firstnameSportsman","lastnameSportsman","emailSportsman","Pending");
    }

    @Test
    public void testConstructorJoggingCategory() {
        E.setEventCategory("Jogging");
        I = new Inregistrare(E,"firstnameSportsman","lastnameSportsman","emailSportsman","Pending");
    }

    @Test
    public void testConstructorTennisCategory() {
        E.setEventCategory("Tennis");
        I = new Inregistrare(E,"firstnameSportsman","lastnameSportsman","emailSportsman","Pending");
    }

    @Test
    public void testConstructorFootballCategory() {
        E.setEventCategory("Football");
        I = new Inregistrare(E,"firstnameSportsman","lastnameSportsman","emailSportsman","Pending");
    }

    @Test
    public void testConstructor(){
        I = new Inregistrare("firstname","lastname");
        assertEquals("firstnamelastname",I.getSportsmanFNLN().toString());
    }

    @Test
    public void testGetterAndSetter(){
        assertEquals("eC", I.geteC());
        assertEquals("eD", I.geteD());
        assertEquals("firstname",I.getSportsmanFirstName());
        assertEquals("lastname",I.getSportsmanLastName());
        assertEquals("email", I.getSportsmanEmail());
        assertEquals("string", I.getSportsmanFNLN());
    }


}
