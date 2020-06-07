package JavaFX;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.HashMap;

/**
 *
 * Singleton obsługujący funkcjonalność przechodzenia pomiędzy scenami
 */
public class ScenesManager {

    HashMap<String, Scene> scenes;
    Stage stage;

    /**
     * @param s nazwa stage
     * @throws java.io.IOException
     */
    public ScenesManager(Stage s) throws java.io.IOException {
        stage = s;
        scenes = new HashMap<>();
        Parent root;
        String[] scenesNames = {
                "Loggin",
                "Register",
                "List",
                "NewRecipe",
                "View"
        };

        for (String name : scenesNames) {
            root= FXMLLoader.load(getClass().getResource(name + "Screen.fxml"));
            Scene scene =new Scene(root);
            scenes.put(name, scene);
        }
    }

    /**
     * @param sceneName nazwa sceny
     *              Funkcja zmienia aktualną scenę na podaną w argumencie
     */
    public void setScene(String sceneName) {
        if (scenes.containsKey(sceneName)) {
            stage.setScene(scenes.get(sceneName));
            stage.show();
        }
    }

    public static ScenesManager getInstance(Stage s) throws java.io.IOException {
        return new ScenesManager(s);
    }
}