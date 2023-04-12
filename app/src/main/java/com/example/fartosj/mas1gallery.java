package com.example.fartosj;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.fartosj.adapter.adapterCardGallery;
import com.example.fartosj.entities.Carta;

import java.util.ArrayList;
import java.util.List;

public class mas1gallery extends AppCompatActivity {

    RecyclerView rv;
    List<Carta> cartas = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mas1gallery);

        init();
    }

    public void init(){

        rv = findViewById(R.id.recyclerGallerymas1);


        Carta mas11= new Carta("ADE","+1",R.drawable.masunouno);
        Carta mas12= new Carta("ADE","+1",R.drawable.masunodos);
        Carta mas13= new Carta("ADE","+1",R.drawable.masunotres);
        Carta mas14= new Carta("ADE","+1",R.drawable.masunocuatro);
        Carta mas15= new Carta("ADE","+1",R.drawable.masunocinco);
        Carta mas16= new Carta("ADE","+1",R.drawable.masunoseis);
        Carta mas17= new Carta("ADE","+1",R.drawable.masunosiete);
        Carta mas18= new Carta("ADE","+1",R.drawable.masunoocho);
        Carta mas19= new Carta("ADE","+1",R.drawable.masunonueve);
        Carta mas110= new Carta("ADE","+1",R.drawable.masunodiez);
        Carta mas111= new Carta("ADE","+1",R.drawable.masunouno);
        Carta mas112= new Carta("ADE","+1",R.drawable.masunodoce);
        Carta mas113= new Carta("ADE","+1",R.drawable.masunotrece);
        Carta mas114= new Carta("ADE","+1",R.drawable.masunocatorce);
        Carta mas115= new Carta("ADE","+1",R.drawable.masunoquince);
        Carta mas116= new Carta("ADE","+1",R.drawable.masunodieciseis);
        Carta mas117= new Carta("ADE","+1",R.drawable.masunodiecesiete);
        Carta mas118= new Carta("ADE","+1",R.drawable.masunodieciocho);
        Carta mas119= new Carta("ADE","+1",R.drawable.masunodiecinueve);
        Carta mas120= new Carta("ADE","+1",R.drawable.masunoveinte);
        Carta mas121= new Carta("ADE","+1",R.drawable.masunoveintiuno);
        Carta mas122= new Carta("ADE","+1",R.drawable.masunoveintidos);
        Carta mas123= new Carta("ADE","+1",R.drawable.masunoveintitres);
        Carta mas124= new Carta("ADE","+1",R.drawable.masunoveinticuatro);
        Carta mas126= new Carta("ADE","+1",R.drawable.masunoveintiseis);
        Carta mas127= new Carta("ADE","+1",R.drawable.masunoveintisiete);
        Carta mas128= new Carta("ADE","+1",R.drawable.masunoveintiocho);
        Carta mas129= new Carta("ADE","+1",R.drawable.masunoveintinueve);



        cartas.add(mas11);
        cartas.add(mas12);
        cartas.add(mas13);
        cartas.add(mas14);
        cartas.add(mas15);
        cartas.add(mas16);
        cartas.add(mas17);
        cartas.add(mas18);
        cartas.add(mas19);

        cartas.add(mas110);
        cartas.add(mas111);
        cartas.add(mas112);
        cartas.add(mas113);
        cartas.add(mas114);
        cartas.add(mas115);
        cartas.add(mas116);
        cartas.add(mas117);
        cartas.add(mas118);
        cartas.add(mas119);

        cartas.add(mas120);
        cartas.add(mas121);
        cartas.add(mas122);
        cartas.add(mas123);
        cartas.add(mas124);
        cartas.add(mas126);
        cartas.add(mas127);
        cartas.add(mas128);
        cartas.add(mas129);



        adapterCardGallery adapter = new adapterCardGallery(cartas);
        rv.setLayoutManager(new LinearLayoutManager(getApplicationContext(),LinearLayoutManager.HORIZONTAL,false));
        rv.setAdapter(adapter);


    }
}