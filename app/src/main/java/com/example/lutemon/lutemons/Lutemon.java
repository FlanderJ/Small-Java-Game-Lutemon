package com.example.lutemon.lutemons;

import java.io.Serializable;

public abstract class Lutemon implements Serializable {
    protected String name;
    protected int photo;
    protected String color;

    protected String location;
    protected int attack;
    protected int defence;
    protected int dodge;
    protected int experience;
    protected int health;
    protected int maxHealth;
    protected int id;
    protected int winCount;
    protected int fightCount;
    protected int trainingCount;
    protected int loseCount;
    private static int idCounter = 0;

    public Lutemon(String name, int photo, String color, int attack, int defence, int dodge, int experience, int health,
    int maxHealth, int id, int winCount, int fightCount, int trainingCount, int loseCount, String location) {
        this.name = name;
        this.photo = photo;
        this.attack = attack;
        this.defence = defence;
        this.dodge = dodge;
        this.experience = experience;
        this.health = health;
        this.maxHealth = maxHealth;
        this.id = id;
        this.winCount = winCount;
        this.fightCount = fightCount;
        this.trainingCount = trainingCount;
        this.loseCount = loseCount;
        this.location = location;
    }
    public Lutemon(){

    }

    public String getName() {
        return name;
    }

    public int getPhoto() {
        return photo;
    }

    public String getColor() {
        return color;
    }

    public int getAttack() {
        return attack;
    }

    public int getDefence() {
        return defence;
    }

    public int getDodge() {
        return dodge;
    }

    public int getExperience() {
        return experience;
    }

    public int getHealth() {
        return health;
    }

    public int getMaxHealth() {
        return maxHealth;
    }

    public int getId() {
        return id;
    }

    public void setWinCount() {
        this.winCount += 1;
    }

    public void setFightCount() {
        this.fightCount += 1;
    }

    public void setTrainingCount() {
        this.trainingCount += 1;
    }

    public void setLoseCount() {
        this.loseCount += 1;
    }

    public int getWinCount() {
        return winCount;
    }

    public int getFightCount() {
        return fightCount;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getTrainingCount() {
        return trainingCount;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getLoseCount() {
        return loseCount;
    }
    public static int getIdCounterValue() {
    return idCounter;
    }

    public String getLocation() {
        return location;
    }

    public static int incrementIdCounter() {
        return ++idCounter;
    }

    public void increaseStats(){}

    public void increaseStatsAfterWin () {
        increaseStats();
        setWinCount();
        setFightCount();
    }
}
