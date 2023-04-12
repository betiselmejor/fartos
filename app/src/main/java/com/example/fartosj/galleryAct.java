package com.example.fartosj;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class galleryAct extends AppCompatActivity {

    Button gomas1,gomas2,gomas3,gosp;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gallery);

        init();
    }


    public void init(){
        gomas1 = findViewById(R.id.show1cards);
        gomas1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent a = new Intent(galleryAct.this, mas1gallery.class);
                startActivity(a);
            }
        });


        gomas2 = findViewById(R.id.show2cards);
        gomas2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent a = new Intent(galleryAct.this, mas2gallery.class);
                startActivity(a);
            }
        });

        gomas3 = findViewById(R.id.show3cards);
        gomas3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent a = new Intent(galleryAct.this, mas3gallery.class);
                startActivity(a);
            }
        });

        gosp = findViewById(R.id.showspcards);
        gosp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent a = new Intent(galleryAct.this,spgallery.class);
                startActivity(a);
            }
        });
    }
}