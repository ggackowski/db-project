package JavaFX;

import Utils.DatabaseProvider;
import dataObjects.User;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

public class RegisterScreen {



    @FXML
    private TextField emailField;

    @FXML
    private TextField passwordField;

    @FXML
    private TextField repeatPasswordField;

    @FXML
    private TextField nameField;

    @FXML
    private TextField surnameField;

    @FXML
    private Button registerButton;

    @FXML
    private Button backButton;

    @FXML
    private Text emailTakenText;

    @FXML
    private Text passwordsText;


    public RegisterScreen() {

    }

    @FXML
    public void backButtonOnAction() {
        HelloFX.scenesManager.setScene("Loggin");
    }

    @FXML
    public void registerButtonOnAction() {
        //TU REJESTRACJA
        if (passwordField.getText().equals(repeatPasswordField.getText())) {
            DatabaseProvider databaseProvider = DatabaseProvider.getInstance();
            User user = new User(nameField.getText(), surnameField.getText(), emailField.getText(), passwordField.getText());
            if (databaseProvider.addUser(user) == false) {
                emailTakenText.setVisible(true);
            }
            else {
                HelloFX.scenesManager.setScene("List");
            }
        }
        else {
            passwordsText.setVisible(true);
        }
    }

}
