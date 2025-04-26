// package com.frost_byte;

// import java.io.IOException;
// import javafx.fxml.FXML;

// public class PrimaryController {

//     @FXML
//     private void switchToSecondary() throws IOException {
//         App.setRoot("secondary");
//     }
// }
package com.frost_byte;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.layout.StackPane;

public class PrimaryController {

    @FXML
    private StackPane contentPane;

    public void initialize() {
        showHome(); // Load home view on start
    }

    @FXML
    private void showHome() {
        loadView("home.fxml");
    }

    @FXML
    private void showProfile() {
        loadView("profile.fxml");
    }

    @FXML
    public void showLessons() {
        loadView("Lessons.fxml");
    }

    @FXML
    private void showSettings() {
        loadView("Settings.fxml");
    }

    private void loadView(String fxmlFile) {
        try {
            Node view = FXMLLoader.load(getClass().getResource(fxmlFile));
            contentPane.getChildren().setAll(view);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
