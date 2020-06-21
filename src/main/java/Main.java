import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {



    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent fxml= FXMLLoader.load(getClass().getResource("/login.fxml"));
        Scene scene=new Scene(fxml);
        scene.getStylesheets().add(getClass().getResource("/login.css").toExternalForm());
        //primaryStage.getScene()=scene;
        primaryStage.setScene(scene);
        primaryStage.show();

    }

    public static void main(String[] args) {
        launch(args);
    }
}