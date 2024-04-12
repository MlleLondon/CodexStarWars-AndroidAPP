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

    public void setVaisseaux(ArrayList<Vaisseau> vaisseaux) {
        this.vaisseaux = vaisseaux;
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
        TextView textViewItemVaisseauName = view.findViewById(R.id.textViewItemVaisseauName);
        TextView textViewItemVaisseauTaille = view.findViewById(R.id.textViewItemVaisseauTaille);
        TextView textViewItemVaisseauEquipage = view.findViewById(R.id.textViewItemVaisseauEquipage);
        ImageView imageViewItemVaisseau = view.findViewById(R.id.imageViewItemVaisseau);

        textViewItemVaisseauName.setText(vaisseaux.get(i).getNom());
        textViewItemVaisseauTaille.setText(vaisseaux.get(i).getLongueur());
        textViewItemVaisseauEquipage.setText(vaisseaux.get(i).getEquipage());
        ApiVaisseauxService.loadVaisseauImage(context, vaisseaux.get(i).getImage(), imageViewItemVaisseau);

        return view;
    }
}
