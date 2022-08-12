package com.flame4ost.missionteegardenb;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    TextView txt_sum_U1;
    TextView txt_sum_U2;
    Simulation simulation = new Simulation(this);
    private int total_budget_u1 = 0;
    private int total_budget_u2 = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txt_sum_U1 = findViewById(R.id.txt_sum_U1);
        txt_sum_U2 = findViewById(R.id.txt_sum_U2);
    }

    public void runTheSimulation(View view) throws Exception {
        //Запуск моделювання для U1
        total_budget_u1 = simulation.runSimulation(simulation.loadU1(simulation.downloadPhaseOne())); //перша фаза
        total_budget_u1 += simulation.runSimulation(simulation.loadU1(simulation.downloadPhaseTwo())); //друга фаза
        txt_sum_U1.setText(total_budget_u1 + " million $");

        //Запуск моделювання для U2
        total_budget_u2 = simulation.runSimulation(simulation.loadU2(simulation.downloadPhaseOne())); //перша фаза
        total_budget_u2 += simulation.runSimulation(simulation.loadU2(simulation.downloadPhaseTwo())); //друга фаза
        txt_sum_U2.setText(total_budget_u2 + " million $");

    }
}