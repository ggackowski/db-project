import dataObjects.Recipe;
import dataObjects.User;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.text.Text;

import java.util.List;

public class Controller {

    @FXML
    private ListView<Text> listView;

    @FXML
    void initialize() {
        DatabaseProvider databaseProvider = new DatabaseProvider();


        User user = new User("Admin","Adminski","admin@admin.com","admin");
        Recipe recipe = new Recipe(user);
        recipe.addDescription("Very good one");

        databaseProvider.addUser(user);
        databaseProvider.addRecipe(recipe);


        List<Recipe> recipes = databaseProvider.getRecipes();
        for (Recipe value : recipes) listView.getItems().add(new Text(value.getDescription()));

    }

    public Controller() {

    }
}
