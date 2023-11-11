package com.example.prototype;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class SearchController implements Initializable {
    @FXML
    public Button BookNowButton;
    @FXML
    private TableView<Flight> flights;
    private ObservableList<Flight> flightData;

    @FXML
    private Button logoutButton;

    public void search() {

        flightData = FXCollections.observableArrayList(Flight.getFlights());

        //add the data to the table (See below)
        flights.setItems(flightData);

        //make columns
        TableColumn<Flight,String> destination = new TableColumn<>("Destination");
        destination.setCellValueFactory(new PropertyValueFactory("Destination"));
        TableColumn<Flight,Float> priceCol = new TableColumn<>("Price");
        priceCol.setCellValueFactory(new PropertyValueFactory("Price"));


        flights.getColumns().setAll(destination,priceCol);
    }
    private void loadPaymentsScene() throws IOException {

        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Make a Payment.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 700, 500);


        ((Stage) flights.getScene().getWindow()).setScene(scene);

    }
    public void onBookNowButtonClick(ActionEvent actionEvent) throws IOException {

       UserRepo.selectedFlight = flights.getSelectionModel().getSelectedItem();

        loadPaymentsScene();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        flightData = FXCollections.observableArrayList(UserRepo.currentUser.getBookFlights());
        flights.setItems(flightData);

        //make columns
        TableColumn<Flight,String> destination = new TableColumn<>("Destination");
        destination.setCellValueFactory(new PropertyValueFactory("Destination"));
        TableColumn<Flight,Float> priceCol = new TableColumn<>("Price");
        priceCol.setCellValueFactory(new PropertyValueFactory("Price"));


        flights.getColumns().setAll(destination,priceCol);
    }

    private void loadLoginScene() throws IOException {

        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 700, 500);

        ((Stage) logoutButton.getScene().getWindow()).setScene(scene);

    }
    @FXML
    public void onLogoutButtonClick(ActionEvent actionEvent) throws IOException {
        loadLoginScene();
    }
}
