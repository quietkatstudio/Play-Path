package com.model;

import org.json.simple.JSONObject;

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

    public Keys setKeySig(Keys keySig) {
        this.keySig = keySig;
        return this.keySig;
    }

    public String setDefPitchA(String defPitchA) {
        this.defPitchA = defPitchA;
        return this.defPitchA;
    }

    public String setDefPitchB(String defPitchB) {
        this.defPitchB = defPitchB;
        return this.defPitchB;
    }

    public String setDefPitchC(String defPitchC) {
        this.defPitchC = defPitchC;
        return this.defPitchC;
    }

    public String setDefPitchD(String defPitchD) {
        this.defPitchD = defPitchD;
        return this.defPitchD;
    }

    public String setDefPitchE(String defPitchE) {
        this.defPitchE = defPitchE;
        return this.defPitchE;
    }

    public String setDefPitchF(String defPitchF) {
        this.defPitchF = defPitchF;
        return this.defPitchF;
    }

    public String setDefPitchG(String defPitchG) {
        this.defPitchG = defPitchG;
        return this.defPitchG;
    }

    public Keys getKeySig() {
        return this.keySig;
    }

    public String getDefPitchA() {
        return this.defPitchA;
    }

    public String getDefPitchB() {
        return this.defPitchB;
    }

    public String getDefPitchC() {
        return this.defPitchC;
    }

    public String getDefPitchD() {
        return this.defPitchD;
    }

    public String getDefPitchE() {
        return this.defPitchE;
    }

    public String getDefPitchF() {
        return this.defPitchF;
    }

    public String getDefPitchG() {
        return this.defPitchG;
    }

    public KeySig(JSONObject jsonKeySig) {
        this.keySig = Keys.valueOf((String) jsonKeySig.get("keySig"));
        this.defPitchA = (String) jsonKeySig.get("defPitchA");
        this.defPitchB = (String) jsonKeySig.get("defPitchB");
        this.defPitchC = (String) jsonKeySig.get("defPitchC");
        this.defPitchD = (String) jsonKeySig.get("defPitchD");
        this.defPitchE = (String) jsonKeySig.get("defPitchE");
        this.defPitchF = (String) jsonKeySig.get("defPitchF");
        this.defPitchG = (String) jsonKeySig.get("defPitchG");
    }
}
