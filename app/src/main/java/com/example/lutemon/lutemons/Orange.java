package com.example.lutemon.lutemons;

import com.example.lutemon.R;
import com.example.lutemon.lutemons.Lutemon;

import java.io.Serializable;

public class Orange extends Lutemon implements Serializable {
    public Orange(String name){
        super(name, R.drawable.orange,"orange",8,1,6,0,17,17,Lutemon.getIdCounterValue(),0,0,0,0, "Home");
        Lutemon.incrementIdCounter();
    }
    public void increaseStats() {
        this.attack += 3;
        this.defence += 1;
        this.dodge += 2;
        this.experience +=1;
        this.maxHealth += 1;
        this.trainingCount += 1;
    }
}
