package com.example.fartosj.entities;

import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;
import androidx.room.Relation;

import java.io.Serializable;
import java.util.ArrayList;

public class Player implements Serializable {


    int runningSkin;

    int standSkin;

    String name;

    int casilla=0;

    public ArrayList<Carta> mano;

    boolean torn;

    boolean kicked=false;

    boolean eliminado=false;

    boolean c8=false;

    int antCasilla;

    public Player(int runningSkin, int standSkin, String name, int casilla, ArrayList<Carta> mano) {
        this.runningSkin = runningSkin;
        this.standSkin = standSkin;
        this.name = name;
        this.casilla = casilla;
        this.mano = mano;
    }
    public Player(int runningSkin, int standSkin, String name, int casilla) {
        this.runningSkin = runningSkin;
        this.standSkin = standSkin;
        this.name = name;
        this.casilla = casilla;
    }

    public Player(String name) {
        this.name = name;
    }

    public Player() {
    }

    public int getRunningSkin() {
        return runningSkin;
    }

    public void setRunningSkin(int runningSkin) {
        this.runningSkin = runningSkin;
    }

    public int getStandSkin() {
        return standSkin;
    }

    public void setStandSkin(int standSkin) {
        this.standSkin = standSkin;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCasilla() {
        return casilla;
    }

    public void setCasilla(int casilla) {
        this.casilla = casilla;
    }

    public ArrayList<Carta> getMano() {
        return mano;
    }

    public void setMano(ArrayList<Carta> mano) {
        this.mano = mano;
    }

    public boolean isTorn() {
        return torn;
    }

    public void setTorn(boolean torn) {
        this.torn = torn;
    }

    public boolean isKicked() {
        return kicked;
    }

    public void setKicked(boolean kicked) {
        this.kicked = kicked;
    }

    public boolean isEliminado() {
        return eliminado;
    }

    public void setEliminado(boolean eliminado) {
        this.eliminado = eliminado;
    }

    public boolean isC8() {
        return c8;
    }

    public void setC8(boolean c8) {
        this.c8 = c8;
    }

    public int getAntCasilla() {
        return antCasilla;
    }

    public void setAntCasilla(int antCasilla) {
        this.antCasilla = antCasilla;
    }
}
