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

import com.codexstarwars_androidapp.R;
import com.codexstarwars_androidapp.models.Espece;
import com.codexstarwars_androidapp.models.EspeceAdapter;
import com.codexstarwars_androidapp.models.Personnage;
import com.codexstarwars_androidapp.models.PersonnageAdapter;
import com.codexstarwars_androidapp.services.ApiServicesEspece;
import com.codexstarwars_androidapp.services.ApiServicesPerso;
import com.codexstarwars_androidapp.services.SearchObserverEspece;
import com.codexstarwars_androidapp.services.SearchObserverPerso;

import java.util.ArrayList;

public class SearchFragmentEspece extends Fragment implements SearchView.OnQueryTextListener, SearchObserverEspece, AdapterView.OnItemClickListener {

    private SearchView searchView;
    private ListView listView;
    private EspeceAdapter especeAdapter;
    private ArrayList<Espece> especes;

    private SearchObserverEspece listener;

    public void setListener(SearchObserverEspece listener) {
        this.listener = listener;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View v = inflater.inflate(R.layout.fragment_search, null);

        searchView = v.findViewById(R.id.searchViewMain);
        searchView.setOnQueryTextListener(this);
        listView = v.findViewById(R.id.listViewMain);
        especes = new ArrayList<>();
        especeAdapter = new EspeceAdapter(especes, getContext());
        listView.setAdapter(especeAdapter);
        listView.setOnItemClickListener(this);

        //On récupère le searchView afin de modifier ses valeurs (ici la couleur de texte)
        EditText searchEditText = searchView.findViewById(androidx.appcompat.R.id.search_src_text);
        searchEditText.setTextColor(Color.BLACK);
        return v;
    }

    @Override
    public boolean onQueryTextSubmit(String query) {
        especes = new ArrayList<>();
        ApiServicesEspece.searchRequest(getContext(), query, this);
        return false;
    }

    @Override
    public boolean onQueryTextChange(String newText) {

        return false;
    }


    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Espece espece = especes.get(position);
        listener.onReceiveEspeceInfo(espece);
    }


    @Override
    public void onReceiveEspeceInfo(Espece espece) {
        if (!especes.contains(especes)) {
            especes.add(espece);
            especeAdapter.setEspeces(especes);
            especeAdapter.notifyDataSetChanged();
        }
    }
}
