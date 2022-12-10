package com.example.a489assignment2;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    int choice = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Spinner spinner = findViewById(R.id.spinner);
        Button proceed = findViewById(R.id.proceed);


        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.planets_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);


        proceed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (choice) {
                    case 0:
                        Intent intent = new Intent(getApplicationContext(),SecondActivity.class);
                        intent.putExtra("Choice",0);
                        startActivity(intent);
                        break;
                    case 1:
                        Intent intent2 = new Intent(getApplicationContext(),ThirdActivity.class);
                        intent2.putExtra("Choice",1);
                        startActivity(intent2);
                        break;
                    case 2:
                        Intent intent3 = new Intent(getApplicationContext(),SecondActivity.class);
                        intent3.putExtra("Choice",2);
                        startActivity(intent3);
                        break;
                }
                Toast.makeText(MainActivity.this, "Choice is : " + choice, Toast.LENGTH_SHORT).show();
            }
        });

       spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
           @Override
           public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
               choice = i;
           }

           @Override
           public void onNothingSelected(AdapterView<?> adapterView) {
               choice = 0;
           }
       });

    }
}