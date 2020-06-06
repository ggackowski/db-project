import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class RegisterScreen {



    @FXML
    private TextField loginField;

    @FXML
    private TextField passwordField;

    @FXML
    private TextField repeatPasswordField;

    @FXML
    private Button registerButton;

    @FXML
    private Button backButton;


    public RegisterScreen() {

    }

    @FXML
    public void backButtonOnAction() {
        HelloFX.scenesManager.setScene("Loggin");
    }

}
