package com.frost_byte;

import com.model.Song;
import com.model.SongList;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.util.Duration;

public class PlaySongController {

    @FXML
    private Label songTitle;

    @FXML
    private Label songArtist;

    @FXML
    private Button playButton;

    @FXML
    private ImageView tubaImage;

    private Song currentSong;
    private Timeline animationTimeline;

    @FXML
    public void initialize() {
        System.out.println("PlaySongController loaded!");
        playButton.setOnAction(event -> {
            playSong(currentSong);
            startTubaAnimation();
        });
    }

    public void setSong(Song song) {
        if (song != null) {
            songTitle.setText(song.getTitle());
            songArtist.setText(song.getArtist());
            currentSong = song;
        }
    }

    private void playSong(Song song) {
        if (song != null) {
            System.out.println("Trying to play song: " + song.getTitle());
            Thread musicThread = new Thread(() -> {
                SongList.getInstance().playSong(song);
            });
            musicThread.start();
        }
    }

    private void startTubaAnimation() {
        if (animationTimeline != null) {
            animationTimeline.stop();
        }

        animationTimeline = new Timeline();

        for (int i = 0; i < 5; i++) {
            final int step = i;
            animationTimeline.getKeyFrames().add(
                new KeyFrame(Duration.seconds(i),
                    event -> updateTubaImage(step)
                )
            );
        }

        animationTimeline.setCycleCount(1); // Only play once
        animationTimeline.play();
    }

    private void updateTubaImage(int step) {
        // Convert step (0-4) to 3-digit binary string
        String binaryString = Integer.toBinaryString(step);
        while (binaryString.length() < 3) {
            binaryString = "0" + binaryString;
        }

        try {
            Image newImage = new Image(getClass().getResource("/images/" + binaryString + ".PNG").toExternalForm());
            tubaImage.setImage(newImage);
            System.out.println("Updated tuba image to: " + binaryString + ".PNG");
        } catch (Exception e) {
            System.out.println("Failed to load image for binary code: " + binaryString);
            e.printStackTrace();
        }
    }
}
