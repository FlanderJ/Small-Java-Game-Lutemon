package com.example.lutemon.lutemons;

import com.example.lutemon.R;
import com.example.lutemon.lutemons.Lutemon;

import java.io.Serializable;

public class Green extends Lutemon implements Serializable {

    public Green(String name) {
        super(name, R.drawable.green, "green", 6, 3, 4, 0, 19, 19, Lutemon.getIdCounterValue(), 0, 0, 0, 0, "Home");
        Lutemon.incrementIdCounter();
    }

    public void increaseStats() {
        this.attack += 2;
        this.defence += 2;
        this.dodge += 2;
        this.experience +=1;
        this.maxHealth += 3;
        this.trainingCount += 1;
    }
}
