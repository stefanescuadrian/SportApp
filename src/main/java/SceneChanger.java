import com.sun.deploy.util.FXLoader;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class SceneChanger {
public void changeScenes(ActionEvent event, String viewName) throws IOException {
    FXMLLoader loader=new FXMLLoader();
    loader.setLocation(getClass().getResource(viewName));
    Parent parent=loader.load();
    Scene scene=new Scene(parent);
    Stage window=(Stage)((Node)event.getSource()).getScene().getWindow();
    window.setScene(scene);
    window.show();
}

}
