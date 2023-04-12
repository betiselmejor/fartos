package com.example.fartosj;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.fartosj.adapter.adapterCardGallery;
import com.example.fartosj.entities.Carta;

import java.util.ArrayList;
import java.util.List;

public class spgallery extends AppCompatActivity {


    RecyclerView rv;
    List<Carta> cartas = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spgallery);

        init();

    }

    public void init(){

        rv = findViewById(R.id.recyclerGallerysp);


        Carta spbroma1= new Carta("ADE","broma",R.drawable.spbroma1);
        Carta spbroma2= new Carta("ADE","broma",R.drawable.spbroma2);

        Carta sphundimiento1 = new Carta("ADE","broma",R.drawable.sphundimiento1);
        Carta sphundimiento2 = new Carta("ADE","broma",R.drawable.sphundimiento2);

        Carta sppatada1= new Carta("ADE","patada",R.drawable.sppatada1);
        Carta sppatada2= new Carta("ADE","patada",R.drawable.sppatada2);
        Carta sppatada3= new Carta("ADE","patada",R.drawable.sppatada3);
        Carta sppatada4= new Carta("ADE","patada",R.drawable.sppatada4);

        Carta sptp1= new Carta("ADE","tp",R.drawable.sptp1);
        Carta sptp2= new Carta("ADE","tp",R.drawable.sptp2);
        Carta sptp3= new Carta("ADE","tp",R.drawable.sptp3);

        Carta sptrip1= new Carta("ADE","trip",R.drawable.sptrip1);
        Carta sptrip2= new Carta("ADE","trip",R.drawable.sptrip2);
        Carta sptrip3= new Carta("ADE","trip",R.drawable.sptrip3);
        Carta sptrip4= new Carta("ADE","trip",R.drawable.sptrip4);

        cartas.add(spbroma1);
        cartas.add(spbroma2);

        cartas.add(sphundimiento1);
        cartas.add(sphundimiento2);

        cartas.add(sppatada1);
        cartas.add(sppatada2);
        cartas.add(sppatada3);
        cartas.add(sppatada4);

        cartas.add(sptp1);
        cartas.add(sptp2);
        cartas.add(sptp3);

        cartas.add(sptrip1);
        cartas.add(sptrip2);
        cartas.add(sptrip3);
        cartas.add(sptrip4);



        adapterCardGallery adapter = new adapterCardGallery(cartas);
        rv.setLayoutManager(new LinearLayoutManager(getApplicationContext(),LinearLayoutManager.HORIZONTAL,false));
        rv.setAdapter(adapter);


    }

}