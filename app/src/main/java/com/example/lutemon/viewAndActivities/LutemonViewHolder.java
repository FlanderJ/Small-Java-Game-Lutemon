package com.example.lutemon.viewAndActivities;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.lutemon.R;

public class LutemonViewHolder extends RecyclerView.ViewHolder {
    ImageView imageLutemon;
    TextView name, attack, defence, dodge, health, experience, location;
    public LutemonViewHolder(@NonNull View itemView) {
        super(itemView);

        name = itemView.findViewById(R.id.txtName);
        attack = itemView.findViewById(R.id.txtAttack);
        defence = itemView.findViewById(R.id.txtDefence);
        dodge = itemView.findViewById(R.id.txtDodge);
        health = itemView.findViewById(R.id.txtHealth);
        experience = itemView.findViewById(R.id.txtExperience);
        location = itemView.findViewById(R.id.txtLocation);
        imageLutemon = itemView.findViewById(R.id.ivLutemonImage);
    }
}
