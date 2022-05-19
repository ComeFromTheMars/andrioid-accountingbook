package com.example.myapplication.Model;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import com.example.myapplication.Activity.Mange_Income_Acitivity;
import com.example.myapplication.Activity.R;

import java.util.List;
import java.util.Map;

public class InCome_Adapter extends SimpleAdapter {
    private Context context;
    List list;
    public static TextView e_id,e_money,e_positon,e_comment,e_kind,e_date;
    public InCome_Adapter(Context context, List<? extends Map<String, ?>> data, int resource, String[] from, int[] to) {
        super(context, data, resource, from, to);
        this.context = context;
    }
    @Override
    //显示一个view
    public View getView(int position, View convertView, ViewGroup parent) {
        convertView = super.getView(position, convertView, parent);
        e_id=convertView.findViewById(R.id.show_income_id);
        final Bundle bundle=new Bundle();
        bundle.putInt("id",Integer.parseInt(e_id.getText().toString()));
        e_date=convertView.findViewById(R.id.show_income_date);
        bundle.putString("date",e_date.getText().toString());
        e_money=convertView.findViewById(R.id.show_income_number);
        bundle.putString("money",e_money.getText().toString());
        e_positon=convertView.findViewById(R.id.show_income_position);
        bundle.putString("position",e_positon.getText().toString());
        e_kind=convertView.findViewById(R.id.show_income_kind);
        bundle.putString("kind",e_kind.getText().toString());
        e_comment=convertView.findViewById(R.id.show_income_comment);
        bundle.putString("comment",e_comment.getText().toString());
        Button b1 = convertView.findViewById(R.id.show_but_mange);
        b1.setText("查看详细信息");
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent13 = new Intent();
                intent13.setClass(context, Mange_Income_Acitivity.class);
                intent13.putExtras(bundle);
                context.startActivity(intent13);
            }
        });
        return convertView;
    }
}

