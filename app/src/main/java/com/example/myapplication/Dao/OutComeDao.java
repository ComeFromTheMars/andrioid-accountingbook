package com.example.myapplication.Dao;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.myapplication.Model.Outcome;

import java.util.ArrayList;
import java.util.List;

public class OutComeDao{
    DataBase db;
    public OutComeDao(Context context){
        db=new DataBase(context,"inf1.db",null,1);
    }
    public List find(){
        SQLiteDatabase database = db.getReadableDatabase();
        List<Outcome> list=new ArrayList<Outcome>();
        String sql="select * from tb_outcome;";
        Cursor cursor = database.rawQuery(sql,null);
        while (cursor.moveToNext()) {
            int id_person = cursor.getInt(1); //获取第一列的值,第一列的索引从0开始
            int n = cursor.getInt(0);//获取第二列的值
            String time= cursor.getString(2);//获取第三列的值
            String kind=cursor.getString(3);
            Outcome in=new Outcome(n,id_person,time,kind);
            in.setComment(cursor.getString(5));
            in.setPosition(cursor.getString(4));
            list.add(in);
        }
        return list;
    };
    public void update(Outcome outcome, String kind){
        SQLiteDatabase database = db.getWritableDatabase();
        String sql="";
        switch (kind){
            case "number":
                sql="update tb_outcome set number ='"+outcome.getNumber()+"' where id="+outcome.getId()+";";
                break;
            case "kind":
                sql="update tb_outcome set  kind ='"+outcome.getKind()+"' where id="+outcome.getId()+";";
                break;
            case "position":
                sql="update tb_outcome set position ='"+outcome.getPosition()+"' where id="+outcome.getId()+";";
                break;
            case "comment":
                sql="update tb_outcome set comment ='"+outcome.getComment()+"' where id="+outcome.getId()+";";
                break;
            case "date":
                sql="update tb_outcome set time ='"+outcome.getDate()+"' where id="+outcome.getId()+";";
                break;
        }
        database.execSQL(sql);
        database.close();
    };
    public void delete(int id){
        String sql="DELETE FROM  tb_outcome WHERE  id= "+id+";";
        SQLiteDatabase database = db.getWritableDatabase();
        database.execSQL(sql);
        database.close();
    };
    public void insert(Outcome outcome){
        String sql="insert into  tb_outcome ('number','time','kind','position','comment') values ('"+ outcome.getNumber()+"','"+outcome.getDate()+"','"+outcome.getKind()+"','"+outcome.getPosition()+"','"+outcome.getComment()+"')";
        SQLiteDatabase database = db.getWritableDatabase();
        database.execSQL(sql);
        database.close();
    };
}
