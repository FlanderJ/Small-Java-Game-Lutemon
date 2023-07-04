package com.example.lutemon.lutemons;

import com.example.lutemon.R;
import com.example.lutemon.lutemons.Lutemon;

import java.io.Serializable;

public class Pink extends Lutemon implements Serializable {
    public Pink(String name) {
        super(name, R.drawable.pink, "pink", 7, 2, 4, 0, 18, 18, Lutemon.getIdCounterValue(), 0, 0, 0, 0, "Home");
        Lutemon.incrementIdCounter();
    }
    public void increaseStats() {
        this.attack += 2;
        this.defence += 1;
        this.dodge += 3;
        this.experience +=1;
        this.maxHealth += 2;
    }
}
