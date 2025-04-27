package com.frost_byte;

import java.io.IOException;
import java.util.ArrayList;

import com.model.DataLoader;
import com.model.DataWriter;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.chart.PieChart.Data;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;
import com.model.Song;

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

    private void loadView(String fxmlFile) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(fxmlFile));
            Node view = loader.load();
            contentPane.getChildren().setAll(view);
            ArrayList<Song> songsList = DataLoader.getSongs();

            // Pass the song list to HomeController if it's home.fxml
            if (fxmlFile.equals("home.fxml")) {
                HomeController homeController = loader.getController();
                homeController.saveSongs(songsList); // Pass song list to HomeController
                homeController.setPrimaryController(this);
            }

            // If we loaded HomeController, link it
            if (fxmlFile.equals("home.fxml")) {
                HomeController homeController = loader.getController();
                homeController.setPrimaryController(this);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
