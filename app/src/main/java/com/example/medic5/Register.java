package com.example.medic5;

import android.content.Intent;
import android.os.Bundle;

import android.view.View;
import android.widget.Button;

import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;


public class Register extends AppCompatActivity {

    public Button login,reg;
    public ImageButton backreg;


    public void init(){
        login = (Button)findViewById(R.id.login);
        reg = (Button)findViewById(R.id.reg);
        backreg = (ImageButton)findViewById(R.id.backreg);
        reg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent bck = new Intent(Register.this,MainActivity.class);
                startActivity(bck);
            }
        });

        backreg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent bck = new Intent(Register.this,Welcome.class);
                startActivity(bck);
            }
        });
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent log = new Intent(Register.this,login.class);
                startActivity(log);

            }
        });
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        init();
    }
}