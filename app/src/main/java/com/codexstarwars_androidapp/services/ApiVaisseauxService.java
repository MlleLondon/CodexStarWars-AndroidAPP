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
import com.codexstarwars_androidapp.models.Vaisseau;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class ApiVaisseauxService {
    private static String URL_API_VAISSEAUX_SEARCH = "https://codexstarwars.000webhostapp.com/index.php?resource=vaisseau&name=";

    public static void searchVaisseauRequest(Context context, String search, SearchVaisseauxObserver listener) {
        RequestQueue queue = Volley.newRequestQueue(context);
        StringRequest request = new StringRequest(URL_API_VAISSEAUX_SEARCH + search,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONArray jsonArray = new JSONArray(response);
                            for (int i = 0; i < jsonArray.length(); i++) {
                                JSONObject object = jsonArray.getJSONObject(i);
                                Vaisseau vaisseau = new Vaisseau(
                                        object.getInt("id"),
                                        object.getString("nom"),
                                        object.getString("description"),
                                        object.getString("longueur"),
                                        object.getString("vitesse"),
                                        object.getString("moteur"),
                                        object.getString("equipage"),
                                        object.getString("image"));
                                // Ajoutez d'autres propriétés de la planète ici
                                listener.onReceiveVaisseauInfos(vaisseau);
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

    public static void loadVaisseauImage(Context context, String image, final ImageView imageView) {
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
