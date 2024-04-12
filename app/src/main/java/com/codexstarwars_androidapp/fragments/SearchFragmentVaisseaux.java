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
import com.codexstarwars_androidapp.models.Vaisseau;
import com.codexstarwars_androidapp.models.VaisseauAdapter;
import com.codexstarwars_androidapp.services.ApiVaisseauxService;
import com.codexstarwars_androidapp.services.SearchVaisseauxObserver;

import java.util.ArrayList;

public class SearchFragmentVaisseaux extends Fragment implements SearchView.OnQueryTextListener, SearchVaisseauxObserver, AdapterView.OnItemClickListener {

    private SearchView searchView;
    private ListView listView;
    private VaisseauAdapter vaisseauAdapter;
    private ArrayList<Vaisseau> vaisseaux;

    private SearchVaisseauxObserver listener;

    public void setListener(SearchVaisseauxObserver listener) {
        this.listener = listener;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_search, null);

        searchView = v.findViewById(R.id.searchViewMain);
        searchView.setOnQueryTextListener(this);
        listView = v.findViewById(R.id.listViewMain);
        vaisseaux = new ArrayList<>();
        vaisseauAdapter = new VaisseauAdapter(vaisseaux, getContext());
        listView.setAdapter(vaisseauAdapter);
        listView.setOnItemClickListener(this);

        EditText searchEditText = searchView.findViewById(androidx.appcompat.R.id.search_src_text);
        searchEditText.setTextColor(Color.BLACK);
        return v;
    }

    @Override
    public boolean onQueryTextSubmit(String query) {
        vaisseaux = new ArrayList<>();
        ApiVaisseauxService.searchVaisseauRequest(getContext(), query, this);
        return false;
    }

    @Override
    public boolean onQueryTextChange(String newText) {

        return false;
    }

    @Override
    public void onReceiveVaisseauInfos(Vaisseau vaisseau) {
        if (!vaisseaux.contains(vaisseau)) {
            vaisseaux.add(vaisseau);
            vaisseauAdapter.setVaisseaux(vaisseaux);
            vaisseauAdapter.notifyDataSetChanged();
        }
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Vaisseau vaisseau = vaisseaux.get(position);
        listener.onReceiveVaisseauInfos(vaisseau);
    }
}
