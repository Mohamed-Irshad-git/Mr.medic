package com.example.medic5;

import android.content.Intent;
import android.os.Bundle;

import android.view.View;
import android.widget.Button;

import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;


public class Register extends AppCompatActivity {


    EditText fullname, emailreg, passreg, conf;
    public Button login,reg;
    public ImageButton backreg;
    FirebaseAuth fAuth;


    public void init(){
        login = (Button)findViewById(R.id.login);
        reg = (Button)findViewById(R.id.reg);
        backreg = (ImageButton)findViewById(R.id.backreg);
        reg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String fulln = fullname.getText().toString();
                String email = emailreg.getText().toString();
                String pass = passreg.getText().toString();
                String confpass = conf.getText().toString();

                if(fulln.isEmpty()){
                    fullname.setError("Full Name is Required");
                    return;
                }

                if(email.isEmpty()){
                    emailreg.setError("Email is Required");
                    return;
                }

                if(pass.isEmpty()){
                    passreg.setError("Password is Required");
                    return;
                }

                if(confpass.isEmpty()){
                    conf.setError("Re-Enter Password");
                    return;
                }

                if(!pass.equals(confpass)){
                    conf.setError("Password Do Not Match");



            }

                Toast.makeText(Register.this,"Data Validated",Toast.LENGTH_SHORT).show();

                fAuth.createUserWithEmailAndPassword(email,pass).addOnSuccessListener(new OnSuccessListener<AuthResult>() {
                    @Override
                    public void onSuccess(AuthResult authResult) {
                        startActivity(new Intent(getApplicationContext(),MainActivity.class));
                        finish();

                    }
                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(Register.this,e.getMessage(),Toast.LENGTH_SHORT).show();

                    }
                });



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

        fullname= (EditText) findViewById(R.id.fullname);
        emailreg= (EditText) findViewById(R.id.emaillog);
        passreg= (EditText) findViewById(R.id.passlog);
        conf= (EditText) findViewById(R.id.conf);

        fAuth = FirebaseAuth.getInstance();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        init();
    }
}