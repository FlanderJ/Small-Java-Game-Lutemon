package com.example.lutemon.lutemons;

import com.example.lutemon.R;
import com.example.lutemon.lutemons.Lutemon;

import java.io.Serializable;

public class White extends Lutemon implements Serializable {
    public White(String name) {
        super(name, R.drawable.white, "white", 5, 4, 10, 0, 20, 20, Lutemon.getIdCounterValue(), 0, 0, 0, 0, "Home");
        Lutemon.incrementIdCounter();
    }
    public void increaseStats() {
        this.attack += 1;
        this.defence += 3;
        this.dodge += 2;
        this.maxHealth += 3;
        this.experience +=1;
        this.trainingCount += 1;
        this.setTrainingCount();
    }
}
