package com.example.myapplication.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.Dao.NoteDao;
import com.example.myapplication.Model.Note;

public class Mange_Note_Acivity extends AppCompatActivity {
    public int id;
    public String  comment;
   EditText text;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mange_note_activity);
        text=findViewById(R.id.note_comment);
        Button button=findViewById(R.id.note_save_but);
        Button button1=findViewById(R.id.note_can_but);
        Button button2=findViewById(R.id.note_but_delete);
        Intent intent=getIntent();
        Bundle bundle=intent.getExtras();
        id=Integer.parseInt(bundle.getString("id"));
        comment=bundle.getString("comment");
        text.setText(comment);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String com=text.getText().toString();
                Note note=new Note(id,com);
                NoteDao noteDao=new NoteDao(getApplicationContext());
                noteDao.update(note);
                Intent intent1=new Intent();
                intent1.setClass(getApplicationContext(),MainScreen.class);
                startActivity(intent1);
                finish();
            }
        });
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1=new Intent();
                intent1.setClass(getApplicationContext(),MainScreen.class);
                startActivity(intent1);
                finish();
            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NoteDao noteDao=new NoteDao(getApplicationContext());
                noteDao.delete(id);
                Intent intent1=new Intent();
                intent1.setClass(getApplicationContext(),MainScreen.class);
                startActivity(intent1);
                finish();
            }
        });
    }
}
