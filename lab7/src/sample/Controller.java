package sample;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;


public class Controller {
    @FXML
    private Label labelka;
    public void initialize() {
        labelka.setText("Foo");
    }
}
