package com.frost_byte;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javax.swing.event.ChangeListener;

import com.model.DataLoader;
import com.model.Song;
import com.model.SongList;

import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;


public class PlaylistController implements Initializable {

    //@FXML
    //private ListView<String> songList;

    // @FXML
    // private TextField songSearch;

    
    private ArrayList<String> songTitleArrList = new ArrayList<String>();

    // public void loadSongs() {
        
    //     ArrayList<Song> songArrayList = DataLoader.getSongs();
    //     for (Song song : songArrayList) {
    //         songTitleArrList.add(song.getTitle());
    //     }

    //     ObservableList<String> observeSongList = FXCollections.observableArrayList(songTitleArrList);
    //     songList = new ListView<String>(observeSongList);
    //     System.out.println(songList.getItems());
    // }

    // @Override
    // public void initialize(URL arg0, ResourceBundle arg1) {
    //     System.out.println("pre-load Songs");
    //     loadSongs();

    // }

    @FXML
    private ListView<String> myListView;

   // ArrayList<Song> songs = new ArrayList<>();
    // ArrayList<Song> songObjects = DataLoader.getSongs();
    // ArrayList<String> songTitles = new ArrayList<String>();

    // for (int i = 0; i < songObjects.size(); i++) {
    //     songTitles.add(song.getTitle());  // Assuming the Song class has a getTitle() method
    // }
    


   
    public Song currentSong; 
   // private ListView<Song> songList;
    @FXML
    private TextField songSearch;

    private void playSong(Song currentSong) {
        if (currentSong != null) {
            SongList.getInstance().playSong(currentSong); // Play the selected song using SongList
        }
    }
    @Override
    public void initialize(URL arg0, ResourceBundle arg1){

        
        // songTitles.add("currentSong");
        // myListView.getItems().addAll(songTitles);

        ArrayList<Song> songArrayList = DataLoader.getSongs();
        for (Song song : songArrayList) {
            songTitleArrList.add(song.getTitle());

        }

        myListView.getItems().addAll(songTitleArrList);
        currentSong = SongList.getInstance().getSongByTitle("Hot Cross Buns");
        System.out.println(currentSong.getTitle());
        playSong(currentSong);
        
        
        
        
        // myListView.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>(){
           
        //     @Override
        //     public void changed(ObservableValue<? extends String> arg0, String arg1, String arg2) {
        //         currentSong = getSongByTitle(myListView.getSelectionModel().getSelectedItem());
        //         playSong(currentSong);
        //     }

        // });
    

        //System.out.println(songList.getItems());

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