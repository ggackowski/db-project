package JavaFX;

import Utils.DatabaseProvider;
import javafx.application.Application;
import javafx.stage.Stage;

public class HelloFX extends Application {

    static ScenesManager scenesManager;
    @Override
    public void start(Stage primaryStage) throws Exception{
        scenesManager = ScenesManager.getInstance(primaryStage);
        primaryStage.setTitle("Recipies");
        scenesManager.setScene("List");
        //DataGenerator dg = new DataGenerator();
        //dg.generateAll();

    }

    public static void main(String[] args) {

        launch(args);
        System.out.println("koniec");
        DatabaseProvider.getInstance().closeSession();

    }

}