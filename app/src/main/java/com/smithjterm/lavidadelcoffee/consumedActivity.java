package com.smithjterm.lavidadelcoffee;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Random;

public class consumedActivity extends AppCompatActivity {

    private static final int LATTE = 75;
    private static final int AMERICANO = 150;
    private static final int MACCHIATO = 169;
    private static final int ESPRESSO = 65;
    private static final int MOCHA = 95;
    private static final int CAPP = 75;

//    private HashMap<String, Integer> remainingHash = new HashMap <String, Integer>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consumed);
    }

    public String determineCoffee(){
        int consumed = getConsumed() * 95;
        int left = 400 - consumed;

        int minimumInt = Integer.MAX_VALUE;
        String minimumString = null;

        ArrayList<String> remainingArr = new ArrayList<String>();

        int remainingLatte = left - LATTE;
        int remainingAm = left - AMERICANO;
        int remainingMac = left - MACCHIATO;
        int remainingEsp = left - ESPRESSO;
        int remainingMocha = left - MOCHA;
        int remainingCapp = left - CAPP;


        if (remainingLatte >= 0 && remainingLatte <= minimumInt) {
            minimumInt = remainingLatte;
            Random rand = new Random();
            int value = rand.nextInt(2);
            if (value == 0){
                minimumString = "Latte";
            }
            else {
                minimumString = "Cappuccino";
            }

        }


        if (remainingAm >= 0 && remainingAm <= minimumInt) {
            minimumInt = remainingAm;
            minimumString = "Americano";
        }

        if (remainingMac >= 0 && remainingMac <= minimumInt) {
            minimumInt = remainingMac;
            minimumString = "Macchiato";
        }

        if (remainingEsp >= 0 && remainingEsp <= minimumInt) {
            minimumInt = remainingEsp;
            minimumString = "Espresso";
        }

        if (remainingMocha >= 0 && remainingMocha <= minimumInt) {
            minimumInt = remainingMocha;
            minimumString = "Mocha";
        }

        return minimumString;
    }

    public void jumpActivity(View view) {
        String determined = determineCoffee();
        if(determined.equals("Latte")) {
            Intent i = new Intent(this, LatteActivity.class);
            startActivity(i);
        }
        else if(determined.equals("Cappuccino")) {
            Intent i = new Intent(this, CappuccinoActivity.class);
            startActivity(i);
        }
        else if(determined.equals("Americano")) {
            Intent i = new Intent(this, AmericanoActivity.class);
            startActivity(i);
        }
        else if(determined.equals("Espresso")) {
            Intent i = new Intent(this, EspressoActivity.class);
            startActivity(i);
        }
        else if(determined.equals("Macchiato")) {
            Intent i = new Intent(this, MacchiatoActivity.class);
            startActivity(i);
        }
        else if(determined.equals("Mocha")) {
            Intent i = new Intent(this, MochaActivity.class);
            startActivity(i);
        }

    }


    public int getConsumed (){
        TextView input = (TextView) findViewById(R.id.userinput_box);
        String inputString = input.getText().toString();
        return Integer.parseInt(inputString);
    }

}
