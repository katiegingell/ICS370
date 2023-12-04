package com.example.demo;

import java.io.Serializable;

public class Payment implements Serializable {

    private String name;
    private Long creditCardNumber;
    private String expirationDate;
    private int cvvNumber;
    private float amount;


    public Payment(String name, Long creditCardNumber, String expirationDate, int cvvNumber, float amount) {
        this.name = name;
        this.creditCardNumber = creditCardNumber;
        this.expirationDate = expirationDate;
        this.cvvNumber = cvvNumber;
        this.amount = amount;
    }

    public String getName() {
        return name;
    }

    public Long getCreditCardNumber() {

        return creditCardNumber;
    }

    public String getExpirationDate() {
        return expirationDate;
    }

    public int getCvvNumber() {
        return cvvNumber;
    }

    public float getAmount() {

        return amount;
    }


}

