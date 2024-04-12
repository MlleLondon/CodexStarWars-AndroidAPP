package com.codexstarwars_androidapp.fragments;

import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;

import androidx.appcompat.widget.SearchView;
import androidx.fragment.app.Fragment;

import java.util.ArrayList;


import com.codexstarwars_androidapp.models.Personnage;
import com.codexstarwars_androidapp.models.PersonnageAdapter;
import com.codexstarwars_androidapp.models.Planete;
import com.codexstarwars_androidapp.models.PlaneteAdapter;
import com.codexstarwars_androidapp.services.ApiServices;
import com.codexstarwars_androidapp.services.ApiServicesPerso;
import com.codexstarwars_androidapp.services.SearchObserver;
import com.codexstarwars_androidapp.R;
import com.codexstarwars_androidapp.services.SearchObserverPerso;

import org.json.JSONException;
import org.json.JSONObject;

public class SearchFragmentPerso extends Fragment implements SearchView.OnQueryTextListener, SearchObserverPerso, AdapterView.OnItemClickListener {

    private SearchView searchView;
    private ListView listView;
    private PersonnageAdapter personnageAdapter;
    private ArrayList<Personnage> personnages;

    private SearchObserverPerso listener;

    public void setListener(SearchObserverPerso listener) {
        this.listener = listener;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View v = inflater.inflate(R.layout.fragment_search, null);

        searchView = v.findViewById(R.id.searchViewMain);
        searchView.setOnQueryTextListener(this);
        listView = v.findViewById(R.id.listViewMain);
        personnages = new ArrayList<>();
        personnageAdapter = new PersonnageAdapter(personnages, getContext());
        listView.setAdapter(personnageAdapter);
        listView.setOnItemClickListener(this);

        //On récupère le searchView afin de modifier ses valeurs (ici la couleur de texte)
        EditText searchEditText = searchView.findViewById(androidx.appcompat.R.id.search_src_text);
        searchEditText.setTextColor(Color.BLACK);
        return v;
    }

    @Override
    public boolean onQueryTextSubmit(String query) {
        personnages = new ArrayList<>();
        ApiServicesPerso.searchRequest(getContext(), query, this);
        return false;
    }

    @Override
    public boolean onQueryTextChange(String newText) {

        return false;
    }

    @Override
    public void onReceivePersonnageInfo(Personnage personnage) {
        if (!personnages.contains(personnage)) {
            personnages.add(personnage);
            personnageAdapter.setPersonnages(personnages);
            personnageAdapter.notifyDataSetChanged();
        }
    }


    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Personnage personnage = personnages.get(position);
        listener.onReceivePersonnageInfo(personnage);
    }


}
