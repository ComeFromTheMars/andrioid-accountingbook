package com.example.myapplication.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainScreen extends AppCompatActivity implements View.OnClickListener{
    Button help,exit,new_income,new_outcome,my_income,my_outcome,data_vison,system_setting,bianqian;
    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.system_setting:
                Intent intent = new Intent();
                intent.setClass(this,System_Setting_Activity.class);
                startActivity(intent);
                break;
            case R.id.help:
                Intent intent3 = new Intent();
                intent3.setClass(this,Help_Activity.class);
                startActivity(intent3);
                break;
            case R.id.exit:
                Intent intent1 = new Intent();
                intent1.setClass(this,MainActivity.class);
                startActivity(intent1);
                finish();
                break;
            case R.id.new_income:
                Intent intent2 = new Intent();
                intent2.setClass(this,new_InCome_Acvtivity.class);
                startActivity(intent2);
                break;
            case R.id.new_outcome:
                Intent intent6 = new Intent();
                intent6.setClass(this,new_Outcome_Activity.class);
                startActivity(intent6);
                break;
            case R.id.data_vision:
                Intent intent8 = new Intent();
                intent8.setClass(this,Show_Data_Activity.class);
                startActivity(intent8);
                break;
            case R.id.my_income:
                Intent intent13 = new Intent();
                intent13.setClass(this, List_InCome_Activity.class);
                startActivity(intent13);
                break;
            case R.id.my_outcome:
                Intent intent14 = new Intent();
                intent14.setClass(this, List_Outcome_Activity.class);
                startActivity(intent14);
                break;
            case R.id.bianqian:
                Intent intent15 = new Intent();
                intent15.setClass(this, List_Note_Activity.class);
                startActivity(intent15);
                break;
        }
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.screen_main);
        help=(Button)findViewById(R.id.help);
        help.setOnClickListener(this);
        exit=(Button)findViewById(R.id.exit);
        exit.setOnClickListener(this);
        new_income=(Button)findViewById(R.id.new_income);
        new_income.setOnClickListener(this);
        new_outcome=(Button)findViewById(R.id.new_outcome);
        new_outcome.setOnClickListener(this);
        my_income=(Button)findViewById(R.id.my_income);
        my_income.setOnClickListener(this);
        my_outcome=(Button)findViewById(R.id.my_outcome);
        my_outcome.setOnClickListener(this);
        system_setting=(Button)findViewById(R.id.system_setting);
        system_setting.setOnClickListener(this);
        data_vison=(Button)findViewById(R.id.data_vision);
        data_vison.setOnClickListener(this);
        bianqian=(Button)findViewById(R.id.bianqian);
        bianqian.setOnClickListener(this);

    }
}
