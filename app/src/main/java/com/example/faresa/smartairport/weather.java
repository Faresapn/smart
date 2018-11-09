package com.example.faresa.smartairport;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class weather extends AppCompatActivity {
    private RequestQueue mRequestQueue;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weather);
        mRequestQueue = Volley.newRequestQueue(this);
        getWeather();
    }
    private void getWeather(){
        String url = "http://api.openweathermap.org/data/2.5/weather?q=Purwokerto&appid=329e794adcf9c138725b1484d4e057b9&units=metric";
        final JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try {
                    JSONArray jsonArray = response.getJSONArray("weather");
                    for(int i = 0; i<jsonArray.length(); i++){

                        JSONObject resul = jsonArray.getJSONObject(i);
                        String cuaca = resul.getString("main");


                      //  IdeItem tambah = new IdeItem(id,judul,url,deskripsi,desP);
                    //    mExampleList.add(tambah);
                    }
                    JSONObject main = response.getJSONObject("main");

                    String temp = main.getString("temp");
                    String humidity = main.getString("humidity");

                    JSONObject wind = response.getJSONObject("wind");

                    String speed = wind.getString("speed");

                    //mExampleAdapter = new AdapterIde(getContext(),mExampleList);
                    //mRecyclerView.setAdapter(mExampleAdapter);
                    //mExampleAdapter.setOnItemClickListener(Home_Umkm.this);



                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        } ,new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
            }
        });
        mRequestQueue.add(request);
    }
}
