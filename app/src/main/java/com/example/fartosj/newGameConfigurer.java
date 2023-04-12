package com.example.fartosj;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class newGameConfigurer extends AppCompatActivity implements View.OnClickListener{


    Button btn4players,btn3players,btn2players,btn1players;

    Fragment players4Fragment;
    FragmentTransaction transaction;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_game_configurer);


        init();
    }

    public void init(){
        btn4players = (Button) findViewById(R.id.btn4player);
        btn4players.setOnClickListener(this);

        btn3players = (Button) findViewById(R.id.btn3player);
        btn3players.setOnClickListener(this);

        btn2players = (Button) findViewById(R.id.btn2player);
        btn2players.setOnClickListener(this);

        btn1players = (Button) findViewById(R.id.btn1player);
        btn1players.setOnClickListener(this);

        transaction = getSupportFragmentManager().beginTransaction();

        players4Fragment= new configureGame4PlayersFragment();
    }

    @Override
    public void onClick(View view){

        switch (view.getId()){
            case R.id.btn4player:
                Toast.makeText(newGameConfigurer.this, "Selectedd 4 players", Toast.LENGTH_SHORT).show();
                btn4players.setBackgroundColor(Color.parseColor("#a5f59b"));
                btn3players.setBackgroundColor(Color.parseColor("#717171"));
                btn2players.setBackgroundColor(Color.parseColor("#717171"));
                btn1players.setBackgroundColor(Color.parseColor("#717171"));
                transaction.replace(R.id.fragment_container,players4Fragment).commit();
                break;
                //cccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccc//

            case R.id.btn3player:
                Toast.makeText(newGameConfigurer.this, "Selectedd 3 players", Toast.LENGTH_SHORT).show();
                btn4players.setBackgroundColor(Color.parseColor("#717171"));
                btn3players.setBackgroundColor(Color.parseColor("#a5f59b"));
                btn2players.setBackgroundColor(Color.parseColor("#717171"));
                btn1players.setBackgroundColor(Color.parseColor("#717171"));
                break;
                //cccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccc//

            case R.id.btn2player:
                Toast.makeText(newGameConfigurer.this, "Selectedd 2 players", Toast.LENGTH_SHORT).show();
                btn4players.setBackgroundColor(Color.parseColor("#717171"));
                btn3players.setBackgroundColor(Color.parseColor("#717171"));
                btn2players.setBackgroundColor(Color.parseColor("#a5f59b"));
                btn1players.setBackgroundColor(Color.parseColor("#717171"));
                break;
                //cccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccc//

            case R.id.btn1player:
                Toast.makeText(newGameConfigurer.this, "Selectedd 1 players", Toast.LENGTH_SHORT).show();
                btn4players.setBackgroundColor(Color.parseColor("#717171"));
                btn3players.setBackgroundColor(Color.parseColor("#717171"));
                btn2players.setBackgroundColor(Color.parseColor("#717171"));
                btn1players.setBackgroundColor(Color.parseColor("#a5f59b"));
                break;
                //cccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccc//

        }
    }
}