package com.example.myapplication.Dao;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.myapplication.Model.Income;

import java.util.ArrayList;
import java.util.List;

public class InComeDao {
    public DataBase db;

    public InComeDao(Context context){
        db=new DataBase(context,"inf1.db",null,1);
    }

    public List<Income> find(){
        SQLiteDatabase database = db.getReadableDatabase();
        List<Income> list=new ArrayList<Income>();
        String sql="select * from tb_income;";
        Cursor cursor = database.rawQuery(sql,null);
        while (cursor.moveToNext()) {
            int id_person = cursor.getInt(1); //获取第一列的值,第一列的索引从0开始
            int n = cursor.getInt(0);//获取第二列的值
            String time= cursor.getString(2);//获取第三列的值
            String kind=cursor.getString(3);
            Income in=new Income(n,id_person,time,kind);
            in.setComment(cursor.getString(5));
            in.setPosition(cursor.getString(4));
            list.add(in);
        }
        db.close();
        return list;
    };
    public void update(Income income,String kind){
        SQLiteDatabase database = db.getWritableDatabase();
        String sql="";
        switch (kind){
            case "number":
                sql="update tb_income set number ='"+income.getNumber()+"' where id="+income.getId()+";";
                break;
            case "kind":
                sql="update tb_income set kind ='"+income.getKind()+"' where id="+income.getId()+";";
               break;
            case "position":
                sql="update tb_income set position ='"+income.getPosition()+"' where id="+income.getId()+";";
                break;
            case "comment":
                sql="update tb_income set comment ='"+income.getComment()+"' where id="+income.getId()+";";
                 break;
            case "date":
                sql="update tb_income set date ='"+income.getDate()+"' where id="+income.getId()+";";
                break;
        }
        database.execSQL(sql);
        database.close();
    };
    public void delete(int id){
        String sql="DELETE FROM tb_income WHERE  id= "+id+";";
        SQLiteDatabase database = db.getWritableDatabase();
        database.execSQL(sql);
        database.close();
    };
    public void insert(Income income){
        String sql="insert into tb_income ('number','time','kind','comment','position') values ('"+income.getNumber()+"','"+income.getDate()+"','"+income.getKind()+"','"+income.getComment()+"','"+income.getPosition()+"')";
        System.out.print(sql);
        SQLiteDatabase database = db.getWritableDatabase();
        if (db!=null){
            database.execSQL(sql);
        }
        database.close();
    };
}
