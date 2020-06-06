
import javafx.application.Application;
import javafx.stage.Stage;

public class HelloFX extends Application {

    static ScenesManager scenesManager;
    @Override
    public void start(Stage primaryStage) throws Exception{
        scenesManager = ScenesManager.getInstance(primaryStage);
        //Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("LogginScreen.fxml"));
        primaryStage.setTitle("Recipies");
        scenesManager.setScene("Loggin");

    }

    public static void main(String[] args) {

        launch(args);


    }

}