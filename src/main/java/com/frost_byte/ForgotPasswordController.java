package com.frost_byte;

import java.io.IOException;

import com.model.MusicApplication;
import com.model.User;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
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
   private Label errorLabel;

   @FXML
   private User currentUser;

   @FXML
   private void handleUsernameNext(){
        String username = usernameText.getText().trim();
        if(username.isEmpty()){
            errorLabel.setText("Please enter your username.");
            return;
        }
        currentUser = facade.getUserByUsername(username);
        if(currentUser == null){

            errorLabel.setText("username not found");
            return;
        }
   }

   @FXML
   private void handleSubmitNewPassword(){
    if(currentUser == null){
        errorLabel.setText("please enter your username first.");
        return;
    }
    String answer = answerText.getText().trim();
    String newPassword = newPasswordText.getText();

    if(answer.isEmpty() || newPassword.isEmpty()){
        errorLabel.setText("please answer the question and enter a new password");
        return;
    }
    if (currentUser.checkSecurityAnswer(answer)){
        currentUser.setPassword(newPassword);
        facade.updateUser(currentUser);

        Alert alert = new Alert(AlertType.INFORMATION);

        alert.setTitle("password reset successful");
        alert.setHeaderText(null);
        alert.setContentText("your password has been updated. you can now login");
        alert.showAndWait();

        try {
            App.setRoot("login");
            
        } catch (IOException e) {
            e.printStackTrace();
        }


    }else{
        errorLabel.setText("incorrect answer. try again.");
    }

   }
    @FXML
    private void handleSubmitAnswer(){
        String username = usernameText.getText();
        String answer = answerText.getText();
        User user = facade.getUserByUsername(username);
        if(user == null){
            errorLabel.setText("username not found");
            return;
        }
        if(user.getSecurityQuestion().equalsIgnoreCase(answer)){
            errorLabel.setText("incorrect answer");
        }
    }

    @FXML
    private void switchToLogin() throws IOException {
        App.setRoot("login"); // make sure this matches your login FXML filename
    }
}
