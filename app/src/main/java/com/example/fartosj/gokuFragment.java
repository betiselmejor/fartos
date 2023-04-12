package com.example.fartosj;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.fartosj.entities.Carta;
import com.example.fartosj.entities.Player;


public class gokuFragment extends Fragment {

    View vista;
    Button use;
    Activity gameAct = (gameActivitytest) getActivity();

    private GokuListener Glistener;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        Glistener = (GokuListener) context;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        vista= inflater.inflate(R.layout.fragment_goku, container, false);



        use=vista.findViewById(R.id.useGoku);
        Carta c = new Carta("goku's help","gokuHelp",1);

        use.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Glistener.onGokuListener(c);
            }
        });



        return vista;
    }


    public interface GokuListener {
        void onGokuListener(Carta carta);
    }
}