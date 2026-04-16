package com.example.estadistiques;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class GridAdapter extends BaseAdapter {

    private Context context;
    private ArrayList<Jugador> arrayList;

    public GridAdapter(Context context, ArrayList<Jugador> arrayList){
        this.context = context;
        this.arrayList = arrayList;
    }

    @Override
    public int getCount() {
        return arrayList.size();
    }

    @Override
    public Object getItem(int position) {
        return arrayList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertview, ViewGroup parent) {

        if (convertview==null){
            LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
            convertview = layoutInflater.inflate(R.layout.item_grid, null);
        }
        ImageView imatge = (ImageView) convertview.findViewById(R.id.foto_jugador);
        imatge.setImageResource(arrayList.get(position).getIdDrawable());

        TextView dorsal_nom = (TextView) convertview.findViewById(R.id.dorsal_jugador);
        dorsal_nom.setText(arrayList.get(position).getDorsal()+ " "+arrayList.get(position).getNom());

        return convertview;
    }
}
