package com.example.prototype;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FlightDatabase {

    private static FlightDatabase instance = null;
    private List <Flight> flights;
    private FlightDatabase() {
        JsonParser parser = new JsonParser();
        try {
            flights = parser.parse("test.json");
        } catch (IOException e) {
            flights = new ArrayList<>();
        }


    }
    public static FlightDatabase getInstance() {
        if (instance == null) {
            instance = new FlightDatabase();

        }
        return instance;
    }

    public List<Flight> getFlights() {
        return flights;
    }
}
