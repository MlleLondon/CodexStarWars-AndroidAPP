package com.codexstarwars_androidapp.fragments;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.ImageButton;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.codexstarwars_androidapp.R;
import com.codexstarwars_androidapp.models.Vaisseau;
import com.codexstarwars_androidapp.services.ApiVaisseauxService;

import androidx.fragment.app.Fragment;

public class HomeFragment extends Fragment implements View.OnClickListener {
    private ImageButton personnagesButton, planetesButton, especesButton, vaisseauxButton;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_home, null);

        personnagesButton = v.findViewById(R.id.imageButtonPerso);
        planetesButton = v.findViewById(R.id.imageButtonPlanete);
        especesButton = v.findViewById(R.id.imageButtonEspece);
        vaisseauxButton = v.findViewById(R.id.imageButtonVaisseau);

        return v;
    }

    @Override
    public void onClick(View view) {
        ImageButton selectedButton = (ImageButton) view;
        switch (selectedButton) {
            case personnagesButton:

                break;
            case planetesButton:

                break;
            case especesButton:

                break;
            case vaisseauxButton:

                break;
        }
    }
}
