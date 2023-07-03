package com.example.lutemon.viewAndActivities;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.lutemon.R;
import com.example.lutemon.lutemons.Lutemon;

import java.util.ArrayList;

public class LutemonListAdapter extends RecyclerView.Adapter<LutemonViewHolder> {
    private Context context;
    ArrayList<Lutemon> lutemons = new ArrayList<>();
    LutemonListAdapter(Context context, ArrayList<Lutemon> lutemons) {
        this.context = context;
        this.lutemons = lutemons;
    }

    @NonNull
    @Override
    public LutemonViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new LutemonViewHolder(LayoutInflater.from(context).inflate(R.layout.lutemon_list_view,parent,false));
    }

    public void onBindViewHolder(@NonNull LutemonViewHolder holder, int position) {
        holder.name.setText(lutemons.get(position).getName() + " (" +  lutemons.get(position).getClass().getSimpleName() + ")");
        holder.attack.setText("Attack: " + String.valueOf(lutemons.get(position).getAttack()));
        holder.defence.setText("Defence: " + String.valueOf(lutemons.get(position).getDefence()));
        holder.dodge.setText("Dodge: " + String.valueOf(lutemons.get(position).getDodge()));
        holder.health.setText("Health: " + String.valueOf(lutemons.get(position).getHealth()) + "/" + String.valueOf(lutemons.get(position).getMaxHealth()));
        holder.experience.setText("Expercience: " + String.valueOf(lutemons.get(position).getExperience()));
        holder.location.setText("Current location: " + lutemons.get(position).getLocation());
        holder.imageLutemon.setImageResource(lutemons.get(position).getPhoto());
    }
    @Override
    public int getItemCount() {
        return lutemons.size();
    }
}
