package JavaFX;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class NewRecipeScreen {

    @FXML
    private TextField titleField;

    @FXML
    private TextArea descriptionArea;

    @FXML
    private TextArea ingredientsArea;

    @FXML
    private TextArea howToArea;

    @FXML
    private Button backButton;

    @FXML
    private  Button addButton;

    public NewRecipeScreen() {}

    @FXML
    public void backButtonOnAction() {
        HelloFX.scenesManager.setScene("List");
    }

    @FXML
    public void addButtonOnAction() {
        HelloFX.scenesManager.setScene("List");
    }

}
