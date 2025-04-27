package com.frost_byte;

import java.io.IOException;

import com.model.UserList;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class LoginController {

    private PrimaryController primary;

    @FXML
    private TextField usernameText;
    @FXML
    private PasswordField passwordText;

    public void setPrimaryController(PrimaryController controller) {
        this.primary = controller;

    }

    @FXML
    private void handleLogin() {
        String username = usernameText.getText();
        String password = passwordText.getText();

        if (UserList.getInstance().login(username, password)) {
            try {
                App.setRoot("primary");
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("Invalid username or password.");
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Login Failed");
            alert.setHeaderText("Invalid Username or Password");
            alert.setContentText("The username or password you entered is incorrect.\n Please press OK to try again.");
            alert.showAndWait();
        }
    }
}