package com.bean;

public class State {
    private String ID;
    private int State_ID;
    private int Cost;
    private String State_name;
    private String Arrive_time;

    public String getID() {
        return ID;
    }

    public int getState_ID() {
        return State_ID;
    }

    public int getCost() {
        return Cost;
    }

    public String getState_name() {
        return State_name;
    }

    public String getArrive_time() {
        return Arrive_time;
    }

    public void setState_name(String state_name) {
        State_name = state_name;
    }

    public void setCost(int cost) {
        Cost = cost;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public void setArrive_time(String arrive_time) {
        Arrive_time = arrive_time;
    }

    public void setState_ID(int state_ID) {
        State_ID = state_ID;
    }
}
