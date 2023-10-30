package com.example.prototype;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.scene.paint.Color;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import javafx.event.ActionEvent;


public class Login {



        @FXML
        private TextField usernameField;

        @FXML
        private PasswordField passwordField;

        @FXML
        private Button loginButton;

        @FXML
        private Text loginStatusText;

        @FXML
        private void onLoginButtonClick(ActionEvent event) {
            String username = usernameField.getText();
            String password = passwordField.getText();

            if (authenticate(username, password)) {
                loginStatusText.setFill(Color.GREEN);
                loginStatusText.setText("Login successful!");
            } else {
                loginStatusText.setFill(Color.RED);
                loginStatusText.setText("Login failed. Please check your username and password.");
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
    }



