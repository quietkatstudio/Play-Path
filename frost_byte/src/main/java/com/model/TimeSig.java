package com.model;

import org.json.simple.JSONObject;

public class TimeSig {
    private int TopNum;
    private int BotNum;

    public TimeSig(int TopNum, int BotNum) {
        this.TopNum = TopNum;
        this.BotNum = BotNum;
    }

    public int setTopNum(int topNum) {
        this.TopNum = topNum;
        return this.TopNum;
    }

    public int setBotNum(int botNum) {
        this.BotNum = botNum;
        return this.BotNum;
    }

    public int getTopNum() {
        return this.TopNum;
    }

    public int getBotNum() {
        return this.BotNum;
    }

    public TimeSig(JSONObject jsonTimeSig) {
        this.TopNum = ((Long) jsonTimeSig.get("TopNum")).intValue();
        this.TopNum = ((Long) jsonTimeSig.get("TopNum")).intValue();
    }
}