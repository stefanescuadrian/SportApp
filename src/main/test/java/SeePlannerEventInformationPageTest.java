import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.testfx.framework.junit.ApplicationTest;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
public class SeePlannerEventInformationPageTest extends ApplicationTest {

 private SeePlannerEventInformationPage I;

 private Eveniment E;
private static String name="flower";
private static String category="Rugby";
private static String dif="Advanced";
private static String loc="Timisoara";
private static String eventPlanner="You";
private static String eName="Cool";
private Label l;

    @BeforeClass
    public static void setupClass() throws Exception{

    }

    @Before
    public void setUp() throws Exception {
        I=new SeePlannerEventInformationPage();
       I.eventLocationLabel=new Label();
       I.eventDifficultyLabel=new Label();
       I.eventCategoryLabel=new Label();
       I.imageViewCat=new ImageView();
       I.imageView=new ImageView();
       I.eventDescriptionLabel=new Label();
       I.eventMaxParticipantsLabel=new Label();
       I.eventDateLabel=new Label();
       I.imageViewLocation=new ImageView();
       I.eventNameLabel=new Label();
       l=new Label();
       E=new Eveniment();


    }

@Test
public void testCheckCategoryJogging(){
    E.seteC("Jogging");
    I.check_category(E);
}

    @Test
    public void testCheckCategoryFootball(){
        E.seteC("Football");
        I.check_category(E);
    }
    @Test
    public void testCheckCategoryTennis(){
        E.seteC("Tennis");
        I.check_category(E);
    }
    @Test
    public void testCheckCategoryRugby(){
        E.seteC("Rugby");
        I.check_category(E);
    }

    @Test
    public void testCheckCategoryBasketball(){
        E.seteC("Basketball");
        I.check_category(E);
    }
@Test
public void testShowDetails(){
E.seteC(category);
E.seteN(name);
E.seteL(loc);
I.showDetails(E);
    }

    @Test
    public void testGetAndSetEventName(){
        l.setText("flower");
        I.setEventNameLabel(l);
        assertEquals(l.getText(),I.getEventNameLabel().getText());
    }

    @Test
    public void testGetAndSetEventMaxParticipantsLabel(){
        l.setText("3");
        I.setEventMaxParticipantsLabel(l);
        assertEquals(l.getText(),I.getEventMaxParticipantsLabel().getText());
    }

    @Test
    public void testGetAndSetEventDateLabel(){
        l.setText("2020-03-12");
        I.setEventDateLabel(l);
        assertEquals(l.getText(),I.getEventDateLabel().getText());
    }
    @Test
    public void testGetAndSetEventDifficultyLabel(){
        l.setText("Advanced");
        I.setEventDifficultyLabel(l);
        assertEquals(l.getText(),I.getEventDifficultyLabel().getText());
    }
    @Test
    public void testGetAndSetEventCategoryLabel(){
        l.setText("Advanced");
        I.setEventCategoryLabel(l);
        assertEquals(l.getText(),I.getEventCategoryLabel().getText());
    }
    @Test
    public void testGetAndSetEventLocationLabel(){
        l.setText("Tm");
        I.setEventLocationLabel(l);
        assertEquals(l.getText(),I.getEventLocationLabel().getText());
    }
    @Test
    public  void testGetAndSetEventDescriptionLabel(){
        l.setText("E fain");
        I.setEventDescriptionLabel(l);
        assertEquals(l.getText(),I.getEventDescriptionLabel().getText());
    }
    @Test
    public  void testGetAndSetEvent(){
        I.setEvent(E);
        assertEquals(E,I.getEvent());
    }
    @Test
    public void testConstructor(){
        SeePlannerEventInformationPage Is=new SeePlannerEventInformationPage(eName,eventPlanner);
        assertEquals("Cool",SeePlannerEventInformationPage.geteName());
        assertEquals("You",SeePlannerEventInformationPage.getEventPlannerMail());
    }

    @Test
    public void testGetAndSetEventPlannerMail(){
        SeePlannerEventInformationPage.seteName("Lia");
        SeePlannerEventInformationPage.setEventPlannerMail("Cool");
        assertEquals("Lia",SeePlannerEventInformationPage.geteName());
        assertEquals("Cool",SeePlannerEventInformationPage.getEventPlannerMail());
    }

}

