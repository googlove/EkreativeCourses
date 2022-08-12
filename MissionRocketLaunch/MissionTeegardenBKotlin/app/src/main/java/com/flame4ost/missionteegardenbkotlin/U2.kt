package com.flame4ost.missionteegardenbkotlin

class U2: Rocket() {
    init {
        cost = 120
        weight = 18000
        max_weight = 29000
        launch_explosion = 0.0
        landing_crash = 0.0
        current_weight = weight
    }

    override fun land(): Boolean {
        val random = (Math.random() * 100 + 1).toInt()
        landing_crash = 8.0 * (current_weight - weight) / (max_weight - weight)

        return landing_crash <= random
    }

    override fun launch(): Boolean {
        val random = (Math.random() * 100 + 1).toInt()
        launch_explosion = 4.0 * (current_weight - weight) / (max_weight - weight)

        return launch_explosion <= random
    }
}