package com.frost_byte;

import com.model.Song;
import javafx.fxml.FXML;
import javafx.scene.control.ListCell;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import java.util.ArrayList;
import com.model.Song;

public class SongController extends ListCell<Song> {

    @FXML
    private ImageView songImageView; // For displaying the song image

    @FXML
    private Text songTitleText; // For displaying the song title

    @FXML
    private Text songAuthorText; // For displaying the song author

    // A list of album art locations, ideally should come from a service or database
    private ArrayList<String> albumArtList;

    public Song selectedSong;

    @FXML
    public void initialize() {
        // Optionally load albumArtList if needed, or pass it from controller
    }

    public void setSong(Song selectedSong) {
        this.selectedSong = selectedSong;
    }

    @Override
    protected void updateItem(Song song, boolean empty) {
        super.updateItem(song, empty);

        if (empty || song == null) {
            setGraphic(null); // Don't display anything if the item is empty
        } else {
            Pane pane = new Pane(); // Or use VBox/HBox depending on layout
            // Load the song details into the pane

            // Set the image for the song (you can adjust this logic)
            for (String s : albumArtList) {
                if (song.getTitle().equals(s)) {
                    Image image = new Image(s); // Set the image path
                    songImageView.setImage(image);
                    break;
                }
            }

            // Set the song title and author
            songTitleText.setText(song.getTitle());
            songAuthorText.setText(song.getArtist());

            // Add to the pane (or use any other container like VBox or HBox)
            pane.getChildren().add(songImageView);
            pane.getChildren().add(songTitleText);
            pane.getChildren().add(songAuthorText);

            setGraphic(pane);
        }
    }
}