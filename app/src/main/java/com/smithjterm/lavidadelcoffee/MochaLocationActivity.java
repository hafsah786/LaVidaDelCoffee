package com.smithjterm.lavidadelcoffee;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MochaLocationActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mocha_location);
    }

    public void resetApp(View view) {
        Intent i = new Intent(this, MainActivity.class);
        consumedActivity.coffeePoint.resetHash();
        startActivity(i);
    }
}
