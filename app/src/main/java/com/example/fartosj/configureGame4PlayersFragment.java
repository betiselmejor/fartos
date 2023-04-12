package com.example.fartosj;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.fartosj.entities.Player;

import java.util.ArrayList;
import java.util.List;


public class configureGame4PlayersFragment extends Fragment implements View.OnClickListener {

    Button p1previousS,p1nextS,
            p2previousS,p2nextS,
            p3previousS,p3nextS,
            p4previousS,p4nextS,
            startGame;

    ImageView skinp1,skinp2,skinp3,skinp4;

    View vista;

    List <Player> skins = new ArrayList<>();

    EditText P1name,P2name,P3name,P4name;

    int contSkinp1=0;
    int contSkinp2=1;
    int contSkinp3=2;
    int contSkinp4=3;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        vista = inflater.inflate(R.layout.fragment_configure_game4_players,container,false);

        init();


        return vista;
    }

    public void init(){
        P1name = (EditText) vista.findViewById(R.id.P1name);
        P2name = (EditText) vista.findViewById(R.id.P2name);
        P3name = (EditText) vista.findViewById(R.id.P3name);
        P4name = (EditText) vista.findViewById(R.id.P4name);

        startGame = (Button) vista.findViewById(R.id.startGameButton);
        startGame.setOnClickListener(this);

        p1previousS = (Button) vista.findViewById(R.id.previousSkinP1);
        p1nextS= (Button) vista.findViewById(R.id.nextSkinP1);
        //--------------------------------------------------------------------//
        p1previousS.setOnClickListener(this);
        p1nextS.setOnClickListener(this);


        p2previousS = (Button) vista.findViewById(R.id.previousSkinP2);
        p2nextS= (Button) vista.findViewById(R.id.nextSkinP2);
        //--------------------------------------------------------------------//
        p2previousS.setOnClickListener(this);
        p2nextS.setOnClickListener(this);


        p3previousS = (Button) vista.findViewById(R.id.previousSkinP3);
        p3nextS= (Button) vista.findViewById(R.id.nextSkinP3);
        //--------------------------------------------------------------------//
        p3previousS.setOnClickListener(this);
        p3nextS.setOnClickListener(this);


        p4previousS = (Button) vista.findViewById(R.id.previousSkinP4);
        p4nextS= (Button) vista.findViewById(R.id.nextSkinP4);
        //--------------------------------------------------------------------//
        p4previousS.setOnClickListener(this);
        p4nextS.setOnClickListener(this);

        createSkins();


        skinp1 = (ImageView) vista.findViewById(R.id.skin1player);
        skinp2 = (ImageView) vista.findViewById(R.id.skin2player);
        skinp3 = (ImageView) vista.findViewById(R.id.skin3player);
        skinp4 = (ImageView) vista.findViewById(R.id.skin4player);

        setIVS();


    }

    public void createSkins(){
        Player p1 = new Player(R.drawable.skinmovimientosora,R.drawable.skinparadosora,"Sora",0);
        Player p2 = new Player(R.drawable.skinmovimientobatman,R.drawable.skinparadobatman,"Batman",0);
        Player p3 = new Player(R.drawable.skinmovimientogoku,R.drawable.skinparadogoku,"Goku",0);
        Player p4 = new Player(R.drawable.skinmovimientomark,R.drawable.skinparadomark,"Mark Evans",0);
        Player p5 = new Player(R.drawable.skinparadospiderman,R.drawable.skinmovimientospiderman,"Spiderman",0);
        Player p6 = new Player(R.drawable.skinmovimientopedro,R.drawable.skinparadopedro,"Pedro",0);

        skins.add(p1);
        skins.add(p2);
        skins.add(p3);
        skins.add(p4);
        skins.add(p5);
        skins.add(p6);
    }

    public void setIVS(){

        Glide.with(this).load(skins.get(contSkinp1).getRunningSkin()).into(skinp1);
        P1name.setText(skins.get(contSkinp1).getName());

        Glide.with(this).load(skins.get(contSkinp2).getRunningSkin()).into(skinp2);
        P2name.setText(skins.get(contSkinp2).getName());


        Glide.with(this).load(skins.get(contSkinp3).getRunningSkin()).into(skinp3);
        P3name.setText(skins.get(contSkinp3).getName());


        Glide.with(this).load(skins.get(contSkinp4).getRunningSkin()).into(skinp4);
        P4name.setText(skins.get(contSkinp4).getName());


    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){
            case R.id.previousSkinP1:
                    if (contSkinp1==0){
                        contSkinp1=5;
                    }else{
                        contSkinp1--;
                    }
                    setIVS();
                break;
            case R.id.nextSkinP1:
                    if (contSkinp1==4){
                        contSkinp1=0;
                    }else{
                        contSkinp1++;
                    }
                    setIVS();
                break;
//ccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccc



            case R.id.previousSkinP2:
                    if (contSkinp2==0){
                        contSkinp2=5;
                    }else{
                        contSkinp2--;
                    }
                    setIVS();
                break;
            case R.id.nextSkinP2:
                    if (contSkinp2==5){
                        contSkinp2=0;
                    }else{
                        contSkinp2++;
                    }
                    setIVS();
                break;
//ccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccc



            case R.id.previousSkinP3:
                    if (contSkinp3==0){
                        contSkinp3=5;
                    }else{
                        contSkinp3--;
                    }
                    setIVS();
                break;
            case R.id.nextSkinP3:
                    if (contSkinp3==5){
                        contSkinp3=0;
                    }else{
                        contSkinp3++;
                    }
                    setIVS();
                break;
//ccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccc



            case R.id.previousSkinP4:
                    if (contSkinp4==0){
                        contSkinp4=5;
                    }else{
                        contSkinp4--;
                    }
                    setIVS();
                break;
            case R.id.nextSkinP4:
                    if (contSkinp4==5){
                        contSkinp4=0;
                    }else{
                        contSkinp4++;
                    }
                    setIVS();
                break;
//ccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccc
//ccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccc
//ccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccc


            case R.id.startGameButton:
                Toast.makeText(getContext(), "asdasd", Toast.LENGTH_SHORT).show();
                    Intent a = new Intent(getActivity(),gameActivitytest.class);
                    a.putExtra("p1name",String.valueOf(P1name.getText()));
                    a.putExtra("p1skin",String.valueOf(contSkinp1));
                    Log.d("p1", String.valueOf(contSkinp1)+ " "+P1name.getText());

                    a.putExtra("p2name",String.valueOf(P2name.getText()));
                    a.putExtra("p2skin",String.valueOf(contSkinp2));
                    Log.d("p2", String.valueOf(contSkinp2)+ " "+P2name.getText());


                    a.putExtra("p3name",String.valueOf(P3name.getText()));
                    a.putExtra("p3skin",String.valueOf(contSkinp3));
                    Log.d("p3", String.valueOf(contSkinp3)+ " "+P3name.getText());



                    a.putExtra("p4name",String.valueOf(P4name.getText()));
                    a.putExtra("p4skin",String.valueOf(contSkinp4));
                    Log.d("p4", String.valueOf(contSkinp4)+ " "+P4name.getText());


                startActivity(a);
                break;

        }
    }
}