package com.frost_byte;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class HomeController {
    private PrimaryController primaryController;

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
    void switchToLessons(ActionEvent event) throws IOException{
        //PrimaryController.showLessons();
        //PrimaryController.showLessons();
}
}