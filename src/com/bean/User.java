package com.bean;

public class User {
    private String user;
    private String pass;
    private String sex;
    private String ID_card;
    private boolean is_admin;
    public String getUser(){
        return user;
    }
    public String getPass(){
        return pass;
    }
    public String getSex(){
        return sex;
    }
    public String getID_card(){
        return ID_card;
    }
    public void setUser(String user){
        this.user = user;
    }
    public void setSex(String sex){
        this.sex  = sex;
    }
    public void setID_card(String ID_card){
        this.ID_card = ID_card;
    }
    public void setIs_admin(String is_admin){
        this.is_admin = Boolean.getBoolean(is_admin);
    }

    public void setPass(String pass) {
        this.pass = pass;
    }
}
