package com.brunocarreira.vehicles.util;

/*
 * @Author:	Bruno Carreira
 * 
 * Enum used to store static data
 * Letter 2 - Doors/Car Type 
 * */
public enum Letter2Enum {
    B("2 doors"),
    C("4 doors"),
    D("5 doors"),
    W("Estate"),
    T("Convertible"),
    F("SUV"),
    P("Pick up"),
    V("Passenger Van");

    private String value;

    Letter2Enum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}