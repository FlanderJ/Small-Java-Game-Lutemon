package com.example.lutemon.lutemons;

import com.example.lutemon.R;
import com.example.lutemon.lutemons.Lutemon;

import java.io.Serializable;

public class Orange extends Lutemon implements Serializable {
    public Orange(String name){
        super(name, R.drawable.orange,"orange",8,1,6,0,17,17,Lutemon.getIdCounterValue(),0,0,0,0, "Home");
        Lutemon.incrementIdCounter();
    }
}
