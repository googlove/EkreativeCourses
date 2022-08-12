package com.flame4ost.missionteegardenbkotlin

class U1: Rocket() {
    init {
        cost = 100
        weight = 10000
        max_weight =18000
        launch_explosion = 0.0
        landing_crash = 0.0
        current_weight = weight
    }

    override fun land(): Boolean{
        val random = (Math.random() * 100 + 1).toInt()
        landing_crash = 1.0 * (current_weight - weight) / (max_weight - weight)

        return landing_crash <= random
    }

    override fun launch(): Boolean {
        val random = (Math.random() * 100 + 1).toInt()
        launch_explosion = 5.0 * (current_weight - weight) / (max_weight - weight)

        return launch_explosion <= random
    }


}