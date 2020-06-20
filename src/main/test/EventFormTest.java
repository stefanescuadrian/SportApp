import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.testfx.framework.junit.ApplicationTest;

import java.awt.*;
import java.time.LocalDate;
import java.util.Date;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class EventFormTest extends ApplicationTest {
    EventForm E;
    @BeforeClass
    public static void setupClass() {

    }

    @Before
    public void setUP() {
        E = new EventForm();
        E.eventCategory = new ChoiceBox();
        E.eventDifficulty = new ChoiceBox();
        E.eventLocation = new TextField();
        E.eventDescription = new TextArea();
        E.eventName = new TextField();
        E.eventMaxNumberParticipants = new TextField();
        //E.setEventCategory(E.eventCategory);
        //E.getEventCategory();
    }

    @Test
    public void testInitialize(){
        E.initialize();
        assertEquals("Category",E.eventCategory.getValue());
        assertEquals("Difficulty",E.eventDifficulty.getValue());
    }

    @Test
    public void testGettersAndSetters(){
        E.setEventCategory(new ChoiceBox());
        E.getEventCategory();
        E.setEventDifficulty(new ChoiceBox());
        E.getEventDifficulty();
        E.setEventDate(new DatePicker());
        E.getEventDate();
        TextField t = new TextField();
        t.setText("text");
        E.setEventLocation(t);
        assertEquals("text",E.getEventLocation().getText());
        TextArea t1 = new TextArea();
        t1.setText("TEXT");
        E.setEventDescription(t1);
        assertEquals("TEXT",E.getEventDescription().getText());
        TextField t2 = new TextField();
        t2.setText("NAME");
        E.setEventName(t2);
        assertEquals("NAME",E.getEventName().getText());
        TextField t3 = new TextField();
        t3.setText("10");
        E.setEventMaxNumberParticipants(t3);
        assertEquals("10",E.getEventMaxNumberParticipants().getText());
    }
}
