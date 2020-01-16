package com.example.otostapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class HitchhikerSearchScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.hitchhikersearchscreen);

        Button waitButton = findViewById(R.id.waitButton);
        Button cancelSearchButton = findViewById(R.id.cancelSearchButton);

        waitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HitchhikerSearchScreen.this, HitchhikerAcceptReject.class);
                try {
                    startActivity(intent);
                } catch (Exception e) {
                    throw e;
                }
            }
        });

        cancelSearchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HitchhikerSearchScreen.this, HitchhikerScreen.class);
                try {
                    startActivity(intent);
                } catch (Exception e) {
                    throw e;
                }
            }
        });

    }
}
