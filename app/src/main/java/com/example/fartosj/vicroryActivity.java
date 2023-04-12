package com.example.fartosj;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;

import com.example.fartosj.entities.Player;

public class vicroryActivity extends AppCompatActivity {
    Player winner;

    ImageView iv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vicrory);

        iv = findViewById(R.id.victoryIV);

        winner = (Player) getIntent().getSerializableExtra("winner");

        iv.setImageResource(winner.getStandSkin());


    }
}