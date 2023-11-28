package com.example.prototype;

import com.example.prototype.Flight;
import com.example.prototype.User;

import java.util.ArrayList;
import java.util.List;

    public class UnitTest {

        public static void main(String[] args) {
            testUserConstructor();
        }

        public static void testUserConstructor() {
            String username = "testUser";
            List<Flight> bookFlights = new ArrayList<>();

            User user = new User(username, bookFlights);


            assert user != null : "User object should not be null";


            assert username.equals(user.getUsername()) : "Username should match";


            assert bookFlights.equals(user.getBookFlights()) : "Booked flights should match";
        }
    }

