package com.example.fartosj;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.fartosj.adapter.adapterCardGallery;
import com.example.fartosj.adapter.adapterCardPlayer;
import com.example.fartosj.entities.Carta;
import com.example.fartosj.entities.Player;
import com.example.fartosj.listeners.SelectListenerCarta;

import java.util.ArrayList;
import java.util.List;


public class cardsFragment extends Fragment implements SelectListenerCarta {

    Carta extra = new Carta("SNAKE WAY","extra",R.drawable.snakeway);

    RecyclerView cartas;
    TextView playerName;
    View vista;
    List<Player> playersOwn = new ArrayList<Player>();
    String torn;

    private CardFragmentListener mListener;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mListener = (CardFragmentListener) context;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        vista=  inflater.inflate(R.layout.fragment_cards, container, false);
        init();
        changeText();
        startRecycler();

        return vista;
    }

    public void init(){
        cartas = vista.findViewById(R.id.recyclerCartasPlayer);
        playerName = vista.findViewById(R.id.playerNameHand);
    }

    public void startRecycler(){
        Bundle bundle = getArguments();
        List<Player> players = (List<Player>) bundle.getSerializable("players");
        Log.d("playersCartas",players.get(0).getName());
        Player pp= null;

        playersOwn= players;

        for (Player p : playersOwn) {
            if (p.getName().equals(torn)) {
                pp=p;
            }
        }

        if (pp.getMano().isEmpty()){
            pp.getMano().add(extra);
        }
        adapterCardPlayer adapter = new adapterCardPlayer(pp.getMano(),this);
        cartas.setLayoutManager(new LinearLayoutManager(vista.getContext(),LinearLayoutManager.HORIZONTAL,false));
        cartas.setAdapter(adapter);

    }

    public void changeText() {
        Bundle bundle = getArguments();
        torn = bundle.getString("torn","---");

        playerName.setText(torn);

    }


    @Override
    public void onItemClicked(Carta carta) {
        Toast.makeText(vista.getContext(), carta.getNom(), Toast.LENGTH_SHORT).show();
        mListener.onCardsObjectiveChanged(carta);


    }

    public interface CardFragmentListener {
        void onCardsObjectiveChanged(Carta carta);
    }

}
