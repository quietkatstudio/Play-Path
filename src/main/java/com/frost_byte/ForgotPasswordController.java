package com.frost_byte;

import com.model.MusicApplication;
import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

/**
 * Controller for the forgot_password.fxml view.
 * Handles the logic for initiating password recovery.
 */
public class ForgotPasswordController {

    @FXML private TextField emailText;
    @FXML private Label errorLabel;

    private MusicApplication facade = new MusicApplication();

    /**
     * Attempts to send a password recovery link to the user's email.
     */
    @FXML
    private void handleSendRecoveryLink() {
        String email = emailText.getText();
        
        if (email.isEmpty() || !email.contains("@")) {
            errorLabel.setText("Error: Please enter a valid email address.");
            return;
        }

        // NOTE: This relies on the MusicApplication facade having a sendRecoveryLink method.
        boolean success = facade.sendRecoveryLink(email);

        if (success) {
             Alert alert = new Alert(AlertType.INFORMATION);
             alert.setTitle("Recovery Sent");
             alert.setHeaderText(null);
             alert.setContentText("If an account exists for that email, recovery instructions have been sent.");
             alert.showAndWait();
        } else {
             // For testing purposes, we use errorLabel. In a final app, this might be a generic message.
             errorLabel.setText("Error processing request. Please try again.");
        }
    }

    /**
     * Switches the view back to the login screen.
     */
    @FXML
    private void switchToLogin() throws IOException {
        App.setRoot("login");
    }
}