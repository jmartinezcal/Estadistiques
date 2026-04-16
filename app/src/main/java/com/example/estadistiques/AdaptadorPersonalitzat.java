package com.example.estadistiques;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class AdaptadorPersonalitzat  extends BaseAdapter {

    private Context context;
    private Jugador jugador;



  public AdaptadorPersonalitzat(Context context, Jugador jugador){

      this.context = context;
      this.jugador = jugador;
  }

    @Override
    public int getCount() {
        return 1;
    }

    @Override
    public Object getItem(int position) {
        return jugador;
    }


    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertview, ViewGroup viewGroup) {

        if (convertview==null){
            LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
            convertview = layoutInflater.inflate(R.layout.item_grid, null);
        }
        ImageView imatge = (ImageView) convertview.findViewById(R.id.foto_jugador);
        imatge.setImageResource(jugador.getIdDrawable());

        TextView dorsal_nom = (TextView) convertview.findViewById(R.id.dorsal_jugador);
        dorsal_nom.setText(jugador.getDorsal()+ " "+jugador.getNom());

        return convertview;

    }
}
