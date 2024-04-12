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
import com.codexstarwars_androidapp.services.ApiServicesPerso;

import java.util.ArrayList;

public class PersonnageAdapter extends BaseAdapter {

    private ArrayList<Personnage> personnages;
    private Context context;

    public PersonnageAdapter(ArrayList<Personnage> personnages, Context context) {
        this.personnages = personnages;
        this.context = context;
    }

    public void setPersonnages(ArrayList<Personnage> personnages) {
        this.personnages = personnages;
    }

    @Override
    public int getCount() {
        return personnages.size();
    }

    @Override
    public Object getItem(int i) {
        return personnages.get(i);
    }

    @Override
    public long getItemId(int i) {
        return personnages.get(i).getId();
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = LayoutInflater.from(context).inflate(R.layout.item_personnage, viewGroup, false);
        }
        TextView textViewName = view.findViewById(R.id.textViewItemPersonnageName);
        TextView textViewLieuNaissance = view.findViewById(R.id.textViewItemPersonnageLieuNaissance);
        TextView textViewEspece = view.findViewById(R.id.textViewItemPersonnageEspece);
        ImageView imageView = view.findViewById(R.id.imageViewItemPersonnage);

        LinearLayout separator=view.findViewById(R.id.layoutSeparatorPersonnage);

        textViewName.setText(personnages.get(i).getNom());
        textViewLieuNaissance.setText(personnages.get(i).getLieuNaissance());
        textViewEspece.setText(personnages.get(i).getEspece());
        ApiServicesPerso.loadPlaneteImage(context, personnages.get(i).getImage(), imageView);

        return view;
    }
}


