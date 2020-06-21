import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import org.junit.Before;
import org.junit.Test;
import org.testfx.framework.junit.ApplicationTest;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
public class EventplannerHomePageTest extends ApplicationTest {
    EventplannerHomePage E;
    @Before
    public void setUp(){
        E = new EventplannerHomePage();
        E.myEventsButton = new Button();
        E.addEventsButton = new Button();
        E.table = new TableView<>();
        E.firstColumn = new TableColumn<>();
        E.secondColumn = new TableColumn<>();
        E.thirdColumn = new TableColumn<>();
    }

    @Test
    public void testGetterAndSetterAndConstructor(){
        EventplannerHomePage.setEventPlannerName("name");
        assertEquals("name",EventplannerHomePage.getEventPlannerName());
        E = new EventplannerHomePage("name1");
        assertEquals("name1",EventplannerHomePage.getEventPlannerName());
    }
}
