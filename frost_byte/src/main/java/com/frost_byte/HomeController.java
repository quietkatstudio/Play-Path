package com.frost_byte;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import java.util.ArrayList;

import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;

public class HomeController {
    private PrimaryController primaryController;

    private ArrayList<String> screenHistory = new ArrayList<>();

    @FXML
    private StackPane contentPane;

    @FXML
    private Text TEMP_TITLE;

    public void setPrimaryController(PrimaryController controller) {
        this.primaryController = controller;
    }

    @FXML
    private Button classesButton;

    @FXML
    private Button lessonsButton;

    @FXML
    private Button logoutButton;

    @FXML
    private Button playButton;

    @FXML
    private void showMusicStudio() {
        loadView("musicStudio.fxml");
        TEMP_TITLE.setText("Music Studio");
        screenHistory.add("musicStudio.fxml");

    }

    @FXML
    public void showLessons() {
        loadView("lessons.fxml");
        TEMP_TITLE.setText("Lessons");
        screenHistory.add("lessons.fxml");

    }

    @FXML
    private void showPlaylist() {
        loadView("playlist.fxml");
        TEMP_TITLE.setText("Playlist");
        screenHistory.add("playlist.fxml");
    }

    @FXML
    private void showClasses() {
        loadView("classes.fxml");
        TEMP_TITLE.setText("Classes");
        screenHistory.add("classes.fxml");
    }

    @FXML
    private Label playsongTxt;

    @FXML
    private Label playsongTxt1;

    @FXML
    private Label playsongTxt11;

    @FXML
    private Label playsongTxt12;

    @FXML
    private Button studioButton;

    @FXML
    void goToPlayList(ActionEvent event) {

    }

    @FXML
    void switchToLessons(ActionEvent event) throws IOException {
        // PrimaryController.showLessons();
        // PrimaryController.showLessons();
    }

    @FXML
    private void loadView(String fxmlFile) {
        try {
            Node view = FXMLLoader.load(getClass().getResource(fxmlFile));
            contentPane.getChildren().setAll(view);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}