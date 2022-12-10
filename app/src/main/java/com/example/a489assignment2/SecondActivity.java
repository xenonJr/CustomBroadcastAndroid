package com.example.a489assignment2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        EditText input = findViewById(R.id.input);
        Button proceed = findViewById(R.id.proceed);
        TextView ins = findViewById(R.id.ins);

        int choice = getIntent().getIntExtra("Choice",-1);

        if(choice==0){
            ins.setText("Enter Some Input");

        }if(choice==2){
            ins.setText("Guess Bettary Parcentage : ");
        }

        proceed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(choice==0){
                    Intent intent = new Intent(getApplicationContext(),ThirdActivity.class);
                    intent.putExtra("toPrint",input.getText().toString());
                    startActivity(intent);
                }
                if(choice ==2){
                    Intent intent = new Intent(getApplicationContext(),ThirdActivity.class);
                    input.setInputType(InputType.TYPE_CLASS_NUMBER);
                    intent.putExtra("battery",Integer.valueOf(input.getText().toString()));
                    startActivity(intent);
                }
            }
        });
    }
}