package com.example.schiffers.chatting.models;

public class chat {
    String username,message,date;
    int photo;
    public chat(){}
    public chat(Integer ph,String username,String message,String dat){
        this.username=username;
        this.message=message;
        this.date=dat;
        this.photo=ph;
    }
    public String getUsername(){
        return username;
    }
    public void setName(String name) {
        this.username = name;
    }
    public String getMessage(){
        return message;
    }
    public void setMessage(String mess) {
        this.message = mess;
    }
    public String getDate(){
        return date;
    }
    public void setDate(String dat) {
        this.date = dat;
    }
    public int getfoto()
    {
        return photo;
    }
}