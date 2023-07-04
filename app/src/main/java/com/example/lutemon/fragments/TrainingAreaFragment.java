package com.example.lutemon.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.lutemon.R;
import com.example.lutemon.lutemons.Lutemon;
import com.example.lutemon.lutemons.Storage;
import com.example.lutemon.viewAndActivities.MainActivity;

public class TrainingAreaFragment extends Fragment {
    private Storage storage;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_transfer_trainingarea, container, false);
    }
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        storage = Storage.getInstance();
        createLutemonSelection(view);

        // Listener for the button on the fragment:
        Button btTransfer = view.findViewById(R.id.btTransfer);
        btTransfer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                transfer(getView());
                returnToMain();
            }
        });
    }

    // Form Lutemon selection by using radiobuttons:
    public void createLutemonSelection(View view) {
        int i = 0;
        // Get the LinearLayout from fragment:
        LinearLayout llLutemonsAtTrain = view.findViewById(R.id.llLutemonsLocation);
        for (Lutemon lutemon : storage.getLutemons()) {
            if ("Training".equals(lutemon.getLocation())) {
                training(lutemon); // Lutemons are getting stronger when at training area.

                CheckBox cbLutemonAtHome = new CheckBox(getActivity());
                cbLutemonAtHome.setText(lutemon.getName() + " (" + lutemon.getClass().getSimpleName() + ")");
                cbLutemonAtHome.setTag(lutemon.getName());
                llLutemonsAtTrain.addView(cbLutemonAtHome);
            }
        }
    }

    // Transfer Lutemons to new location:
    public void transfer(View view) {
        LinearLayout llLutemonsAtTrain = view.findViewById(R.id.llLutemonsLocation);
        RadioGroup rgNewLocation = view.findViewById(R.id.rgNewLocation);
        RadioButton rbSelectedLocation = view.findViewById(rgNewLocation.getCheckedRadioButtonId());
        String selectedLocation = rbSelectedLocation.getText().toString();
        // Traverse trough checkboxes and change the location attribute of all checked lutemons:
        for (int i=0; i < llLutemonsAtTrain.getChildCount(); i++) {
            CheckBox cbLutemon = (CheckBox) llLutemonsAtTrain.getChildAt(i);
            if (cbLutemon.isChecked()) {

                String selectedLutemon = (String) cbLutemon.getTag();
                System.out.println(selectedLutemon);
                Lutemon lutemonToTransfer = Storage.getInstance().getLutemonByName(selectedLutemon);
                lutemonToTransfer.setLocation(selectedLocation);
                Storage.getInstance().saveLutemons();
            }
        }
    }

    // Return to the most recent view:
    public void returnToMain() {
        Intent intent = new Intent(getActivity(), MainActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
        getActivity().finish();
    }

    public void training(Lutemon lutemon) {
        lutemon.increaseStats();
        lutemon.increaseStats();
        storage.saveLutemons();
    }
}
