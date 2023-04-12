package com.example.fartosj;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

public class MainActivity extends AppCompatActivity {

    Button goGallery, goGame;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();


    }
    public void init(){
        goGallery = (Button) findViewById(R.id.toGalleryBtn);
        goGame = (Button) findViewById(R.id.toGameBtn);


        goGallery.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent a = new Intent(MainActivity.this, galleryAct.class);
                startActivity(a);
            }
        });

        goGame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent a = new Intent(MainActivity.this, newGameConfigurer.class);
                startActivity(a);
            }
        });
    }
}