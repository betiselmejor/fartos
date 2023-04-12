package com.example.fartosj;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.fartosj.adapter.adapterCardGallery;
import com.example.fartosj.entities.Carta;

import java.util.ArrayList;
import java.util.List;

public class mas2gallery extends AppCompatActivity {

    RecyclerView rv;
    List<Carta> cartas = new ArrayList<>();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mas2gallery);


        init();
    }

    public void init(){

        rv = findViewById(R.id.recyclerGallerymas2);


        Carta mas21= new Carta("ADE","+2",R.drawable.masdosuno);
        Carta mas22= new Carta("ADE","+2",R.drawable.masdostres);
        Carta mas23= new Carta("ADE","+2",R.drawable.masdosseis);
        Carta mas24= new Carta("ADE","+2",R.drawable.masdossiete);
        Carta mas25= new Carta("ADE","+2",R.drawable.masdosocho);
        Carta mas26= new Carta("ADE","+2",R.drawable.masdosnueve);
        Carta mas27= new Carta("ADE","+2",R.drawable.masdosonce);
        Carta mas28= new Carta("ADE","+2",R.drawable.masdostrece);
        Carta mas29= new Carta("ADE","+2",R.drawable.masdosquince);


        Carta mas210= new Carta("ADE","+2",R.drawable.masdosdieciseis);
        Carta mas211= new Carta("ADE","+2",R.drawable.masdosdiecisiete);
        Carta mas212= new Carta("ADE","+2",R.drawable.masdosdieciocho);
        Carta mas213= new Carta("ADE","+2",R.drawable.masdosdiecinueve);
        Carta mas214= new Carta("ADE","+2",R.drawable.masdosveinte);
        Carta mas215= new Carta("ADE","+2",R.drawable.masdosveintiuno);
        Carta mas216= new Carta("ADE","+2",R.drawable.masdosveintidos);
        Carta mas217= new Carta("ADE","+2",R.drawable.masdosveintitres);
        Carta mas219= new Carta("ADE","+2",R.drawable.masdosveintiuno);

        cartas.add(mas21);
        cartas.add(mas22);
        cartas.add(mas23);
        cartas.add(mas24);
        cartas.add(mas25);
        cartas.add(mas26);
        cartas.add(mas27);
        cartas.add(mas28);
        cartas.add(mas29);

        cartas.add(mas210);
        cartas.add(mas211);
        cartas.add(mas212);
        cartas.add(mas213);
        cartas.add(mas214);
        cartas.add(mas215);
        cartas.add(mas216);
        cartas.add(mas217);
        cartas.add(mas219);

        adapterCardGallery adapter = new adapterCardGallery(cartas);
        rv.setLayoutManager(new LinearLayoutManager(getApplicationContext(),LinearLayoutManager.HORIZONTAL,false));
        rv.setAdapter(adapter);


    }
}