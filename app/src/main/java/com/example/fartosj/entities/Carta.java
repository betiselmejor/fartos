package com.example.fartosj.entities;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

import java.io.Serializable;

public class Carta implements Serializable {
    String nom;

    String type;

    int id;

 public   String jugadorNom;

    public Carta() {
    }

    public Carta(String nom, String type, int id) {
        this.nom = nom;
        this.type = type;
        this.id = id;
    }


    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getJugadorNom() {
        return jugadorNom;
    }

    public void setJugadorNom(String jugadorNom) {
        this.jugadorNom = jugadorNom;
    }
}

