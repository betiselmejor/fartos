package com.example.fartosj.adapter;

import android.annotation.SuppressLint;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.fartosj.R;
import com.example.fartosj.entities.Carta;
import com.example.fartosj.listeners.SelectListenerCarta;

import java.util.List;

public class adapterCardPlayer extends RecyclerView.Adapter<adapterCardPlayer.MyviewHolder>{

    private List<Carta> cartas;

    private SelectListenerCarta selectListenerCarta;

    public adapterCardPlayer(List<Carta> cartas) {
        this.cartas = cartas;
    }

    public adapterCardPlayer(List<Carta> cartas, SelectListenerCarta selectListenerCarta) {
        this.cartas = cartas;
        this.selectListenerCarta = selectListenerCarta;
    }

    @NonNull
    @Override
    public MyviewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {


        return new adapterCardPlayer.MyviewHolder(LayoutInflater.from(parent.getContext())
                .inflate(R.layout.layout_card_gallery,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull MyviewHolder holder, @SuppressLint("RecyclerView") int position) {
        holder.bindData(cartas.get(position));

        holder.iv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selectListenerCarta.onItemClicked(cartas.get(position));
            }
        });


    }

    @Override
    public int getItemCount() {
        return cartas.size();
    }




    public class MyviewHolder extends RecyclerView.ViewHolder{
        ImageView iv;

        public MyviewHolder(@NonNull View itemView){
            super(itemView);

            iv = itemView.findViewById(R.id.cartamas1);
        }

        void bindData(final Carta c){
            iv.setImageResource(c.getId());
            Glide.with(itemView).load(c.getId()).into(iv);

        }

    }
}
