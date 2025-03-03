package com.model;

public class TimeSig {
    private int TopNum;
    private int BotNum;

    public TimeSig(int TopNum, int BotNum) {
        this.TopNum = TopNum;
        this.BotNum = BotNum;
    }

    private int setTopNum(int topNum) {
        this.TopNum = topNum;
        return this.TopNum;
    }

    private int setBotNum(int botNum) {
        this.BotNum = botNum;
        return this.BotNum;
    }

    private int getTopNum() {
        return this.TopNum;
    }

    private int getBotNum() {
        return this.BotNum;
    }
}