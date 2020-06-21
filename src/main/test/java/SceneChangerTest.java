import javafx.event.ActionEvent;
import org.junit.Before;
import org.junit.Test;
import org.testfx.framework.junit.ApplicationTest;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import java.io.IOException;

public class SceneChangerTest extends ApplicationTest {
    private static final int id = 10;
    private static final String commandName = "name";
    SceneChanger S;
    ActionEvent A;
    @Before
    public void setUp() {
        S = new SceneChanger();
    }

    @Test
    public void testChangeScenes() throws IOException {
        try {
            S.changeScenes(A, "/test.fxml");
        }
        catch (NullPointerException e)
        {
            System.out.println(e);
        }

    }
}
