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

    private ArrayList<String> screenHistory = new ArrayList<>();

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

    @FXML
    private void loadView(String fxmlFile) {
        try {
            Node view = FXMLLoader.load(getClass().getResource(fxmlFile));
            contentPane.getChildren().setAll(view);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void printScreenHistory() {
        for (String a : screenHistory) {
            System.out.println(a);
        }

        if (screenHistory.size() > 1) {
            // Get the second-to-last screen, not the last one.
            String previousScreen = screenHistory.get(screenHistory.size() - 2);

            // Load the previous screen.
            loadView(previousScreen);

            // Set the title based on the previous screen's FXML name.
            if (previousScreen.equals("home.fxml")) {
                TEMP_TITLE.setText("Home Screen");
            } else if (previousScreen.equals("playlist.fxml")) {
                TEMP_TITLE.setText("Playlist");
            } else if (previousScreen.equals("musicStudio.fxml")) {
                TEMP_TITLE.setText("Music Studio");
            } else if (previousScreen.equals("playSong.fxml")) {
                TEMP_TITLE.setText("Play Music");
            } else if (previousScreen.equals("settings.fxml")) {
                TEMP_TITLE.setText("Settings");
            } else if (previousScreen.equals("lessons.fxml")) {
                TEMP_TITLE.setText("Lessons");
            } else {
                TEMP_TITLE.setText("Unknown Screen"); // Default title if no match is found
            }

            // Remove the current screen from the history (we are going back).
            screenHistory.remove(screenHistory.size() - 1);
        }
    }

}
