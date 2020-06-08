package JavaFX;

import Utils.CurrentRecipe;
import Utils.CurrentUser;
import Utils.DatabaseProvider;
import dataObjects.Recipe;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class EditRecipeScreen {

    @FXML
    private TextField titleField;

    @FXML
    private TextArea descriptionArea;

    @FXML
    private TextArea ingredientsArea;

    @FXML
    private Button backButton;

    @FXML
    private  Button saveButton;

    public EditRecipeScreen() {}

    @FXML
    public void initialize() {
        titleField.setText(CurrentRecipe.getInstance().get().getTitle());
        descriptionArea.setText(CurrentRecipe.getInstance().get().getDescription());
        ingredientsArea.setText(CurrentRecipe.getInstance().get().getIngredients());
    }

    @FXML
    public void backButtonOnAction() {
        HelloFX.scenesManager.setScene("View");
    }

    @FXML
    public void saveButtonOnAction() {
        Recipe recipe = CurrentRecipe.getInstance().get();
        recipe.setIngredients(ingredientsArea.getText());
        recipe.setDescription(descriptionArea.getText());
        recipe.setTitle(titleField.getText());
        DatabaseProvider.getInstance().updateRecipe(recipe);
        HelloFX.scenesManager.setScene("View");
    }

}
