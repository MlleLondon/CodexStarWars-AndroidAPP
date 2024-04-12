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

        //Nom de la planète
        textViewName.setText(planete.getName());

        //Région de la planète
        textViewPlaneteRegion.setText(planete.getRegion());

        //Type de la planete
        textViewPlaneteType.setText( (planete.getType()=="Inconnu"?"":planete.getType()));

        //Système de la planete
        textViewPlaneteSysteme.setText(planete.getSysteme());

        //Nombre de lunes de la planète
        textViewPlaneteLunes.setText(""+planete.getNbLunes());

        //Description de la planète
        textViewPlaneteDesc.setText(planete.getDescription());

        //Diamètre
        textViewPlaneteDiametre.setText( (planete.getDiametre()=="Inconnu"?"":"∅ : ")+planete.getDiametre());

        //Population
        textViewPlanetePopulation.setText(planete.getPopulation());

        ApiServices.loadPlaneteImage(getContext(), planete.getImage(), imageView);

    }
}



