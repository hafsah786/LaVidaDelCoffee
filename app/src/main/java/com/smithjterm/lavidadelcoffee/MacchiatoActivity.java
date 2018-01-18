package com.smithjterm.lavidadelcoffee;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MacchiatoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_macchiato);
    }

    public void locationAct(View view) {
        Intent i = new Intent(this, MacchiatoLocationActivity.class);
        startActivity(i);
    }
}
