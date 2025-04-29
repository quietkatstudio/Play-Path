package com.frost_byte;

import java.io.IOException;
import java.util.ArrayList;

import com.model.Song;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
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
    public void showScreen(String fxmlFile, String title) {
        loadView(fxmlFile);
        TEMP_TITLE.setText(title);
        screenHistory.add(fxmlFile);
    }

    @FXML
    private void showHome() {
        showScreen("home.fxml", "Home");
    }

    @FXML
    public void showProfile() {
        showScreen("profile.fxml", "Profile");
    }

    @FXML
    public void showMusicStudio() {
        showScreen("musicStudio.fxml", "Music Studio");
    }

    @FXML
    public void showLessons() {
        showScreen("lessons.fxml", "Lessons");
    }

    @FXML
    public void showSettings() {
        showScreen("settings.fxml", "Settings");
    }

    @FXML
    public void showPlaylist() {
        showScreen("playlist.fxml", "Playlist");
    }

    @FXML
    public void showSongPlayer(Song selectedSong) {
        // showScreen("playSong.fxml", "PlaySong");
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/frost_byte/playSong.fxml"));
            Parent view = loader.load();

            // Get the controller for PlaySong
            PlaySongController controller = loader.getController();
            controller.setSong(selectedSong); // <- pass the selected song

            contentPane.getChildren().setAll(view);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void printScreenHistory() {
        if (screenHistory.size() > 1) {
            screenHistory.remove(screenHistory.size() - 1); // Remove current
            String previousScreen = screenHistory.get(screenHistory.size() - 1);
            setTitleFromScreen(previousScreen);
            loadView(previousScreen);
        }
    }

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
                TEMP_TITLE.setText("Play Song");
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

    private void loadView(String fxmlFile) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(fxmlFile));
            Node view = loader.load();
            contentPane.getChildren().setAll(view);

            // If we loaded HomeController, link it
            if (fxmlFile.equals("home.fxml")) {
                HomeController homeController = loader.getController();
                homeController.setPrimaryController(this);
            }

            // If we loaded HomeController, link it
            if (fxmlFile.equals("playlist.fxml")) {
                PlaylistController playlistController = loader.getController();
                playlistController.setPrimaryController(this);
            }

            // If we loaded SettingsController, link it too
            if (fxmlFile.equals("settings.fxml")) {
                SettingsController settingsController = loader.getController();
                settingsController.setPrimaryController(this);
            }

            // If we loaded SettingsController, link it too
            if (fxmlFile.equals("lessons.fxml")) {
                LessonsController lessonsController = loader.getController();
                lessonsController.setPrimaryController(this);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}