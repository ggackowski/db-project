package JavaFX;

import Utils.CurrentUser;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

public class LoggingScreen  {

    @FXML
    private TextField loginField;

    @FXML
    private TextField passwordField;

    @FXML
    private Button loginButton;

    @FXML
    private Button homeButton;

    @FXML
    private Button registerButton;

    @FXML
    private Text wrongUser;

    @FXML
    void initialize() {
        wrongUser.setVisible(false);
    }

    public LoggingScreen() {

    }

    @FXML
    public void registerButtonOnAction() {
        HelloFX.scenesManager.setScene("Register");
    }

    @FXML
    public void loginButtonOnAction() {
        String login = this.loginField.getText();
        String password = this.passwordField.getText();
        System.out.println(login + " " + password);
        CurrentUser currentUser = CurrentUser.getInstance();
        if (currentUser.login(login, password)) {
            HelloFX.scenesManager.setScene("List");
            System.out.println("zalogowan");
        }
        else {

            System.out.println("nie zalogowan");
            wrongUser.setVisible(true);
        }
    }

    public void homeButtonOnAction() {
        HelloFX.scenesManager.setScene("List");
    }

}
