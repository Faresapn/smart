package com.example.faresa.smartairport;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Login extends AppCompatActivity implements View.OnClickListener{


    private TextView txtMoveActivity;
    private Button btnMoveActivity;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        btnMoveActivity = (Button)findViewById(R.id.Login);
        btnMoveActivity.setOnClickListener(this);

        txtMoveActivity= (TextView) findViewById(R.id.signup1);
        txtMoveActivity.setOnClickListener(this);
    }
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.signup1:
                Intent moveIntent = new Intent(Login.this, signup.class);
                startActivity(moveIntent);
                break;
            case R.id.Login:
                Intent moveIntent1 = new Intent(Login.this, home.class);
                startActivity(moveIntent1);
                break;
            default:
                break;


        }
    }
}


