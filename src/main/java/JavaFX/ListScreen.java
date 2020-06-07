package JavaFX;

import Utils.CurrentRecipe;
import Utils.CurrentUser;
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
    private Button logButton;

    @FXML
    void initialize() {
        Utils.DatabaseProvider databaseProvider = Utils.DatabaseProvider.getInstance();
        CurrentRecipe currentRecipe = CurrentRecipe.getInstance();

        //User user = new User("Admin","Adminski","admin@admin.com","admin");
        //Recipe recipe = new Recipe(user);
        //recipe.addDescription("Very good one");

        //databaseProvider.addUser(user);
        //databaseProvider.addRecipe(recipe);
        if (!CurrentUser.getInstance().isUserLogged()) {
            addNewRecipeButton.setVisible(false);
            logButton.setText("Log in");
        }
        else {
            logButton.setText("Log out " + CurrentUser.getInstance().getLoggedUser().getName());
        }

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

    public void logButtonOnAction() {
        if (CurrentUser.getInstance().isUserLogged()) {
            CurrentUser.getInstance().logout();
            HelloFX.scenesManager.setScene("List");
        }
        else {
            HelloFX.scenesManager.setScene("Loggin");
        }
    }

    public void test() {

    }
}
