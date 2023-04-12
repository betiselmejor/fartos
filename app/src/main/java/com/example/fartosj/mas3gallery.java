package com.example.fartosj;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.fartosj.adapter.adapterCardGallery;
import com.example.fartosj.entities.Carta;

import java.util.ArrayList;
import java.util.List;

public class mas3gallery extends AppCompatActivity {

    RecyclerView rv;
    List<Carta> cartas = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mas3gallery);

        init();
    }

    public void init(){

        rv = findViewById(R.id.recyclerGallerymas3);


        Carta mas31= new Carta("ADE","+3",R.drawable.mastresuno);
        Carta mas32= new Carta("ADE","+3",R.drawable.mastresdos);
        Carta mas33= new Carta("ADE","+3",R.drawable.mastrescuatro);
        Carta mas34= new Carta("ADE","+3",R.drawable.mastrescinco);
        Carta mas35= new Carta("ADE","+3",R.drawable.mastresseis);
        Carta mas36= new Carta("ADE","+3",R.drawable.mastressiete);
        Carta mas37= new Carta("ADE","+3",R.drawable.mastresocho);
        Carta mas38= new Carta("ADE","+3",R.drawable.mastresnueve);
        Carta mas39= new Carta("ADE","+3",R.drawable.mastresdiez);
        Carta mas310= new Carta("ADE","+3",R.drawable.mastrestres);

        cartas.add(mas31);
        cartas.add(mas32);
        cartas.add(mas33);
        cartas.add(mas34);
        cartas.add(mas35);
        cartas.add(mas36);
        cartas.add(mas37);
        cartas.add(mas38);
        cartas.add(mas39);
        cartas.add(mas310);


        adapterCardGallery adapter = new adapterCardGallery(cartas);
        rv.setLayoutManager(new LinearLayoutManager(getApplicationContext(),LinearLayoutManager.HORIZONTAL,false));
        rv.setAdapter(adapter);


    }

}