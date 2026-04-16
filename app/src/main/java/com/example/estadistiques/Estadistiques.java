package com.example.estadistiques;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;


public class Estadistiques extends Activity {


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.estadistiques);

        ArrayList<Jugador> pista;
        ArrayList<Jugador> banqueta;

        Button bt_rof;
        Button bt_rdef;
        Button bt_tap;
        Button bt_tll_fallat;
        Button bt_tll_ficat;
        Button bt_t2_fallat;
        Button bt_t2_ficat;
        Button bt_t3_fallat;
        Button bt_t3_ficat;
        Button bt_assist;
        Button bt_perdua;
        Button bt_falta;
        Button bt_robatori;

        Jugador jugador = (Jugador) getIntent().getSerializableExtra("jugador");
        banqueta = (ArrayList<Jugador>) getIntent().getSerializableExtra("banqueta");
        pista = (ArrayList<Jugador>) getIntent().getSerializableExtra("pista");


        for (int i=0; i<pista.size(); i++) {
            if (jugador.getDorsal().equals(pista.get(i).getDorsal())) {
               pista.remove(i);
            }
        }

        ImageView foto = findViewById(R.id.foto_estadistica);
        foto.setImageResource(jugador.getIdDrawable());

        TextView dorsal = findViewById(R.id.dorsal_nom_estadistica);
        dorsal.setText(jugador.getDorsal() + " " + jugador.getNom());


        //definim tots els botons
        // rebot ofensiu
        bt_rof = findViewById(R.id.bt_rof);
        bt_rof.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                jugador.setRof(jugador.rof);
                tornar_pista(jugador, pista, banqueta);
            }
        });

        // rebot defensiu
        bt_rdef = findViewById(R.id.bt_rdef);
        bt_rdef.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                jugador.setRdef(jugador.rdef);
                tornar_pista(jugador, pista, banqueta);
            }
        });

        // tap
        bt_tap = findViewById(R.id.bt_tap);
        bt_tap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                jugador.setTaps(jugador.rdef);
                tornar_pista(jugador, pista, banqueta);
            }
        });

        // tir lliure fallat
        bt_tll_fallat = findViewById(R.id.bt_tllfallat);
        bt_tll_fallat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                jugador.setTllfallat(jugador.tllfallat);
                tornar_pista(jugador, pista, banqueta);
            }
        });

        // tir lliure ficat
        bt_tll_ficat = findViewById(R.id.bt_tllficat);
        bt_tll_ficat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                jugador.setTllficat(jugador.tllficat);
                tornar_pista(jugador, pista, banqueta);
            }
        });

        // tir 2 fallat
        bt_t2_fallat = findViewById(R.id.bt_t2fallat);
        bt_t2_fallat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                jugador.setT2fallat(jugador.t2fallat);
                tornar_pista(jugador, pista, banqueta);
            }
        });

        // tir 2 ficat
        bt_t2_ficat = findViewById(R.id.bt_t2ficat);
        bt_t2_ficat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                jugador.setT2ficat(jugador.t2ficat);
                tornar_pista(jugador, pista, banqueta);
            }
        });

        // tir 3 fallat
        bt_t3_fallat = findViewById(R.id.bt_t3fallat);
        bt_t3_fallat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                jugador.setT3fallat(jugador.t3fallat);
                tornar_pista(jugador, pista, banqueta);
            }
        });

        // tir 3 ficat
        bt_t3_ficat = findViewById(R.id.bt_t3ficat);
        bt_t3_ficat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                jugador.setT3ficat(jugador.t3ficat);
                tornar_pista(jugador, pista, banqueta);
            }
        });

        // assistències
        bt_assist = findViewById(R.id.bt_assistencia);
        bt_assist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                jugador.setAssist(jugador.assist);
                tornar_pista(jugador, pista, banqueta);
            }
        });

        // perdua
        bt_perdua = findViewById(R.id.bt_pilota_perduda);
        bt_perdua.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                jugador.setPerdues(jugador.perdues);
                tornar_pista(jugador, pista, banqueta);
            }
        });

        // robatori
        bt_robatori = findViewById(R.id.bt_robatori);
        bt_robatori.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                jugador.setRobat(jugador.robat);
                tornar_pista(jugador, pista, banqueta);
            }
        });

        // falta personal
        bt_falta = findViewById(R.id.bt_falta_personal);
        bt_falta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                jugador.setFalta_personal(jugador.falta_personal);
                tornar_pista(jugador, pista, banqueta);
            }
        });

    }

    public void tornar_pista (Jugador jugador, ArrayList<Jugador> pista, ArrayList<Jugador> banqueta){
        pista.add(jugador);
        Intent i = new Intent(getApplicationContext(), MainActivity.class);
        i.putExtra("banqueta", banqueta);
        i.putExtra("pista", pista);
        startActivity(i);
        this.finish();
    }


    protected void onPause() {
        super.onPause();
    }
}
