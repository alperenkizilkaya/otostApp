package com.example.otostapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class TravelEnd extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.travelend);

        Button acceptTravelEnd = findViewById(R.id.acceptTravelEnd);

        acceptTravelEnd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(TravelEnd.this, CommentstarActivity.class);
                try {
                    startActivity(intent);
                } catch (Exception e) {
                    throw e;
                }
            }
        });

    }
}
