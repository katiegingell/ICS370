package com.example.prototype;

import javafx.scene.control.Button;

import java.io.Serializable;

public class Flight implements Serializable {
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




}




