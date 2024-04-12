package com.codexstarwars_androidapp.services;

import android.content.Context;
import android.graphics.Bitmap;
import android.widget.ImageView;


import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.ImageRequest;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.codexstarwars_androidapp.models.Personnage;
import com.codexstarwars_androidapp.models.Planete;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class ApiServicesPerso {

    // private static String URL_API_SEARCH = "http://192.168.76.45/CodexStarWars-RestAPI/server/index.php?resource=planete&name=";
    private static String URL_API_SEARCH = "https://codexstarwars.000webhostapp.com/index.php?resource=personnage&name=";


    public static void searchRequest(Context context, String search, SearchObserverPerso listener) {
        RequestQueue queue = Volley.newRequestQueue(context);
        StringRequest request = new StringRequest(URL_API_SEARCH + search,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONArray jsonArray = new JSONArray(response);
                            for (int i = 0; i < jsonArray.length(); i++) {
                                JSONObject object = jsonArray.getJSONObject(i);
                                Personnage personnage = new Personnage(
                                        object.getInt("id"),
                                        object.getString("bom"),
                                        object.getString("description"),
                                        object.getString("alias"),
                                        object.getString("dateNaissance"),
                                        object.getString("lieuNaissance"),
                                        object.getString("dateMort"),
                                        object.getString("lieuMort"),
                                        object.getString("espece"),
                                        object.getString("genre"),
                                        object.getString("image"));
                                // Ajoutez d'autres propriétés de la planète ici
                                listener.onReceivePersonnageInfo(personnage);
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }

                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
            }
        });
        queue.add(request);
    }

    public static void loadPlaneteImage(Context context, String image, final ImageView imageView) {
        RequestQueue queue = Volley.newRequestQueue(context);
        ImageRequest request = new ImageRequest(image,
                new Response.Listener<Bitmap>() {
                    @Override
                    public void onResponse(Bitmap bitmap) {
                        imageView.setImageBitmap(bitmap);
                    }
                }, 0, 0, null,
                new Response.ErrorListener() {
                    public void onErrorResponse(VolleyError error) {
                        imageView.setImageResource(android.R.drawable.ic_menu_gallery);
                    }
                });
        queue.add(request);
    }


}
