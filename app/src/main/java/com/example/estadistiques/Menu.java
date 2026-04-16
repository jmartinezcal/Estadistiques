package com.example.estadistiques;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

public class Menu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu_inicial);


        ArrayList<Jugador> banqueta = new ArrayList<Jugador>();
        ArrayList<Jugador> pista = new ArrayList<Jugador>();

        Jugador j1 = new Jugador("David", "Martínez", "13", R.drawable.d13);
        Jugador j2 = new Jugador("Pere", "Llimós", "7", R.drawable.p7);
        Jugador j3 = new Jugador("Lluc", "Marugán", "28", R.drawable.l28);
        Jugador j4 = new Jugador("Alan", "", "22", R.drawable.a15);
        Jugador j5 = new Jugador("Martí", "Pons", "18", R.drawable.m4);
        Jugador j6 = new Jugador("Nil", "", "30", R.drawable.n5);
        Jugador j7 = new Jugador("Guillem", "Lleugí", "9", R.drawable.g3);
        Jugador j8 = new Jugador("Oriol", "Hernández", "2",R.drawable.o9);
        Jugador j9 = new Jugador("Edgar", "", "8", R.drawable.e6);
        Jugador j10 = new Jugador("Hugo", "Vázquez", "44", R.drawable.h44);


        banqueta.add(j1);
        banqueta.add(j2);
        banqueta.add(j3);
        banqueta.add(j4);
        banqueta.add(j5);
        banqueta.add(j6);
        banqueta.add(j7);
        banqueta.add(j8);
        banqueta.add(j9);
        banqueta.add(j10);

        Button bt_triar_jug = new Button(this);
        bt_triar_jug= findViewById(R.id.bt_partit);
        bt_triar_jug.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                triarEquip(banqueta, pista);
            }
        });

    }

    public void triarEquip(ArrayList<Jugador> banqueta, ArrayList<Jugador> pista){

        Intent i = new Intent(this, SeleccionarJugador.class);
        i.putExtra("banqueta", banqueta );
        i.putExtra("pista", pista);
        startActivity(i);
        finish();

    }
}
