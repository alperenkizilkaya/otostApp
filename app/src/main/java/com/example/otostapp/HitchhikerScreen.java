package com.example.otostapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class HitchhikerScreen extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.hitchhikerscreen);

        Button hitchhikerScreenSaveButton = findViewById(R.id.hitchhikerScreenSave);

        hitchhikerScreenSaveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HitchhikerScreen.this, HitchhikerAlertScreen.class);
                try {
                    System.out.println("AAAAAAAAAAAAbbbbbbbbbbbbbbbbAAAAAAAAAAAAAA");
                    startActivity(intent);
                } catch (Exception e) {
                    System.out.println("AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA");
                    throw e;
                }
            }
        });

    }
}
