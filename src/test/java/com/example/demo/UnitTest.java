package com.example.demo;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import static org.junit.Assert.*;

    public class UnitTest {

        @Test
        public void testUserConstructor() {
            String username = "testUser";
            List<Flight> bookFlights = new ArrayList<>();

            User user = new User(username, bookFlights);

            // username should not be null
            assertNotNull(user.getUsername());

            // username should match
            assertEquals(username,user.getUsername());

            // user flights should match
            assertEquals(bookFlights, user.getBookFlights());
        }
    }

