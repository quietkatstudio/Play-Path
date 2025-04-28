package com.frost_byte;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;

public class SettingsController {

    private PrimaryController primary;

    @FXML private TextField titleField;
    @FXML private TextField versionField;
    @FXML private TextField userFileField;
    @FXML private TextField songFileField;
    @FXML private TextField lessonFileField;

    @FXML private Button saveButton;
    @FXML private Button cancelButton;

    private final Properties props = new Properties();
    private static final String PROPERTIES_FILE = "frost_byte/src/main/java/com/model/app.properties";

    /** Called by FXMLLoader after fields are injected */
    @FXML
    private void initialize() {
        loadProperties();
    }

    /** Let PrimaryController inject itself so we can navigate back */
    public void setPrimaryController(PrimaryController controller) {
        this.primary = controller;
    }

    @FXML
    private void handleSave(ActionEvent event) {
        // Update properties from fields
        props.setProperty("app.title", titleField.getText());
        props.setProperty("app.version", versionField.getText());
        props.setProperty("user.file", userFileField.getText());
        props.setProperty("song.file", songFileField.getText());
        props.setProperty("lesson.file", lessonFileField.getText());

        // Persist
        try (FileOutputStream out = new FileOutputStream(PROPERTIES_FILE)) {
            props.store(out, "Application Settings");
            Alert ok = new Alert(AlertType.INFORMATION);
            ok.setTitle("Settings Saved");
            ok.setHeaderText(null);
            ok.setContentText("Your settings have been saved.");
            ok.showAndWait();
            // Navigate back home
            if (primary != null) primary.showHome();
        } catch (IOException e) {
            e.printStackTrace();
            Alert err = new Alert(AlertType.ERROR);
            err.setTitle("Save Failed");
            err.setHeaderText("Could not write settings file.");
            err.setContentText(e.getMessage());
            err.showAndWait();
        }
    }

    @FXML
    private void handleCancel(ActionEvent event) {
        // Simply go back—discard any changes
        if (primary != null) primary.showHome();
    }

    private void loadProperties() {
        try (FileInputStream in = new FileInputStream(PROPERTIES_FILE)) {
            props.load(in);
        } catch (IOException e) {
            // no file? fallback to defaults
            setDefaultProperties();
        }
        // Populate fields
        titleField.setText(props.getProperty("app.title", ""));
        versionField.setText(props.getProperty("app.version", ""));
        userFileField.setText(props.getProperty("user.file", ""));
        songFileField.setText(props.getProperty("song.file", ""));
        lessonFileField.setText(props.getProperty("lesson.file", ""));
    }

    private void setDefaultProperties() {
        props.setProperty("app.title", "Frost Byte Music App");
        props.setProperty("app.version", "1.0");
        props.setProperty("user.file", "json/users.json");
        props.setProperty("song.file", "json/songs.json");
        props.setProperty("lesson.file", "json/lessons.json");
    }
}
