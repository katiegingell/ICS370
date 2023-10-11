package com.example.prototype;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class SearchController {
    @FXML
    private TableView<Flight> flights;
    private ObservableList<Flight> flightData;

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
}
