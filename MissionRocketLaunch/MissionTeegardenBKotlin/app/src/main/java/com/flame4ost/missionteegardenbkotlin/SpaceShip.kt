package com.flame4ost.missionteegardenbkotlin

open interface SpaceShip {
    open fun launch(): Boolean
    open fun land(): Boolean
    open fun canCarry(item: Item?): Boolean
    open fun carry(item: Item?): Int
}