package com.example.myapplication.Activity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.Dao.InComeDao;
import com.example.myapplication.Dao.OutComeDao;
import com.example.myapplication.Model.Income;
import com.example.myapplication.Model.Outcome;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.data.PieEntry;

import java.util.ArrayList;
import java.util.List;

public class Show_Data_Activity  extends AppCompatActivity {
    Button b1,b2;
    List<Income> list;
    List<Outcome> list1;
    private PieChart pieChart;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fscgghfjkadcvy);
            b1=findViewById(R.id.button4);
            b2=findViewById(R.id.button5);
            b1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                InComeDao inComeDao =new InComeDao(getApplicationContext());
                list=inComeDao.find();
                pieChart = (PieChart) findViewById(R.id.mPieChart);
                show_pie_chart_1(list);
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                OutComeDao inComeDao =new OutComeDao(getApplicationContext());
                list1=inComeDao.find();
                pieChart = (PieChart) findViewById(R.id.mPieChart);
                show_pie_chart_2(list1);
            }
        });
    }
    private void show_pie_chart_1(List<Income> list) {
        float a=0;
        float b=0;
        float c=0;
        float d=0;
        System.out.println("list in :"+list.size());
        for(Income income:list) {
            if (income.getKind().equals("A")) {
                a++;
            } else if (income.getKind().equalsIgnoreCase("B")) {
                b++;
            } else if (income.getKind().equalsIgnoreCase("C")) {
                c++;
            } else if (income.getKind().equalsIgnoreCase("D")) {
                d++;
            }
            System.out.println(a);
            System.out.println(b);
            System.out.println(c);
            System.out.println(d);
            // 设置每份所占数量
            List<PieEntry> yvals = new ArrayList<>();
            yvals.add(new PieEntry(a / list.size(), "A"));
            yvals.add(new PieEntry(b / list.size(), "B"));
            yvals.add(new PieEntry(c / list.size(), "C"));
            yvals.add(new PieEntry(d / list.size(), "D"));
            //设置每份的颜色
            List<Integer> colors = new ArrayList<>();
            colors.add(Color.parseColor("#6785f2"));
            colors.add(Color.parseColor("#675cf2"));
            colors.add(Color.parseColor("#496cef"));
            colors.add(Color.parseColor("#aa63fa"));
            PieChartManagger pieChartManagger = new PieChartManagger(pieChart);
            pieChartManagger.showSolidPieChart(yvals, colors);
        }
    }
    private void show_pie_chart_2(List<Outcome> list) {
        float a=0;
        float b=0;
        float c=0;
        float d=0;
        System.out.println("list out :"+list.size());
        for(Outcome income:list) {
            if (income.getKind().equals("A")) {
                a++;
            } else if (income.getKind().equalsIgnoreCase("B")) {
                b++;
            } else if (income.getKind().equalsIgnoreCase("C")) {
                c++;
            } else if (income.getKind().equalsIgnoreCase("D")) {
                d++;
            }
        }
        System.out.println(a);
        System.out.println(b);
        System.out.println(c);
        System.out.println(d);
            // 设置每份所占数量
            List<PieEntry> yvals = new ArrayList<>();
            yvals.add(new PieEntry(a / list.size(), "A"));
            yvals.add(new PieEntry(b / list.size(), "B"));
            yvals.add(new PieEntry(c / list.size(), "C"));
            yvals.add(new PieEntry(d / list.size(), "D"));
            //设置每份的颜色
            List<Integer> colors = new ArrayList<>();
            colors.add(Color.parseColor("#6785f2"));
            colors.add(Color.parseColor("#675cf2"));
            colors.add(Color.parseColor("#496cef"));
            colors.add(Color.parseColor("#aa63fa"));
            PieChartManagger pieChartManagger = new PieChartManagger(pieChart);
            pieChartManagger.showSolidPieChart(yvals, colors);
        }

}
