package com.example.otostapp;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class RegisterPersonal extends AppCompatActivity {

    private RadioGroup radioGroup;
    private RadioButton radioButton;

    private DataBase db;

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register_personal);

        db =  new DataBase(this, "Otstop", null, 2);

        Button registerAccept = findViewById(R.id.registerAccept);
        Button carTab1 = findViewById(R.id.carTab1);



        registerAccept.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RegisterPersonal.this, MainActivity.class);
                try {
                    EditText editName = findViewById(R.id.name);
                    EditText editMail = findViewById(R.id.mail);
                    EditText editPassword = findViewById(R.id.password);
                    EditText editAge = findViewById(R.id.age);
                    EditText editAboutMe = findViewById(R.id.aboutMe);

                    String name = String.valueOf(editName.getText());
                    String eMail = String.valueOf(editMail.getText());
                    String passsword = String.valueOf(editPassword.getText());
                    String bio = String.valueOf(editAboutMe.getText());
                    int age = Integer.valueOf(String.valueOf(editAge.getText()));

                    radioGroup = (RadioGroup) findViewById(R.id.sexRadioGroup);
                    int selectedId = radioGroup.getCheckedRadioButtonId();
                    radioButton = (RadioButton) findViewById(selectedId);
                    Sex sex = Sex.valueOf(String.valueOf(radioButton.getText()));

                    radioGroup = (RadioGroup) findViewById(R.id.musicRadioGroup);
                    selectedId = radioGroup.getCheckedRadioButtonId();
                    radioButton = (RadioButton) findViewById(selectedId);
                    Set<MusicType> musicTypeSet = new HashSet<>();
                    MusicType musicType = new MusicType();
                    musicType.setType(String.valueOf(radioButton.getText()));
                    musicTypeSet.add(musicType);

                    radioGroup = (RadioGroup) findViewById(R.id.filmRadioGroup);
                    selectedId = radioGroup.getCheckedRadioButtonId();
                    radioButton = (RadioButton) findViewById(selectedId);
                    Set<FilmGenre> filmGenreSet = new HashSet<>();
                    FilmGenre filmGenre = new FilmGenre();
                    filmGenre.setGenre(String.valueOf(radioButton.getText()));
                    System.out.println(String.valueOf(radioButton.getText()));
                    filmGenreSet.add(filmGenre);

                    User user = new User(name,eMail,passsword,sex,age,bio,filmGenreSet,musicTypeSet);

                    if(db.addUser(user))
                        startActivity(intent);
                    else
                        Toast.makeText(RegisterPersonal.this, "Kayıt Hata Verdi!", Toast.LENGTH_SHORT).show();
                } catch (Exception e) {
                    throw e;
                }
            }
        });
        carTab1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RegisterPersonal.this, RegisterCar.class);
                try {
                    startActivity(intent);
                } catch (Exception e) {
                    throw e;
                }
            }
        });
    }
}
