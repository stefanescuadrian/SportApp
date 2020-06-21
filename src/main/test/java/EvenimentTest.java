import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.testfx.framework.junit.ApplicationTest;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class EvenimentTest extends ApplicationTest {
    private Eveniment E;
    private String nume ="You";
    private  String mail ="A";
    private String categorie="Basketball";
    private String loc="Tm";
    private String des="addda";
    private String diff="Advanced";
    private int part=2;
    private String data="2020-12-12";
    @BeforeClass
    public static void setupClass() throws Exception{ }

    @Before
    public void setUp(){

    }

    @Test
    public void testConstructor(){
        Eveniment e=new Eveniment(mail,categorie,diff,nume,loc,part,data,des);
        assertEquals(mail,e.getEventPlannerMail());
        assertEquals(categorie,e.getEventCategory());
        assertEquals(diff,e.getEventDifficulty());
        assertEquals(nume,e.getEventName());
        assertEquals(loc,e.getEventLocation());
        assertEquals(part,e.getEventMaxNumberParticipants());
        assertEquals(data,e.getEventDate());
        assertEquals(des,e.getEventDescription());
    }
}
