package com.example.medic5;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class non_covid extends AppCompatActivity {

    public Button hpcount, sts, vcc, oxy;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_non_covid);

        sts = (Button) findViewById(R.id.sts);
        sts.setOnClickListener(v -> openStatus());


        hpcount = (Button) findViewById(R.id.hpcount);
        hpcount.setOnClickListener(v -> openHpCount());

        vcc = (Button) findViewById(R.id.vcc);
        vcc.setOnClickListener(v -> openVcc());

        oxy = (Button) findViewById(R.id.oxy);
        oxy.setOnClickListener(v -> openOxy());
    }


    public void openStatus() {
        Intent intent1 = new Intent(Intent.ACTION_VIEW, Uri.parse("https://stopcorona.tn.gov.in/beds.php"));
        startActivity(intent1);
    }

    public void openHpCount() {
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://stopcorona.tn.gov.in/beds.php"));
        startActivity(intent);
    }


    public void openVcc() {
        Intent intent2 = new Intent(Intent.ACTION_VIEW, Uri.parse("https://stopcorona.tn.gov.in/beds.php"));
        startActivity(intent2);
    }

    public void openOxy() {
        Intent intent3 = new Intent(Intent.ACTION_VIEW, Uri.parse("https://life.coronasafe.network/tamil_nadu/chennai/oxygen"));
        startActivity(intent3);
    }

}


