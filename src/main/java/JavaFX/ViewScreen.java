package JavaFX;

import Utils.CurrentRecipe;
import Utils.CurrentUser;
import dataObjects.Recipe;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.text.Text;

import java.io.IOException;


public class ViewScreen {

    @FXML
    private Text titleText;

    @FXML
    private Text descriptionText;

    @FXML
    private Text ingredientsText;

    @FXML
    private Text authorText;

    @FXML
    private Text ratingText;

    @FXML
    private ChoiceBox<String> voteBox;

    @FXML
    private Button deleteButton;

    @FXML
    private Button voteButton;

    @FXML
    private Button backButton;

    public void initialize() {
        if (CurrentRecipe.getInstance().get() != null) {
            Recipe recipe = CurrentRecipe.getInstance().get();
            System.out.println(CurrentRecipe.getInstance().get().getTitle());
            titleText.setText(recipe.getTitle());
            descriptionText.setText(recipe.getDescription());
            ingredientsText.setText(recipe.getIngredients());
            authorText.setText(recipe.getAuthor().getEmail());
            String rating = Double.toString(recipe.getAVGRating());
            if (rating.equals("NaN"))
                rating = "No votes";
            ratingText.setText(rating);
        }else {
            titleText.setText("Placki ziemniaczane");
            descriptionText.setText("Smaczne placki bardzo");
            ingredientsText.setText("-Ziemniaki 200g\n-Jajko 50g\n");
        }
        voteBox.getItems().add("1");
        voteBox.getItems().add("2");
        voteBox.getItems().add("3");
        voteBox.getItems().add("4");
        voteBox.getItems().add("5");
    }

    public ViewScreen() {

    }

    public void backButtonOnAction() throws IOException {
        HelloFX.scenesManager.setScene("List");
    }

    public void deleteButtonOnAction() {
        System.out.println("deleted xd");
        //if ()
    }

    public void voteButtonOnAction() {
        System.out.println("Voted " + voteBox.getValue());
    }


}
