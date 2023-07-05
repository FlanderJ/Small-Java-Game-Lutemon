package com.example.lutemon.viewAndActivities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.lutemon.R;
import com.example.lutemon.lutemons.Storage;

public class MainActivity extends AppCompatActivity {

    private Storage storage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.storage = Storage.getInstance();

        // Initialize context:
        Storage.getInstance().init(getApplicationContext());
        // Load existing Lutemons from file:
        Storage.getInstance().loadLutemons();
    }

    public void switchAddNewLutemon(View view) {
        Intent intent = new Intent(this, AddLutemonActivity.class);
        startActivity(intent);
    }

    public  void switchToListView(View view) {
        Intent intent = new Intent(this, ListLutemonsActivity.class);
        startActivity(intent);
    }

    public void switchToTransverView(View view) {
        Intent intent = new Intent(this, TransferLutemonsActivity.class);
        startActivity(intent);
    }

    public void switchToBattleFieldView(View view) {
        Intent intent = new Intent(this, BattleFieldActivity.class);
        startActivity(intent);
    }
}