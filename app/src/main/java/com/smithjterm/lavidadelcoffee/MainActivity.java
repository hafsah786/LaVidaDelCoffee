package com.smithjterm.lavidadelcoffee;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);

        setContentView(R.layout.activity_main);
    }

    public void startApp(View view) {
        Intent i = new Intent(this, consumedActivity.class);

        //Intent i = new Intent(this, LatteActivity.class);

        startActivity(i);
    }
}
