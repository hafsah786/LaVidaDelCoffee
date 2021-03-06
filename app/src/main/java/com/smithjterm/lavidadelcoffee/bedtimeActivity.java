package com.smithjterm.lavidadelcoffee;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class bedtimeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bedtime);
    }


    public void bed(View view) {
        DateFormat df = new SimpleDateFormat("H");

        Date dateobj = new Date();
        int hour = Integer.parseInt(df.format(dateobj));
        int bedtime = 0;

        TextView input = (TextView) findViewById(R.id.bedtimeinput_box);
        String inputString = input.getText().toString();

        //handle the case if the user doesn't input the hour
        if (inputString.length() > 2) {
            this.recreate();
        }
        else {
            bedtime = Integer.parseInt(inputString);

            if (hour <= 10) {
                consumedActivity.addPoint("Latte");
                consumedActivity.addPoint("iceLatte");
                //if the point of Latte is greater than the point of maxPoint, Latte becomes the new maxPoint
                if (consumedActivity.coffeePoint.getPoint("Latte") > consumedActivity.coffeePoint.getPoint(consumedActivity.coffeePoint.maxPoint)) {
                    consumedActivity.coffeePoint.maxPoint = "Latte";
                }

                if(consumedActivity.coffeePoint.getPoint("iceLatte") > consumedActivity.coffeePoint.getPoint(consumedActivity.coffeePoint.maxPoint)){
                    consumedActivity.coffeePoint.maxPoint = "iceLatte";
                }
            }
            if (hour <= 12) {
                consumedActivity.addPoint("Cappuccino");
                consumedActivity.addPoint("iceCapp");
                //if the point of Capp is greater than the point of maxPoint, Capp becomes the new maxPoint
                if (consumedActivity.coffeePoint.getPoint("Cappuccino") > consumedActivity.coffeePoint.getPoint(consumedActivity.coffeePoint.maxPoint)) {
                    consumedActivity.coffeePoint.maxPoint = "Cappuccino";
                }

                if(consumedActivity.coffeePoint.getPoint("iceCapp") > consumedActivity.coffeePoint.getPoint(consumedActivity.coffeePoint.maxPoint)){
                    consumedActivity.coffeePoint.maxPoint = "iceCapp";
                }
            }
            if (hour <= 19) {
                consumedActivity.addPoint("Americano");
                consumedActivity.addPoint("iceAmericano");
                //if the point of Am is greater than the point of maxPoint, Am becomes the new maxPoint
                if (consumedActivity.coffeePoint.getPoint("Americano") > consumedActivity.coffeePoint.getPoint(consumedActivity.coffeePoint.maxPoint)) {
                    consumedActivity.coffeePoint.maxPoint = "Americano";
                }
                if(consumedActivity.coffeePoint.getPoint("iceAmericano") > consumedActivity.coffeePoint.getPoint(consumedActivity.coffeePoint.maxPoint)){
                    consumedActivity.coffeePoint.maxPoint = "iceAmericano";
                }
            }

            if (Math.abs(bedtime - hour) >= 8) {
                consumedActivity.addPoint("Espresso");
                //if the point of Esp is greater than the point of maxPoint, Esp becomes the new maxPoint
                if (consumedActivity.coffeePoint.getPoint("Espresso") > consumedActivity.coffeePoint.getPoint(consumedActivity.coffeePoint.maxPoint)) {
                    consumedActivity.coffeePoint.maxPoint = "Espresso";
                }
            }

            if (Math.abs(bedtime - hour) >= 8) {
                consumedActivity.addPoint("Macchiato");
                consumedActivity.addPoint("iceCaramelMac");
                consumedActivity.addPoint("iceLatteMac");
                //if the point of Esp is greater than the point of maxPoint, Esp becomes the new maxPoint
                if (consumedActivity.coffeePoint.getPoint("Macchiato") > consumedActivity.coffeePoint.getPoint(consumedActivity.coffeePoint.maxPoint)) {
                    consumedActivity.coffeePoint.maxPoint = "Macchiato";
                }

                if(consumedActivity.coffeePoint.getPoint("iceCaramelMac") > consumedActivity.coffeePoint.getPoint(consumedActivity.coffeePoint.maxPoint)){
                    consumedActivity.coffeePoint.maxPoint = "iceCaramelMac";
                }
                if(consumedActivity.coffeePoint.getPoint("iceLatteMac") > consumedActivity.coffeePoint.getPoint(consumedActivity.coffeePoint.maxPoint)){
                    consumedActivity.coffeePoint.maxPoint = "iceLatteMac";
                }
            }

            if (hour <= 17) {
                consumedActivity.addPoint("Mocha");
                consumedActivity.addPoint("iceMocha");
                //if the point of Mocha is greater than the point of maxPoint, Mocha becomes the new maxPoint
                if (consumedActivity.coffeePoint.getPoint("Mocha") > consumedActivity.coffeePoint.getPoint(consumedActivity.coffeePoint.maxPoint)) {
                    consumedActivity.coffeePoint.maxPoint = "Mocha";
                }
                if(consumedActivity.coffeePoint.getPoint("iceMocha") > consumedActivity.coffeePoint.getPoint(consumedActivity.coffeePoint.maxPoint)){
                    consumedActivity.coffeePoint.maxPoint = "iceMocha";
                }
            }
            //jump to the next activity (consumed page)
            Intent i = new Intent(this, temperatureActivity.class);
            startActivity(i);
        }
    }

}
