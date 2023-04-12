package com.example.fartosj;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.room.Room;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.fartosj.entities.Carta;
import com.example.fartosj.entities.Player;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.IllegalFormatCodePointException;
import java.util.List;
//
//import com.example.fartosj.DAOS.PlayerDao;
////import com.example.fartosj.database.AppDatabase;
//import com.example.fartosj.entities.Player;

public class gameActivitytest extends AppCompatActivity implements com.example.fartosj.cardsFragment.CardFragmentListener, Objective.sendCartaApply, gokuFragment.GokuListener {

    Fragment mapFragment;
    gameFragmenttest gameFragmenttest;
    Fragment cardsFragment;
    Fragment objectiveFragment;
    Fragment fragmentKinton;

    FragmentTransaction transaction;
    FragmentTransaction transaction2;
    FragmentTransaction transaction3;
    FragmentTransaction transaction4;

    List<Player> playerList= new ArrayList<>();

    TextView tornTV,numTorn,numRonda;
    int tornI=0;
    int nRonda=1;
    int nTorn=1;
    int nRondaN3=0;
    int ultimaCasella=0;
    String torn;
    Button cardsBTN;
    boolean cardsMenuDisplayed=false;



    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_activitytest);
        Intent intent = getIntent();

        Bundle bundle = new Bundle();

        String nomp1 = intent.getStringExtra("p1name");
        String skinp1 = intent.getStringExtra("p1skin");

        String nomp2 = intent.getStringExtra("p2name");
        String skinp2 = intent.getStringExtra("p2skin");



        String nomp3 = intent.getStringExtra("p3name");
        String skinp3 = intent.getStringExtra("p3skin");


        String nomp4 = intent.getStringExtra("p4name");
        String skinp4 = intent.getStringExtra("p4skin");

        bundle.putString("p1name",nomp1);
        bundle.putString("p1skin",skinp1);

        bundle.putString("p2name",nomp2);
        bundle.putString("p2skin",skinp2);

        bundle.putString("p3name",nomp3);
        bundle.putString("p3skin",skinp3);

        bundle.putString("p4name",nomp4);
        bundle.putString("p4skin",skinp4);

