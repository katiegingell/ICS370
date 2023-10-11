package com.example.prototype;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class HelloController implements Initializable {
    @FXML
    private Label welcomeText;

    @FXML
    private Button loginButton;


    public void onLoginButtonClick(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Use Case 2.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 320, 240);

        ((Stage) loginButton.getScene().getWindow()).setScene(scene);

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {


    }
}