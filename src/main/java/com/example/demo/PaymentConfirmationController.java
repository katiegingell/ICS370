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
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ResourceBundle;

public class PaymentConfirmationController implements Initializable  {

    @FXML
    private Button goBackButton;

    @FXML
    private Button logoutButton;

    @FXML
    private Text confirmationNumberText;

    private ConfirmationNumberGenerator confirmationNumberGenerator = new ConfirmationNumberGenerator();

    private void generateAndSetConfirmationNumber() {
        // Generate a random confirmation number
        String confirmationNumber = confirmationNumberGenerator.generateConfirmationNumber();

        // Set the confirmation number on the UI
        confirmationNumberText.setText("Confirmation Number: " + confirmationNumber);
    }

    private void loadFlightsScene() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HomeApplication.class.getResource("FlightSearch.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 700, 500);

        ((Stage) goBackButton.getScene().getWindow()).setScene(scene);
    }
    public void onGoBackClick(ActionEvent actionEvent) throws IOException {
        loadFlightsScene();
    }
    private void loadLoginScene() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HomeApplication.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 700, 500);

        ((Stage) logoutButton.getScene().getWindow()).setScene(scene);
    }

    @FXML
    public void onLogoutButtonClick(ActionEvent actionEvent) throws IOException {
        loadLoginScene();
    }

    private void serializeUser(User user) {
        try (ObjectOutputStream oos = new ObjectOutputStream(
                Files.newOutputStream(Paths.get(user.getUsername())))) {
            oos.writeObject(user);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        // Serialize the user
        serializeUser(UserRepo.currentUser);

        UserRepo.selectedFlight = null;

        generateAndSetConfirmationNumber();
    }
}
