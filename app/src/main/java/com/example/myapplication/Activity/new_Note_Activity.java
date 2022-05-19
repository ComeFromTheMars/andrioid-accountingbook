package com.example.myapplication.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.Dao.NoteDao;
import com.example.myapplication.Model.Note;

public class new_Note_Activity extends AppCompatActivity {

    EditText t1;
    String s1;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.xinzengbianqian);
        Button b1=findViewById(R.id.new_note_save);
        Button b2=findViewById(R.id.new_note_can);
        t1=(EditText)findViewById(R.id.new_note_comment);


        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                s1=t1.getText().toString();
                Note note=new Note(s1);
                System.out.println(s1);
                NoteDao noteDao=new NoteDao(getApplicationContext());
                noteDao.insert(note);
                System.out.println(note.getConnet());
                Intent intent = new Intent();
                intent.setClass(getApplicationContext(), MainScreen.class);
                startActivity(intent);
                finish();
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                t1.setText("");
            }
        });
    }
}

