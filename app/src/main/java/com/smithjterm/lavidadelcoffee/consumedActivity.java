package com.smithjterm.lavidadelcoffee;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.webkit.HttpAuthHandler;
import android.widget.TextView;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.Random;

/**
 * a class that stores the userInput (how many cups of coffee user already consumed)
 * and determine which type of coffee to recommend based on each coffee point
 */

public class consumedActivity extends AppCompatActivity {

    //caffeine amount for each type of coffee
    private static final int LATTE = 75;
    private static final int AMERICANO = 150;
    private static final int MACCHIATO = 169;
    private static final int ESPRESSO = 65;
    private static final int MOCHA = 95;
    private static final int CAPP = 75;

    //create a CoffeePoint object which contains a HashMap of all coffee points
    public static CoffeePoint coffeePoint = new CoffeePoint();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consumed);
    }

    /**
     * @return how many cups of coffee the user already consumed
     */
    public int getConsumed (){
        TextView input = (TextView) findViewById(R.id.userinput_box);
        String inputString = input.getText().toString();
        return Integer.parseInt(inputString);
    }

    /**
     * add one point to the input type of coffee
     * @param string: the type of coffee that will be added point to
     */
    public static void addPoint(String string) {
        coffeePoint.add(string);
    }


    /**
     * if "left" is greater than the caffeine of a certain type of coffee
     * add one point to that type of coffee
     *
     * @return the remaining amount of caffeine that user can have for today
     */
    public int remainCoffee(){
        //how much caffeine the user already have: No. of cups * average caffeine per cup
        int consumed = getConsumed() * 95;

        //how much caffeine the user can still consume for today
        int left = 400 - consumed;

        //the difference between left and the caffeine of each type of coffee
        int remainingLatte = left - LATTE;
        int remainingAm = left - AMERICANO;
        int remainingMac = left - MACCHIATO;
        int remainingEsp = left - ESPRESSO;
        int remainingMocha = left - MOCHA;
        int remainingCapp = left - CAPP;


        //if left is greater than the caffeine of Latte, add one point to Latte
        if (remainingLatte >= 0) {
            addPoint("Latte");
            addPoint("iceLatte");
            //if the point of Latte is greater than the point of maxPoint, Latte becomes the new maxPoint
            if(coffeePoint.getPoint("Latte") > coffeePoint.getPoint(coffeePoint.maxPoint)){
                coffeePoint.maxPoint = "Latte";
            }
            if(coffeePoint.getPoint("iceLatte") > coffeePoint.getPoint(coffeePoint.maxPoint)){
                coffeePoint.maxPoint = "iceLatte";
            }
        }

        //if left is greater than the caffeine of Capp, add one point to Capp
        if (remainingCapp >= 0) {
            addPoint("Cappuccino");
            addPoint("iceCapp");
            //if the point of Capp is greater than the point of maxPoint, Capp becomes the new maxPoint
            if(coffeePoint.getPoint("Cappuccino") > coffeePoint.getPoint(coffeePoint.maxPoint)){
                coffeePoint.maxPoint = "Cappuccino";
            }
            if(coffeePoint.getPoint("iceCapp") > coffeePoint.getPoint(coffeePoint.maxPoint)){
                coffeePoint.maxPoint = "iceCapp";
            }
        }

        //if left is greater than the caffeine of Am, add one point to Am
        if (remainingAm >= 0 ) {
            addPoint("Americano");
            addPoint("iceAmericano");
            //if the point of Am is greater than the point of maxPoint, Am becomes the new maxPoint
            if(coffeePoint.getPoint("Americano") > coffeePoint.getPoint(coffeePoint.maxPoint)){
                coffeePoint.maxPoint = "Americano";
            }
            if(coffeePoint.getPoint("iceAmericano") > coffeePoint.getPoint(coffeePoint.maxPoint)){
                coffeePoint.maxPoint = "iceAmericano";
            }
        }

        //if left is greater than the caffeine of Mac, add one point to Mac
        if (remainingMac >= 0 ) {
            addPoint("Macchiato");
            addPoint("iceCaramelMac");
            addPoint("iceLatteMac");
            //if the point of Mac is greater than the point of maxPoint, Mac becomes the new maxPoint
            if(coffeePoint.getPoint("Macchiato") > coffeePoint.getPoint(coffeePoint.maxPoint)){
                coffeePoint.maxPoint = "Macchiato";
            }
            if(coffeePoint.getPoint("iceCaramelMac") > coffeePoint.getPoint(coffeePoint.maxPoint)){
                coffeePoint.maxPoint = "iceCaramelMac";
            }
            if(coffeePoint.getPoint("iceLatteMac") > coffeePoint.getPoint(coffeePoint.maxPoint)){
                coffeePoint.maxPoint = "iceLatteMac";
            }
        }

        //if left is greater than the caffeine of Esp, add one point to Esp
        if (remainingEsp >= 0 ) {
            addPoint("Espresso");
            //if the point of Esp is greater than the point of maxPoint, Esp becomes the new maxPoint
            if(coffeePoint.getPoint("Espresso") > coffeePoint.getPoint(coffeePoint.maxPoint)){
                coffeePoint.maxPoint = "Espresso";
            }
        }

        //if left is greater than the caffeine of Mocha, add one point to Mocha
        if (remainingMocha >= 0 ) {
            addPoint("Mocha");
            addPoint("iceMocha");
            //if the point of Mocha is greater than the point of maxPoint, Mocha becomes the new maxPoint
            if(coffeePoint.getPoint("Mocha") > coffeePoint.getPoint(coffeePoint.maxPoint)){
                coffeePoint.maxPoint = "Mocha";
            }
            if(coffeePoint.getPoint("iceMocha") > coffeePoint.getPoint(coffeePoint.maxPoint)){
                coffeePoint.maxPoint = "iceMocha";
            }
        }
        return left;
    }

    /**
     * jump to corresponding activity (coffee display page) based on the chosen coffee type
     */
    public void jumpActivity(View view) {
        int left = remainCoffee();

        //if the user already exceeds their caffeine amount, jump to NoRemaining page
        if(left < 0) {
            Intent i = new Intent(this, NoRemainingCoffeeActivity.class);
            TextView nameText = (TextView) findViewById(R.id.nameText);
            nameText.setText(CoffeePoint.inputName);
            startActivity(i);
        }
        else if(coffeePoint.maxPoint.equals("Latte")) {
            Intent i = new Intent(this, LatteActivity.class);
            startActivity(i);
        }
        else if(coffeePoint.maxPoint.equals("Cappuccino")) {
            Intent i = new Intent(this, CappuccinoActivity.class);
            startActivity(i);
        }
        else if(coffeePoint.maxPoint.equals("Americano")) {
            Intent i = new Intent(this, AmericanoActivity.class);
            startActivity(i);
        }
        else if(coffeePoint.maxPoint.equals("Espresso")) {
            Intent i = new Intent(this, EspressoActivity.class);
            startActivity(i);
        }
        else if(coffeePoint.maxPoint.equals("Macchiato")) {
            Intent i = new Intent(this, MacchiatoActivity.class);
            startActivity(i);
        }
        else if(coffeePoint.maxPoint.equals("Mocha")) {
            Intent i = new Intent(this, MochaActivity.class);
            startActivity(i);
        }

        else if(coffeePoint.maxPoint.equals("iceAmericano")) {
            Intent i = new Intent(this, iceAmericanoActivity.class);
            startActivity(i);
        }
        else if(coffeePoint.maxPoint.equals("iceCapp")) {
            Intent i = new Intent(this, iceCappActivity.class);
            startActivity(i);
        }
        else if(coffeePoint.maxPoint.equals("iceCaramelMac")) {
            Intent i = new Intent(this, iceCaramelMacActivity.class);
            startActivity(i);
        }
        else if(coffeePoint.maxPoint.equals("iceLatte")) {
            Intent i = new Intent(this, iceLatteActivity.class);
            startActivity(i);
        }
        else if(coffeePoint.maxPoint.equals("iceMocha")) {
            Intent i = new Intent(this, iceMochaActivity.class);
            startActivity(i);
        }
        else if(coffeePoint.maxPoint.equals("iceLatteMac")) {
            Intent i = new Intent(this, iceLatteMacActivity.class);
            startActivity(i);
        }
    }

}
