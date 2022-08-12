package com.flame4ost.missionteegardenbkotlin

import android.content.Context
import android.content.res.AssetManager
import java.io.IOException
import java.util.*
import kotlin.collections.ArrayList

class Simulation(var context: Context) {

    @Throws(IOException::class)
    fun downloadPhaseOne(): ArrayList<Item>{
        val ass_maneger: AssetManager = context!!.assets
        val loadManifest: ArrayList<Item> = ArrayList()

        val filescanner = Scanner(ass_maneger.open("Phase-1.txt"))

        while (filescanner.hasNextLine()) {
            val newItem: Item = Item()
            val tokens = filescanner.nextLine().split("=").toTypedArray()
            newItem.name = tokens[0]
            newItem.weight = tokens[tokens.size - 1].toInt()
            loadManifest.add(newItem)
        }

        return loadManifest
    }

    @Throws(IOException::class)
    fun downloadPhaseTwo(): ArrayList<Item>{
        val ass_maneger: AssetManager = context!!.assets
        val loadManifest: ArrayList<Item> = ArrayList()

        val filescanner = Scanner(ass_maneger.open("Phase-2.txt"))

        while (filescanner.hasNextLine()) {
            val newItem: Item = Item()
            val tokens = filescanner.nextLine().split("=").toTypedArray()
            newItem.name = tokens[0]
            newItem.weight = tokens[tokens.size - 1].toInt()
            loadManifest.add(newItem)
        }

        return loadManifest
    }

    fun loadU1(list: ArrayList<Item>): ArrayList<Rocket>{
        val rocket_list_one : ArrayList<Rocket> = ArrayList()
        var rocket_one: Rocket = U1()

        for (thisItem in list) {
            if (rocket_one.canCarry(thisItem)) {
                rocket_list_one.add(rocket_one)
            } else {
                rocket_one = U1()
                rocket_list_one.add(rocket_one)
            }
        }
        return rocket_list_one
    }

    fun loadU2(list: ArrayList<Item>): ArrayList<Rocket>{
        val rocket_list_two: ArrayList<Rocket> = ArrayList()
        var rocket_two: Rocket = U2()

        for (thisItem in list) {
            if (rocket_two.canCarry(thisItem)) {
                rocket_list_two.add(rocket_two)
            } else {
                rocket_two = U2()
                rocket_list_two.add(rocket_two)
            }
        }
        return rocket_list_two
    }

    fun runSimulation(rockets: ArrayList<Rocket>): Int{
        var totalCost = 0

        for (currentRocket in rockets) {
            totalCost += currentRocket.getCost()
            while (!currentRocket.launch() || !currentRocket.land()) {
                totalCost += currentRocket.getCost()
            }
        }
        return totalCost
    }
}