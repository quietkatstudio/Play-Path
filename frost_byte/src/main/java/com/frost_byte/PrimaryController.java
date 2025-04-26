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
import javafx.scene.text.Text;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.layout.StackPane;

public class PrimaryController {

    @FXML
    private StackPane contentPane;

    @FXML
    private Text TEMP_TITLE;

    public void initialize() {
        showHome(); // Load home view on start
    }

    @FXML
    private void showHome() {

        loadView("home.fxml");
        TEMP_TITLE.setText("Home");
    }

    @FXML
    private void showProfile() {
        loadView("profile.fxml");
        TEMP_TITLE.setText("Profile");
    }

    @FXML
    private void showMusicStudio() {
        loadView("musicStudio.fxml");
        TEMP_TITLE.setText("Music Studio");
    }

    @FXML
    public void showLessons() {
        loadView("Lessons.fxml");
        TEMP_TITLE.setText("Lessons");
    }

    @FXML
    private void showSettings() {
        loadView("Settings.fxml");
        TEMP_TITLE.setText("Settings");
    }

    @FXML
    private void showPlaylist() {
        loadView("Playlist.fxml");
        TEMP_TITLE.setText("Playlist");
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
