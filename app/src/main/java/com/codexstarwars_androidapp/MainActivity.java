package com.codexstarwars_androidapp;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;


import com.codexstarwars_androidapp.fragments.PersonnageFragment;
import com.codexstarwars_androidapp.fragments.PlaneteFragment;
import com.codexstarwars_androidapp.fragments.SearchFragment;
import com.codexstarwars_androidapp.fragments.SearchFragmentPerso;
import com.codexstarwars_androidapp.models.Personnage;
import com.codexstarwars_androidapp.models.Planete;
import com.codexstarwars_androidapp.services.SearchObserver;
import com.codexstarwars_androidapp.services.SearchObserverPerso;

public class MainActivity extends AppCompatActivity implements SearchObserver, SearchObserverPerso {

    private PlaneteFragment planeteFragment;
    private SearchFragment searchFragment;


    private SearchFragmentPerso searchFragmentPerso;

    private PersonnageFragment personnageFragment;
  
    private boolean isMobile() {
        return findViewById(R.id.frameLayout)!=null;
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
            searchFragment = new SearchFragment();
            searchFragment.setListener(this);

            searchFragmentPerso = new SearchFragmentPerso();
            searchFragmentPerso.setListener(this);
            planeteFragment = new PlaneteFragment();
            personnageFragment = new PersonnageFragment();

            getSupportFragmentManager().beginTransaction()
                    .add(R.id.frameLayout, searchFragment)
                    .add(R.id.frameLayout, searchFragmentPerso)
                    .add(R.id.frameLayout, planeteFragment)
                    .add(R.id.frameLayout, personnageFragment)
                    .hide(planeteFragment)
                    .hide(personnageFragment)
                    .commit();

            planeteFragment = new PlaneteFragment();

            getSupportFragmentManager().beginTransaction()
                    .add(R.id.frameLayout, searchFragment)
                    .add(R.id.frameLayout, planeteFragment)
                    .hide(planeteFragment)
                    .commit();
    }

    }

    @Override
    public void onReceivePlaneteInfo(Planete planete) {
        planeteFragment.onSelectPlanete(planete);
        getSupportFragmentManager().beginTransaction()
                .hide(searchFragment)
                .show(planeteFragment)
                .commit();
    }

    @Override
    public void onReceivePersonnageInfo(Personnage personnage) {
        personnageFragment.onSelectPersonnage(personnage);
        getSupportFragmentManager().beginTransaction()
                .hide(searchFragment)
                .show(personnageFragment)
                .commit();
    }


}