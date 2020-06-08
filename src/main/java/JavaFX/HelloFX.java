package JavaFX;

import Utils.DatabaseProvider;
import dataGeneration.DataGenerator;
import javafx.application.Application;
import javafx.stage.Stage;

public class HelloFX extends Application {

    static ScenesManager scenesManager;
    @Override
    public void start(Stage primaryStage) throws Exception{
        //DataGenerator dg = new DataGenerator();
        //dg.generateAll();

        scenesManager = ScenesManager.getInstance(primaryStage);
        primaryStage.setTitle("Recipies");
        scenesManager.setScene("List");

    }

    public static void main(String[] args) {

        launch(args);
        System.out.println("koniec");
        DatabaseProvider.getInstance().closeSession();

    }

}