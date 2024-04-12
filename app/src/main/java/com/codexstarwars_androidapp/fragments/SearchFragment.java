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
import com.codexstarwars_androidapp.services.SearchObserver;
import com.codexstarwars_androidapp.R;

import org.json.JSONException;
import org.json.JSONObject;

public class SearchFragment extends Fragment implements SearchView.OnQueryTextListener, SearchObserver, AdapterView.OnItemClickListener {

        private SearchView searchView;
        private ListView listView;
        private PlaneteAdapter planeteAdapter;
        private ArrayList<Planete> planetes;

        private SearchObserver listener;

        public void setListener(SearchObserver listener) {
            this.listener = listener;
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
            View v = inflater.inflate(R.layout.fragment_search, null);

            searchView = v.findViewById(R.id.searchViewMain);
            searchView.setOnQueryTextListener(this);
            listView = v.findViewById(R.id.listViewMain);
            planetes = new ArrayList<>();
            planeteAdapter = new PlaneteAdapter(planetes, getContext());
            listView.setAdapter(planeteAdapter);
            listView.setOnItemClickListener(this);

            //On récupère le searchView afin de modifier ses valeurs (ici la couleur de texte)
            EditText searchEditText = searchView.findViewById(androidx.appcompat.R.id.search_src_text);
            searchEditText.setTextColor(Color.BLACK);
            return v;
        }

        @Override
        public boolean onQueryTextSubmit(String query) {
            planetes = new ArrayList<>();
            ApiServices.searchRequest(getContext(), query, this);
            return false;
        }

        @Override
        public boolean onQueryTextChange(String newText) {

            return false;
        }

    @Override
    public void onReceivePlaneteInfo(Planete planete) {
        if (!planetes.contains(planete)) {
            planetes.add(planete);
            planeteAdapter.setPlanetes(planetes);
            planeteAdapter.notifyDataSetChanged();
        }
    }


        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            Planete planete = planetes.get(position);
            listener.onReceivePlaneteInfo(planete);
        }


}
