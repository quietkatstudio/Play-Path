package com.frost_byte;

import java.io.IOException;

import com.model.MusicApplication;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class LoginController {

    private PrimaryController primary;

    @FXML
    private TextField usernameText;
    @FXML
    private PasswordField passwordText;

    private MusicApplication facade = new MusicApplication();

    public void setPrimaryController(PrimaryController controller) {
        this.primary = controller;

    }

    @FXML
    private void handleLogin() {
        String username = usernameText.getText();
        String password = passwordText.getText();

        if (facade.login(username, password)) {
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

    @FXML
    private void switchToRegister() throws IOException {
        App.setRoot("register");
    }

    @FXML
    private void switchToForgotPassword() throws IOException {
        App.setRoot("forgot_password");
    }
}