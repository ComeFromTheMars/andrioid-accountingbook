package com.example.myapplication.Dao;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class UserDao extends SQLiteOpenHelper {
    Context context;
    public UserDao(@Nullable Context context, @Nullable String databasename, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, databasename, factory, version);
        this.context=context;
    }

    public void onCreate(SQLiteDatabase db) {
        //创建表
        String sql="CREATE TABLE `UserList` (\n" +
                "\t`username`\tTEXT NOT NULL,\n" +
                "\t`id`\tINTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,\n" +
                "\t`passw`\tTEXT NOT NULL\n" +
                ")";
        db.execSQL(sql);
    }

    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        //数据库升级
    }
    public String findPassw(){
        String s="";
        String sql="select * from UserList where id=1";
        SQLiteDatabase database = this.getWritableDatabase();
        Cursor cursor = database.rawQuery(sql,null);
        cursor.moveToFirst();
        s=cursor.getString(2);
        return s;
    }
    public void changePassw(int id,String newPassw){
        SQLiteDatabase database = this.getWritableDatabase();
        //String sql1="insert into UserList('username','id','passw') values('yinyi',1,'123456')";
        String sql="update UserList set passw ='"+newPassw+"' where id="+id+";";
        System.out.println(sql);
        database.execSQL(sql);
        database.close();
    }
}
