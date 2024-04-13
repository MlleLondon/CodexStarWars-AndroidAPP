package com.codexstarwars_androidapp.services;

import android.content.Context;
import android.graphics.Bitmap;
import android.widget.ImageView;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.ImageRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.codexstarwars_androidapp.models.Espece;
import com.codexstarwars_androidapp.models.Planete;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class ApiServicesEspece {

    // private static String URL_API_SEARCH = "http://192.168.76.45/CodexStarWars-RestAPI/server/index.php?resource=planete&name=";
    private static String URL_API_SEARCH = "https://codexstarwars.000webhostapp.com/index.php?resource=espece&name=";


    public static void searchRequest(Context context, String search, SearchObserverEspece listener) {
        RequestQueue queue = Volley.newRequestQueue(context);
        StringRequest request = new StringRequest(URL_API_SEARCH + search,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONArray jsonArray = new JSONArray(response);
                            for (int i = 0; i < jsonArray.length(); i++) {
                                JSONObject object = jsonArray.getJSONObject(i);
                                Espece espece = new Espece(
                                        object.getInt("id"),
                                        object.getString("nom"),
                                        object.getString("description"),
                                        object.getString("classification"),
                                        object.getString("taille"),
                                        object.getString("couleursCorps"),
                                        object.getString("couleursPoils"),
                                        object.getString("planete"),
                                        object.getString("habitat"),
                                        object.getString("langage"),
                                        object.getString("image"));
                                // Ajoutez d'autres propriétés de l'espèce ici
                                listener.onReceiveEspeceInfo(espece);
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

    public static void loadEspeceImage(Context context, String image, final ImageView imageView) {
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