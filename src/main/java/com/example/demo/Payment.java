package com.example.demo;

public class Payment {

    private int ID;
    private String name;
    private int creditCardNumber;
    private float amount;


    public Payment(int ID, String name, int creditCardNumber, float amount) {
        this.ID = ID;
        this.name = name;
        this.creditCardNumber = creditCardNumber;
        this.amount = amount;
    }


    public int getID() {
        return ID;
    }

    public String getName() {
        return name;
    }

    public int getCreditCardNumber() {

        return creditCardNumber;
    }

    public float getAmount() {

        return amount;
    }


}

