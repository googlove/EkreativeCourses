package com.flame4ost.missionteegardenb;

import android.content.Context;
import android.content.res.AssetManager;


import java.io.IOException;

import java.util.ArrayList;
import java.util.Scanner;

public class Simulation {
    private Context context;

    public Simulation(Context context) {
        this.context = context;
    }

    public ArrayList<Item> downloadPhaseOne() throws IOException {

        AssetManager ass_maneger = context.getAssets();
        ArrayList<Item> loadManifest = new ArrayList();

        Scanner filescanner = new Scanner(ass_maneger.open("Phase-1.txt"));

        while (filescanner.hasNextLine()) {

            Item newItem = new Item();
            String[] tokens = filescanner.nextLine().split("=");
            newItem.name = tokens[0];
            newItem.weight = Integer.parseInt(tokens[tokens.length-1]);

            loadManifest.add(newItem);
        }

        return loadManifest;
    }

    public ArrayList<Item> downloadPhaseTwo() throws IOException {

        AssetManager ass_maneger = context.getAssets();
        ArrayList<Item> loadManifest = new ArrayList();

        Scanner filescanner = new Scanner(ass_maneger.open("Phase-2.txt"));

        while (filescanner.hasNextLine()) {

            Item newItem = new Item();
            String[] tokens = filescanner.nextLine().split("=");
            newItem.name = tokens[0];
            newItem.weight = Integer.parseInt(tokens[tokens.length-1]);

            loadManifest.add(newItem);
        }

        return loadManifest;
    }

    public ArrayList<Rocket> loadU1(ArrayList<Item> list) {
        ArrayList<Rocket> rocket_list_one = new ArrayList<>();
        Rocket rocket_one = new U1();

        for (Item thisItem : list) {
            if (rocket_one.canCarry(thisItem)) {
                rocket_list_one.add(rocket_one);
            } else {
                rocket_one = new U1();
                rocket_list_one.add(rocket_one);
            }
        }
        return rocket_list_one;
    }

    public ArrayList<Rocket> loadU2(ArrayList<Item> list) {

        ArrayList<Rocket> rocket_list_two = new ArrayList();
        Rocket rocket_two = new U2();

        for (Item thisItem : list) {
            if (rocket_two.canCarry(thisItem)) {
                rocket_list_two.add(rocket_two);
            } else {
                rocket_two = new U2();
                rocket_list_two.add(rocket_two);
            }
        }
        return rocket_list_two;
    }

    public int runSimulation(ArrayList<Rocket> rockets) {

        int totalCost = 0;

        for (Rocket currentRocket : rockets) {
            totalCost += currentRocket.getCost();

            while (!currentRocket.launch() || !currentRocket.land()) {
                totalCost += currentRocket.getCost();
            }
        }
        return totalCost;
    }

}
