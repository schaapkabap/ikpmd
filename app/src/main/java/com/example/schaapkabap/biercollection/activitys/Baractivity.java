package com.example.schaapkabap.biercollection.activitys;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.schaapkabap.biercollection.Models.Barchart;
import com.example.schaapkabap.biercollection.R;
import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.charts.CombinedChart;
import com.github.mikephil.charting.components.AxisBase;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.data.CombinedData;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.formatter.IAxisValueFormatter;
import com.github.mikephil.charting.formatter.IndexAxisValueFormatter;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class Baractivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_baractivity);

        BarChart barChart = (BarChart) findViewById(R.id.barchart);

        ArrayList<BarEntry> entries = new ArrayList<BarEntry>();
                entries.add(new BarEntry(0f, 5));
                entries.add(new BarEntry(1f, 4));
                entries.add(new BarEntry(2f, 4));
                entries.add(new BarEntry(3f, 3));
                entries.add(new BarEntry(4f, 3));
                entries.add(new BarEntry(5f, 2));
                entries.add(new BarEntry(6f, 0));



        BarDataSet dataset = new BarDataSet(entries, "aantal bierbrouwerijen per staat");

        ArrayList<String> labels = new ArrayList <String>();
                labels.add("texas");
                labels.add("Florida");
                labels.add("Georgia");
                labels.add("Virginia");
                labels.add("Hawai");
                labels.add("New-York");
                labels.add("Illois");




        float minXRange = 10;
        float maxXRange = 10;
        barChart.setVisibleXRange(minXRange, maxXRange);
        XAxis xAxis = barChart.getXAxis();
        xAxis.setValueFormatter(new IndexAxisValueFormatter(labels));
        BarData data = new BarData(dataset);
        barChart.setData(data);


    }





}

