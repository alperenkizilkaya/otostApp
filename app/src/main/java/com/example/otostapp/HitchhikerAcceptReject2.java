package com.example.otostapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class HitchhikerAcceptReject2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.hitchhikeracceptreject2);

        Button acceptMatch2 = findViewById(R.id.acceptMatch2);
        Button rejectMatch2 = findViewById(R.id.rejectMatch2);
        Button personalTab1 = findViewById(R.id.personalTab1);

        acceptMatch2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HitchhikerAcceptReject2.this, MatchScreen.class);
                try {
                    startActivity(intent);
                } catch (Exception e) {
                    throw e;
                }
            }
        });
        rejectMatch2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HitchhikerAcceptReject2.this, HitchhikerSearchScreen.class);
                try {
                    startActivity(intent);
                } catch (Exception e) {
                    throw e;
                }
            }
        });
        personalTab1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HitchhikerAcceptReject2.this, HitchhikerAcceptReject.class);
                try {
                    startActivity(intent);
                } catch (Exception e) {
                    throw e;
                }
            }
        });

    }
}
