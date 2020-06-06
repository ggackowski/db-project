import dataObjects.Recipe;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.text.Text;


public class ViewScreen {

    @FXML
    private Text titleText;

    @FXML
    private Text descriptionText;

    @FXML
    private Text ingredientsText;

    @FXML
    private Text howToText;

    @FXML
    private ChoiceBox<String> voteBox;

    @FXML
    private Button deleteButton;

    @FXML
    private Button voteButton;

    @FXML
    private Button backButton;

    public void initialize() {
        titleText.setText("Placki ziemniaczane");
        descriptionText.setText("Smaczne placki bardzo");
        ingredientsText.setText("-Ziemniaki 200g\n-Jajko 50g\n");
        howToText.setText("Zetrzyj ziemniaki na tarce\nDodaj jajko\nWymieszaj\nUsmarz\nSmacznego!!\n");
        voteBox.getItems().add("1");
        voteBox.getItems().add("2");
        voteBox.getItems().add("3");
        voteBox.getItems().add("4");
        voteBox.getItems().add("5");
    }

    public ViewScreen() {

    }

    public void backButtonOnAction() {
        HelloFX.scenesManager.setScene("List");
    }

    public void deleteButtonOnAction() {
        System.out.println("deleted xd");
    }

    public void voteButtonOnAction() {
        System.out.println("Voted " + voteBox.getValue());
    }


}
