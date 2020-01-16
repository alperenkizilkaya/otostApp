package com.example.otostapp;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity{
    /***
    //Spinner içerisine koyacağımız verileri tanımlıyoruz.
    private String[] brand={"ford","bmw","audi"};
    private String[] ford_model={"focus"};
    private String[] bmw_model={"M550i"};
    private String[] audi_model={"A1"};

    //Spinner'ları ve Adapter'lerini tanımlıyoruz.
    private Spinner brandSpinner;
    private Spinner modelSpinner;
    private ArrayAdapter<String> dataAdapterForBrand;
    private ArrayAdapter<String> dataAdapterForModel;
    ***/
    EditText eMailEdit;
    EditText passwordEdit;
    DataBase db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        db =  new DataBase(this, "Otstop", null, 2);



        Button registerButton = findViewById(R.id.registerButton);


        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, RegisterPersonal.class);
                try {
                    startActivity(intent);
                } catch (Exception e) {
                    throw e;
                }
            }
        });

        Button loginButton = findViewById(R.id.loginButton);
        loginButton.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.KITKAT)
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SecondScreen.class);
                try {
                    eMailEdit = findViewById(R.id.email);
                    passwordEdit = findViewById(R.id.password);

                    String eMail = String.valueOf(eMailEdit.getText());
                    String password = String.valueOf(passwordEdit.getText());
                    User user = db.getUser(eMail, password);

                    if(user != null)
                        startActivity(intent);
                    else
                        Toast.makeText(MainActivity.this, "Böyle bir kullanıcı yok!", Toast.LENGTH_SHORT).show();
                } catch (Exception e) {
                    throw e;
                }
            }
        });


        /***
        Spinner ageSpinner= findViewById(R.id.ageSpinner);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.numbers, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        ageSpinner.setAdapter(adapter);
        ageSpinner.setOnItemSelectedListener(this);

        //xml kısmında hazırladığımğız spinnerları burda tanımladıklarımızla eşleştiriyoruz.
        brandSpinner = (Spinner) findViewById(R.id.brandSpinner);
        modelSpinner = (Spinner) findViewById(R.id.modelSpinner);

        //Spinner'lar için adapterleri hazırlıyoruz.
        dataAdapterForBrand = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, brand);
        dataAdapterForModel = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item,ford_model);

        //Listelenecek verilerin görünümünü belirliyoruz.
        dataAdapterForBrand.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        dataAdapterForModel.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        //Hazırladğımız Adapter'leri Spinner'lara ekliyoruz.
        brandSpinner.setAdapter(dataAdapterForBrand);
        modelSpinner.setAdapter(dataAdapterForModel);

        // Listelerden bir eleman seçildiğinde yapılacakları tanımlıyoruz.
        brandSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> parent, View view,
                                       int position, long id) {
                //Hangi il seçilmişse onun ilçeleri adapter'e ekleniyor.
                if(parent.getSelectedItem().toString().equals(brand[0]))
                    dataAdapterForModel = new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_spinner_item,ford_model);
                else if(parent.getSelectedItem().toString().equals(brand[1]))
                    dataAdapterForModel = new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_spinner_item,bmw_model);
                else if(parent.getSelectedItem().toString().equals(brand[2]))
                    dataAdapterForModel = new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_spinner_item,audi_model);

                dataAdapterForModel.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                modelSpinner.setAdapter(dataAdapterForModel);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

        modelSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> parent, View view,
                                       int position, long id) {
                //Seçilen il ve ilçeyi ekranda gösteriyoruz.
                Toast.makeText(getBaseContext(), ""+brandSpinner.getSelectedItem().toString()+"n"+parent.getSelectedItem().toString(), Toast.LENGTH_SHORT).show();
            }

            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
         ***/
    }



    /***
    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String text = parent.getItemAtPosition(position).toString();
        Toast.makeText(parent.getContext(),text, Toast.LENGTH_SHORT).show();
    }
    ***/

    /***
    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
    ***/

}
