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
        showScreen("home.fxml", "Home");
    }

    // General method to show screens with dynamic titles
    private void showScreen(String fxmlFile, String title) {
        loadView(fxmlFile);
        TEMP_TITLE.setText(title);
        screenHistory.add(fxmlFile);
    }

    @FXML
    private void showHome() {
        showScreen("home.fxml", "Home");
    }

    @FXML
    private void showProfile() {
        showScreen("profile.fxml", "Profile");
    }

    @FXML
    private void showMusicStudio() {
        showScreen("musicStudio.fxml", "Music Studio");
    }

    @FXML
    public void showLessons() {
        showScreen("lessons.fxml", "Lessons");
    }

    @FXML
    private void showSettings() {
        showScreen("settings.fxml", "Settings");
    }

    @FXML
    private void showPlaylist() {
        showScreen("playlist.fxml", "Playlist");
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
            String previousScreen = screenHistory.get(screenHistory.size() - 2);
            loadView(previousScreen);
            setTitleFromScreen(previousScreen);
            screenHistory.remove(screenHistory.size() - 1);
        }
    }

    // Set the title dynamically based on the screen
    private void setTitleFromScreen(String screen) {
        switch (screen) {
            case "home.fxml":
                TEMP_TITLE.setText("Home");
                break;
            case "playlist.fxml":
                TEMP_TITLE.setText("Playlist");
                break;
            case "musicStudio.fxml":
                TEMP_TITLE.setText("Music Studio");
                break;
            case "playSong.fxml":
                TEMP_TITLE.setText("Playlist");
                break;
            case "settings.fxml":
                TEMP_TITLE.setText("Settings");
                break;
            case "lessons.fxml":
                TEMP_TITLE.setText("Lessons");
                break;
            default:
                TEMP_TITLE.setText("Unknown Screen");
                break;
        }
    }
}