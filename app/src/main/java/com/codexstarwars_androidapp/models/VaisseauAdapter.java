package com.codexstarwars_androidapp.models;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.codexstarwars_androidapp.R;
import com.codexstarwars_androidapp.services.ApiVaisseauxService;

import java.util.ArrayList;

public class VaisseauAdapter extends BaseAdapter {
    private ArrayList<Vaisseau> vaisseaux;
    private Context context;

    public VaisseauAdapter(ArrayList<Vaisseau> vaisseaux, Context context) {
        this.vaisseaux = vaisseaux;
        this.context = context;
    }

    @Override
    public int getCount() {
        return this.vaisseaux.size();
    }

    @Override
    public Object getItem(int i) {
        return this.vaisseaux.get(i);
    }

    @Override
    public long getItemId(int i) {
        return this.vaisseaux.get(i).getId();
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = LayoutInflater.from(context).inflate(R.layout.item_vaisseau, viewGroup, false);
        }
        TextView textViewVaisseauName = view.findViewById(R.id.textViewVaisseauName);
        TextView textViewVaisseauDescription = view.findViewById(R.id.textViewVaisseauDescription);
        TextView textViewVaisseauLongueur = view.findViewById(R.id.textViewVaisseauLongueur);
        TextView textViewVaisseauVitesse = view.findViewById(R.id.textViewVaisseauVitesse);
        TextView textViewVaisseauEquipage = view.findViewById(R.id.textViewVaisseauEquipage);
        TextView textViewVaisseauMoteur = view.findViewById(R.id.textViewVaisseauMoteur);
        ImageView imageViewVaisseau = view.findViewById(R.id.imageViewVaisseau);

        textViewVaisseauName.setText(vaisseaux.get(i).getNom());
        textViewVaisseauDescription.setText(vaisseaux.get(i).getDescription());
        textViewVaisseauLongueur.setText(vaisseaux.get(i).getLongueur());
        textViewVaisseauVitesse.setText(vaisseaux.get(i).getVitesse());
        textViewVaisseauEquipage.setText(vaisseaux.get(i).getEquipage());
        textViewVaisseauMoteur.setText(vaisseaux.get(i).getMoteur());
        ApiVaisseauxService.loadVaisseauImage(context, vaisseaux.get(i).getImage(), imageViewVaisseau);

        return view;
    }
}
