package com.model;

public enum Accidentals {
    FLAT("B"),
    NATURAL("N"),
    SHARP("#"),
    B("B"),
    N("N"),
    S("#");

    private final String symbol;

    Accidentals(String symbol) {
        this.symbol = symbol;
    }

    public String getSymbol() {
        return symbol;
    }
}