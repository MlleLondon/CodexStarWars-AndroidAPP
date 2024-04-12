package com.codexstarwars_androidapp.services;

import com.codexstarwars_androidapp.models.Personnage;
import com.codexstarwars_androidapp.models.Planete;

import org.json.JSONObject;

public interface SearchObserverPerso {
    void onReceivePersonnageInfo(Personnage personnage);
}