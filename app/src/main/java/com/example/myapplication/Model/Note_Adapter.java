package com.example.myapplication.Model;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import com.example.myapplication.Activity.Mange_Note_Acivity;
import com.example.myapplication.Activity.R;

import java.util.List;
import java.util.Map;

public class Note_Adapter extends SimpleAdapter {
    Context context;
    TextView t1,t2;
    Button b1;
    Bundle bundle;
    public Note_Adapter(Context context, List<? extends Map<String, ?>> data, int resource, String[] from, int[] to) {
        super(context, data, resource, from, to);
        this.context=context;
    }
    @Override
    //显示一个view
    public View getView(int position, View convertView, ViewGroup parent) {
        convertView = super.getView(position, convertView, parent);
        t1=convertView.findViewById(R.id.show_note_id);
        t2=convertView.findViewById(R.id.show_note_comment);
        b1=convertView.findViewById(R.id.show_but_note);
        b1.setText("查看详细信息");
        bundle=new Bundle();
        bundle.putString("comment",t2.getText().toString());
        bundle.putString("id",t1.getText().toString());
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent13 = new Intent();
                intent13.setClass(context, Mange_Note_Acivity.class);
                intent13.putExtras(bundle);
                context.startActivity(intent13);
            }
        });
        return convertView;
    }
}
