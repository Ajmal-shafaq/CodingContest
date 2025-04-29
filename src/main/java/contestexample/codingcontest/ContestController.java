package contestexample.codingcontest;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class ContestController {
    @FXML
    private Label welcomeText;

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }
}