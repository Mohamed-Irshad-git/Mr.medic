package com.example.medic5;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class login extends AppCompatActivity {


    public Button login2;
    public ImageButton backlog;
    EditText emaillog,passlog;
    FirebaseAuth firebaseAuth;


    public void init(){

        firebaseAuth = FirebaseAuth.getInstance();

        login2 = (Button)findViewById(R.id.login2);

        backlog = (ImageButton)findViewById(R.id.backlog);

        backlog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent bck = new Intent(login.this,Welcome.class);
                startActivity(bck);
            }
        });
        login2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               if(emaillog.getText().toString().isEmpty()){
                   emaillog.setError("Enter Email");
                   return;
               }

                if(passlog.getText().toString().isEmpty()){
                    passlog.setError("Enter Password");
                    return;
                }

                firebaseAuth.signInWithEmailAndPassword(emaillog.getText().toString(),passlog.getText().toString()).addOnSuccessListener(new OnSuccessListener<AuthResult>() {
                    @Override
                    public void onSuccess(AuthResult authResult) {
                        startActivity(new Intent(getApplicationContext(),MainActivity.class));
                        finish();

                    }
                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(login.this,e.getMessage(),Toast.LENGTH_SHORT).show();

                    }
                });




            }
        });

        emaillog= findViewById(R.id.emaillog);
        passlog= findViewById(R.id.passlog);

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        init();
    }

    @Override
    protected void onStart() {
        super.onStart();
        if(FirebaseAuth.getInstance().getCurrentUser() !=null){
            startActivity(new Intent(getApplicationContext(),MainActivity.class));
            finish();
        }
    }
}