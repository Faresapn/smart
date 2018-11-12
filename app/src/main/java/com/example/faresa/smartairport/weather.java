package com.example.faresa.smartairport;

import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.format.DateFormat;
import android.text.format.DateUtils;
import android.widget.DatePicker;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.text.DateFormatSymbols;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class weather extends AppCompatActivity {
    private RequestQueue mRequestQueue;
    private TextView date , txtweather;
    private ImageView weather;
    GetSetWeather get = new GetSetWeather();
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weather);
        mRequestQueue = Volley.newRequestQueue(this);
        date = findViewById(R.id.date);

        txtweather = findViewById(R.id.txtweather);
        weather = findViewById(R.id.weather);
        getWeather();
        getDate();
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    private void getDate() {
        DateFormatSymbols dfs = new DateFormatSymbols(Locale.forLanguageTag("Senin"));
        String[] weekdays = dfs.getWeekdays();
        Calendar cal = Calendar.getInstance();

        int day = cal.get(Calendar.DAY_OF_WEEK);
        String  month = String.valueOf(cal.get(Calendar.MONTH)) ;
        String  dayy =  String.valueOf(cal.get(Calendar.DATE));
        String  year = String.valueOf(cal.get(Calendar.YEAR));

        date.setText(weekdays[day]+","+" "+ dayy+" " + month+" " + year );
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

                        get.setCuaca(cuaca);

                    }
                    JSONObject main = response.getJSONObject("main");

                    String temp = main.getString("temp");
                    String humidity = main.getString("humidity");

                    JSONObject wind = response.getJSONObject("wind");

                    String speed = wind.getString("speed");
                    String cuaca = get.getCuaca();
                    txtweather.setText(cuaca + " " + temp + "˚ C");




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
