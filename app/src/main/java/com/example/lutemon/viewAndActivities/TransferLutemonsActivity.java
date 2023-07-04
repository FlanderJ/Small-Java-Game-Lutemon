package com.example.lutemon.viewAndActivities;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.example.lutemon.R;
import com.example.lutemon.fragments.BattleFieldFragment;
import com.example.lutemon.fragments.HomeFragment;
import com.example.lutemon.fragments.TrainingAreaFragment;
import com.google.android.material.tabs.TabLayout;

public class TransferLutemonsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedinstanceState) {
        super.onCreate(savedinstanceState);
        setContentView(R.layout.activity_transfer_lutemons);

        // Initialize with the home fragment:
        Fragment fragment = new HomeFragment();
        replaceFragment(fragment);

        // Tab buttons from activity_transfer_lutemons:
        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabLayout);

        // When one of the tabs gets clicked, change to that tab:
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            // Get selected tab:
            public void onTabSelected(TabLayout.Tab tab) {
                Fragment fragment = null;
                switch (tab.getPosition()) {
                    case 0:
                        fragment = new HomeFragment();
                        break;
                    case 1:
                        fragment = new TrainingAreaFragment();
                        break;
                    case 2:
                        fragment = new BattleFieldFragment();
                        break;
                }
                if (fragment != null) {
                    replaceFragment(fragment);
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }


    // Method that replaces current fragment with new:
    public void replaceFragment(Fragment fragment) {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.frameLayout, fragment)
                .commit();
    }
}
