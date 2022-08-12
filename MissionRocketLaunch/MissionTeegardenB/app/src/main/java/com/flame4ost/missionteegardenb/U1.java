package com.flame4ost.missionteegardenb;

public class U1 extends Rocket{

    public U1 (){
        cost = 100;
        weight = 10000;
        max_weight = 18000;
        launch_explosion = 0.0;
        landing_crash = 0.0;
        current_weight = weight;
    }

    @Override
    public boolean land(){
        int random = (int)(Math.random() * 100 + 1);
        this.landing_crash = 1.0 * (this.current_weight - this.weight) / (this.max_weight - this.weight);

        return this.landing_crash <= random;
    }

    @Override
    public boolean launch(){
        int random = (int)(Math.random() * 100 + 1);
        this.launch_explosion = 5.0 * (this.current_weight - this.weight) / (this.max_weight - this.weight);

        return this.launch_explosion <= random;
    }
}
