package com.example.fartosj.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.fartosj.R;
import com.example.fartosj.entities.Carta;

import java.util.List;

public class adapterCardGallery extends RecyclerView.Adapter<adapterCardGallery.MyviewHolder> {

    private List<Carta> cartas;

    public adapterCardGallery(List<Carta> cartas) {
        this.cartas = cartas;
    }

    @NonNull
    @Override
    public adapterCardGallery.MyviewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MyviewHolder(LayoutInflater.from(parent.getContext())
                .inflate(R.layout.layout_card_gallery,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull adapterCardGallery.MyviewHolder holder, int position) {
        holder.bindData(cartas.get(position));




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