//        mapFragment= new gameFragmenttest();
//        mapFragment.setArguments(bundle);



        transaction = getSupportFragmentManager().beginTransaction();
        gameFragmenttest = (gameFragmenttest) getSupportFragmentManager().findFragmentById(R.id.gameFragmentContainer);
        gameFragmenttest = new gameFragmenttest();
        gameFragmenttest.setArguments(bundle);
        transaction.replace(R.id.gameContainer,gameFragmenttest).commit();

        tornTV = (TextView) findViewById(R.id.torn);
        tornTV.setText(nomp1);

        numRonda=(TextView) findViewById(R.id.numRondaTV);
        numTorn=(TextView) findViewById(R.id.numTornTV);

        numTorn.setText(String.valueOf(nTorn));
        numRonda.setText(String.valueOf(nRonda));


        cardsBTN = (Button) findViewById(R.id.asasas);
        cardsBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (cardsMenuDisplayed){
                    cardsBTN.setText("SHOW\nCARDS");
                    transaction2 = getSupportFragmentManager().beginTransaction();
                    transaction2.remove(cardsFragment).commit();
                    gameFragmenttest.noScroll();
                    cardsMenuDisplayed = !cardsMenuDisplayed;

                }else{
                    cardsBTN.setText("HIDE\nCARDS");
                    playerList= gameFragmenttest.pasarPlayers();
                    Log.d("pasandoPlayers",playerList.get(0).getName());
                    gameFragmenttest.noScroll();
                    transaction2 = getSupportFragmentManager().beginTransaction();
                    cardsFragment = new cardsFragment();
                    Bundle bundleTorn = new Bundle();
                    bundleTorn.putString("torn", String.valueOf(tornTV.getText()));
                    bundleTorn.putSerializable("players", (Serializable) playerList);
                    cardsFragment.setArguments(bundleTorn);
                    transaction2.replace(R.id.cartasFragment,cardsFragment).commit();
                    cardsMenuDisplayed = !cardsMenuDisplayed;
                }

            }
        });

    }




    public void nextTorn(){
        gameFragmenttest.checkVictory();
        tornI++;
        if (tornI==4){
            tornI=0;
            nTorn++;
            if (nTorn==7){
                nTorn=1;
                gameFragmenttest.reparteCartas();
                nRonda++;
            }
                if (nRonda>=3){

                    gameFragmenttest.eliminarCasellas(nRondaN3);
                    nRondaN3++;
                }
            numTorn.setText(String.valueOf(nTorn));
            numRonda.setText(String.valueOf(nRonda));
        }


        if (tornI==0){
            tornTV.setText(playerList.get(0).getName());
            if (playerList.get(0).isEliminado()){
                nextTorn();
            }
        }
        if (tornI==1){
            tornTV.setText(playerList.get(1).getName());
            if (playerList.get(1).isEliminado()){
                nextTorn();
            }
        }
        if (tornI==2){
            tornTV.setText(playerList.get(2).getName());
            if (playerList.get(2).isEliminado()){
                nextTorn();
            }
        }
        if (tornI==3){
            tornTV.setText(playerList.get(3).getName());
            if (playerList.get(3).isEliminado()){
                nextTorn();
            }
        }




    }

    public boolean checkC8(Player p){
        boolean tr=false;
        if (p.getCasilla()==7 && p.getAntCasilla()<=6){
            tr=true;
        }
        return tr;
    }

    @Override
    public void onCardsObjectiveChanged(Carta carta) {
        cardsMenuDisplayed = !cardsMenuDisplayed;
        cardsBTN.setText("SHOW\nCARDS");

        playerList= gameFragmenttest.pasarPlayers();
        transaction2 = getSupportFragmentManager().beginTransaction();
        transaction2.remove(cardsFragment).commit();
        objectiveFragment = new Objective();
        Bundle bundleObj = new Bundle();
        bundleObj.putString("torn", String.valueOf(tornTV.getText()));
        bundleObj.putSerializable("players", (Serializable) playerList);
        bundleObj.putSerializable("carta",(Serializable) carta);
        objectiveFragment.setArguments(bundleObj);
        transaction3 = getSupportFragmentManager().beginTransaction();
        transaction3.replace(R.id.cartasFragment,objectiveFragment).commit();

    }

    @Override
    public void onSendCartaApply(List<Player> players) {
        transaction3 = getSupportFragmentManager().beginTransaction();
        transaction3.remove(objectiveFragment).commit();
        gameFragmenttest.coolocarJugadores(players);

        cardsBTN.setText("SHOW\nCARDS");

        boolean c8=false;
        for (Player p:playerList) {
            if (checkC8(p)==true ){
                c8=true;
                p.setC8(true);
            }else{}
        }

        if (c8){
            for (Player p:playerList) {
                if (p.isC8()==true && p.getAntCasilla()<=6){
                    startGokuHelp(p);
                    p.setC8(false);
                }else{}
            }
        }else {
            nextTorn();
        }

    }

    public void startGokuHelp(Player p){
        transaction4 = getSupportFragmentManager().beginTransaction();
        fragmentKinton = new gokuFragment();
        Bundle bundle = new Bundle();
        bundle.putSerializable("player", (Serializable) p);
        transaction4.replace(R.id.fragmentKinton,fragmentKinton).commit();


    }

    public void objectiveGoku(Player p){


    }

    @Override
    public void onGokuListener(Carta carta) {
        transaction4 = getSupportFragmentManager().beginTransaction();
        transaction4.remove(fragmentKinton).commit();

        Carta c = new Carta("goku's help","gokuHelp",1);
        onCardsObjectiveChanged(c);

    }
}