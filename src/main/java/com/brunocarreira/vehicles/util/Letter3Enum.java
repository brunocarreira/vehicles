package com.brunocarreira.vehicles.util;

/*
 * @Author:	Bruno Carreira
 * 
 * Enum used to store static data
 * Letter 3 - Transmission 
 * */
public enum Letter3Enum {
    M("Manual"),
    A("Automatic");

    private String value;

    Letter3Enum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}