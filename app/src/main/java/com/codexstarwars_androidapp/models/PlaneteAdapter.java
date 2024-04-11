package com.codexstarwars_androidapp.models;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.codexstarwars_androidapp.R;
import com.codexstarwars_androidapp.services.ApiServices;

import java.util.ArrayList;

public class PlaneteAdapter extends BaseAdapter {

        private ArrayList<Planete> planetes;
        private Context context;

        public PlaneteAdapter(ArrayList<Planete> planetes, Context context) {
            this.planetes = planetes;
            this.context = context;
        }

        public void setPlanetes(ArrayList<Planete> planetes) {
            this.planetes = planetes;
        }

        @Override
        public int getCount() {
            return planetes.size();
        }

        @Override
        public Object getItem(int i) {
            return planetes.get(i);
        }

        @Override
        public long getItemId(int i) {
            return planetes.get(i).getId();
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {
            if (view == null) {
                view = LayoutInflater.from(context).inflate(R.layout.item_planete, viewGroup, false);
            }
            TextView textViewName = view.findViewById(R.id.textViewItemPlaneteName);
            TextView textViewRegion = view.findViewById(R.id.textViewItemPlaneteRegion);
            TextView textViewType = view.findViewById(R.id.textViewItemPlaneteType);
            ImageView imageView = view.findViewById(R.id.imageViewItemPlanete);

            LinearLayout separator=view.findViewById(R.id.layoutSeparatorPlanete);

            textViewName.setText(planetes.get(i).getName());
            textViewRegion.setText(planetes.get(i).getRegion());
            textViewType.setText(planetes.get(i).getType());
            ApiServices.loadPlaneteImage(context, planetes.get(i).getImage(), imageView);

            return view;
        }
    }


