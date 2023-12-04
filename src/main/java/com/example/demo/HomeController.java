package com.example.demo;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class HomeController implements Initializable {


    @FXML
    private TextField usernameField;

    @FXML
    private PasswordField passwordField;

    @FXML
    private Button loginButton;

    @FXML
    private Label loginStatusLabel;

    @FXML
    private Button createAccountButton;

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

    @FXML
    public void onCreateAccountButtonClick(ActionEvent actionEvent) throws IOException {
        loadSignUpScene();
    }

    private void loadSignUpScene() throws IOException {

        FXMLLoader fxmlLoader = new FXMLLoader(HomeApplication.class.getResource("SignUp.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 700, 500);

        ((Stage) createAccountButton.getScene().getWindow()).setScene(scene);

    }


    private void loadFlightsScene() throws IOException {

        FXMLLoader fxmlLoader = new FXMLLoader(HomeApplication.class.getResource("FlightSearch.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 700, 500);

        ((Stage) loginButton.getScene().getWindow()).setScene(scene);

    }



}