package com.codexstarwars_androidapp;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;


import com.codexstarwars_androidapp.fragments.PersonnageFragment;
import com.codexstarwars_androidapp.fragments.PlaneteFragment;
import com.codexstarwars_androidapp.fragments.SearchFragment;
import com.codexstarwars_androidapp.fragments.SearchFragmentPerso;
import com.codexstarwars_androidapp.fragments.SearchFragmentVaisseaux;
import com.codexstarwars_androidapp.fragments.VaisseauFragment;
import com.codexstarwars_androidapp.models.Personnage;
import com.codexstarwars_androidapp.models.Planete;
import com.codexstarwars_androidapp.models.Vaisseau;
import com.codexstarwars_androidapp.services.SearchObserver;
import com.codexstarwars_androidapp.services.SearchObserverPerso;
import com.codexstarwars_androidapp.services.SearchVaisseauxObserver;

public class MainActivity extends AppCompatActivity implements SearchObserver, SearchObserverPerso, SearchVaisseauxObserver {

    private PlaneteFragment planeteFragment;
    private SearchFragment searchFragment;
    private SearchFragmentPerso searchFragmentPerso;
    private PersonnageFragment personnageFragment;
    private SearchFragmentVaisseaux searchFragmentVaisseaux;
    private VaisseauFragment vaisseauFragment;
  
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
            searchFragmentVaisseaux = new SearchFragmentVaisseaux();
            searchFragmentVaisseaux.setListener(this);

            planeteFragment = new PlaneteFragment();
            personnageFragment = new PersonnageFragment();
            vaisseauFragment = new VaisseauFragment();

            getSupportFragmentManager().beginTransaction()
                    .add(R.id.frameLayout, searchFragment)
                    .add(R.id.frameLayout, searchFragmentPerso)
                    .add(R.id.frameLayout, searchFragmentVaisseaux)
                    .add(R.id.frameLayout, planeteFragment)
                    .add(R.id.frameLayout, personnageFragment)
                    .add(R.id.frameLayout, vaisseauFragment)
                    .hide(planeteFragment)
                    .hide(personnageFragment)
                    .hide(vaisseauFragment)
                    .commit();
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
                .hide(searchFragmentPerso)
                .show(personnageFragment)
                .commit();
    }

    @Override
    public void onReceiveVaisseauInfos(Vaisseau vaisseau) {
        vaisseauFragment.onSelectVaisseau(vaisseau);
        getSupportFragmentManager().beginTransaction()
                .hide(searchFragmentVaisseaux)
                .show(vaisseauFragment)
                .commit();
    }
}