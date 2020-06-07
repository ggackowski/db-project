package JavaFX;

import Utils.CurrentRecipe;
import dataObjects.Recipe;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.text.Text;

import java.util.List;

public class ListScreen {

    @FXML
    private ListView<Text> listView;

    @FXML
    private Button addNewRecipeButton;

    @FXML
    private Button sampleRecipeButton;

    @FXML
    void initialize() {
        Utils.DatabaseProvider databaseProvider = Utils.DatabaseProvider.getInstance();
        CurrentRecipe currentRecipe = CurrentRecipe.getInstance();

        //User user = new User("Admin","Adminski","admin@admin.com","admin");
        //Recipe recipe = new Recipe(user);
        //recipe.addDescription("Very good one");

        //databaseProvider.addUser(user);
        //databaseProvider.addRecipe(recipe);


        List<Recipe> recipes = databaseProvider.getRecipes();

        for (Recipe value : recipes) {
            //System.out.println(value.getTitle());
            Text recipe = new Text(value.getTitle());
            recipe.setOnMousePressed(e -> {
                System.out.println("klikniete" + recipe.getText());
                Recipe r = databaseProvider.getRecipeByTitle(recipe.getText());
                currentRecipe.set(r);
                HelloFX.scenesManager.setScene("View");
            });
            listView.getItems().add(recipe);
        }

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

    public void test() {

    }
}
