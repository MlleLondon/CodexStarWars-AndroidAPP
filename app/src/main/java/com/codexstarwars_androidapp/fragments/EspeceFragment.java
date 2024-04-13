package com.codexstarwars_androidapp.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.codexstarwars_androidapp.R;
import com.codexstarwars_androidapp.models.Espece;
import com.codexstarwars_androidapp.models.Personnage;
import com.codexstarwars_androidapp.services.ApiServicesEspece;

public class EspeceFragment extends Fragment {


    private ImageView imageView;
    private TextView textViewName, textViewClassification, textViewTaille, textViewPlanete, textViewLangage, textViewDescription;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_espece, null);

        textViewName = v.findViewById(R.id.textViewEspeceName);
        textViewClassification = v.findViewById(R.id.textViewEspeceClassification);
        textViewTaille = v.findViewById(R.id.textViewEspeceTaille);
        textViewPlanete = v.findViewById(R.id.textViewEspecePlanete);
        textViewLangage = v.findViewById(R.id.textViewEspeceLangage);
        textViewDescription = v.findViewById(R.id.textViewEspeceDesc);

        imageView = v.findViewById(R.id.imageViewEspece);

        return v;
    }

    public void onSelectEspece(Espece espece) {

        textViewName.setText(espece.getNom());
        textViewClassification.setText(""+espece.getClassification());
        textViewTaille.setText(""+ espece.getTaille());
        textViewPlanete.setText("Planète : " + espece.getPlanete());
        textViewLangage.setText("Langage : " + espece.getLangage());
        textViewDescription.setText(""+ espece.getDescription());

        ApiServicesEspece.loadEspeceImage(getContext(), espece.getImage(), imageView);

    }
}



