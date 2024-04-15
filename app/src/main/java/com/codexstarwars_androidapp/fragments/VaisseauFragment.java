package com.codexstarwars_androidapp.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.codexstarwars_androidapp.R;
import com.codexstarwars_androidapp.models.Vaisseau;
import com.codexstarwars_androidapp.services.ApiVaisseauxService;

public class VaisseauFragment extends Fragment {
    private ImageView imageViewVaisseau;
    private TextView textViewVaisseauName, textViewVaisseauDescription, textViewVaisseauLongueur,
            textViewVaisseauVitesse, textViewVaisseauEquipage, textViewVaisseauMoteur;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_vaisseau, null);

        textViewVaisseauName = v.findViewById(R.id.textViewVaisseauName);
        textViewVaisseauDescription = v.findViewById(R.id.textViewVaisseauDescription);
        textViewVaisseauLongueur = v.findViewById(R.id.textViewVaisseauLongueur);
        textViewVaisseauVitesse = v.findViewById(R.id.textViewVaisseauVitesse);
        textViewVaisseauEquipage = v.findViewById(R.id.textViewVaisseauEquipage);
        textViewVaisseauMoteur = v.findViewById(R.id.textViewVaisseauMoteur);
        imageViewVaisseau = v.findViewById(R.id.imageViewVaisseau);

        return v;
    }

    public void onSelectVaisseau(Vaisseau vaisseau) {

        textViewVaisseauName.setText(vaisseau.getNom());
        textViewVaisseauDescription.setText(vaisseau.getDescription());
        textViewVaisseauLongueur.setText(vaisseau.getLongueur());
        textViewVaisseauVitesse.setText(vaisseau.getVitesse());
        textViewVaisseauEquipage.setText(vaisseau.getEquipage());
        textViewVaisseauMoteur.setText(vaisseau.getMoteur());

        ApiVaisseauxService.loadVaisseauImage(getContext(), vaisseau.getImage(), imageViewVaisseau);
    }
}