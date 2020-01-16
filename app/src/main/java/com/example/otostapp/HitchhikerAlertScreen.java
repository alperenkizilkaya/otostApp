package com.example.otostapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class HitchhikerAlertScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.hitchikeralertscreen);

        Button acceptAlert = findViewById(R.id.acceptAlert);
        Button rejectAlert = findViewById(R.id.rejectAlert);

        acceptAlert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HitchhikerAlertScreen.this, HitchhikerSearchScreen.class);
                try {
                    startActivity(intent);
                } catch (Exception e) {
                    throw e;
                }
            }
        });
        rejectAlert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HitchhikerAlertScreen.this, HitchhikerScreen.class);
                try {
                    startActivity(intent);
                } catch (Exception e) {
                    throw e;
                }
            }
        });
    }
}
