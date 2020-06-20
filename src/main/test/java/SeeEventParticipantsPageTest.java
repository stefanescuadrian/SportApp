import javafx.event.EventHandler;
import javafx.event.EventType;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.input.MouseButton;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.testfx.framework.junit.ApplicationTest;
import org.testfx.robot.ClickRobot;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.io.IOException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class SeeEventParticipantsPageTest extends ApplicationTest {
    private SeeEventParticipantsPage S;

    @Before
    public void setUp() throws Exception {
        S = new SeeEventParticipantsPage();
        S.pendingTable = new TableView<>();
        S.acceptedTable = new TableView<>();
        S.declinedTable = new TableView<>();
        S.backButton = new Button();
        S.declinedColumn = new TableColumn<>();
        S.pendingColumn = new TableColumn<>();
        S.acceptedColumn = new TableColumn<>();
        S.acceptButton = new Button();
    }
    @Test
    public void acceptParticipantTest() throws IOException {
        S.acceptParticipant();
    }

    @Test
    public void declineParticipantTest(){
        S.declineParticipant();
    }

    @Test
    public void constructor(){
        S = new SeeEventParticipantsPage("mail","nume","10");
        assertEquals(S.getEventPlannerMail(),"mail");
        assertEquals(S.geteName(),"nume");
        assertEquals(S.getEventMaxParticipants(),10);

    }

    @Test
    public void testSetters(){
        S.seteName("nume");
        S.setEventMaxParticipants(10);
        S.setEventPlannerMail("mail");
        assertEquals("nume",S.geteName());
        assertEquals("mail",S.getEventPlannerMail());
        assertEquals(10,S.getEventMaxParticipants());
    }




}
