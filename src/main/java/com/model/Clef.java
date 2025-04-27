package com.model;

public class Clef {
    private ClefType clef;

    public Clef(ClefType clef) {
        this.clef = clef;
    }

    public ClefType setClef(ClefType clef) {
        this.clef = clef;
        return this.clef;
    }

    public ClefType getClef() {
        return this.clef;
    }
}
