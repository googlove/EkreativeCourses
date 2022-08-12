package com.flame4ost.missionteegardenbkotlin

open class Rocket: SpaceShip {
    internal var cost: Int = 0
    var weight: Int = 0
    var max_weight: Int = 0
    var launch_explosion: Double = 0.0
    var landing_crash: Double =0.0
    var current_weight: Int = 0

    override fun launch(): Boolean { return true }

    override fun land(): Boolean{ return true }

    override fun canCarry(item: Item?): Boolean{
        return this.current_weight + item!!.weight <= max_weight}

    override fun carry(item: Item?): Int{
        this.current_weight +=item!!.weight;
        return this.current_weight
    }

    open fun getCost(): Int{ return this.cost}
}