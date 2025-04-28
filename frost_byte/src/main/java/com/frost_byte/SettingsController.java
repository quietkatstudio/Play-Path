package com.frost_byte;

import java.io.IOException;

import com.model.DataWriter;
import com.model.User;
import com.model.UserList;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;

public class SettingsController {

    private PrimaryController primary;

    // --- Change Username Fields ---
    @FXML private TextField oldUsernameField1;
    @FXML private PasswordField oldPasswordField1;
    @FXML private TextField newUsernameField;

    // --- Change Password Fields ---
    @FXML private TextField usernameField2;
    @FXML private PasswordField oldPasswordField2;
    @FXML private PasswordField newPasswordField;

    // --- Delete Account Fields ---
    @FXML private TextField usernameField3;
    @FXML private PasswordField passwordField3;

    // --- Buttons ---
    @FXML private Button changeUsernameButton;
    @FXML private Button changePasswordButton;
    @FXML private Button deleteAccountButton;
    @FXML private Button backButton;

    /** Let PrimaryController inject itself so we can navigate back home */
    public void setPrimaryController(PrimaryController controller) {
        this.primary = controller;
    }

    @FXML
    private void initialize() {
        // nothing to preload
    }

    /** Handle “Change Username” */
    @FXML
    private void handleChangeUsername(ActionEvent ev) {
        String oldU = oldUsernameField1.getText().trim();
        String oldP = oldPasswordField1.getText().trim();
        String newU = newUsernameField.getText().trim();
        UserList ul = UserList.getInstance();

        if (!ul.login(oldU, oldP)) {
            alertError("Incorrect credentials for user “" + oldU + "”.");
            return;
        }
        if (ul.getUser(newU) != null) {
            alertError("Username “" + newU + "” is already taken.");
            return;
        }
        User oldUser = ul.getUser(oldU);
        // remove old and add new with same ID & data
        ul.getUsers().remove(oldUser);
        User newUser = new User(
            oldUser.getID(),
            newU,
            oldUser.getFirstName(),
            oldUser.getLastName(),
            oldUser.getEmail(),
            oldUser.getPassword(),
            oldUser.getIsTeacher()
        );
        ul.getUsers().add(newUser);
        ul.saveUsers();
        alertInfo("Username changed to “" + newU + "”.\nPlease login again.");
        // go back to login screen
        try { App.setRoot("login"); }
        catch (IOException e) { e.printStackTrace(); }
    }

    /** Handle “Change Password” */
    @FXML
    private void handleChangePassword(ActionEvent ev) {
        String u = usernameField2.getText().trim();
        String oldP = oldPasswordField2.getText().trim();
        String newP = newPasswordField.getText().trim();
        UserList ul = UserList.getInstance();

        if (!ul.login(u, oldP)) {
            alertError("Incorrect credentials for user “" + u + "”.");
            return;
        }
        User user = ul.getUser(u);
        ul.getUsers().remove(user);
        User newUser = new User(
            user.getID(),
            user.getUserName(),
            user.getFirstName(),
            user.getLastName(),
            user.getEmail(),
            newP,
            user.getIsTeacher()
        );
        ul.getUsers().add(newUser);
        ul.saveUsers();
        alertInfo("Password changed for user “" + u + "”.\nPlease login again.");
        try { App.setRoot("login"); }
        catch (IOException e) { e.printStackTrace(); }
    }

    /** Handle “Delete Account” */
    @FXML
    private void handleDeleteAccount(ActionEvent ev) {
        String u = usernameField3.getText().trim();
        String p = passwordField3.getText().trim();
        UserList ul = UserList.getInstance();

        if (!ul.login(u, p)) {
            alertError("Incorrect credentials for user “" + u + "”.");
            return;
        }
        User user = ul.getUser(u);
        ul.getUsers().remove(user);
        ul.saveUsers();
        alertInfo("Account “" + u + "” deleted.");
        try { App.setRoot("login"); }
        catch (IOException e) { e.printStackTrace(); }
    }

    /** Back to Home */
    @FXML
    private void handleBack(ActionEvent ev) {
        if (primary != null) primary.showHome();
    }

    /** Helpers to show alerts */
    private void alertError(String msg) {
        Alert a = new Alert(AlertType.ERROR);
        a.setTitle("Error");
        a.setHeaderText(null);
        a.setContentText(msg);
        a.showAndWait();
    }

    private void alertInfo(String msg) {
        Alert a = new Alert(AlertType.INFORMATION);
        a.setTitle("Success");
        a.setHeaderText(null);
        a.setContentText(msg);
        a.showAndWait();
    }
}
