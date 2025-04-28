package com.frost_byte;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import com.model.DataLoader;
import com.model.Song;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;


public class PlaylistController implements Initializable {

    @FXML
    private ListView<String> myListView;

   // ArrayList<Song> songs = new ArrayList<>();
    ArrayList<Song> songObjects = DataLoader.getSongs();
    ArrayList<String> songTitles = new ArrayList<String>();

    // for (int i = 0; i < songObjects.size(); i++) {
    //     songTitles.add(song.getTitle());  // Assuming the Song class has a getTitle() method
    // }
    


   
    String currentSong; 
   // private ListView<Song> songList;
    @FXML
    private TextField songSearch;

    @Override
    public void initialize(URL arg0, ResourceBundle arg1){
        myListView.getItems().addAll(songTitles);

    }
    // private ArrayList<Song> songs = new ArrayList<>();

    // public void loadSongs() {

    //     ArrayList<Song> songArrayList = DataLoader.getSongs();
    //     for (Song song : songArrayList) {
    //         songList.getItems().add(song);
    //     }

    // }

    // public void initialize() {
    //     songs = DataLoader.getSongs();
    // }

    // @FXML
    // private void searchButtonClick() {
    //     ObservableList<Song> songListObservableList = songList.getItems();
    //     String selectedSong = songSearch.getText();

    //     if (songList != null && !songListObservableList.isEmpty()) {
    //         // Iterate through the ObservableList using an enhanced for-loop
    //         for (Song song : songListObservableList) {
    //             if (song.getTitle().contains(selectedSong)) {
    //                 System.out.println("Song Title: " + song.getTitle() + ", Artist: " + song.getArtist());
    //             }
    //         }

    //     }
    // }
}