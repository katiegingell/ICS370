package com.example.prototype;

import java.util.UUID;


public class ConfirmationNumberGenerator {

        public static String generateConfirmationNumber() {

            UUID uuid = UUID.randomUUID();


            return uuid.toString();
        }
    }


