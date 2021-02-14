package com.bean;

public class Train {
    private String ID;
    private String seat;
    private String remain;
    private String type;
    public String getID(){
        return ID;
    }

    public String getSeat(){
        return seat;
    }

    public String getRemain(){
        return remain;
    }

    public String getType(){
        return type;
    }

    public void setID(String ID){
        this.ID = ID;
    }

    public void setRemain(String remain) {
        this.remain = remain;
    }

    public void setSeat(String seat) {
        this.seat = seat;
    }

    public void setType(String type) {
        this.type = type;
    }
}
