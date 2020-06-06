
import dataObjects.Rating;
import dataObjects.Recipe;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.hibernate.HibernateException;
import org.hibernate.Metamodel;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import javax.persistence.metamodel.EntityType;

public class HelloFX extends Application {
    static ScenesManagerSingleton scenesManager;
    @Override
    public void start(Stage primaryStage) throws Exception{
        scenesManager = ScenesManagerSingleton.getInstance(primaryStage);
        //Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("LogginScreen.fxml"));
        primaryStage.setTitle("Recipies");
        scenesManager.setScene("Loggin");

    }

    public static void main(String[] args) {
        launch(args);


    }

}