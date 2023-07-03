package com.example.lutemon.viewAndActivities;

import android.os.Bundle;

import com.example.lutemon.R;
import com.example.lutemon.lutemons.Black;
import com.example.lutemon.lutemons.Green;
import com.example.lutemon.lutemons.Lutemon;
import com.example.lutemon.lutemons.Orange;
import com.example.lutemon.lutemons.Pink;
import com.example.lutemon.lutemons.Storage;
import com.example.lutemon.lutemons.White;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class AddLutemonActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_lutemon);
    }

    // This view handles adding Lutemons:
    public void addLutemon(View view) {
        // Taking user input:
        EditText etLutemonName = findViewById(R.id.etName);
        RadioGroup rgLutemons = findViewById(R.id.rgLutemons);
        RadioButton rbLutemon = findViewById(rgLutemons.getCheckedRadioButtonId());

        String lutemonType = rbLutemon.getText().toString();
        String lutemonName = etLutemonName.getText().toString();

        switch (lutemonType){
            case ("White"):
                Lutemon lutemonWhite = new White(lutemonName);
                Storage.getInstance().addLutemon(lutemonWhite);
                Storage.getInstance().saveLutemon(lutemonWhite);
                break;
            case ("Black"):
                Lutemon lutemonBlack = new Black(lutemonName);
                Storage.getInstance().addLutemon(lutemonBlack);
                Storage.getInstance().saveLutemon(lutemonBlack);
                break;
            case ("Pink"):
                Lutemon lutemonPink = new Pink(lutemonName);
                Storage.getInstance().addLutemon(lutemonPink);
                Storage.getInstance().saveLutemon(lutemonPink);
                break;
            case ("Green"):
                Lutemon lutemonGreen = new Green(lutemonName);
                Storage.getInstance().addLutemon(lutemonGreen);
                Storage.getInstance().saveLutemon(lutemonGreen);
                break;
            case ("Orange"):
                Lutemon lutemonOrange = new Orange(lutemonName);
                Storage.getInstance().addLutemon(lutemonOrange);
                Storage.getInstance().saveLutemon(lutemonOrange);
                break;
        }

    }
}