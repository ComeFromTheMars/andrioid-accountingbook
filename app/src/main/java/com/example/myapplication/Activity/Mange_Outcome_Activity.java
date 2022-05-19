package com.example.myapplication.Activity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.Dao.OutComeDao;
import com.example.myapplication.Model.Outcome;

import java.util.Calendar;

public class Mange_Outcome_Activity extends AppCompatActivity implements  View.OnClickListener{
    private Calendar c;
    String date="";
    Button income_choice_but,income_save,income_can,income_delete;
    EditText money,kind,comment,position;
    int id;int new_money;
    String new_kind;
    String new_comment;
    String new_position;
    public void onClick(View view){
        c=Calendar.getInstance();
        new DatePickerDialog( this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                date=year+"--"+month+"--"+dayOfMonth;
                income_choice_but.setText(date);
            }
        }
                ,c.get(Calendar.YEAR)
                ,c.get(Calendar.MONTH)
                ,c.get(Calendar.DAY_OF_MONTH)).show();
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mange__income);
        TextView t=findViewById(R.id.textView19);
        t.setText("详细支出");
        income_save=findViewById(R.id.save_but);
        income_can=findViewById(R.id.can_but);
        income_delete=findViewById(R.id.income_but_delete);
        Intent intent=getIntent();
        Bundle bundle=intent.getExtras();
        id=bundle.getInt("id");
        income_choice_but=findViewById(R.id.choice_time);
        income_choice_but.setOnClickListener(this);
        money=findViewById(R.id.new_InCome_Add_income_number);
        money.setText(bundle.getString("money").substring(5));
        kind=findViewById(R.id.income_kind);
        kind.setText(bundle.getString("kind").substring(5));
        comment=findViewById(R.id.income_comment);
        comment.setText(bundle.getString("comment").substring(5));
        position=findViewById(R.id.position_text);
        position.setText(bundle.getString("position").substring(5));
        income_delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                OutComeDao inComeDao=new  OutComeDao(getApplicationContext());
                inComeDao.delete(id);
                Intent intent = new Intent();
                intent.setClass(getApplicationContext(),MainScreen.class);
                startActivity(intent);
                finish();
            }
        });
        income_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Outcome income=new Outcome(
                        Double.parseDouble(money.getText().toString()),
                        id,
                        date,
                        position.getText().toString(),
                        comment.getText().toString(),
                        kind.getText().toString()
                );
                OutComeDao inComeDao =new OutComeDao(getApplicationContext());
                inComeDao.update(income,"number");
                inComeDao.update(income,"kind");
                inComeDao.update(income,"position");
                inComeDao.update(income,"comment");
                inComeDao.update(income,"date");
                Intent intent = new Intent();
                intent.setClass(getApplicationContext(),MainScreen.class);
                startActivity(intent);
                finish();
            }
        });
        income_can.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setClass(getApplicationContext(),MainScreen.class);
                startActivity(intent);
                finish();
            }
        });

    }

}