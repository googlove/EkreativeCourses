package com.flame4ost.missionteegardenb;

public class U2 extends Rocket{
    public U2 (){
        cost = 120;
        weight = 18000;
        max_weight = 29000;
        launch_explosion = 0.0;
        landing_crash = 0.0;

        current_weight = weight;
    }

    public boolean launch() {
        int random = (int)(Math.random() * 100 + 1);
        this.launch_explosion = 4.0 * (this.current_weight - this.weight) / (this.max_weight - this.weight);

        return this.launch_explosion <= random;
    }

    public boolean land() {
        int random = (int)(Math.random() * 100 + 1);
        this.landing_crash = 8.0 * (this.current_weight - this.weight) / (this.max_weight - this.weight);

        return this.landing_crash <= random;
    }
}
