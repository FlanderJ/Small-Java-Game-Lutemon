package com.example.lutemon.lutemons;

import com.example.lutemon.R;

import java.io.Serializable;

public class Black extends Lutemon implements Serializable {
    public Black(String name){
        super(name, R.drawable.black,"black",9,0,2,0,16,16,Lutemon.getIdCounterValue(),0,0,0,0, "Home");
    Lutemon.incrementIdCounter();
    }
}
