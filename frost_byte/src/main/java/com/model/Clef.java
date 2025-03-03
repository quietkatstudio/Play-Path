package com.model;

public class Clef {
    private ClefType clef;

    public Clef(ClefType clef) {
        this.clef = clef;
    }

    private ClefType setClef(ClefType clef) {
        this.clef = clef;
        return this.clef;
    }

    private ClefType getClef() {
        return this.clef;
    }
}
