package com.example.projekt_sonb;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class GuiController {
    @FXML
    private Label welcomeText;

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }
}