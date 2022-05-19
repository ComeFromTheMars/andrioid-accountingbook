package com.example.myapplication.Dao;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import androidx.annotation.Nullable;

public class DataBase extends SQLiteOpenHelper {
    public DataBase(@Nullable Context context, @Nullable String databasename, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, databasename, factory, version);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        //创建表
        String sql="CREATE TABLE \"tb_income\" (\n" +
                "\t`number`\tINTEGER NOT NULL,\n" +
                "\t`id`\tINTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,\n" +
                "\t`time`\tTEXT NOT NULL,\n" +
                "\t`kind`\tTEXT NOT NULL,\n" +
                "\t`position`\tTEXT,\n" +
                "\t`comment`\tINTEGER\n" +
                ")";
        db.execSQL(sql);
        String sql1="CREATE TABLE `tb_note` (\n" +
                "\t`connet`\tTEXT NOT NULL,\n" +
                "\t`id`\tINTEGER NOT NULL PRIMARY KEY AUTOINCREMENT UNIQUE\n" +
                ")";
        db.execSQL(sql1);
        String sql2="CREATE TABLE \"tb_outcome\" (\n" +
                "\t`number`\tINTEGER NOT NULL,\n" +
                "\t`id`\tINTEGER NOT NULL,\n" +
                "\t`time`\tTEXT NOT NULL,\n" +
                "\t`kind`\tTEXT NOT NULL,\n" +
                "\t`position`\tTEXT NOT NULL,\n" +
                "\t`comment`\tTEXT NOT NULL,\n" +
                "\tPRIMARY KEY(id)\n" +
                ")";
        db.execSQL(sql2);
        //创建表
        String sql3="CREATE TABLE `UserList` (\n" +
                "\t`username`\tTEXT NOT NULL,\n" +
                "\t`id`\tINTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,\n" +
                "\t`passw`\tTEXT NOT NULL\n" +
                ")";
        db.execSQL(sql3);
//        String sql4="CREATE TABLE `UserList` (\n" +
//                "\t`username`\tTEXT NOT NULL,\n" +
//                "\t`id`\tINTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,\n" +
//                "\t`passw`\tTEXT NOT NULL\n" +
//                ")";
//        db.execSQL(sql4);
    }
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        onCreate(db);
    }
}
