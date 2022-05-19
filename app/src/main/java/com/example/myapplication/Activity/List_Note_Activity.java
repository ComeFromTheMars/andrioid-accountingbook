package com.example.myapplication.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.Dao.NoteDao;
import com.example.myapplication.Model.Note;
import com.example.myapplication.Model.Note_Adapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class List_Note_Activity extends AppCompatActivity {
    Button new_note;
    List<Note> list;
    Note_Adapter note_adapter;
    ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_note_activity);
        new_note=findViewById(R.id.button3);
        new_note.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setClass(getApplicationContext(), new_Note_Activity.class);
                startActivity(intent);
            }
        });
        NoteDao noteDao=new NoteDao(getApplicationContext());
        list=noteDao.find();
        listView=findViewById(R.id.show_view_note);
        note_adapter=new Note_Adapter(
                this,
                this.initCarsInfoForMap(),
                R.layout.list_note_item,
                new String[]{"ID","comment"},
                new int [] {R.id.show_note_id,R.id.show_note_comment}
        );
        listView.setAdapter(note_adapter);
    }
    public List<Map<String,Object>> initCarsInfoForMap(){
        List<Map<String,Object>> list_note= new ArrayList<>();
        for( Note note:list){
            Map<String,Object> item=new HashMap<>();
            item.put("ID",note.getId());
            item.put("comment",note.getConnet());
            Button button=new Button(getApplicationContext());
            item.put("show_but_note",button);
            list_note.add(item);
        }
        return list_note;
    }
}
