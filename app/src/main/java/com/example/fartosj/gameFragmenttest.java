package com.example.fartosj;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;


import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TableLayout;

import com.example.fartosj.entities.Carta;
import com.example.fartosj.entities.Player;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class gameFragmenttest extends Fragment {

    View vista;
    RelativeLayout container;
    private ScaleGestureDetector mScaleGestureDetector;
    private GestureDetector mGestureDetector;
    private View mContentView;
    private float mScaleFactor = 1.0f;
    private float mPosX;
    private float mPosY;
    private float mLastTouchX;
    private float mLastTouchY;

    ImageView j1c1,j1c2,j1c3,j1c4,j1c5,j1c6,j1c7,j1c8,j1c9,j1c10,j1c11,j1c12,j1c13,j1c14,
            j2c1,j2c2,j2c3,j2c4,j2c5,j2c6,j2c7,j2c8,j2c9,j2c10,j2c11,j2c12,j2c13,j2c14,
            j3c1,j3c2,j3c3,j3c4,j3c5,j3c6,j3c7,j3c8,j3c9,j3c10,j3c11,j3c12,j3c13,j3c14,
            j4c1,j4c2,j4c3,j4c4,j4c5,j4c6,j4c7,j4c8,j4c9,j4c10,j4c11,j4c12,j4c13,j4c14,c15;

    TableLayout c1,c2,c3,c4,c5,c6,c7,c8,c9,c10,c11,c12,c13,c14;

    List<Player> skins = new ArrayList<>();
    List<Player> players = new ArrayList<>();
    List<Carta> baraja = new ArrayList<>();
    List<Carta> descartes= new ArrayList<>();

    int cortebaraja=0;
    int ronda=0;
    int torn=0;

    private Player p1= new Player();
    private Player p2= new Player();
    private Player p3= new Player();
    private Player p4= new Player();

    String turno;

    boolean scrollable=true;


    public interface OnButtonClickListener {
        void onButtonClick(ArrayList<Player> myList);
    }

    private OnButtonClickListener listener;

    //...


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        vista =  inflater.inflate(R.layout.fragment_game_fragmenttest, container, false);


        turno = "p1";

        initZoom();
        startIVS();
        startSkins();
        initPlayers();
        reparteCartas();
        for (Player p :
                players) {
            colocarJugadores(p);
        }

        pasarPlayers();

        return  vista;
    }

    private class ScaleListener extends ScaleGestureDetector.SimpleOnScaleGestureListener {
        @Override
        public boolean onScale(ScaleGestureDetector detector) {
            if (scrollable){
                mScaleFactor *= detector.getScaleFactor();
                mScaleFactor = Math.max(1.0f, Math.min(mScaleFactor, 3.0f)); // Limita el zoom a 3x

                container.setScaleX(mScaleFactor);
                container.setScaleY(mScaleFactor);
                return true;
            }
            return true;

        }
    }

    private class GestureListener extends GestureDetector.SimpleOnGestureListener {
        @Override
        public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
            if (scrollable){
                container.scrollBy((int) distanceX, (int) distanceY);

            }
            return true;
        }
    }

    public void initZoom(){
//        mContentView = vista.findViewById(android.R.id.content);
         container = vista.findViewById(R.id.gameFragmentContainer);
        mScaleGestureDetector = new ScaleGestureDetector(getContext(), new ScaleListener());
        mGestureDetector = new GestureDetector(getContext(), new GestureListener());

        container.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (scrollable){
                    mScaleGestureDetector.onTouchEvent(motionEvent);
                    mGestureDetector.onTouchEvent(motionEvent);
                }

                return true;
            }
        });


    }

    public void noScroll(){
        scrollable=!scrollable;
    }

    public void startIVS(){
        c1 = (TableLayout) vista.findViewById(R.id.casella1);
        c2 = (TableLayout) vista.findViewById(R.id.casella2);
        c3 = (TableLayout) vista.findViewById(R.id.casella3);
        c4 = (TableLayout) vista.findViewById(R.id.casella4);
        c5 = (TableLayout) vista.findViewById(R.id.casella5);
        c6 = (TableLayout) vista.findViewById(R.id.casella6);
        c7 = (TableLayout) vista.findViewById(R.id.casella7);
        c8 = (TableLayout) vista.findViewById(R.id.casella8);
        c9 = (TableLayout) vista.findViewById(R.id.casella9);
        c10 = (TableLayout) vista.findViewById(R.id.casella10);
        c11 = (TableLayout) vista.findViewById(R.id.casella11);
        c12 = (TableLayout) vista.findViewById(R.id.casella12);
        c13 = (TableLayout) vista.findViewById(R.id.casella13);
        c14 = (TableLayout) vista.findViewById(R.id.casella14);



        j1c1 = (ImageView) vista.findViewById(R.id.casella1J1);
        j1c2 = (ImageView) vista.findViewById(R.id.casella2J1);
        j1c3 = (ImageView) vista.findViewById(R.id.casella3J1);
        j1c4 = (ImageView) vista.findViewById(R.id.casella4J1);
        j1c5 = (ImageView) vista.findViewById(R.id.casella5J1);
        j1c6 = (ImageView) vista.findViewById(R.id.casella6J1);
        j1c7 = (ImageView) vista.findViewById(R.id.casella7J1);
        j1c8 = (ImageView) vista.findViewById(R.id.casella8J1);
        j1c9 = (ImageView) vista.findViewById(R.id.casella9J1);
        j1c10 = (ImageView) vista.findViewById(R.id.casella10J1);
        j1c11 = (ImageView) vista.findViewById(R.id.casella11J1);
        j1c12 = (ImageView) vista.findViewById(R.id.casella12J1);
        j1c13 = (ImageView) vista.findViewById(R.id.casella13J1);
        j1c14 = (ImageView) vista.findViewById(R.id.casella14J1);
//        j1c15 = (ImageView) findViewById(R.id.casella15T);

        j2c1 = (ImageView) vista.findViewById(R.id.casella1J2);
        j2c2 = (ImageView) vista.findViewById(R.id.casella2J2);
        j2c3 = (ImageView) vista.findViewById(R.id.casella3J2);
        j2c4 = (ImageView) vista.findViewById(R.id.casella4J2);
        j2c5 = (ImageView) vista.findViewById(R.id.casella5J2);
        j2c6 = (ImageView) vista.findViewById(R.id.casella6J2);
        j2c7 = (ImageView) vista.findViewById(R.id.casella7J2);
        j2c8 = (ImageView) vista.findViewById(R.id.casella8J2);
        j2c9 = (ImageView) vista.findViewById(R.id.casella9J2);
        j2c10 = (ImageView) vista.findViewById(R.id.casella10J2);
        j2c11 = (ImageView) vista.findViewById(R.id.casella11J2);
        j2c12 = (ImageView) vista.findViewById(R.id.casella12J2);
        j2c13 = (ImageView) vista.findViewById(R.id.casella13J2);
        j2c14 = (ImageView) vista.findViewById(R.id.casella14J2);
//        j2c15 = (ImageView) vista.findViewById(R.id.casella15T);

        j3c1 = (ImageView) vista.findViewById(R.id.casella1J3);
        j3c2 = (ImageView) vista.findViewById(R.id.casella2J3);
        j3c3 = (ImageView) vista.findViewById(R.id.casella3J3);
        j3c4 = (ImageView) vista.findViewById(R.id.casella4J3);
        j3c5 = (ImageView) vista.findViewById(R.id.casella5J3);
        j3c6 = (ImageView) vista.findViewById(R.id.casella6J3);
        j3c7 = (ImageView) vista.findViewById(R.id.casella7J3);
        j3c8 = (ImageView) vista.findViewById(R.id.casella8J3);
        j3c9 = (ImageView) vista.findViewById(R.id.casella9J3);
        j3c10 = (ImageView) vista.findViewById(R.id.casella10J3);
        j3c11 = (ImageView) vista.findViewById(R.id.casella11J3);
        j3c12 = (ImageView) vista.findViewById(R.id.casella12J3);
        j3c13 = (ImageView) vista.findViewById(R.id.casella13J3);
        j3c14 = (ImageView) vista.findViewById(R.id.casella14J3);
//        j3c15 = (ImageView) vista.findViewById(R.id.casella15T);

        j4c1 = (ImageView) vista.findViewById(R.id.casella1J4);
        j4c2 = (ImageView) vista.findViewById(R.id.casella2J4);
        j4c3 = (ImageView) vista.findViewById(R.id.casella3J4);
        j4c4 = (ImageView) vista.findViewById(R.id.casella4J4);
        j4c5 = (ImageView) vista.findViewById(R.id.casella5J4);
        j4c6 = (ImageView) vista.findViewById(R.id.casella6J4);
        j4c7 = (ImageView) vista.findViewById(R.id.casella7J4);
        j4c8 = (ImageView) vista.findViewById(R.id.casella8J4);
        j4c9 = (ImageView) vista.findViewById(R.id.casella9J4);
        j4c10 = (ImageView) vista.findViewById(R.id.casella10J4);
        j4c11 = (ImageView) vista.findViewById(R.id.casella11J4);
        j4c12 = (ImageView) vista.findViewById(R.id.casella12J4);
        j4c13 = (ImageView) vista.findViewById(R.id.casella13J4);
        j4c14 = (ImageView) vista.findViewById(R.id.casella14J4);

        c15 = (ImageView) vista.findViewById(R.id.casella15T);


    }

    public void startSkins(){
        Player p1 = new Player(R.drawable.skinmovimientosora,R.drawable.skinparadosora,"Sora",0);
        Player p2 = new Player(R.drawable.skinmovimientobatman,R.drawable.skinparadobatman,"Batman",0);
        Player p3 = new Player(R.drawable.skinmovimientogoku,R.drawable.skinparadogoku,"Goku",0);
        Player p4 = new Player(R.drawable.skinmovimientomark,R.drawable.skinparadomark,"Mark Evans",0);
        Player p5 = new Player(R.drawable.skinparadospiderman,R.drawable.skinmovimientospiderman,"Spiderman",0);
        Player p6 = new Player(R.drawable.skinmovimientopedro,R.drawable.skinparadopedro,"Spiderman",0);

        skins.add(p1);
        skins.add(p2);
        skins.add(p3);
        skins.add(p4);
        skins.add(p5);
        skins.add(p6);
    }

    public void startBaraja(){
        Carta mas11= new Carta("ADE","+1",R.drawable.masunouno);
        Carta mas12= new Carta("AMUMU","+1",R.drawable.masunodos);
        Carta mas13= new Carta("ASHE","+1",R.drawable.masunotres);
        Carta mas14= new Carta("AXEL","+1",R.drawable.masunocuatro);
        Carta mas15= new Carta("AXEL DEL MADRID","+1",R.drawable.masunocinco);
        Carta mas16= new Carta("BARDO","+1",R.drawable.masunoseis);
        Carta mas17= new Carta("BRAUM","+1",R.drawable.masunosiete);
        Carta mas18= new Carta("CHOGATH","+1",R.drawable.masunoocho);
        Carta mas19= new Carta("EKKO","+1",R.drawable.masunonueve);
        Carta mas110= new Carta("EZREAL","+1",R.drawable.masunodiez);
        Carta mas111= new Carta("ADE","+1",R.drawable.masunouno);
        Carta mas112= new Carta("GNAR","+1",R.drawable.masunodoce);
        Carta mas113= new Carta("IRELIA","+1",R.drawable.masunotrece);
        Carta mas114= new Carta("JIHN","+1",R.drawable.masunocatorce);
        Carta mas115= new Carta("KALISTA","+1",R.drawable.masunoquince);
        Carta mas116= new Carta("KING","+1",R.drawable.masunodieciseis);
        Carta mas117= new Carta("ADE","+1",R.drawable.masunodiecesiete);
        Carta mas118= new Carta("LEE SIN","+1",R.drawable.masunodieciocho);
        Carta mas119= new Carta("MISS FORTUNE","+1",R.drawable.masunodiecinueve);
        Carta mas120= new Carta("MORGANA","+1",R.drawable.masunoveinte);
        Carta mas121= new Carta("OMEGA TEEMP","+1",R.drawable.masunoveintiuno);
        Carta mas122= new Carta("PRINCETON","+1",R.drawable.masunoveintidos);
        Carta mas123= new Carta("PYKE","+1",R.drawable.masunoveintitres);
        Carta mas124= new Carta("TEEMO","+1",R.drawable.masunoveinticuatro);
        Carta mas126= new Carta("TWITCH","+1",R.drawable.masunoveintiseis);
        Carta mas127= new Carta("VAYNE","+1",R.drawable.masunoveintisiete);
        Carta mas128= new Carta("VLADIMIR","+1",R.drawable.masunoveintiocho);
        Carta mas129= new Carta("YASUO","+1",R.drawable.masunoveintinueve);

        Carta mas21= new Carta("ASHOKA","+2",R.drawable.masdosuno);
        Carta mas22= new Carta("BUU","+2",R.drawable.masdostres);
        Carta mas23= new Carta("SON GOHAN","+2",R.drawable.masdosseis);
        Carta mas24= new Carta("SON GOKU","+2",R.drawable.masdossiete);
        Carta mas25= new Carta("GRIEVOUS","+2",R.drawable.masdosocho);
        Carta mas26= new Carta("LEIA ORGANA","+2",R.drawable.masdosnueve);
        Carta mas27= new Carta("FREEZER","+2",R.drawable.masdosonce);
        Carta mas28= new Carta("LUKE SKYWALKER","+2",R.drawable.masdostrece);
        Carta mas29= new Carta("ANAKIN SKYWALKER","+2",R.drawable.masdosquince);
        Carta mas210= new Carta("OBI WAN","+2",R.drawable.masdosdieciseis);
        Carta mas211= new Carta("PICCOLO","+2",R.drawable.masdosdiecisiete);
        Carta mas212= new Carta("RAOUL CAROULE","+2",R.drawable.masdosdieciocho);
        Carta mas213= new Carta("TEN SHIN HAN","+2",R.drawable.masdosdiecinueve);
        Carta mas214= new Carta("TRUNKS","+2",R.drawable.masdosveinte);
        Carta mas215= new Carta("VEGETA","+2",R.drawable.masdosveintiuno);
        Carta mas216= new Carta("WINGO","+2",R.drawable.masdosveintidos);
        Carta mas217= new Carta("YAMCHA","+2",R.drawable.masdosveintitres);
        Carta mas219= new Carta("VEGETA","+2",R.drawable.masdosveintiuno);

        Carta mas31= new Carta("CRUZ RAMIREZ","+3",R.drawable.mastresuno);
        Carta mas32= new Carta("DOC HUDSON","+3",R.drawable.mastresdos);
        Carta mas33= new Carta("GOGETA SSB","+3",R.drawable.mastrescuatro);
        Carta mas34= new Carta("BEAST GOHAN","+3",R.drawable.mastrescinco);
        Carta mas35= new Carta("GOKU BETIS","+3",R.drawable.mastresseis);
        Carta mas36= new Carta("GOLDEN FREEZER","+3",R.drawable.mastressiete);
        Carta mas37= new Carta("KEFLA","+3",R.drawable.mastresocho);
        Carta mas38= new Carta("MCQUEEN","+3",R.drawable.mastresnueve);
        Carta mas39= new Carta("SORA","+3",R.drawable.mastresdiez);
        Carta mas310= new Carta("VEGETA SSB","+3",R.drawable.mastrestres);

        Carta spbroma1= new Carta("BROMA","broma",R.drawable.spbroma1);
        Carta spbroma2= new Carta("BROMA","broma",R.drawable.spbroma2);

        Carta sphundimiento1 = new Carta("HUNDIMIENTO","sink",R.drawable.sphundimiento1);
        Carta sphundimiento2 = new Carta("HUNDIMIENTO","sink",R.drawable.sphundimiento2);

        Carta sppatada1= new Carta("TORMENTA DE FUEGO","patada",R.drawable.sppatada1);
        Carta sppatada2= new Carta("TORMENTA DE FUEGO","patada",R.drawable.sppatada2);
        Carta sppatada3= new Carta("TORMENTA DE FUEGO","patada",R.drawable.sppatada3);

        Carta sptp1= new Carta("CANVI DE LLOC INSTANTANI","tp",R.drawable.sptp1);
        Carta sptp2= new Carta("TELEPORTATION","tp",R.drawable.sptp2);
        Carta sptp3= new Carta("XPEKE","tp",R.drawable.sptp3);

        Carta sptrip1= new Carta("AXEL FAIL","trip",R.drawable.sptrip1);
        Carta sptrip2= new Carta("AXEL FAIL","trip",R.drawable.sptrip2);
        Carta sptrip3= new Carta("MCQUEEN FAIL","trip",R.drawable.sptrip3);
        Carta sptrip4= new Carta("MCQUEEN FAIL","trip",R.drawable.sptrip4);

        Carta extra = new Carta("SNAKE WAY","extra",R.drawable.snakeway);

        baraja.add(mas11);
        baraja.add(mas12);
        baraja.add(mas13);
        baraja.add(mas14);
        baraja.add(mas15);
        baraja.add(mas16);
        baraja.add(mas17);
        baraja.add(mas18);
        baraja.add(mas19);
        baraja.add(mas110);
        baraja.add(mas111);
        baraja.add(mas112);
        baraja.add(mas113);
        baraja.add(mas114);
        baraja.add(mas115);
        baraja.add(mas116);
        baraja.add(mas117);
        baraja.add(mas118);
        baraja.add(mas119);
        baraja.add(mas120);
        baraja.add(mas121);
        baraja.add(mas122);
        baraja.add(mas123);
        baraja.add(mas124);
        baraja.add(mas126);
        baraja.add(mas127);
        baraja.add(mas128);
        baraja.add(mas129);
        baraja.add(mas21);
        baraja.add(mas22);
        baraja.add(mas23);
        baraja.add(mas24);
        baraja.add(mas25);
        baraja.add(mas26);
        baraja.add(mas27);
        baraja.add(mas28);
        baraja.add(mas29);
        baraja.add(mas210);
        baraja.add(mas211);
        baraja.add(mas212);
        baraja.add(mas213);
        baraja.add(mas214);
        baraja.add(mas215);
        baraja.add(mas216);
        baraja.add(mas217);
        baraja.add(mas219);
        baraja.add(mas31);
        baraja.add(mas32);
        baraja.add(mas33);
        baraja.add(mas34);
        baraja.add(mas35);
        baraja.add(mas36);
        baraja.add(mas37);
        baraja.add(mas38);
        baraja.add(mas39);
        baraja.add(mas310);
        baraja.add(spbroma1);
        baraja.add(spbroma2);
        baraja.add(sphundimiento1);
        baraja.add(sphundimiento2);
        baraja.add(sppatada1);
        baraja.add(sppatada2);
        baraja.add(sppatada3);
        baraja.add(sptp1);
        baraja.add(sptp2);
        baraja.add(sptp3);
        baraja.add(sptrip1);
        baraja.add(sptrip2);
        baraja.add(sptrip3);
        baraja.add(sptrip4);

        Log.d("cartas", "baraja creada correctamente"+ " "+ baraja.size() +" primera: " +baraja.get(0).getNom()+ " ultima: " + baraja.get(69).getNom());
        mezclarBaraja(baraja);
    }

    public void mezclarBaraja(List<Carta> baraja){
        Collections.shuffle(baraja);
        Log.d("cartas", "baraja mezclada correctamente"+ " "+" primera: " +baraja.get(0).getNom()+ " ultima: " + baraja.get(69).getNom());

    }

    public void initPlayers(){
        players.add(p1);
        players.add(p2);
        players.add(p3);
        players.add(p4);
        Bundle bundle = getArguments();

        String nomp1 = bundle.getString("p1name");
        String skinp1 = bundle.getString("p1skin");
        createPlayer(p1,nomp1,skinp1);

        String nomp2 = bundle.getString("p2name");
        String skinp2 = bundle.getString("p2skin");
        createPlayer(p2,nomp2,skinp2);


        String nomp3 = bundle.getString("p3name");
        String skinp3 = bundle.getString("p3skin");
        createPlayer(p3,nomp3,skinp3);


        String nomp4 = bundle.getString("p4name");
        String skinp4 = bundle.getString("p4skin");
        createPlayer(p4,nomp4,skinp4);



    }

    public void createPlayer(Player p, String nomp1, String contskinp1){
        int numSkin = Integer.parseInt(contskinp1);
        p.setName(nomp1);
        if (numSkin == 0){
            p.setRunningSkin(skins.get(0).getRunningSkin());
            p.setStandSkin(skins.get(0).getStandSkin());
        }
        if (numSkin == 1 ){
            p.setRunningSkin(skins.get(1).getRunningSkin());
            p.setStandSkin(skins.get(1).getStandSkin());
        }
        if (numSkin == 2 ){
            p.setRunningSkin(skins.get(2).getRunningSkin());
            p.setStandSkin(skins.get(2).getStandSkin());
        }
        if (numSkin == 3 ){
            p.setRunningSkin(skins.get(3).getRunningSkin());
            p.setStandSkin(skins.get(3).getStandSkin());
        }
        if (numSkin == 4 ){
            p.setRunningSkin(skins.get(4).getRunningSkin());
            p.setStandSkin(skins.get(4).getStandSkin());
        }
        if (numSkin == 5 ){
            p.setRunningSkin(skins.get(5).getRunningSkin());
            p.setStandSkin(skins.get(5).getStandSkin());
        }
        Log.d("players", "created player "+p.getName() + " " + p.getRunningSkin());

    }

    public void reparteCartas(){
        startBaraja();


        for (Player p :
                players) {
            ArrayList<Carta> mano = new ArrayList<>();

            for (int i = 0; i < 6; i++) {
                mano.add(baraja.get(i));
                baraja.remove(i);
            }
            p.setMano(mano);
            Log.d("cartasJ", "cartas del jugador " + p.getName() + " "+mano.size() + " primera= "+ mano.get(0).getNom());
        }

    }

    public void colocarJugadores(Player p){
        if (p.isEliminado()==true){
            p.setStandSkin(0);
            p.setRunningSkin(0);
        }

        if (p.getName().equals(p1.getName())){
            if (p.getCasilla()==0){
                j1c1.setImageResource(p.getStandSkin());
            }else{
                j1c1.setImageResource(0);
            }


            if (p.getCasilla()==1){
                j1c2.setImageResource(p.getStandSkin());
            }else{
                j1c2.setImageResource(0);
            }


            if (p.getCasilla()==2){
                j1c3.setImageResource(p.getStandSkin());
            }else{
                j1c3.setImageResource(0);
            }


            if (p.getCasilla()==3){
                j1c4.setImageResource(p.getStandSkin());
            }else{
                j1c4.setImageResource(0);
            }


            if (p.getCasilla()==4){
                j1c5.setImageResource(p.getStandSkin());
            }else{
                j1c5.setImageResource(0);
            }


            if (p.getCasilla()==5){
                j1c6.setImageResource(p.getStandSkin());
            }else{
                j1c6.setImageResource(0);
            }


            if (p.getCasilla()==6){
                j1c7.setImageResource(p.getStandSkin());
            }else{
                j1c7.setImageResource(0);
            }


            if (p.getCasilla()==7){
                j1c8.setImageResource(p.getStandSkin());
            }else{
                j1c8.setImageResource(0);
            }


            if (p.getCasilla()==8){
                j1c9.setImageResource(p.getStandSkin());
            }else{
                j1c9.setImageResource(0);
            }


            if (p.getCasilla()==9){
                j1c10.setImageResource(p.getStandSkin());
            }else{
                j1c10.setImageResource(0);
            }


            if (p.getCasilla()==10){
                j1c11.setImageResource(p.getStandSkin());
            }else{
                j1c11.setImageResource(0);
            }


            if (p.getCasilla()==11){
                j1c12.setImageResource(p.getStandSkin());
            }else{
                j1c12.setImageResource(0);
            }


            if (p.getCasilla()==12){
                j1c13.setImageResource(p.getStandSkin());
            }else{
                j1c13.setImageResource(0);
            }


            if (p.getCasilla()==13){
                j1c14.setImageResource(p.getStandSkin());
            }else{
                j1c14.setImageResource(0);
            }


            if (p.getCasilla()>=14){
                c15.setImageResource(p.getStandSkin());
            }else{
                c15.setImageResource(0);
            }



        }

        if (p.getName().equals(p2.getName())){
            if (p.getCasilla()==0){
                j2c1.setImageResource(p.getStandSkin());
            }else{
                j2c1.setImageResource(0);
            }


            if (p.getCasilla()==1){
                j2c2.setImageResource(p.getStandSkin());
            }else{
                j2c2.setImageResource(0);
            }


            if (p.getCasilla()==2){
                j2c3.setImageResource(p.getStandSkin());
            }else{
                j2c3.setImageResource(0);
            }


            if (p.getCasilla()==3){
                j2c4.setImageResource(p.getStandSkin());
            }else{
                j2c4.setImageResource(0);
            }


            if (p.getCasilla()==4){
                j2c5.setImageResource(p.getStandSkin());
            }else{
                j2c5.setImageResource(0);
            }


            if (p.getCasilla()==5){
                j2c6.setImageResource(p.getStandSkin());
            }else{
                j2c6.setImageResource(0);
            }


            if (p.getCasilla()==6){
                j2c7.setImageResource(p.getStandSkin());
            }else{
                j2c7.setImageResource(0);
            }


            if (p.getCasilla()==7){
                j2c8.setImageResource(p.getStandSkin());
            }else{
                j2c8.setImageResource(0);
            }


            if (p.getCasilla()==8){
                j2c9.setImageResource(p.getStandSkin());
            }else{
                j2c9.setImageResource(0);
            }


            if (p.getCasilla()==9){
                j2c10.setImageResource(p.getStandSkin());
            }else{
                j2c10.setImageResource(0);
            }


            if (p.getCasilla()==10){
                j2c11.setImageResource(p.getStandSkin());
            }else{
                j2c11.setImageResource(0);
            }


            if (p.getCasilla()==11){
                j2c12.setImageResource(p.getStandSkin());
            }else{
                j2c12.setImageResource(0);
            }


            if (p.getCasilla()==12){
                j2c13.setImageResource(p.getStandSkin());
            }else{
                j2c13.setImageResource(0);
            }


            if (p.getCasilla()==13){
                j2c14.setImageResource(p.getStandSkin());
            }else{
                j2c14.setImageResource(0);
            }


            if (p.getCasilla()>=14){
                c15.setImageResource(p.getStandSkin());
            }else{
                c15.setImageResource(0);
            }



        }


        if (p.getName().equals(p3.getName())){
            if (p.getCasilla()==0){
                j3c1.setImageResource(p.getStandSkin());
            }else{
                j3c1.setImageResource(0);
            }


            if (p.getCasilla()==1){
                j3c2.setImageResource(p.getStandSkin());
            }else{
                j3c2.setImageResource(0);
            }


            if (p.getCasilla()==2){
                j3c3.setImageResource(p.getStandSkin());
            }else{
                j3c3.setImageResource(0);
            }


            if (p.getCasilla()==3){
                j3c4.setImageResource(p.getStandSkin());
            }else{
                j3c4.setImageResource(0);
            }


            if (p.getCasilla()==4){
                j3c5.setImageResource(p.getStandSkin());
            }else{
                j3c5.setImageResource(0);
            }


            if (p.getCasilla()==5){
                j3c6.setImageResource(p.getStandSkin());
            }else{
                j3c6.setImageResource(0);
            }


            if (p.getCasilla()==6){
                j3c7.setImageResource(p.getStandSkin());
            }else{
                j3c7.setImageResource(0);
            }


            if (p.getCasilla()==7){
                j3c8.setImageResource(p.getStandSkin());
            }else{
                j3c8.setImageResource(0);
            }


            if (p.getCasilla()==8){
                j3c9.setImageResource(p.getStandSkin());
            }else{
                j3c9.setImageResource(0);
            }


            if (p.getCasilla()==9){
                j3c10.setImageResource(p.getStandSkin());
            }else{
                j3c10.setImageResource(0);
            }


            if (p.getCasilla()==10){
                j3c11.setImageResource(p.getStandSkin());
            }else{
                j3c11.setImageResource(0);
            }


            if (p.getCasilla()==11){
                j3c12.setImageResource(p.getStandSkin());
            }else{
                j3c12.setImageResource(0);
            }


            if (p.getCasilla()==12){
                j3c13.setImageResource(p.getStandSkin());
            }else{
                j3c13.setImageResource(0);
            }


            if (p.getCasilla()==13){
                j3c14.setImageResource(p.getStandSkin());
            }else{
                j3c14.setImageResource(0);
            }


            if (p.getCasilla()>=14){
                c15.setImageResource(p.getStandSkin());
            }else{
                c15.setImageResource(0);
            }



        }


        if (p.getName().equals(p4.getName())){
            if (p.getCasilla()==0){
                j4c1.setImageResource(p.getStandSkin());
            }else{
                j4c1.setImageResource(0);
            }


            if (p.getCasilla()==1){
                j4c2.setImageResource(p.getStandSkin());
            }else{
                j4c2.setImageResource(0);
            }


            if (p.getCasilla()==2){
                j4c3.setImageResource(p.getStandSkin());
            }else{
                j4c3.setImageResource(0);
            }


            if (p.getCasilla()==3){
                j4c4.setImageResource(p.getStandSkin());
            }else{
                j4c4.setImageResource(0);
            }


            if (p.getCasilla()==4){
                j4c5.setImageResource(p.getStandSkin());
            }else{
                j4c5.setImageResource(0);
            }


            if (p.getCasilla()==5){
                j4c6.setImageResource(p.getStandSkin());
            }else{
                j4c6.setImageResource(0);
            }


            if (p.getCasilla()==6){
                j4c7.setImageResource(p.getStandSkin());
            }else{
                j4c7.setImageResource(0);
            }


            if (p.getCasilla()==7){
                j4c8.setImageResource(p.getStandSkin());
            }else{
                j4c8.setImageResource(0);
            }


            if (p.getCasilla()==8){
                j4c9.setImageResource(p.getStandSkin());
            }else{
                j4c9.setImageResource(0);
            }


            if (p.getCasilla()==9){
                j4c10.setImageResource(p.getStandSkin());
            }else{
                j4c10.setImageResource(0);
            }


            if (p.getCasilla()==10){
                j4c11.setImageResource(p.getStandSkin());
            }else{
                j4c11.setImageResource(0);
            }


            if (p.getCasilla()==11){
                j4c12.setImageResource(p.getStandSkin());
            }else{
                j4c12.setImageResource(0);
            }


            if (p.getCasilla()==12){
                j4c13.setImageResource(p.getStandSkin());
            }else{
                j4c13.setImageResource(0);
            }


            if (p.getCasilla()==13){
                j4c14.setImageResource(p.getStandSkin());
            }else{
                j4c14.setImageResource(0);
            }


            if (p.getCasilla()>=14){
                c15.setImageResource(p.getStandSkin());
            }else{
                c15.setImageResource(0);
            }



        }

    }


    public void coolocarJugadores(List<Player> plaayers ){

        players=plaayers;
        for (Player p :
                plaayers) {
            colocarJugadores(p);
        }
    }

    public List<Player> pasarPlayers(){
        return players;
    }

    public void eliminarCasellas(int nCasillas){
//        nCasillas--;

        for (Player p : players) {
            if (p.getCasilla() <= nCasillas) {
                p.setEliminado(true);
                p.setRunningSkin(0);
                p.setStandSkin(0);

            }
        }
        if (nCasillas>=0){
            c1.setBackgroundColor(Color.RED);
            c1.setVisibility(View.INVISIBLE);
        }
        if (nCasillas>=1){
            c2.setBackgroundColor(Color.RED);
            c2.setVisibility(View.INVISIBLE);

        }
        if (nCasillas>=2){
            c3.setBackgroundColor(Color.RED);
            c3.setVisibility(View.INVISIBLE);

        }
        if (nCasillas>=3){
            c4.setBackgroundColor(Color.RED);
            c4.setVisibility(View.INVISIBLE);

        }
        if (nCasillas>=4){
            c5.setBackgroundColor(Color.RED);
            c5.setVisibility(View.INVISIBLE);

        }
        if (nCasillas>=5){
            c6.setBackgroundColor(Color.RED);
            c6.setVisibility(View.INVISIBLE);

        }
        if (nCasillas>=6){
            c7.setVisibility(View.INVISIBLE);

            c7.setBackgroundColor(Color.RED);
        }
        if (nCasillas>=7){
            c8.setBackgroundColor(Color.RED);
            c8.setVisibility(View.INVISIBLE);

        }
        if (nCasillas>=8){
            c9.setBackgroundColor(Color.RED);
            c9.setVisibility(View.INVISIBLE);

        }
        if (nCasillas>=9){
            c10.setBackgroundColor(Color.RED);
            c10.setVisibility(View.INVISIBLE);

        }
        if (nCasillas>=10){
            c11.setBackgroundColor(Color.RED);
            c11.setVisibility(View.INVISIBLE);

        }
        if (nCasillas>=11){
            c12.setBackgroundColor(Color.RED);
            c12.setVisibility(View.INVISIBLE);

        }
        if (nCasillas>=12){
            c13.setBackgroundColor(Color.RED);
            c13.setVisibility(View.INVISIBLE);

        }
        if (nCasillas>=13){
            c14.setBackgroundColor(Color.RED);
            c14.setVisibility(View.INVISIBLE);

        }
        if (nCasillas>=14){
            c15.setBackgroundColor(Color.RED);
            c15.setVisibility(View.INVISIBLE);

        }





    }

    public void checkVictory(){
        Player winer = null;

        for (Player p :
                players) {
                if (p.getCasilla() >= 14) {
                    winer = p;
                    Intent a = new Intent(getActivity(),vicroryActivity.class);
                    a.putExtra("winner",winer);
                    startActivity(a);

                }
            }

        int contEliminados=0;
        for (Player p :players) {
            if (p.isEliminado()) {
                contEliminados++;
            }
        }
        if (contEliminados==3){
            for (Player p :players) {
                if (p.isEliminado()==false) {
                    winer = p;
                    Intent a = new Intent(getActivity(),vicroryActivity.class);
                    a.putExtra("winner",winer);
                    startActivity(a);
                }
                    contEliminados++;
                }
        }
    }

}