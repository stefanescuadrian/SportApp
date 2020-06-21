import javafx.beans.property.SimpleStringProperty;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.testfx.framework.junit.ApplicationTest;
import sun.java2d.pipe.SpanShapeRenderer;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
public class SeeEventInformationPageTest extends ApplicationTest {
    private SeeEventInformationPage S;
    private Eveniment E;
    private static final SimpleStringProperty eventCategory = new SimpleStringProperty("Jogging");
    private String eventplanner="Ana";
    private String eventName="fain";
    @BeforeClass
    public static void setupClass() throws Exception{
    }
    @Before
    public void setUp() throws Exception {
        S = new SeeEventInformationPage();
        S.eventLocationLabel = new Label();
        S.imageViewLocation = new ImageView();
        S.imageView = new ImageView();
        S.eventDifficultyLabel = new Label();
        S.eventMaxParticipantsLabel = new Label();
        S.eventDateLabel = new Label();
        S.imageViewCat = new ImageView();
        S.eventCategoryLabel = new Label();
        S.eventDescriptionLabel = new Label();
        S.eventNameLabel = new Label();
        E = new Eveniment();
    }
    @Test
    public void testCheck_CategoryJogging(){
        E.seteC("Jogging");
        S.check_category(E);
    }
    @Test
    public void testCheck_CategoryBasketball(){
        E.seteC("Basketball");
        S.check_category(E);
    }
    @Test
    public void testCheck_CategoryTennis(){
        E.seteC("Tennis");
        S.check_category(E);
    }
    @Test
    public void testCheck_CategoryFootball(){
        E.seteC("Football");
        S.check_category(E);
    }
    @Test
    public void testCheck_CategoryRugby(){
        E.seteC("Rugby");
        S.check_category(E);
    }
    @Test
    public void testShowDetails(){
        E.seteN("NumeEveniment");
        E.seteC("Jogging");
        E.seteD("Descriere");
        E.seteDif("Advanced");
        E.seteL("Location");
        E.setMaxNumberParticipants(10);
        E.seteDate("12-04-2000");
        S.showDetails(E);
    }
    @Test
    public  void testGetAndSetEvent(){
        S.setEvent(E);
        assertEquals(E,S.getEvent());
    }
    @Test
    public void testConstructor(){
        SeeEventInformationPage Is=new SeeEventInformationPage(eventName,eventplanner);
        assertEquals("fain",SeeEventInformationPage.geteName());
        assertEquals("Ana",SeeEventInformationPage.getEventPlannerMail());
    }

    @Test
    public void testGetAndSetEventPlannerMail(){
       SeeEventInformationPage.seteName("Lia");
       SeeEventInformationPage.setEventPlannerMail("Cool");
        assertEquals("Lia",SeeEventInformationPage.geteName());
        assertEquals("Cool",SeeEventInformationPage.getEventPlannerMail());
    }
}