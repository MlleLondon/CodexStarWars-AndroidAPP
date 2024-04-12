package com.codexstarwars_androidapp.services;

import com.codexstarwars_androidapp.models.Vaisseau;

public interface SearchVaisseauxObserver {
    void onReceiveVaisseauInfos(Vaisseau vaisseau);
}
