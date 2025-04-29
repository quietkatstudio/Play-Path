package com.frost_byte;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javax.swing.event.ChangeListener;

import com.model.DataLoader;
import com.model.Lesson;
import com.model.LessonList;

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

public class LessonsController implements Initializable {

    private PrimaryController primaryController;

    // @FXML
    // private StackPane contentPane;

    public void setPrimaryController(PrimaryController controller) {
        this.primaryController = controller;
    }

    // @FXML
    // private void showSongPlayer(Song currentSong) {
    // if (primaryController != null)
    // primaryController.showSongPlayer(currentSong);
    // }

    private ArrayList<String> LessonTitleArrList = new ArrayList<String>();

    @FXML
    private ListView<String> listViewLessons;

    public Lesson currentLesson;
    // private ListView<Song> songList;
    // @FXML
    // private TextField songSearch;

    // private void playSong(Song currentSong) {
    // if (currentSong != null) {
    // SongList.getInstance().playSong(currentSong); // Play the selected song using
    // SongList
    // }
    // }

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {

        ArrayList<Lesson> lessonArrayList = DataLoader.getLessons();
        System.out.println("unfilled Lesson arraylist \\n");
        System.out.println(lessonArrayList.get(0).getTitle());

        for (Lesson lesson : lessonArrayList) {
            // songTitleArrList.add(song.getTitle());
            LessonTitleArrList.add(lesson.getTitle() + "\n -------------------------------------------");
            System.out.println("Added: " + lesson.getTitle());
        }

        listViewLessons.getItems().addAll(LessonTitleArrList);

        listViewLessons.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue != null) {
                currentLesson = LessonList.getInstance().getLessonByTitle(newValue.split("\n")[0]);
                // showSongPlayer(currentLesson);
                // playSong(currentSong);
                System.out.println("Selected lesson: " + newValue);
            }
        });

    }

}