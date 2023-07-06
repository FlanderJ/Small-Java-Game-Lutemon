package com.example.lutemon.viewAndActivities;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.lutemon.R;
import com.example.lutemon.lutemons.Storage;

public class ListLutemonsActivity extends AppCompatActivity {
    private Storage storage;
    private RecyclerView recyclerView;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_lutemons);

        storage = Storage.getInstance();

        // Initialize RecyclerView into this View:
        recyclerView = findViewById(R.id.rvLutemons);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        // Connect RecyclerView with the Adapter:
        recyclerView.setAdapter(new LutemonListAdapter(getApplicationContext(), storage.getLutemons()));
    }
}
