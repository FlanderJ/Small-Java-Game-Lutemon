package com.example.lutemon.viewAndActivities;

import android.content.Context;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.example.lutemon.R;
import com.example.lutemon.fragments.HomeFragment;

public class TransferLutemonsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedinstanceState) {
        super.onCreate(savedinstanceState);
        setContentView(R.layout.activity_transfer_lutemons);

        // Initialize with the home fragment:
        Fragment fragment = new HomeFragment();
        replaceFragment(fragment);
    }

    public void replaceFragment(Fragment fragment) {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.frameLayout, fragment)
                .commit();
    }
}
