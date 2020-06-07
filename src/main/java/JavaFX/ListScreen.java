package JavaFX;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.text.Text;

public class ListScreen {

    @FXML
    private ListView<Text> listView;

    @FXML
    private Button addNewRecipeButton;

    @FXML
    private Button sampleRecipeButton;

    @FXML
    void initialize() {
       // Utils.DatabaseProvider databaseProvider = Utils.DatabaseProvider.getInstance();


        //User user = new User("Admin","Adminski","admin@admin.com","admin");
        //Recipe recipe = new Recipe(user);
        //recipe.addDescription("Very good one");

        //databaseProvider.addUser(user);
        //databaseProvider.addRecipe(recipe);


        //List<Recipe> recipes = databaseProvider.getRecipes();
        //for (Recipe value : recipes) listView.getItems().add(new Text(value.getDescription()));

    }

    public ListScreen() {

    }

    @FXML
    public void addNewRecipeButtonOnAction() {
        HelloFX.scenesManager.setScene("NewRecipe");
    }

    public void sampleRecipeButtonOnAction() {
        HelloFX.scenesManager.setScene("View");
    }
}
