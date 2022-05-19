package com.example.myapplication.Model;

public class Outcome {
    private double number;
    private  int id;
    private String comment;
    private String position;

    private String date;
    private String kind;
    public Outcome(int number,int id ,String date,String kind) {
        this.number = number;
        this.id=id;
        this.date=date;
        this.kind=kind;
    }
    public Outcome(double number,int id ,String date,String kind,String comment,String position) {
        this.number = number;
        this.id=id;
        this.date=date;
        this.position=position;
        this.comment=comment;
        this.kind=kind;
    }

    public int getId() {
        return id;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public void setId(int id) {
        this.id = id;
    }


    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public double getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }
    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }
}
