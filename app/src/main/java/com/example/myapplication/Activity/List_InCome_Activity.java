package com.example.myapplication.Activity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.Dao.InComeDao;
import com.example.myapplication.Model.InCome_Adapter;
import com.example.myapplication.Model.Income;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class List_InCome_Activity extends AppCompatActivity {
    private ListView listview;//定义ListView变量listview来获取布局文件中的ListView控件
    // 声明一个simpleAdapter
    private InCome_Adapter simpleAdapter;
    InComeDao inComeDao;
    List<Income> incomes;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_income_activity);
        // 绑定listview控件
        listview=this.findViewById(R.id.show_view);
        inComeDao=new InComeDao(getApplicationContext());
        incomes=inComeDao.find();
        // 实例化adapter
        simpleAdapter=new InCome_Adapter(
                this,
                this.initCarsInfoForMap(),
                R.layout.list_income_item,
                new String[]{"show_income_number","show_income_date","show_income_kind","show_income_position","show_income_commment","show_income_id"},
                new int[]{R.id.show_income_number,R.id.show_income_date,R.id.show_income_kind,R.id.show_income_position,R.id.show_income_comment,R.id.show_income_id});
        // 将adapter绑定到listview上
        listview.setAdapter(simpleAdapter);
    }
    public List<Map<String,Object>> initCarsInfoForMap(){
        List<Map<String,Object>> list_income= new ArrayList<>();
        for(Income in :incomes){
            System.out.print(in.toString());
            Map<String,Object> item=new HashMap<>();
            item.put("show_income_id","ID："+in.getId());
            item.put("show_income_number","收入金额："+in.getNumber());
            item.put("show_income_date","收入时间："+in.getDate());
            item.put("show_income_kind","收入类别："+in.getKind());
            item.put("show_income_position","收入位置："+in.getPosition());
            item.put("show_income_commment","收入备注："+in.getComment());
            item.put("show_income_id",""+in.getId());
            Button button=new Button(getApplicationContext());
            item.put("show_but_mange",button);
            list_income.add(item);
        }
        return list_income;
    }
}

