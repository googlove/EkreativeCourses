package com.flame4ost.missionteegardenb;

public interface SpaceShip {

    public boolean launch();
    public boolean land();
    public boolean canCarry(Item item);
    public int carry(Item item);

}
