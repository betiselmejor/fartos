package com.example.fartosj;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.fartosj.entities.Carta;
import com.example.fartosj.entities.Player;

import java.util.ArrayList;
import java.util.IllegalFormatCodePointException;
import java.util.List;


public class Objective extends Fragment implements View.OnClickListener {

    View vista;
    ImageView IVp1,IVp2,IVp3,IVp4;
    TextView TVp1,TVp2,TVp3,TVp4,
                deadp1,deadp2,deadp3,deadp4,
                POSp1,POSp2,POSp3,POSp4,
                effect,userTV,targetTV;
    Button use;
    List<Player> playerList;
    Carta carta;
    String torn;
    Player user;
    Player target= null;

    int ultimaCasella=0;

    View v1;

    private sendCartaApply mListener;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mListener = (sendCartaApply) context;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        vista= inflater.inflate(R.layout.fragment_objective, container, false);
        init();
        getData();
        colocarJugadors();
        changeTitle();

        return vista;
    }

    public void init(){
        IVp1 = vista.findViewById(R.id.objectiveP1);
        IVp1.setOnClickListener(this);

        IVp2 = vista.findViewById(R.id.objectiveP2);
        IVp2.setOnClickListener(this);

        IVp3 = vista.findViewById(R.id.objectiveP3);
        IVp3.setOnClickListener(this);

        IVp4 = vista.findViewById(R.id.objectiveP4);
        IVp4.setOnClickListener(this);


        TVp1 = vista.findViewById(R.id.PN1text);
        TVp2 = vista.findViewById(R.id.PN2text);
        TVp3 = vista.findViewById(R.id.PN3text);
        TVp4 = vista.findViewById(R.id.PN4text);

        POSp1 = vista.findViewById(R.id.posP1);
        POSp2 = vista.findViewById(R.id.posP2);
        POSp3 = vista.findViewById(R.id.posP3);
        POSp4 = vista.findViewById(R.id.posP4);

        effect = vista.findViewById(R.id.effectTV);

        deadp1 = vista.findViewById(R.id.deadp1);
        deadp2 = vista.findViewById(R.id.deadp2);
        deadp3 = vista.findViewById(R.id.deadp3);
        deadp4 = vista.findViewById(R.id.deadp4);

        userTV = vista.findViewById(R.id.userTV);
        targetTV = vista.findViewById(R.id.targetTV);
        use = vista.findViewById(R.id.useBTN);
        use.setOnClickListener(this);


    }
    public void changeTitle(){
        if (carta.getType().equals("+1")){
            effect.setText("Effect: Moves you 1 square ahead or one of your rivals 1 back");

        }

        if (carta.getType().equals("+2")){
            effect.setText("Effect: Moves you 2 squares ahead or one of your rivals 2 back");

        }

        if (carta.getType().equals("+3")){
            effect.setText("Effect: Moves you 3 square ahead or one of your rivals 3 back");
        }

        if (carta.getType().equals("broma")){
            effect.setText("Effect: Change your cards with the target player");
        }

        if (carta.getType().equals("sink")){
            effect.setText("Effect: The target player goes to the 1st square");
        }

        if (carta.getType().equals("patada")){
            effect.setText("Effect: Decrease the power of the target player cards by 1");
        }

        if (carta.getType().equals("tp")){
            effect.setText("Effect: Change your position with the target");
        }

        if (carta.getType().equals("trip")){
            effect.setText("Effect: The target loses a card");
        }

        if (carta.getType().equals("extra")){
            effect.setText("Effect: Try luck");
        }

        if (carta.getType().equals("gokuHelp")){
            effect.setText("Effect: Seems like goku wants to help you!");

        }

    }

    public void getData(){
        Bundle bundle = getArguments();
        List<Player> players = (List<Player>) bundle.getSerializable("players");
        playerList=players;
        carta = (Carta) bundle.getSerializable("carta");

        torn = bundle.getString("torn");

        for (Player p :
                playerList) {
            if (p.getName().equals(torn)){
                user = p;
            }
        }
        Log.d("gettingData","USER: " + user.getName());

        userTV.setText(user.getName());
    }

    public void colocarJugadors(){
        Glide.with(this).load(playerList.get(0).getRunningSkin()).into(IVp1);
        TVp1.setText(playerList.get(0).getName());
        POSp1.setText(String.valueOf(playerList.get(0).getCasilla()+1));
        if (playerList.get(0).isEliminado()){
            deadp1.setVisibility(View.VISIBLE);
        }

        Glide.with(this).load(playerList.get(1).getRunningSkin()).into(IVp2);
        TVp2.setText(playerList.get(1).getName());
        POSp2.setText(String.valueOf(playerList.get(1).getCasilla()+1));
        if (playerList.get(1).isEliminado()){
            deadp2.setVisibility(View.VISIBLE);
        }


        Glide.with(this).load(playerList.get(2).getRunningSkin()).into(IVp3);
        TVp3.setText(playerList.get(2).getName());
        POSp3.setText(String.valueOf(playerList.get(2).getCasilla()+1));
        if (playerList.get(2).isEliminado()){
            deadp3.setVisibility(View.VISIBLE);
        }

        Glide.with(this).load(playerList.get(3).getRunningSkin()).into(IVp4);
        TVp4.setText(playerList.get(3).getName());
        POSp4.setText(String.valueOf(playerList.get(3).getCasilla()+1));
        if (playerList.get(3).isEliminado()){
            deadp4.setVisibility(View.VISIBLE);
        }



    }
