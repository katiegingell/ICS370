package com.example.demo;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.net.URL;
import java.util.ResourceBundle;

public class PaymentController implements Initializable {

    @FXML
    public Button checkoutButton;

    @FXML
    private Button goBackButton;

    @FXML
    private Button logoutButton;

    @FXML
    private Text confirmationNumberText;

    private ConfirmationNumberGenerator confirmationNumberGenerator = new ConfirmationNumberGenerator();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }


    public void onCheckOutClick(ActionEvent actionEvent) throws IOException {
        if (UserRepo.selectedFlight != null) {
            UserRepo.currentUser.getBookFlights().add(UserRepo.selectedFlight);
            FXMLLoader fxmlLoader = new FXMLLoader(HomeApplication.class.getResource("PaymentConfirmation.fxml"));
            Scene scene = new Scene(fxmlLoader.load(), 700, 500);

            ((Stage) goBackButton.getScene().getWindow()).setScene(scene);

        }
    }


    private void loadFlightsScene() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HomeApplication.class.getResource("Use Case 2.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 700, 500);

        ((Stage) goBackButton.getScene().getWindow()).setScene(scene);
    }

    public void onGoBackClick(ActionEvent actionEvent) throws IOException {
        loadFlightsScene();
    }

    private void loadLoginScene() throws IOException {

        FXMLLoader fxmlLoader = new FXMLLoader(HomeApplication.class.getResource("Home.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 700, 500);

        ((Stage) logoutButton.getScene().getWindow()).setScene(scene);
    }
    @FXML
    public void onLogoutButtonClick(ActionEvent actionEvent) throws IOException {
        loadLoginScene();
    }
}