package com.example.estadistiques;

import android.content.Intent;
import android.os.Parcelable;
import android.provider.ContactsContract;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Layout;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.Serializable;
import java.sql.Array;
import java.util.ArrayList;
import java.util.List;

public class  MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ArrayList<Jugador> pista;
        ArrayList<Jugador> banqueta;

        //guardem els id dels listviews dels jugadors
        final int[] lv_jug={R.id.lv_0, R.id.lv_1, R.id.lv_2, R.id.lv_3, R.id.lv_4};


        //Aquí rebem les dues llistes de jugadors, els que hi ha a la pista i els que hi ha a la banqueta
        banqueta = (ArrayList<Jugador>) getIntent().getSerializableExtra("banqueta");
        pista = (ArrayList<Jugador>) getIntent().getSerializableExtra("pista");



        int i=0;

        for (Jugador jug: pista) {
            colocar_jugadors_pista(jug, lv_jug[i], pista, banqueta);
            i++;
        }

        //identifiquem els botons de canvi i final de partit
        Button bt_canvi = findViewById(R.id.bt_canvi);
        Button bt_final = findViewById(R.id.bt_final);

        bt_canvi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), SeleccionarJugador.class);
                i.putExtra("banqueta", banqueta);
                i.putExtra("pista", pista);
                startActivity(i);
                finish();
            }
        });

        //que fem al final de partit. Buidem la llista de pista i passem tots els jugadors a la llista
        //de banqueta. Finalment transferim la llista de banqueta.
        //De moment anirem directament al resum
        bt_final.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                 for (Jugador jug:pista) {
                    banqueta.add(jug);
                 }
                 pista.clear();

                 Intent intent = new Intent(getApplicationContext(), Resum.class);
                 intent.putExtra("banqueta", banqueta);
                 intent.putExtra("pista", pista);
                 startActivity(intent);
                 finish();

            }
        });


    }

    public void colocar_jugadors_pista(Jugador jugador, int lloc, ArrayList<Jugador> pista, ArrayList<Jugador> banqueta){

        //col·locarem els jugadors en una listview d'un element
        ListView listView;
        //tenim un adaptador personalitzat on li passem un jugador
        AdaptadorPersonalitzat adapter;

        listView = (ListView) findViewById(lloc);
        adapter = new AdaptadorPersonalitzat(this, jugador);
        listView.setAdapter(adapter);


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(getApplicationContext(), Estadistiques.class);
                intent.putExtra("jugador",  jugador);
                intent.putExtra("banqueta", banqueta);
                intent.putExtra("pista", pista);
                startActivity(intent);
                finish();
            }
        });

    }
/*
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode==2){
            Toast.makeText(getApplicationContext(), "entro aquí", Toast.LENGTH_LONG).show();
            Jugador jugador = (Jugador) getIntent().getSerializableExtra("jugador");

            for (int i=0; i<pista.size(); i++) {
                if (jugador.getDorsal().equals(pista.get(i).getDorsal())) {
                    pista.remove(i);
                }
            }
            pista.add(jugador);
        }
    }*/
}