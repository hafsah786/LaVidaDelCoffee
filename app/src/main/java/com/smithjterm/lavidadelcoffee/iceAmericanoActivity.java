package com.smithjterm.lavidadelcoffee;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class iceAmericanoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ice_americano);
    }

    public void locationAct(View view) {
        Intent i = new Intent(this, AmericanoLocationActivity.class);
        startActivity(i);
    }
}
