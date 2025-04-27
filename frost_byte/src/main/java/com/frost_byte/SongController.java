package com.frost_byte;

import com.model.Song;
import com.model.SongList;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.Button;

public class SongController {

    @FXML
    private Label songTitleLabel;
    @FXML
    private Label artistLabel;
    @FXML
    private Label genreLabel;
    @FXML
    private Label durationLabel;
    @FXML
    private Label tempoLabel;
    @FXML
    private Button playButton;

    private Song currentSong;

    // Method to initialize song details
    public void setSong(Song song) {
        currentSong = song; // Store the current song

        // Set song details to labels
        songTitleLabel.setText(song.getTitle());
        artistLabel.setText(song.getArtist());
        genreLabel.setText(song.getGenre());
        durationLabel.setText(song.getDuration());
        tempoLabel.setText(song.getTempo());

        // Set action for play button
        playButton.setOnAction(event -> playSong());
    }

    // Method to play the song
    private void playSong() {
        if (currentSong != null) {
            SongList.getInstance().playSong(currentSong); // Play the selected song using SongList
        }
    }
}
