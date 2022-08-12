package com.flame4ost.missionteegardenb;

public class Rocket implements SpaceShip{

    int cost;
    int weight;
    int max_weight;
    double launch_explosion;
    double landing_crash;
    int current_weight;


    public boolean launch() {
        return true;
    }

    public boolean land() {
        return true;
    }

    public boolean canCarry(Item item) {
        return this.current_weight + item.weight <= max_weight;
    }

    public int carry(Item item) {
        this.current_weight += item.weight;
        return this.current_weight;
    }

    protected int getCost() {
        return cost;
    }
}
