package com.bean;

public class Order {
    private String user;
    private String ID;
    private String state_from;
    private String state_to;
    private String from_time;
    private String to_time;
    private int cost;

    public String getUser() {
        return user;
    }

    public String getID() {
        return ID;
    }

    public String getState_from() {
        return state_from;
    }

    public String getState_to() {
        return state_to;
    }

    public String getFrom_time() {
        return from_time;
    }

    public String getTo_time() {
        return to_time;
    }

    public int getCost() {
        return cost;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public void setState_from(String state_from) {
        this.state_from = state_from;
    }

    public void setState_to(String state_to) {
        this.state_to = state_to;
    }

    public void setFrom_time(String from_time) {
        this.from_time = from_time;
    }

    public void setTo_time(String to_time) {
        this.to_time = to_time;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }
}
