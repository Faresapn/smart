package com.example.faresa.smartairport;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class home extends AppCompatActivity implements View.OnClickListener{

    private ImageView imgmoveactivity;
    private CardView crdview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        crdview = (CardView) findViewById(R.id.System);
        crdview.setOnClickListener(this);
        imgmoveactivity = (ImageView) findViewById(R.id.profile_image);
        imgmoveactivity.setOnClickListener(this);
    }
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.profile_image:
                Intent moveIntent = new Intent(home.this, profile.class);
                startActivity(moveIntent);
                break;
            case R.id.System:
                Intent moveIntent1 = new Intent(home.this, Alert.class);
                startActivity(moveIntent1);
                break;
            default:
                break;

        }
    }
}
