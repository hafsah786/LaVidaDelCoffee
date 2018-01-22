package com.smithjterm.lavidadelcoffee;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;

public class temperatureActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_temperature);
    }

    /**
     * onClick method that is called when checkBox in preference page is checked
     */
    public void onCheckboxClicked(View view) {
        //see if the view is checked
        boolean checked = ((CheckBox) view).isChecked();

        //see which checkbox was clicked
        switch(view.getId()) {
            //if milk is chosen, add one point to Latte
            case R.id.hotBox:
                if (checked) {
                    consumedActivity.addPoint("Latte");
                    consumedActivity.addPoint("Cappuccino");
                    consumedActivity.addPoint("Espresso");
                    consumedActivity.addPoint("Macchiato");
                    consumedActivity.addPoint("Mocha");
                    consumedActivity.addPoint("Americano");
                    //if the point of Latte is greater than the point of maxPoint, Latte becomes the new maxPoint
                    if (consumedActivity.coffeePoint.getPoint("Latte") > consumedActivity.coffeePoint.getPoint(consumedActivity.coffeePoint.maxPoint)) {
                        consumedActivity.coffeePoint.maxPoint = "Latte";
                    }
                    if (consumedActivity.coffeePoint.getPoint("Cappuccino") > consumedActivity.coffeePoint.getPoint(consumedActivity.coffeePoint.maxPoint)) {
                        consumedActivity.coffeePoint.maxPoint = "Cappuccino";
                    }
                    if (consumedActivity.coffeePoint.getPoint("Espresso") > consumedActivity.coffeePoint.getPoint(consumedActivity.coffeePoint.maxPoint)) {
                        consumedActivity.coffeePoint.maxPoint = "Espresso";
                    }
                    if (consumedActivity.coffeePoint.getPoint("Macchiato") > consumedActivity.coffeePoint.getPoint(consumedActivity.coffeePoint.maxPoint)) {
                        consumedActivity.coffeePoint.maxPoint = "Macchiato";
                    }
                    if (consumedActivity.coffeePoint.getPoint("Mocha") > consumedActivity.coffeePoint.getPoint(consumedActivity.coffeePoint.maxPoint)) {
                        consumedActivity.coffeePoint.maxPoint = "Mocha";
                    }
                    if (consumedActivity.coffeePoint.getPoint("Americano") > consumedActivity.coffeePoint.getPoint(consumedActivity.coffeePoint.maxPoint)) {
                        consumedActivity.coffeePoint.maxPoint = "Americano";
                    }
                }
                break;

            //if chocolate is chosen, add one point to Mocha
            case R.id.coldBox:
                if (checked) {
                    consumedActivity.addPoint("iceAmericano");
                    consumedActivity.addPoint("iceCapp");
                    consumedActivity.addPoint("iceCaramelMac");
                    consumedActivity.addPoint("iceLatte");
                    consumedActivity.addPoint("iceMocha");
                    consumedActivity.addPoint("iceLatteMac");
                    //if the point of Mocha is greater than the point of maxPoint, Mocha becomes the new maxPoint
                    if (consumedActivity.coffeePoint.getPoint("iceAmericano") > consumedActivity.coffeePoint.getPoint(consumedActivity.coffeePoint.maxPoint)) {
                        consumedActivity.coffeePoint.maxPoint = "iceAmericano";
                    }
                    if (consumedActivity.coffeePoint.getPoint("iceCapp") > consumedActivity.coffeePoint.getPoint(consumedActivity.coffeePoint.maxPoint)) {
                        consumedActivity.coffeePoint.maxPoint = "iceCapp";
                    }
                    if (consumedActivity.coffeePoint.getPoint("iceCaramelMac") > consumedActivity.coffeePoint.getPoint(consumedActivity.coffeePoint.maxPoint)) {
                        consumedActivity.coffeePoint.maxPoint = "iceCaramelMac";
                    }
                    if (consumedActivity.coffeePoint.getPoint("iceLatte") > consumedActivity.coffeePoint.getPoint(consumedActivity.coffeePoint.maxPoint)) {
                        consumedActivity.coffeePoint.maxPoint = "iceLatte";
                    }
                    if (consumedActivity.coffeePoint.getPoint("iceMocha") > consumedActivity.coffeePoint.getPoint(consumedActivity.coffeePoint.maxPoint)) {
                        consumedActivity.coffeePoint.maxPoint = "iceMocha";
                    }
                    if (consumedActivity.coffeePoint.getPoint("iceLatteMac") > consumedActivity.coffeePoint.getPoint(consumedActivity.coffeePoint.maxPoint)) {
                        consumedActivity.coffeePoint.maxPoint = "iceLatteMac";
                    }
                }
                break;
        }

        //jump to the next activity (consumed page)
        Intent i = new Intent(this, consumedActivity.class);
        startActivity(i);
    }
}
