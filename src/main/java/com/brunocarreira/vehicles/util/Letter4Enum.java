package com.brunocarreira.vehicles.util;

/*
 * @Author:	Bruno Carreira
 * 
 * Enum used to store static data
 * Letter 4 - Fuel/Air Cond 
 * */
public enum Letter4Enum {
    N("Petrol/no AC"),
    R("Petrol/AC");

    private String value;

    Letter4Enum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}