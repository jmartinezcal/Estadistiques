package com.example.estadistiques;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Resum extends AppCompatActivity {

    //ArrayList<Jugador> banqueta = new ArrayList<Jugador>();
    //ArrayList<Jugador> pista = new ArrayList<Jugador>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.resum);

        ArrayList<Jugador> banqueta;
        ArrayList<Jugador> pista;


        //a banqueta guardarem tots els jugadors que ens enviaran des del menú principal
        banqueta = (ArrayList<Jugador>) getIntent().getSerializableExtra("banqueta");
        pista = (ArrayList<Jugador>) getIntent().getSerializableExtra("pista");


        //ordenem la llista banqueta abans de treure les estadístiques pel dorsal ascendent
        Collections.sort(banqueta, new Comparator<Jugador>() {
            @Override
            public int compare(Jugador jugador, Jugador jugador1) {
                int aux;

                aux = Integer.parseInt(jugador1.getDorsal());

                return Integer.valueOf(jugador.getDorsal()).compareTo(aux);
            }
        });


        //introduirem des de l'array els elements a la listview resum estadistica
        //tenim un adaptador personalitzat on li passem la llista de jugadors
        AdaptadorResum adapter;


        //identifiquem la listview on carregarem les estadístiques de cada jugador
        ListView lv = findViewById(R.id.lv_resum_estadistica);

        adapter = new AdaptadorResum(this, banqueta);
        lv.setAdapter(adapter);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(getApplicationContext(), "Després farem el jugador", Toast.LENGTH_LONG).show();
            }
        });
    }



}
