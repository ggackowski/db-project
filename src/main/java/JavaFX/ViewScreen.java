package JavaFX;

import Utils.CurrentRecipe;
import Utils.CurrentUser;
import Utils.DatabaseProvider;
import dataObjects.Recipe;
import dataObjects.User;
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
    private Text votedText;

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

    @FXML
    private Button editButton;

    public void initialize() {
        if (CurrentRecipe.getInstance().get() != null) {
            Recipe recipe = CurrentRecipe.getInstance().get();
            System.out.println(CurrentRecipe.getInstance().get().getTitle());
            titleText.setText(recipe.getTitle());
            descriptionText.setText(recipe.getDescription());
            ingredientsText.setText(recipe.getIngredients());
            authorText.setText(recipe.getAuthor().fullName());
            String rating = String.format("%.2f", recipe.getAVGRating());
            votedText.setVisible(false);
            //System.out.println(CurrentUser.getInstance().getLoggedUser().getEmail());
            if (CurrentUser.getInstance().isUserLogged()) {
                if (!CurrentUser.getInstance().getLoggedUser().equals(CurrentRecipe.getInstance().get().getAuthor())) {
                    deleteButton.setVisible(false);
                    editButton.setVisible(false);
                }
                if (!recipe.canVote(CurrentUser.getInstance().getLoggedUser())) {
                    voteBox.setVisible(false);
                    voteButton.setVisible(false);
                    votedText.setVisible(true);
                }
            }
            else {
                    editButton.setVisible(false);
                    voteBox.setVisible(false);
                    voteButton.setVisible(false);
                    deleteButton.setVisible(false);
            }
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

            DatabaseProvider.getInstance().removeRecipe(CurrentRecipe.getInstance().get());
            CurrentRecipe.getInstance().set(null);
            HelloFX.scenesManager.setScene("List");
            System.out.println("deleted xd");


    }

    public void editButtonOnAction() {
        HelloFX.scenesManager.setScene("EditRecipe");
    }

    public void voteButtonOnAction() {
        System.out.println("Voted " + voteBox.getValue());
        Recipe recipe = CurrentRecipe.getInstance().get();
        User user = CurrentUser.getInstance().getLoggedUser();
        recipe.addRating(user, Integer.parseInt(voteBox.getValue()));
        DatabaseProvider.getInstance().updateRecipe(recipe);
        HelloFX.scenesManager.setScene("View");
    }


}
