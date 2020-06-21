import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.testfx.framework.junit.ApplicationTest;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class EditEventsTest extends ApplicationTest {
    private EditEvents E;
    private TextField t;
    private TextArea a;
    private Eveniment event;
    private static String mail="fain";
    private static String nume="Cool";

    private static String name="flower";
    private static String category="Rugby";
    private static String dif="Advanced";
    private static String loc="Timisoara";
    private static String eventPlanner="You";
    private static String eName="Cool";
    @BeforeClass
    public static void setupClass() throws Exception{ }

    @Before
    public void setUp(){
        event=new Eveniment();
        E=new EditEvents();
        t=new TextField();
        a=new TextArea();
        E.eventCategory=new ChoiceBox();
        E.eventDifficulty=new ChoiceBox();
        E.eventLocation=new TextField();
        E.eventDescription=new TextArea();
        E.eventName=new TextField();
        E.eventDate=new TextField();
        E.eventMaxNumberParticipants=new TextField();



    }
 @Test
    public void testDoubleParamConstructor(){
        EditEvents ed=new EditEvents(nume,mail);
        assertEquals("Cool",EditEvents.geteName());
        assertEquals("fain",EditEvents.getEventPlannerMail());
    }

    @Test
    public void testSingleParamConstructor(){
        EditEvents ed=new EditEvents(mail);

        assertEquals("fain",EditEvents.getEventPlannerMail());
    }
    @Test
    public void testGetAndSetEventCategory(){
        E.eventCategory.setValue("Jogging");
        E.setEventCategory(E.eventCategory);
        assertEquals("Jogging",E.getEventCategory().getValue().toString());
    }
    @Test
    public void testGetAndSetEventDifficulty(){
        E.eventDifficulty.setValue("Advanced");
        E.setEventDifficulty(E.eventDifficulty);
        assertEquals("Advanced",E.getEventDifficulty().getValue().toString());
    }
    @Test
    public void testGetAndSetEventLocation(){
        t.setText("Timisoara");
        E.setEventLocation(t);
        assertEquals(t.toString(),E.getEventLocation().toString());
    }
    @Test
    public void testGetAndSetEventDescription(){
       a.setText("Descriere");
        E.setEventDescription(a);
        assertEquals(a.toString(),E.getEventDescription().toString());
    }
    @Test
    public void testGetAndSetEventMaxNumberParticipants(){
        t.setText("12");
        E.setEventMaxNumberParticipants(t);
        assertEquals(t.toString(),E.getEventMaxNumberParticipants().toString());
    }
    @Test
    public void testGetAndSetEventDate(){
        t.setText("2020-12-04");
        E.setEventDate(t);
        assertEquals(t.toString(),E.getEventDate().toString());
    }

    @Test
    public void testGetAndSetEventName(){
        t.setText("Cool");
        E.setEventName(t);
        assertEquals(t.toString(),E.getEventName().toString());
    }
    @Test
    public void testGetAndSetNameAndMail(){
    EditEvents.seteName(nume);
    EditEvents.setEventPlannerMail(mail);
    assertEquals("fain",EditEvents.getEventPlannerMail());
    assertEquals("Cool",EditEvents.geteName());
    }
    @Test
    public void testGetAndSetEvent(){
        E.setEvent(event);
        assertEquals(event,E.getEvent());
    }

    @Test
    public void testShowDetails(){
      event.seteN(name);
        event.seteC(category);
        event.seteL(loc);
        E.showDetails(event);
    }


}

