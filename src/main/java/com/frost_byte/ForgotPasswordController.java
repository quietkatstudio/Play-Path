package com.frost_byte;

import java.io.IOException;

import com.model.MusicApplication;
import com.model.User;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class ForgotPasswordController {

    private MusicApplication facade = new MusicApplication();

    @FXML
    private TextField usernameText;

    @FXML
    private Label securityQuestionLabel;

    @FXML
    private TextField answerText;

    @FXML
    private PasswordField newPasswordText;

    @FXML
    private Button submitButton;

    @FXML
    private Button submitNewPasswordButton;

    @FXML
    private Label errorLabel;

    private User currentUser;

    @FXML
    private void initialize() {
        // Only username visible at first
        securityQuestionLabel.setVisible(false);
        answerText.setVisible(false);
        submitButton.setVisible(false);
        newPasswordText.setVisible(false);
        submitNewPasswordButton.setVisible(false);

        usernameText.setOnAction(e -> handleUsernameNext());
    }

    @FXML
    private void handleUsernameNext() {
        String username = usernameText.getText().trim();
        if (username.isEmpty()) {
            errorLabel.setText("Please enter your username.");
            return;
        }

        currentUser = facade.getUserByUsername(username);
        if (currentUser == null) {
            errorLabel.setText("Username not found.");
            return;
        }

        // Show security question and answer input
        securityQuestionLabel.setText(currentUser.getSecurityQuestion());
        securityQuestionLabel.setVisible(true);
        answerText.setVisible(true);
        submitButton.setVisible(true);
        errorLabel.setText("");
    }

    @FXML
    private void handleSubmitAnswer() {
        if (currentUser == null) {
            errorLabel.setText("Please enter your username first.");
            return;
        }

        String answer = answerText.getText().trim();
        if (answer.isEmpty()) {
            errorLabel.setText("Please enter your answer.");
            return;
        }

        if (currentUser.checkSecurityAnswer(answer)) {
            errorLabel.setText("Correct answer! You may now enter a new password.");
            newPasswordText.setVisible(true);
            submitNewPasswordButton.setVisible(true);
        } else {
            errorLabel.setText("Incorrect answer. Try again.");
        }
    }

    @FXML
    private void handleSubmitNewPassword() {
        if (currentUser == null) {
            errorLabel.setText("Please complete the security question first.");
            return;
        }

        String newPassword = newPasswordText.getText().trim();
        if (newPassword.isEmpty()) {
            errorLabel.setText("Please enter a new password.");
            return;
        }

        currentUser.setPassword(newPassword);
        facade.updateUser(currentUser);
        errorLabel.setText("Password updated successfully!");

        try {
            App.setRoot("login");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void switchToLogin() throws IOException {
        App.setRoot("login");
    }
}
