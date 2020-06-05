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
        databaseProvider.addRecipe(recipe, user);


        List<Recipe> recipes = databaseProvider.getRecipes();
        for (int i = 0; i < recipes.size(); ++i)
            listView.getItems().add(new Text(recipes.get(i).getDescription()));

    }

    public Controller() {

    }
}
