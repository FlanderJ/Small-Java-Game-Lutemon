package com.example.lutemon.fragments;

import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;


import com.example.lutemon.R;
import com.example.lutemon.lutemons.Lutemon;
import com.example.lutemon.lutemons.Storage;
import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.components.LegendEntry;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.interfaces.datasets.IBarDataSet;

import java.util.ArrayList;
import java.util.List;


public class FightCountStatisticFragment extends Fragment {
    private ArrayList<BarEntry> dataValues = new ArrayList<>();
    private Storage storage;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_fightstatistics, container, false);
    }

    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        int orange = Color.rgb(255, 165, 0);
        int pink = Color.rgb(255, 105, 180);


        BarChart barChart = view.findViewById(R.id.barChart);

        int index = 0;
        ArrayList<Integer> colors = new ArrayList<>();
        ArrayList<LegendEntry> legendEntries = new ArrayList<>();
        for (Lutemon lutemon : Storage.getInstance().getLutemons()) {
            BarEntry entry = new BarEntry(index,(float) lutemon.getFightCount());
            dataValues.add(entry);
            System.out.println(entry);


            if (lutemon.getClass().getSimpleName().equals("White")) {
                colors.add(Color.GRAY);
            }
            else if (lutemon.getClass().getSimpleName().equals("Black")) {
                colors.add(Color.BLACK);
            }
            else if (lutemon.getClass().getSimpleName().equals("Pink")) {
                colors.add(pink);
            }
            else if (lutemon.getClass().getSimpleName().equals("Green")) {
                colors.add(Color.GREEN);
            }
            else if (lutemon.getClass().getSimpleName().equals("Orange")) {
                colors.add(orange);
            }
            LegendEntry legendEntry = new LegendEntry();
            legendEntry.formColor = colors.get(index);
            legendEntry.label = lutemon.getName();
            legendEntries.add(legendEntry);
            index++;
        }

        BarDataSet barDataSet = new BarDataSet(dataValues, "Fights");
        barDataSet.setColors(colors);
        List<IBarDataSet> dataSets = new ArrayList<>();
        dataSets.add(barDataSet);
        BarData barData = new BarData(dataSets);
        barData.setBarWidth(0.9f);
        barChart.setData(barData);
        barChart.setData(barData);

        barChart.getXAxis().setDrawGridLines(false);
        barChart.getAxisLeft().setDrawGridLines(false);
        barChart.getAxisRight().setDrawGridLines(false);
        barChart.getAxisRight().setEnabled(false);
        barChart.getDescription().setEnabled(true);
        barChart.getDescription().setPosition(barChart.getWidth() / 2, 0);
        barChart.getDescription().setText("Fights");


        XAxis xAxis = barChart.getXAxis();
        xAxis.setAxisMinimum(0f);
        xAxis.setAxisMaximum(index-1);
        xAxis.setGranularity(1f);

        Legend legend = barChart.getLegend();
        legend.setCustom(legendEntries);
        System.out.println("Legend entries: " + legendEntries.size());


        barChart.invalidate();
    }
}

