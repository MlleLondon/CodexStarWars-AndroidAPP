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
import com.codexstarwars_androidapp.models.Planete;
import com.codexstarwars_androidapp.models.PlaneteAdapter;
import com.codexstarwars_androidapp.services.ApiServices;

public class PlaneteFragment extends Fragment {


    private ImageView imageView;
    private TextView textViewName, textViewPlaneteRegion, textViewPlaneteType, textViewPlaneteSysteme, textViewPlaneteLunes, textViewPlaneteDesc, textViewPlaneteDiametre, textViewPlanetePopulation;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_planete, null);

        textViewName = v.findViewById(R.id.textViewPlaneteName);
        textViewPlaneteRegion = v.findViewById(R.id.textViewPlaneteRegion);
        textViewPlaneteType = v.findViewById(R.id.textViewPlaneteType);
        textViewPlaneteSysteme = v.findViewById(R.id.textViewPlaneteSysteme);
        textViewPlaneteLunes = v.findViewById(R.id.textViewPlaneteLunes);
        textViewPlaneteDesc = v.findViewById(R.id.textViewPlaneteDesc);
        textViewPlaneteDiametre = v.findViewById(R.id.textViewPlaneteDiametre);
        textViewPlanetePopulation = v.findViewById(R.id.textViewPlanetePopulation);

        imageView = v.findViewById(R.id.imageViewPlanete);

        return v;
    }

    public void onSelectPlanete(Planete planete) {

        textViewName.setText(planete.getName());
        textViewPlaneteRegion.setText("Région : " + planete.getRegion());
        textViewPlaneteType.setText("Type : " + planete.getType());
        textViewPlaneteSysteme.setText("Système : " + planete.getSysteme());
        textViewPlaneteLunes.setText("Nombres de lune(s) : " + planete.getNbLunes());
        textViewPlaneteDesc.setText("Description : " + planete.getDescription());
        textViewPlaneteDiametre.setText("Diamètre : " + planete.getDiametre());
        textViewPlanetePopulation.setText("Population : " + planete.getPopulation());

    }
}



