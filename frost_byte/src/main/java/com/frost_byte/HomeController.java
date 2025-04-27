package com.frost_byte;

import javafx.scene.Scene;
import java.io.IOException;
import java.util.ArrayList;
import javafx.scene.Parent;
import javafx.stage.Stage;

import com.model.DataWriter;
import com.model.Song;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import java.util.ArrayList;

import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;

public class HomeController {
    private PrimaryController primaryController;

    private ArrayList<String> screenHistory = new ArrayList<>();

    @FXML
    private StackPane contentPane;

    @FXML
    private Text TEMP_TITLE;

    @FXML
    private Button classesButton;

    @FXML
    private Button lessonsButton;

    @FXML
    private Button logoutButton;

    @FXML
    private Button playButton;

    @FXML
    private Button studioButton;

    ArrayList<Song> songList = new ArrayList<>();

    public void saveSongs(ArrayList<Song> songslist) {
        this.songList = songslist;
    }

    public void setPrimaryController(PrimaryController controller) {
        this.primaryController = controller;
    }

    private Song selectedSong;

    public void setSelectedSong(Song song) {
        this.selectedSong = song;
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
    private void showPlaylist() {
        loadView("playlist.fxml");
        TEMP_TITLE.setText("Playlist");
        screenHistory.add("playlist.fxml");
    }

    @FXML
    private void showClasses() {
        loadView("classes.fxml");
        TEMP_TITLE.setText("Classes");
        screenHistory.add("classes.fxml");
    }

    @FXML
    private Label playsongTxt;

    @FXML
    private Label playsongTxt1;

    @FXML
    private Label playsongTxt11;

    @FXML
    private Label playsongTxt12;

    @FXML
    private void loadView(String fxmlFile) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/frost_byte/" + fxmlFile));
            Parent root = loader.load();

            if (fxmlFile.equals("song.fxml")) {
                SongController controller = loader.getController();
                controller.setSong(selectedSong);
            }

            // Update the scene
            Scene scene = new Scene(root);
            Stage stage = (Stage) contentPane.getScene().getWindow();
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void handleLogout() {
        try {
            DataWriter.saveSongs(songList);
            App.setRoot("login");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
