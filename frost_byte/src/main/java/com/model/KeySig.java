package com.model;

public class KeySig {
    private Keys keySig;
    private String defPitchA;
    private String defPitchB;
    private String defPitchC;
    private String defPitchD;
    private String defPitchE;
    private String defPitchF;
    private String defPitchG;

    public KeySig(Keys keySig, String defPitchA, String defPitchB, String defPitchC, String defPitchD, String defPitchE,
            String defPitchF, String defPitchG) {
        this.keySig = keySig;
        this.defPitchA = defPitchA;
        this.defPitchB = defPitchB;
        this.defPitchC = defPitchC;
        this.defPitchD = defPitchD;
        this.defPitchE = defPitchE;
        this.defPitchF = defPitchF;
        this.defPitchG = defPitchG;
    }

    private Keys setKeySig(Keys keySig) {
        this.keySig = keySig;
        return this.keySig;
    }

    private String setDefPitchA(String defPitchA) {
        this.defPitchA = defPitchA;
        return this.defPitchA;
    }

    private String setDefPitchB(String defPitchB) {
        this.defPitchB = defPitchB;
        return this.defPitchB;
    }

    private String setDefPitchC(String defPitchC) {
        this.defPitchC = defPitchC;
        return this.defPitchC;
    }

    private String setDefPitchD(String defPitchD) {
        this.defPitchD = defPitchD;
        return this.defPitchD;
    }

    private String setDefPitchE(String defPitchE) {
        this.defPitchE = defPitchE;
        return this.defPitchE;
    }

    private String setDefPitchF(String defPitchF) {
        this.defPitchF = defPitchF;
        return this.defPitchF;
    }

    private String setDefPitchG(String defPitchG) {
        this.defPitchG = defPitchG;
        return this.defPitchG;
    }

    private Keys getKeySig() {
        return this.keySig;
    }

    private String getDefPitchA() {
        return this.defPitchA;
    }

    private String getDefPitchB() {
        return this.defPitchB;
    }

    private String getDefPitchC() {
        return this.defPitchC;
    }

    private String getDefPitchD() {
        return this.defPitchD;
    }

    private String getDefPitchE() {
        return this.defPitchE;
    }

    private String getDefPitchF() {
        return this.defPitchF;
    }

    private String getDefPitchG() {
        return this.defPitchG;
    }
}
