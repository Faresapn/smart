package com.example.faresa.smartairport;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class signup extends AppCompatActivity implements View.OnClickListener{

    private Button btnMoveActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        btnMoveActivity = (Button)findViewById(R.id.sign);
        btnMoveActivity.setOnClickListener(this);
    }
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.sign:
                Intent moveIntent = new Intent(signup.this, Login.class);
                startActivity(moveIntent);
                break;

        }
    }
}
