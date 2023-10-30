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

        if (authenticate(username, password)) {
            // If authentication is successful, proceed to the next scene
            loadFlightsScene();
        } else {
            loginStatusLabel.setText("Login failed. Please check your username and password.");
        }
    }

    private boolean authenticate(String username, String password) {
        try (BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\hocke\\IdeaProjects\\Logins.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 2) {
                    String storedUsername = parts[0];
                    String storedPassword = parts[1];
                    if (username.equals(storedUsername) && password.equals(storedPassword)) {
                        return true;
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

    private void loadFlightsScene() throws IOException {

            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Use Case 2.fxml"));
            Scene scene = new Scene(fxmlLoader.load(), 320, 240);

            ((Stage) loginButton.getScene().getWindow()).setScene(scene);

        }



    private void loadPaymentsScene() throws IOException {

        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Make a Payment.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 320, 240);


        ((Stage) BookNowButton.getScene().getWindow()).setScene(scene);

    }

}

