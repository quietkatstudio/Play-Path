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
import java.util.ArrayList;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;

public class PrimaryController {

    ArrayList screenHistory;
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
        screenHistory.add("home.fxml");
    }

    @FXML
    private void showProfile() {
        loadView("profile.fxml");
        TEMP_TITLE.setText("Profile");
        screenHistory.add("profile.fxml");
    }

    @FXML
    private void showMusicStudio() {
        loadView("musicStudio.fxml");
        TEMP_TITLE.setText("Music Studio");
        screenHistory.add("musicStudio.fxml");
    }

    @FXML
    public void showLessons() {
        loadView("lessons.fxml");
        TEMP_TITLE.setText("Lessons");
        screenHistory.add("lessons.fxml");
    }

    @FXML
    private void showSettings() {
        loadView("settings.fxml");
        TEMP_TITLE.setText("Settings");
        screenHistory.add("settings.fxml");
    }

    @FXML
    private void showPlaylist() {
        loadView("playlist.fxml");
        TEMP_TITLE.setText("Playlist");
        screenHistory.add("playlist.fxml");
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
