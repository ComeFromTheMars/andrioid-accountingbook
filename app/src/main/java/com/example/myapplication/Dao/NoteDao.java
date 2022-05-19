package com.example.myapplication.Dao;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.myapplication.Model.Note;

import java.util.ArrayList;
import java.util.List;

public class NoteDao {
    DataBase db;
    public NoteDao(Context context){
        db=new DataBase(context,"inf1.db",null,1);
    }
    public List find(){
        SQLiteDatabase database = db.getReadableDatabase();
        List<Note> list=new ArrayList<Note>();
        String sql="select * from tb_note;";
        Cursor cursor = database.rawQuery(sql,null);
        while (cursor.moveToNext()) {
            Note in =new Note(cursor.getInt(1),cursor.getString(0));
            list.add(in);
        }
        return list;
    };

    public void update(Note note){
        SQLiteDatabase database = db.getWritableDatabase();
        String sql="";
        sql="update tb_note set connet ='"+note.getConnet()+"' where id="+note.getId()+";";
        database.execSQL(sql);
        database.close();
    };
    public void delete(int id ){
        String sql="DELETE FROM tb_note WHERE  id= "+id+";";
        SQLiteDatabase database = db.getWritableDatabase();
        database.execSQL(sql);
        database.close();
    };
    public void insert(Note note){
        String sql="insert into  tb_note ('connet') values ('"+ note.getConnet()+"')";
        SQLiteDatabase database = db.getWritableDatabase();
        database.execSQL(sql);
        database.close();
    };
}
