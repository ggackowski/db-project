import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.HashMap;

/**
 *
 * Singleton obsługujący funkcjonalność przechodzenia pomiędzy scenami
 */
public class ScenesManagerSingleton {

    HashMap<String, Scene> scenes;
    Stage stage;

    /**
     * @param s nazwa stage
     * @throws java.io.IOException
     */
    public ScenesManagerSingleton(Stage s) throws java.io.IOException {
        stage = s;
        scenes = new HashMap<>();
        Parent root;
        String[] scenesNames = {
                "Loggin",
                "Register"
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

    public static ScenesManagerSingleton getInstance(Stage s) throws java.io.IOException {
        return new ScenesManagerSingleton(s);
    }
}