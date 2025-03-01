package com.model;

public class ChooseInstrument {
    private Instruments currentInstrument;

    public ChooseInstrument(Instruments chosenInstrument) {
        this.currentInstrument = chosenInstrument;
    }

    private Instruments setInstrument(Instruments chosenInstrument) {
        this.currentInstrument = chosenInstrument;
        return this.currentInstrument;
    }

    private Instruments getInstrument() {
        return this.currentInstrument;
    }
}
