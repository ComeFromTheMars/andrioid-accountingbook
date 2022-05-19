package com.example.myapplication.Model;

public class User {
    private int id;

    public int getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassw() {
        return passw;
    }

    public void setPassw(String passw) {
        this.passw = passw;
    }

    public void setId(int id) {
        this.id = id;
    }

    private String passw;
    private String username;
}
