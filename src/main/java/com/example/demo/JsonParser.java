package com.example.demo;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class JsonParser {

    public List <Flight> parse(String fileName) throws IOException {
        StringBuilder buffer = new StringBuilder();
        for (String line : Files.readAllLines(Path.of(fileName))) {
            buffer.append(line);
        }

        JSONObject object = new JSONObject(buffer.toString());




        return parseFlights(object.getJSONArray("flight_list"));
    }

    private List<Flight> parseFlights(JSONArray flightArray) {
        List<Flight> flights = new ArrayList<>();

        for (Object o : flightArray) {



                JSONObject flight = (JSONObject) o;


                float price = (flight.getFloat("price"));
                String destination = (flight.getString("destination"));
                long date = (flight.getLong("date"));
                Flight newFlight = new Flight(price,destination,date);
                flights.add(newFlight);
            }


        return flights;
    }

    private JSONArray flightsToJsonArray(List<Flight> flights) {
        JSONArray flightArray = new JSONArray();

        JSONArray flightList = new JSONArray();
        for (Flight flight : flights) {
            flightList.put(flightToJson(flight));
        }

        flightArray.put(flightList);

        return flightArray;
    }

    private JSONObject flightToJson(Flight flight) {
        JSONObject jsonFlight = new JSONObject();

        jsonFlight.put("price", flight.getPrice());
        jsonFlight.put("destination", flight.getDestination());
        jsonFlight.put("date", flight.getDate());

        return jsonFlight;
    }
}
