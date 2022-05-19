package com.example.myapplication.Model;

public class Note {
    private int id;
    private String connet;

    public Note(int id,String connet) {
        this.id = id;
        this.connet=connet;
    }
    public Note(String connet) {
        this.connet=connet;
    }

    public int getId() {
        return id;
    }

    public String getConnet() {
        return connet;
    }

    public void setConnet(String connet) {
        this.connet = connet;
    }

    public void setId(int id) {
        this.id = id;
    }
}
