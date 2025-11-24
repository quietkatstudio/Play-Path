package com.frost_byte;

import java.io.IOException;
import java.util.ArrayList;

import com.model.Song;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;

public class HomeController {

    private PrimaryController primaryController;

    ArrayList<Song> songList = new ArrayList<>();

    public void saveSongs(ArrayList<Song> songslist) {
        this.songList = songslist;
    }

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

    public void setPrimaryController(PrimaryController controller) {
        this.primaryController = controller;
    }

    @FXML
    private void showMusicStudio() {
        if (primaryController != null)
            primaryController.showMusicStudio();
    }

    @FXML
    public void showLessons() {
        if (primaryController != null)
            primaryController.showLessons();
    }

    @FXML
    private void showPlaylist() {
        if (primaryController != null)
            primaryController.showPlaylist();
    }

    @FXML
    private void showClasses() {
       // if (primaryController != null)
           // primaryController.showClasses(); // or show specific class screen
    }

    public void openSongPage(Song selectedSong) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/frost_byte/song.fxml"));
            Parent root = loader.load();

            // Pass the selected song to the SongController
            SongController controller = loader.getController();
            controller.setSong(selectedSong);

            // Update the scene
            Scene scene = new Scene(root);
            // Stage stage = (Stage) songButton.getScene().getWindow();
            // stage.setScene(scene);
            // stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void handleLogout() {

        try {
           // DataWriter.saveSongs(songList);
            App.setRoot("login");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}