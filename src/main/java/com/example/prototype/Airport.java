package com.example.prototype;

public class Airport {

    private String name;

    private String code;

    public String getName() {
        return name;
    }

    public String getCode() {
        return code;
    }

    public Airport(String name, String code) {
        this.name = name;
        this.code = code;
    }
}
