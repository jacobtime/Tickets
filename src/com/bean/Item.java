package com.bean;

public class Item {
    private String ID;
    private String type;
    private String start_time;
    private String end_time;
    private int remain;
    private int cost;
    private int time;

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public int getCost() {
        return cost;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getID() {
        return ID;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setRemain(int remain) {
        this.remain = remain;
    }

    public int getRemain() {
        return remain;
    }

    public String getEnd_time() {
        return end_time;
    }

    public String getStart_time() {
        return start_time;
    }

    public String getType() {
        return type;
    }

    public void setEnd_time(String end_time) {
        this.end_time = end_time;
    }

    public void setStart_time(String start_time) {
        this.start_time = start_time;
    }
}
