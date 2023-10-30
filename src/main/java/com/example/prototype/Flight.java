package com.example.prototype;

import java.util.ArrayList;
import java.util.List;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class Flight {
    private float price;

    private String destination;

    private long date;

    private Button BookNowButton;


    public Flight(float price, String destination, long date) {
        this.price = price;
        this.destination = destination;
        this.date = date;
    }

    public float getPrice() {
        return price;
    }

    public String getDestination() {
        return destination;
    }

    public long getDate() {
        return date;
    }

    public static List <Flight> getFlights() {
        List <Flight> flights = new ArrayList<>();

        flights.add(new Flight(300.0f, "New York", System.currentTimeMillis() + 86400000));
        flights.add(new Flight(250.0f, "Los Angeles", System.currentTimeMillis() + 172800000));
        flights.add(new Flight(150.0f, "Chicago", System.currentTimeMillis() + 259200000));
        flights.add(new Flight(200.0f, "Miami", System.currentTimeMillis() + 345600000));
        flights.add(new Flight(350.0f, "San Francisco", System.currentTimeMillis() + 432000000));



        return flights;




    }
// provide flight mock flight data


}




