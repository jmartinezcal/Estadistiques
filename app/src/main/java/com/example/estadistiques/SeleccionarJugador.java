package com.example.estadistiques;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class SeleccionarJugador extends Activity {


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.seleccionar_jugador);

        ArrayList<Jugador> pista ;
        ArrayList<Jugador> banqueta;

        int falten_jug; // jugadors que falten a sortir a pista
        TextView txt_numjugpista;
        Button bt;

        //Aquí rebem les dues llistes de jugadors, els que hi ha a la pista i els que hi ha a la banqueta
        banqueta = (ArrayList<Jugador>) getIntent().getSerializableExtra("banqueta");
        pista = (ArrayList<Jugador>) getIntent().getSerializableExtra("pista");

        // una pijada!! Posar el missatge dels jugadors que falten per escollir
        falten_jug = 5 - pista.size();
        txt_numjugpista = (TextView) findViewById(R.id.tnumjug);
        if (falten_jug==0){
            TextView missatge = (TextView) findViewById(R.id.txt_escull);
            missatge.setText("CAP AL PARTIT!!!");

            txt_numjugpista.setVisibility(View.GONE);

            TextView ocultar = (TextView) findViewById(R.id.txt_jugadors);
            ocultar.setVisibility(View.GONE);
        } else {
            txt_numjugpista.setText("" + falten_jug);
        }


        definir_pista_i_banqueta(pista, banqueta, R.id.lpista);
        definir_pista_i_banqueta(banqueta,pista, R.id.lbanqueta);

        //butó per enviar els jugadors a la pista i banqueta
       bt = findViewById(R.id.bt_seleccionar_jug);
       bt.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               jugadors_pista(pista, banqueta);
           }
       });

    }

    public void  definir_pista_i_banqueta(ArrayList<Jugador> llista1, ArrayList<Jugador> llista2, int pista_banqueta){

        GridView gridView;
        GridAdapter adapter;


            //jugadors a la graella de pista o banqueta
            gridView = (GridView) findViewById(pista_banqueta);
            adapter = new GridAdapter(this, llista1);
            gridView.setAdapter(adapter);

            //quan cliquem sobre els jugadors canvien de llista. De pista a banqueta o de banqueta a pista
            gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                    llista2.add(llista1.get(position));
                    llista1.remove(position);
                    recreate();
                }
            });

    }

    public void jugadors_pista(ArrayList<Jugador> pista, ArrayList<Jugador> banqueta){

        if (pista.size()<6) {
            Intent i = new Intent(this, MainActivity.class);
            i.putExtra("banqueta", banqueta);
            i.putExtra("pista", pista);
            startActivity(i);
            finish();
        } else {
            Toast.makeText(this,"No pots treure a pista més de 5 jugadors", Toast.LENGTH_LONG).show();
        }
    }
}
