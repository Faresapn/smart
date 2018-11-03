package com.example.faresa.smartairport;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class home extends AppCompatActivity implements View.OnClickListener{

    private ImageView imgmoveactivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

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

        }
    }
}
