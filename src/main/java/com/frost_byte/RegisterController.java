package com.frost_byte;

import java.io.IOException;

import com.model.MusicApplication;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

/**
 * Controller for the register.fxml view.
 * Handles new user registration and navigation back to the login screen.
 */
public class RegisterController {

    @FXML private TextField usernameText;
    @FXML private TextField firstNameText;
    @FXML private TextField lastNameText;
    @FXML private TextField emailText;
    @FXML private PasswordField passwordText;
    @FXML private PasswordField confirmPasswordText;
    @FXML private Label errorLabel;
    @FXML private CheckBox isTeacherCheck; // Assuming you might have a teacher/student option

    // Instance of the application logic facade
    private MusicApplication facade = new MusicApplication();

    /**
     * Handles the Register button press, attempts to register a new user.
     */
    @FXML
    private void handleRegister() {
        String username = usernameText.getText();
        String password = passwordText.getText();
        String confirmPassword = confirmPasswordText.getText();
        String firstName = firstNameText.getText();
        String lastName = lastNameText.getText();
        String email = emailText.getText();
        boolean isTeacher = isTeacherCheck != null && isTeacherCheck.isSelected();
        
        // Basic validation
        if (!password.equals(confirmPassword)) {
            errorLabel.setText("Error: Passwords do not match.");
            return;
        }

        if (username.isEmpty() || password.isEmpty() || firstName.isEmpty() || lastName.isEmpty() || email.isEmpty()) {
            errorLabel.setText("Error: All fields must be filled out.");
            return;
        }

        // Use the Facade to check if the username is available (assuming facade has this method)
        // NOTE: The logic here relies on the actual implementation of MusicApplication.availableUsername 
        // and MusicApplication.register, which depend on the missing UserList class.
        
        // The facade's availableUsername is likely meant to return TRUE if the user EXISTS.
        // Let's assume the facade's availableUsername is TRUE if the user exists (unavailable).
        if (facade.availableUsername(username)) {
             errorLabel.setText("Error: This username is already taken.");
             return;
        }
        
        // Register the user
        facade.register(username, firstName, lastName, email, password, isTeacher);

        // Success message and transition back to login
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("Registration Successful");
        alert.setHeaderText(null);
        alert.setContentText("Your account has been created. Please log in.");
        alert.showAndWait();
        
        try {
            switchToLogin();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Switches the view back to the login screen.
     * This is needed for the "Back to Login" button.
     */
    @FXML
    private void switchToLogin() throws IOException {
        App.setRoot("login");
    }
}