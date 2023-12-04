package com.example.demo;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;


public class SignUpController implements Initializable {
    @FXML
    private TextField signUpUsernameField;
    @FXML
    private PasswordField signUpPasswordField;
    @FXML
    private PasswordField confirmPasswordField;
    @FXML
    private Button signUpButton;
    @FXML
    private Button goBackButton;
    @FXML
    private Label signUpStatusLabel;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
    }

    @FXML
    public void onCreateAccountClick(ActionEvent actionEvent) throws IOException {
        String username = signUpUsernameField.getText();
        String password = signUpPasswordField.getText();
        String confirmPassword = confirmPasswordField.getText();

        if (!password.equals(confirmPassword)) {
            signUpStatusLabel.setText("Passwords do not match. Please try again.");
            return;
        }

        if (createAccount(username, password)) {

            loadFlightsScene();
        } else {
            signUpStatusLabel.setText("Failed to create an account. Please choose a different username.");
        }
    }
    private void loadFlightsScene() throws IOException {

        FXMLLoader fxmlLoader = new FXMLLoader(HomeApplication.class.getResource("FlightSearch.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 700, 500);

        ((Stage) signUpButton.getScene().getWindow()).setScene(scene);

    }

    private void loadHomeScene() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HomeApplication.class.getResource("Home.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 700, 500);

        ((Stage) goBackButton.getScene().getWindow()).setScene(scene);
    }
    public void onGoBackClick(ActionEvent actionEvent) throws IOException {
        loadHomeScene();
    }

    private boolean createAccount(String username, String password) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("Logins.txt", true))) {
            // Check if the username already exists
            if (PasswordUtils.getUserFromFile(username) != null) {
                return false;
            }

            // Append the new username and password to Logins.txt
            writer.write(username + "," + password);
            writer.newLine();

            // Create a new user and save it to a file
            User newUser = new User(username, null);
            PasswordUtils.saveUserToFile(newUser);
            UserRepo.currentUser = newUser;

            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }
}
