package com.example.estadistiques;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.util.ArrayList;

public class AdaptadorResum  extends BaseAdapter {

    private Context context;
    private ArrayList <Jugador> arrayList;

    public AdaptadorResum(Context context, ArrayList<Jugador> arrayList) {
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
    public View getView(int position, View convertview, ViewGroup viewGroup) {

        DecimalFormat df = new DecimalFormat("#.0");

        int total_tirs1 =arrayList.get(position).getTllficat()+arrayList.get(position).getTllfallat();
        int total_tirs2 =arrayList.get(position).getT2ficat()+arrayList.get(position).getT2fallat();
        int total_tirs3 =arrayList.get(position).getT3ficat()+arrayList.get(position).getT3fallat();

        double t1_100 = (double) (arrayList.get(position).getTllficat()*100)/total_tirs1;
        double t2_100 = (double) (arrayList.get(position).getT2ficat()*100)/total_tirs2;
        double t3_100 = (double) (arrayList.get(position).getT3ficat()*100)/total_tirs3;

        int total_punts = arrayList.get(position).getTllficat() + (arrayList.get(position).getT2ficat()*2) +
                (arrayList.get(position).getT3ficat()*3);

        if (convertview==null){
            LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
            convertview = layoutInflater.inflate(R.layout.item_listview_resum, null);
        }

        TextView dorsal = (TextView) convertview.findViewById(R.id.resum_dorsal);
        dorsal.setText(""+arrayList.get(position).getDorsal());

        ImageView imatge = (ImageView) convertview.findViewById(R.id.foto_jugador);
        imatge.setImageResource(arrayList.get(position).getIdDrawable());

        TextView nom = (TextView) convertview.findViewById(R.id.dorsal_jugador);
        nom.setText("" + arrayList.get(position).getNom());

        TextView tirs1 = (TextView) convertview.findViewById(R.id.resum_tirs1);
        tirs1.setText(arrayList.get(position).getTllficat() +"/"+ total_tirs1);

        TextView tir_1_100 = (TextView) convertview.findViewById(R.id.resum_1_100);
        if (total_tirs1==0){
            tir_1_100.setText("0,0 %");
        } else {
            tir_1_100.setText(df.format(t1_100) + " %");
        }

        TextView tirs2 = (TextView) convertview.findViewById(R.id.resum_tirs2);
        tirs2.setText(arrayList.get(position).getT2ficat()+"/"+ total_tirs2);

        TextView tir_2_100 = (TextView) convertview.findViewById(R.id.resum_2_100);
        if (total_tirs2==0){
            tir_2_100.setText("0,0 %");
        } else {
            tir_2_100.setText(df.format(t2_100) + " %");
        }

        TextView tirs3 = (TextView) convertview.findViewById(R.id.resum_tirs3);
        tirs3.setText(arrayList.get(position).getT3ficat()+"/"+ total_tirs3);

        TextView tir_3_100 = (TextView) convertview.findViewById(R.id.resum_3_100);
        if (total_tirs3==0){
            tir_3_100.setText("0,0 %");
        } else {
            tir_3_100.setText(df.format(t3_100) + " %");
        }

        TextView reb_of = (TextView) convertview.findViewById(R.id.resum_rof);
        reb_of.setText(""+arrayList.get(position).getRof());

        TextView reb_def = (TextView) convertview.findViewById(R.id.resum_rdef);
        reb_def.setText(""+arrayList.get(position).getRdef());

        TextView taps = (TextView) convertview.findViewById(R.id.resum_tap);
        taps.setText(""+arrayList.get(position).getTaps());

        TextView assist = (TextView) convertview.findViewById(R.id.resum_assist);
        assist.setText(""+arrayList.get(position).getAssist());

        TextView robat = (TextView) convertview.findViewById(R.id.resum_rob);
        robat.setText(""+arrayList.get(position).getRobat());

        TextView perdua = (TextView) convertview.findViewById(R.id.resum_perd);
        perdua.setText(""+arrayList.get(position).getPerdues());

        TextView faltes = (TextView) convertview.findViewById(R.id.resum_falta);
        faltes.setText(""+arrayList.get(position).getFalta_personal());

        TextView punts = (TextView) convertview.findViewById(R.id.resum_punts);
        punts.setText(""+ total_punts);

        return convertview;
    }
}
