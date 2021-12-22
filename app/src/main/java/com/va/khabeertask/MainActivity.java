package com.va.khabeertask;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        List<TitleValueColorEntity> pieChartData = new ArrayList();
        pieChartData.add(new TitleValueColorEntity("",40.8f,getResources().getColor(R.color.dark_blue)));
        pieChartData.add(new TitleValueColorEntity("",59.2f,getResources().getColor(R.color.dark_yellow)));
    }
}