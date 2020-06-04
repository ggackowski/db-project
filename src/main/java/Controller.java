import dataObjects.Recipe;
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

        /*
        Author author = new Author("Admin", "Admin");
        Recipe recipe = new Recipe(author);
        recipe.addDescription("Very good one");
        databaseProvider.addRecipe(recipe, author);
        */

        List<Recipe> recipes = databaseProvider.getRecipies();
        for (int i = 0; i < recipes.size(); ++i)
            listView.getItems().add(new Text(recipes.get(i).getDescription()));

    }

    public Controller() {

    }
}
