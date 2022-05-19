package com.example.myapplication.Model;

import java.io.Serializable;

public class Income  implements Serializable {
    private int number;
    private int id;
    private String kind;
    private String date;
    private String comment;
    private String position;
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    public Income(int number,int id ,String date,String kind,String comment,String position) {
        this.number = number;
        this.id=id;
        this.date=date;
        this.position=position;
        this.comment=comment;
        this.kind=kind;
    }



    public Income(int number,int id ,String date,String kind) {
        this.number = number;
        this.id=id;
        this.date=date;
        this.kind=kind;
    }



    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String toString(){
        return getNumber()+" "+getDate()+" "+getKind()+"";
    }
}
