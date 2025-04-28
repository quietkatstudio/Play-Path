package com.frost_byte;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import com.model.DataLoader;
import com.model.Song;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

public class PlaylistController implements Initializable {

    @FXML
    private ListView<String> songList;

    @FXML
    private TextField songSearch;

    private ArrayList<Song> songs = new ArrayList<Song>();
    private ArrayList<String> songTitleArrList = new ArrayList<String>();

    public void loadSongs() {
        ArrayList<Song> songArrayList = DataLoader.getSongs();
        for (Song song : songArrayList) {
            songTitleArrList.add(song.getTitle());
        }
        songList.getItems().addAll(songTitleArrList);
    }

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        System.out.println("pre-load Songs");
        loadSongs();

    }

    @FXML
    private void searchButtonClick() {
        String selectedSong = songSearch.getText().toLowerCase();

        if (songs != null && !songs.isEmpty()) {
            for (Song song : songs) {
                if (song.getTitle().toLowerCase().contains(selectedSong)) {
                    System.out.println("Song Title: " + song.getTitle() + ", Artist: " +
                            song.getArtist());
                }
            }
        }
    }
}