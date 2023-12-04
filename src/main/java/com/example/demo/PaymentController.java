package com.example.demo;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
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
    private TextField cardNumberField;

    @FXML
    private TextField expirationDateField;

    @FXML
    private TextField cvvNumberField;

    @FXML
    private TextField nameOnCardField;

    @FXML
    private Text paymentStatusText;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    public static void savePaymentToFile(Payment payment) {
        try {
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(payment.getName()));
            oos.writeObject(payment);
            oos.close();
        } catch(IOException e){
            throw new RuntimeException(e);
        }
    }

    public void onCheckOutClick(ActionEvent actionEvent) throws IOException {
        String nameOnCard = nameOnCardField.getText();
        String cardNumber = cardNumberField.getText();
        String expirationDate = expirationDateField.getText();
        String cvvNumber = cvvNumberField.getText();

        if (nameOnCard.isEmpty() || cardNumber.isEmpty() || expirationDate.isEmpty() || cvvNumber.isEmpty()){
            paymentStatusText.setText("Required field(s) empty");
        } else {
            Long cardNumberLong = Long.valueOf(cardNumber);
            int cvvNumberInt = Integer.parseInt(cvvNumber);
            Payment payment = new Payment(nameOnCard, cardNumberLong, expirationDate, cvvNumberInt, UserRepo.selectedFlight.getPrice());
            if (UserRepo.selectedFlight != null) {
                savePaymentToFile(payment);
                UserRepo.currentUser.getBookFlights().add(UserRepo.selectedFlight);

                FXMLLoader fxmlLoader = new FXMLLoader(HomeApplication.class.getResource("PaymentConfirmation.fxml"));
                Scene scene = new Scene(fxmlLoader.load(), 700, 500);

                ((Stage) goBackButton.getScene().getWindow()).setScene(scene);
        }

        }
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

        FXMLLoader fxmlLoader = new FXMLLoader(HomeApplication.class.getResource("Home.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 700, 500);

        ((Stage) logoutButton.getScene().getWindow()).setScene(scene);
    }
    @FXML
    public void onLogoutButtonClick(ActionEvent actionEvent) throws IOException {
        loadLoginScene();
    }
}