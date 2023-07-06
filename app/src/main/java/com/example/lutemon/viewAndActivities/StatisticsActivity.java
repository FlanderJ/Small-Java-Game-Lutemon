package com.example.lutemon.viewAndActivities;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.example.lutemon.R;
import com.example.lutemon.fragments.BattleFieldFragment;
import com.example.lutemon.fragments.FightCountStatisticFragment;
import com.example.lutemon.fragments.HomeFragment;
import com.example.lutemon.fragments.LoseStatisticFragment;
import com.example.lutemon.fragments.TrainingAreaFragment;
import com.example.lutemon.fragments.WinStatisticFragment;
import com.google.android.material.tabs.TabLayout;

public class StatisticsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedinstanceState) {
        super.onCreate(savedinstanceState);
        setContentView(R.layout.activity_statistics);

        // Initialize with the home fragment:
        Fragment fragment = new FightCountStatisticFragment();
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
                        fragment = new FightCountStatisticFragment();
                        break;
                    case 1:
                        fragment = new WinStatisticFragment();
                        break;
                    case 2:
                        fragment = new LoseStatisticFragment();
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
