package com.codexstarwars_androidapp.models;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.codexstarwars_androidapp.R;
import com.codexstarwars_androidapp.services.ApiServicesEspece;
import com.codexstarwars_androidapp.services.ApiServicesPerso;

import java.util.ArrayList;

public class EspeceAdapter extends BaseAdapter {

    private ArrayList<Espece> especes;
    private Context context;

    public EspeceAdapter(ArrayList<Espece> especes, Context context) {
        this.especes = especes;
        this.context = context;
    }

    public void setEspeces(ArrayList<Espece> especes) {
        this.especes = especes;
    }

    @Override
    public int getCount() {
        return especes.size();
    }

    @Override
    public Object getItem(int i) {
        return especes.get(i);
    }

    @Override
    public long getItemId(int i) {
        return especes.get(i).getId();
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = LayoutInflater.from(context).inflate(R.layout.item_espece, viewGroup, false);
        }
        ImageView imageView= view.findViewById(R.id.imageViewItemEspece);
        TextView textViewName = view.findViewById(R.id.textViewItemEspeceName);
        TextView textViewPlanete = view.findViewById(R.id.textViewItemEspecePlanete);
        TextView textViewTaille = view.findViewById(R.id.textViewItemEspeceTaille);

        textViewName.setText(especes.get(i).getNom());
        textViewPlanete.setText(especes.get(i).getPlanete());
        textViewTaille.setText(especes.get(i).getTaille());
        ApiServicesEspece.loadEspeceImage(context, especes.get(i).getImage(), imageView);

        return view;
    }
}


