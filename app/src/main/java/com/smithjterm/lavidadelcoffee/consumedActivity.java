package com.smithjterm.lavidadelcoffee;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class consumedActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consumed);
    }

    public int getConsumed (){
        TextView input = (TextView) findViewById(R.id.userinput_box);
        String inputString = input.getText().toString();
        return Integer.parseInt(inputString);
    }

}
