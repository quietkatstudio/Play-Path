package com.frost_byte;

import com.model.Song;
import com.model.SongList;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;


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

    private void playSong(Song currentSong) {
        System.out.println("trying to play song");
        if (currentSong != null) {
            Thread musicThread = new Thread(() -> {
                SongList.getInstance().playSong(currentSong); // Play the selected song using SongList
            });

            musicThread.start();
            for (int i = 0; i < 5; i++) {
                System.out.println("Change image... Step " + (i + 1));
                Image image = new Image("@../../images/101.PNG");
                tubaImage = new ImageView(image);
               // tubaImage.setImage(newImage("@../../images/101.PNG"));
                try {
                    Thread.sleep(1000); // Simulate doing something for 1 second
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            
            
            
            
            
        }
    }

    @FXML
    public void initialize() {
        // You can leave this empty for now
        System.out.println("PlaySongController loaded!");
        playButton.setOnAction(event -> playSong(currentSong));
    }

     

   
    public void setSong(Song song) {
        if (song != null) {
            songTitle.setText(song.getTitle());
            songArtist.setText(song.getArtist());
            currentSong = song;

            // Optional: if you want to set the image too
            // tubaImage.setImage(new Image(song.getImagePath()));
        }
    }
    
}
