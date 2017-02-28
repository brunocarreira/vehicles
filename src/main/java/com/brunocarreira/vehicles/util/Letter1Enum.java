package com.brunocarreira.vehicles.util;

/*
 * @Author:	Bruno Carreira
 * 
 * Enum used to store static data
 * Letter 1 - Car Type 
 * */
public enum Letter1Enum {
    M("Mini"),
    E("Economy"),
    C("Compact"),
    I("Intermediate"),
    S("Standard"),
    F("Full size"),
    P("Premium"),
    L("Luxury"),
    X("Special");

    private String value;

    Letter1Enum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}