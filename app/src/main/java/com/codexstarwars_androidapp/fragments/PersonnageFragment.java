package com.codexstarwars_androidapp.fragments;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.codexstarwars_androidapp.R;
import com.codexstarwars_androidapp.models.Personnage;
import com.codexstarwars_androidapp.services.ApiServicesPerso;

public class PersonnageFragment extends Fragment {


    private ImageView imageView;
    private TextView textViewName, textViewPersonnageDesc, textViewPersonnageAlias, textViewPersonnagedateNaissance, textViewPersonnagelieuNaissance, textViewPersonnagedateMort, textViewPersonnagelieuMort, textViewPersonnageEspece, textViewPersonnageGenre;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_personnage, null);

        textViewName = v.findViewById(R.id.textViewPersonnageName);
        textViewPersonnageDesc = v.findViewById(R.id.textViewPersonnageDesc);
        textViewPersonnageAlias = v.findViewById(R.id.textViewPersonnageAlias);
        textViewPersonnagedateNaissance = v.findViewById(R.id.textViewPersonnageDateNaissance);
        textViewPersonnagelieuNaissance = v.findViewById(R.id.textViewPersonnageLieuNaissance);
        textViewPersonnagedateMort = v.findViewById(R.id.textViewPersonnageDateMort);
        textViewPersonnagelieuMort = v.findViewById(R.id.textViewPersonnageLieuMort);
        textViewPersonnageEspece = v.findViewById(R.id.textViewPersonnageEspece);
        textViewPersonnageGenre = v.findViewById(R.id.textViewPersonnageGenre);

        imageView = v.findViewById(R.id.imageViewPersonnage);

        return v;
    }

    public void onSelectPersonnage(Personnage personnage) {

        textViewName.setText(personnage.getNom());
        textViewPersonnageDesc.setText("Description : " + personnage.getDescription());
        textViewPersonnageAlias.setText("Alias : " + personnage.getAlias());
        textViewPersonnagedateNaissance.setText("Date de naissance : " + personnage.getDateNaissance());
        textViewPersonnagelieuNaissance.setText("Lieu de naissance : " + personnage.getLieuNaissance());
        textViewPersonnagedateMort.setText("Date de mort : " + personnage.getDateMort());
        textViewPersonnagelieuMort.setText("Lieu de mort : " + personnage.getLieuMort());
        textViewPersonnageEspece.setText("Espèce : " + personnage.getEspece());
        textViewPersonnageGenre.setText("Genre : " + personnage.getGenre());

    }
}



