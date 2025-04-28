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
import javafx.scene.layout.StackPane;

//import javafx.beans.value.ChangeListener;

import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.control.SpinnerValueFactory.IntegerSpinnerValueFactory;



public class PlaylistController implements Initializable {

    private PrimaryController primaryController;

    @FXML
    private StackPane contentPane;

    public void setPrimaryController(PrimaryController controller) {
        this.primaryController = controller;
    }
    @FXML
    private void showSongPlayer(Song currentSong) {
        if (primaryController != null)
            primaryController.showSongPlayer(currentSong);
    }

    private ArrayList<String> songTitleArrList = new ArrayList<String>();

    @FXML
    private ListView<String> myListView;

   
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

       

        ArrayList<Song> songArrayList = DataLoader.getSongs();
        for (Song song : songArrayList) {
            songTitleArrList.add(song.getTitle());

        }

        myListView.getItems().addAll(songTitleArrList);
        currentSong = SongList.getInstance().getSongByTitle("Hot Cross Buns");
        System.out.println(currentSong.getTitle());
       // playSong(currentSong);
        
        

        myListView.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue != null) {
                currentSong = SongList.getInstance().getSongByTitle(newValue);
                showSongPlayer(currentSong);
                //playSong(currentSong);
                System.out.println("Selected song: " + newValue);
            }
        });
        
      

    }
    

}