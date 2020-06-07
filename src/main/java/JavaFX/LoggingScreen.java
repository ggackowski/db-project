package JavaFX;

import Utils.CurrentUser;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class LoggingScreen  {

    @FXML
    private TextField loginField;

    @FXML
    private TextField passwordField;

    @FXML
    private Button loginButton;

    @FXML
    private Button registerButton;

    @FXML
    void initialize() {

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
        CurrentUser currentUser = new CurrentUser();
        if (currentUser.login(login, password)) {
            System.out.println("zalogowan");
        }
        else {
            System.out.println("nie zalogowan");
        }
    }

}
