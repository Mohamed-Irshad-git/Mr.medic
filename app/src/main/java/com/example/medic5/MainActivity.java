package com.example.medic5;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    public Button covid,noncov;

    public void init(){
        covid = (Button)findViewById(R.id.covid);
        noncov = (Button)findViewById(R.id.noncovid);
        noncov.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent ncov = new Intent(MainActivity.this,non_covid.class);
                startActivity(ncov);
            }
        });
        covid.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent cov = new Intent(MainActivity.this,covidp.class);
                startActivity(cov);

            }
        });
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }
}