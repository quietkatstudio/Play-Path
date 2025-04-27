package com.model;

public class ChooseInstrument {
    private Instruments currentInstrument;

    public ChooseInstrument(Instruments chosenInstrument) {
        this.currentInstrument = chosenInstrument;
    }

    public Instruments setInstrument(Instruments chosenInstrument) {
        this.currentInstrument = chosenInstrument;
        return this.currentInstrument;
    }

    public Instruments getInstrument() {
        return this.currentInstrument;
    }
}
