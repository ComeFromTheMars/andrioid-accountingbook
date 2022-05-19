package com.example.myapplication.Activity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.Dao.OutComeDao;
import com.example.myapplication.Model.Outcome;

import java.util.Calendar;

public class new_Outcome_Activity extends AppCompatActivity implements  View.OnClickListener{
    private Calendar c;
    String date="";
    Button choice_out,new_outcome_but_save,new_outcome_but_can;
    TextView money,kind,comment,position;
    public void onClick(View view){
        c=Calendar.getInstance();
        new DatePickerDialog( this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                date=year+"--"+month+"--"+dayOfMonth;
                choice_out.setText(date);
            }
        }
                ,c.get(Calendar.YEAR)
                ,c.get(Calendar.MONTH)
                ,c.get(Calendar.DAY_OF_MONTH)).show();
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.xinzengzhichu);
        choice_out=findViewById(R.id.choice_out);
        new_outcome_but_save=findViewById(R.id.save_b_out);
        new_outcome_but_can=findViewById(R.id.can_out);
        new_outcome_but_can.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setClass(getApplicationContext(),MainScreen.class);
                startActivity(intent);
                finish();
            }
        });
        money=findViewById(R.id.new_outcome_number);
        comment=findViewById(R.id.new_outcome_comment);
        kind=findViewById(R.id.new_outcome_kind);
        choice_out.setOnClickListener(this);
        position=findViewById(R.id.new_outcome_position);
        new_outcome_but_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                OutComeDao inComeDao=new OutComeDao(getApplicationContext());
                Outcome in=new Outcome(Integer.parseInt(money.getText().toString()),1,date,kind.getText().toString());
                in.setComment(comment.getText().toString());
                in.setPosition(position.getText().toString());
                inComeDao.insert(in);
                Toast.makeText( new_Outcome_Activity.this, "已经保存", Toast.LENGTH_SHORT ).show();
                Intent intent3 = new Intent();
                intent3.setClass(getApplicationContext(),MainScreen.class);
                startActivity(intent3);
            }
        });
    }
}
