package com.example.myapplication.Activity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.Dao.InComeDao;
import com.example.myapplication.Model.Income;

import java.util.Calendar;

public class new_InCome_Acvtivity extends AppCompatActivity implements View.OnClickListener{
    private Calendar c;
    String date="";
    Button save_but,can_but,choice_but;
    EditText number_money,kind,comment,position;
    public void onClick(View view){
        c=Calendar.getInstance();
        new DatePickerDialog( this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                date=year+"--"+month+"--"+dayOfMonth;
                choice_but.setText(date);
            }
        }
                ,c.get(Calendar.YEAR)
                ,c.get(Calendar.MONTH)
                ,c.get(Calendar.DAY_OF_MONTH)).show();
    }
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.xinzengshouru);
        save_but=findViewById(R.id.save_but);
        can_but=findViewById(R.id.can_but);
        can_but.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setClass(getApplicationContext(),MainScreen.class);
                startActivity(intent);
                finish();
            }
        });
        choice_but=findViewById(R.id.choice_time);
        choice_but.setOnClickListener(this);
        choice_but.setText(date);
        number_money=findViewById(R.id.new_InCome_Add_income_number);
        kind=(EditText) findViewById(R.id.income_kind);
        comment=findViewById(R.id.income_comment);
        position=findViewById(R.id.position_text);
        save_but.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                InComeDao inComeDao=new InComeDao(getApplicationContext());
                Income in=new Income(Integer.parseInt(number_money.getText().toString()),1,date,kind.getText().toString());
                in.setComment(comment.getText().toString());
                in.setPosition(position.getText().toString());
                inComeDao.insert(in);
                Toast.makeText( new_InCome_Acvtivity.this, "已经保存", Toast.LENGTH_SHORT ).show();
                Intent intent3 = new Intent();
                intent3.setClass(getApplicationContext(),MainScreen.class);
                startActivity(intent3);
            }
        });
    }




}
