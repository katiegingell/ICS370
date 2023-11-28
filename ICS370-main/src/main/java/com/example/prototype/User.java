package com.example.prototype;

import java.io.Serializable;
import java.util.List;

public class User implements Serializable {
    private String username;
    private List<Flight> bookFlights;


    public User (String username, List<Flight> bookFlights) {

        this.username = username;
        this.bookFlights = bookFlights;


    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public List<Flight> getBookFlights() {
        return bookFlights;
    }

    public void setBookFlights(List<Flight> bookFlights) {
        this.bookFlights = bookFlights;
    }
    //add getters and setters



}
