import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import org.junit.Before;
import org.junit.Test;

import java.awt.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class EventplannerMyEventsPageTest {
    private EventplannerMyEventsPage E;

    @Before
    public void setUp(){
        E = new EventplannerMyEventsPage();
        E.firstColumn = new TableColumn<>();
        E.secondColumn = new TableColumn<>();
        E.thirdColumn = new TableColumn<>();
    }

    @Test
    public void testConstructor(){
        E = new EventplannerMyEventsPage("name");
        assertEquals("name",EventplannerMyEventsPage.getEventPlannerName());
    }

    @Test
    public void testSetter(){
        EventplannerMyEventsPage.setEventPlannerName("name");
        assertEquals("name",EventplannerMyEventsPage.getEventPlannerName());
    }




}
