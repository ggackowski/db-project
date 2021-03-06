package JavaFX;

import Utils.CurrentRecipe;
import Utils.CurrentUser;
import Utils.DatabaseProvider;
import dataObjects.Recipe;
import dataObjects.User;
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
    private Button deleteButton;

    @FXML
    void initialize() {
        Utils.DatabaseProvider databaseProvider = Utils.DatabaseProvider.getInstance();
        CurrentRecipe currentRecipe = CurrentRecipe.getInstance();

        if (!CurrentUser.getInstance().isUserLogged()) {
            addNewRecipeButton.setVisible(false);
            logButton.setText("Log in");
            deleteButton.setVisible(false);
        }
        else {
            logButton.setText("Log out " + CurrentUser.getInstance().getLoggedUser().getName());
        }

        List<Recipe> recipes = databaseProvider.getRecipes();

        for (Recipe value : recipes) {
            Text recipe = new Text(value.getTitle());
            recipe.setOnMousePressed(e -> {
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

    public void deleteButtonOnAction() {
        User user = CurrentUser.getInstance().getLoggedUser();
        CurrentUser.getInstance().logout();
        DatabaseProvider.getInstance().removeUser(user);
        HelloFX.scenesManager.setScene("List");
    }

    public void test() {

    }
}
