package com.example.prototype;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class HelloController implements Initializable {


    @FXML
    private TextField usernameField;

    @FXML
    private PasswordField passwordField;

    @FXML
    private Button loginButton;

    @FXML
    private Button BookNowButton;

    @FXML
    private Label loginStatusLabel;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
    }

    @FXML
    public void onLoginButtonClick(ActionEvent actionEvent) throws IOException {
        String username = usernameField.getText();
        String password = passwordField.getText();
        User user = PasswordUtils.authenticate(username,password);

        if (user != null) {
            UserRepo.currentUser = user;
            // If authentication is successful, proceed to the next scene
            loadFlightsScene();
        } else {
            loginStatusLabel.setText("Login failed. Please check your username and password.");
        }
    }




    private void loadFlightsScene() throws IOException {

            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Use Case 2.fxml"));
            Scene scene = new Scene(fxmlLoader.load(), 320, 240);

            ((Stage) loginButton.getScene().getWindow()).setScene(scene);

        }


    public void onCheckOutClick(ActionEvent actionEvent) {

       if (UserRepo.selectedFlight != null) {

           UserRepo.currentUser.getBookFlights().add(UserRepo.selectedFlight);

           PasswordUtils.saveUserToFile(UserRepo.currentUser);

           UserRepo.selectedFlight = null;


       }

    }
}

