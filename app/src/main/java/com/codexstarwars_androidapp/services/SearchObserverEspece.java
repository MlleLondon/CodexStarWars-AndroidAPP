package com.codexstarwars_androidapp.services;

import com.codexstarwars_androidapp.models.Espece;
import com.codexstarwars_androidapp.models.Planete;

public interface SearchObserverEspece {
    void onReceiveEspeceInfo(Espece espece);
}