//    public void checkdead(Player p ,TextView tv){
//        if (p.isEliminado()){
//            tv.setTextColor(Color.RED);
//        }
//
//
//    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.objectiveP1:
                target = playerList.get(0);
                changeTarget();
                break;
            case R.id.objectiveP2:
                target = playerList.get(1);
                changeTarget();
                break;
            case R.id.objectiveP3:
                target = playerList.get(2);
                changeTarget();
                break;
            case R.id.objectiveP4:
                target = playerList.get(3);
                changeTarget();
                break;


            case R.id.useBTN:
                tryuseCard();
                break;
        }

    }



    public void changeTarget(){
        if (target.isEliminado()){
            Toast.makeText(vista.getContext(), "jugador esta eliminat escull un altre", Toast.LENGTH_SHORT).show();
            target=null;
        }else{
            targetTV.setText(target.getName());

        }
    }

    public void tryuseCard(){

        if (String.valueOf(targetTV.getText()).equals("---")){
            Toast.makeText(vista.getContext(), "Select a target first", Toast.LENGTH_SHORT).show();
        }else{
            useCard();
        }
    }

    public void useCard(){
        target.setAntCasilla(target.getCasilla());
        Log.d("antCasilla", "ant Casilla "+ String.valueOf(target.getAntCasilla()));

        user.setAntCasilla(user.getCasilla());
        Log.d("antCasilla", "ant Casilla user "+ String.valueOf(user.getAntCasilla()));


        if (carta.getType().equals("+1")){
            useM1card();
        }

        if (carta.getType().equals("+2")){
            useM2card();
        }

        if (carta.getType().equals("+3")){
            useM3card();
        }

        if (carta.getType().equals("broma")){
            useTrickCard();
        }

        if (carta.getType().equals("sink")){
            useSinkCard();
        }
        if (carta.getType().equals("patada")){
            useKickCard();
        }

        if (carta.getType().equals("tp")){
            useTpCard();
        }

        if (carta.getType().equals("trip")){
            useTripCard();
        }
        if (carta.getType().equals("extra")){
            useExtraCard();
        }
        if (carta.getType().equals("gokuHelp")){
            useGokuCard();
        }
    }

    public void useM1card(){
        if (user.equals(target)){
            if (user.isKicked()==true){
                Toast.makeText(vista.getContext(), "using card on self", Toast.LENGTH_SHORT).show();
                target.setCasilla(target.getCasilla()+0);
                target.setKicked(false);

            }else{
                Toast.makeText(vista.getContext(), "using card on self", Toast.LENGTH_SHORT).show();
                target.setCasilla(target.getCasilla()+1);
            }

        }else{
            if (target.getCasilla() ==ultimaCasella || target.getCasilla()-3<ultimaCasella ){
                Toast.makeText(vista.getContext(), "El jugador objectiu no pot tirar enrere, perds la carta por bobo", Toast.LENGTH_SHORT).show();
            }else{
                if (user.isKicked()==true && !(target.getCasilla()-0<ultimaCasella)){
                    target.setCasilla(target.getCasilla()-0);
                    target.setKicked(false);

                }
                target.setCasilla(target.getCasilla()-1);
            }
        }
        applyCard();

    }

    public void useM2card(){
        if (user.equals(target)){
            if (user.isKicked()==true){
                Toast.makeText(vista.getContext(), "using card on self", Toast.LENGTH_SHORT).show();
                target.setCasilla(target.getCasilla()+1);
                target.setKicked(false);

            }else{
                Toast.makeText(vista.getContext(), "using card on self", Toast.LENGTH_SHORT).show();
                target.setCasilla(target.getCasilla()+2);
            }

        }else{
            if (target.getCasilla() ==ultimaCasella || target.getCasilla()-3<ultimaCasella ){
                Toast.makeText(vista.getContext(), "El jugador objectiu no pot tirar enrere, perds la carta por bobo", Toast.LENGTH_SHORT).show();
            }else{
                if (user.isKicked()==true && !(target.getCasilla()-1<ultimaCasella)){
                    target.setCasilla(target.getCasilla()-1);
                    target.setKicked(false);

                }
                target.setCasilla(target.getCasilla()-2);
            }
        }
        applyCard();

    }

    public void useM3card(){
        if (user.equals(target)){
            if (user.isKicked()==true){
                Toast.makeText(vista.getContext(), "using card on self", Toast.LENGTH_SHORT).show();
                target.setCasilla(target.getCasilla()+2);
                target.setKicked(false);

            }else{
                Toast.makeText(vista.getContext(), "using card on self", Toast.LENGTH_SHORT).show();
                target.setCasilla(target.getCasilla()+3);
            }

        }else{
            if (target.getCasilla() ==ultimaCasella || target.getCasilla()-3<ultimaCasella ){
                Toast.makeText(vista.getContext(), "El jugador objectiu no pot tirar enrere, perds la carta por bobo", Toast.LENGTH_SHORT).show();
            }else{
                if (user.isKicked()==true && !(target.getCasilla()-2<ultimaCasella)){
                    target.setCasilla(target.getCasilla()-2);
                    target.setKicked(false);

                }
                target.setCasilla(target.getCasilla()-3);
            }
        }
        applyCard();

    }

    public void useTrickCard(){
        if (user.equals(target)){
            Toast.makeText(vista.getContext(), "This card cant be used on yourself, select another target", Toast.LENGTH_SHORT).show();
        }else{
            String nomCarta = carta.getNom();
            List<Carta> cartasUser = user.getMano();
            List<Carta> cartasTarget = target.getMano();

            user.setMano((ArrayList<Carta>) cartasTarget);
            target.setMano((ArrayList<Carta>) cartasUser);

            for (Carta c :
                    target.getMano()) {
                if (c.equals(nomCarta)){
                    target.getMano().remove(c);
                }
            }
            applyCard();

        }

    }

    public void useSinkCard(){
        if (user.equals(target)){
            Toast.makeText(vista.getContext(), "This card cant be used on yourself, select another target", Toast.LENGTH_SHORT).show();
        }else{
            target.setCasilla(ultimaCasella);
            applyCard();

        }

    }

    public void useKickCard(){
        if (user.equals(target)){
            Toast.makeText(vista.getContext(), "This card cant be used on yourself, select another target", Toast.LENGTH_SHORT).show();
        }else{
            target.setKicked(true);
            applyCard();

        }

    }

    public void useTpCard(){
        if (user.equals(target)){
            Toast.makeText(vista.getContext(), "This card cant be used on yourself, select another target", Toast.LENGTH_SHORT).show();
        }else{
            int posTarget = target.getCasilla();
            int posUser = user.getCasilla();

            user.setCasilla(posTarget);
            target.setCasilla(posUser);
            applyCard();

        }

    }

    public void useTripCard(){
        if (user.equals(target)){
            Toast.makeText(vista.getContext(), "This card cant be used on yourself, select another target", Toast.LENGTH_SHORT).show();
        }else{
            target.getMano().remove(0);
            applyCard();

        }
    }

    public void useExtraCard(){
        int prob = (int) Math.round(Math.random()*2);
        if (prob>0){
            target.setCasilla(target.getCasilla()+1);
        }else{
            target.setCasilla(target.getCasilla()-1);
        }
        applyCard();

    }

    public void useGokuCard(){
        if (user.equals(target)){
                Toast.makeText(vista.getContext(), "using card on self", Toast.LENGTH_SHORT).show();
                target.setCasilla(target.getCasilla()+5);
                applyCard();
        }else{
            if (target.getCasilla() <=ultimaCasella|| target.getCasilla()-5<ultimaCasella){
                Toast.makeText(vista.getContext(), "El jugador objectiu no pot tirar enrere, selecciona algun altre", Toast.LENGTH_SHORT).show();
            }else{

                target.setCasilla(target.getCasilla()-5);
                applyCard();
            }


        }
//        applyCard();


    }


    public void applyCard(){
        List<Carta> cartasUser = user.getMano();
        List<Carta> cartasTarget = target.getMano();
        Log.d("aplicantlacarta", String.valueOf(cartasUser.size()));

        for (int i = 0; i < cartasUser.size(); i++) {
            if (cartasUser.get(i).equals(carta)){
                cartasUser.remove(i);
            }
        }
        for (int i = 0; i < cartasTarget.size(); i++) {
            if (cartasTarget.get(i).equals(carta)){
                cartasTarget.remove(i);
            }
        }
        user.setMano((ArrayList<Carta>) cartasUser);
        target.setMano((ArrayList<Carta>) cartasTarget);

        Toast.makeText(vista.getContext(), "aplicada la carta" + carta.getNom()+ " a "+ target.getName(), Toast.LENGTH_SHORT).show();

        Log.d("aplicantlacarta","User data: num Cartas"+ String.valueOf(user.getMano().size()));
        Log.d("aplicantlacarta","User data: pos"+ user.getCasilla());

        Log.d("aplicantlacarta","target data: num Cartas"+ target.getMano().size());
        Log.d("aplicantlacarta","target data: pos"+ target.getCasilla());



        mListener.onSendCartaApply(playerList);
    }

    public interface sendCartaApply {
        void onSendCartaApply(List<Player> players);
    }
}