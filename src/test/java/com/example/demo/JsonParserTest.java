package com.example.demo;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class JsonParserTest {

    @Test
    void parse() throws IOException {
        JsonParser parser = new JsonParser();

        List<Flight> flights = parser.parse("test.json");

        assertEquals(6, flights.size());

    }

    @Test
    void flightToJson(){
        JsonParser parser = new JsonParser();

        Flight f = new Flight(400, "Portland",1641273599);

        System.out.println(parser.flightToJson(f));

    }
}