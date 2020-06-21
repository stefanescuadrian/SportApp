import javafx.scene.control.CheckBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TitledPane;
import javafx.scene.layout.Pane;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.testfx.framework.junit.ApplicationTest;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
public class SportsmanMyEventsPageTest extends ApplicationTest
{
    private SportsmanMyEventsPage S;
    private static String mail="Wow";
    private  static String firstName= "Ana";
    private  static String lastName= "You";
    @BeforeClass
    public static void setupClass() throws Exception{ }

    @Before
    public void setUp(){
        S=new SportsmanMyEventsPage();
        S.basketFilter=new CheckBox();
        S.footballFilter=new CheckBox();
        S.joggingFilter=new CheckBox();
        S.tennisFilter=new CheckBox();
        S.rugbyFilter=new CheckBox();
        S.filters=new TitledPane();
        S.checkPane=new Pane();
        S.firstColumn=new TableColumn<>();
        S.secondColumn=new TableColumn<>();
        S.thirdColumn=new TableColumn<>();
        S.table=new TableView<>();
        S.fourthColumn=new TableColumn<>();


    }
    @Test
    public void testConstructor(){
        SportsmanMyEventsPage se=new SportsmanMyEventsPage(mail);
        assertEquals("Wow",SportsmanMyEventsPage.getSportsmanEmail());
    }
    @Test
    public void testGetAndSetSportsmanFirstLastName(){
        SportsmanMyEventsPage se=new SportsmanMyEventsPage();
        SportsmanMyEventsPage.setSportsmanFirstName(firstName);
       SportsmanMyEventsPage.setSportsmanLastName(lastName);
       SportsmanMyEventsPage.setSportsmanEmail(mail);
        assertEquals("Ana",SportsmanMyEventsPage.getSportsmanFirstName());
        assertEquals("You",SportsmanMyEventsPage.getSportsmanLastName());
        assertEquals("Wow",SportsmanMyEventsPage.getSportsmanEmail());
    }
    @Test
public void testActionBasket(){
    S.basketFilter.setSelected(true);
    assertTrue(S.basketFilter.isSelected());
    S.actionBasket();
    S.basketFilter.setSelected(false);
    assertFalse(S.basketFilter.isSelected());
    S.actionBasket();
}
    @Test
    public void testActionJogging(){
        S.joggingFilter.setSelected(true);
        assertTrue(S.joggingFilter.isSelected());
        S.actionJogging();
        S.joggingFilter.setSelected(false);
        assertFalse(S.joggingFilter.isSelected());
        S.actionJogging();
    }
    @Test
    public void testActionTennis(){
        S.tennisFilter.setSelected(true);
        assertTrue(S.tennisFilter.isSelected());
        S.actionTennis();
        S.tennisFilter.setSelected(false);
        assertFalse(S.tennisFilter.isSelected());
        S.actionTennis();
    }
    @Test
    public void testActionRugby(){
        S.rugbyFilter.setSelected(true);
        assertTrue(S.rugbyFilter.isSelected());
        S.actionRugby();
        S.rugbyFilter.setSelected(false);
        assertFalse(S.rugbyFilter.isSelected());
        S.actionRugby();
    }

    @Test
    public void testActionFootball(){
        S.footballFilter.setSelected(true);
        assertTrue(S.footballFilter.isSelected());
        S.actionFootball();
        S.footballFilter.setSelected(false);
        assertFalse(S.footballFilter.isSelected());
        S.actionFootball();
    }

}
