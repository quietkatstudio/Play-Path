package com.model;

public class Tuba {
    private boolean valve1;
    private boolean valve2;
    private boolean valve3;

    public Tuba(boolean valve1, boolean valve2, boolean valve3) {
        this.valve1 = valve1;
        this.valve2 = valve2;
        this.valve3 = valve3;
    }

    private boolean toggleValve1() {
        if(valve1 == false) {
            valve1 = true;
        } else {
            valve1 = false;
        }

        return valve1;
    }

    private boolean toggleValve2() {
        if(valve2 == false) {
            valve2 = true;
        } else {
            valve2 = false;
        }

        return valve2;
    }

    private boolean toggleValve3() {
        if(valve3 == false) {
            valve3 = true;
        } else {
            valve3 = false;
        }

        return valve3;
    }

    private boolean setValve1(boolean valve1) {
        this.valve1 = valve1;
        return this.valve1;
    }

    private boolean setValve2(boolean valve2) {
        this.valve2 = valve2;
        return this.valve2;
    }

    private boolean setValve3(boolean valve3) {
        this.valve3 = valve3;
        return this.valve3;
    }

    private boolean getValve1() {
        return this.valve1;
    }

    private boolean getValve2() {
        return this.valve2;
    }

    private boolean getValve3() {
        return this.valve3;
    }
}
