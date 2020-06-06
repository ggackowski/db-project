package LoggingScreen;

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
    private Button registerButton;

    @FXML
    void initialize() {

    }

    public LoggingScreen() {

    }

    @FXML
    public void loginButtonOnAction() {
        String login = this.loginField.getText();
        String password = this.passwordField.getText();
        System.out.println(login + " " + password);
    }

}
