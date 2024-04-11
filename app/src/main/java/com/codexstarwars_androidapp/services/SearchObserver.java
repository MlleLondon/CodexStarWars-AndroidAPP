package com.codexstarwars_androidapp.services;

import com.codexstarwars_androidapp.models.Planete;

import org.json.JSONObject;

public interface SearchObserver {
    void onReceivePlaneteInfo(Planete planete);
}