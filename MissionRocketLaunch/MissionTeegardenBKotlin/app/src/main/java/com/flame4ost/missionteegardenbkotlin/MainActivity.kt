package com.flame4ost.missionteegardenbkotlin

import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    var txt_sum_U1: TextView? = null
    var txt_sum_U2: TextView? = null
    var simulation = Simulation(this)
    private var total_budget_u1 = 0
    private var total_budget_u2 = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        txt_sum_U1 = findViewById(R.id.txt_sum_U1)
        txt_sum_U2 = findViewById(R.id.txt_sum_U2)
    }

    fun runTheSimulation(view: View){

        //Запуск моделювання для U1
        total_budget_u1 = simulation.runSimulation(simulation.loadU1(simulation.downloadPhaseOne())) //перша фаза
        total_budget_u1 += simulation.runSimulation(simulation.loadU1(simulation.downloadPhaseTwo())) //друга фаза
        txt_sum_U1!!.text = "$total_budget_u1 million $"

        //Запуск моделювання для U2
        total_budget_u2 = simulation.runSimulation(simulation.loadU2(simulation.downloadPhaseOne())) //перша фаза
        total_budget_u2 += simulation.runSimulation(simulation.loadU2(simulation.downloadPhaseTwo())) //друга фаза
        txt_sum_U2!!.text = "$total_budget_u2 million $"
    }

}