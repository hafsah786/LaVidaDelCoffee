package com.smithjterm.lavidadelcoffee;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;

public class personalityActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_personality);
    }

    /**
     * onClick method that is called when checkBox in preference page is checked
     */
    public void onCheckboxClicked(View view) {
        //see if the view is checked
        boolean checked = ((CheckBox) view).isChecked();

        //see which checkbox was clicked
        switch(view.getId()) {
            //if latteBox is chosen, add one point to Latte
            case R.id.latteBox:
                if (checked){
                    consumedActivity.addPoint("Latte");
                    consumedActivity.addPoint("iceLatte");
                    //if the point of Latte is greater than the point of maxPoint, Latte becomes the new maxPoint
                    if(consumedActivity.coffeePoint.getPoint("Latte") > consumedActivity.coffeePoint.getPoint(consumedActivity.coffeePoint.maxPoint)){
                        consumedActivity.coffeePoint.maxPoint = "Latte";
                    }
                    if(consumedActivity.coffeePoint.getPoint("iceLatte") > consumedActivity.coffeePoint.getPoint(consumedActivity.coffeePoint.maxPoint)){
                        consumedActivity.coffeePoint.maxPoint = "iceLatte";
                    }
                }
                break;

            //if mochaBox is chosen, add one point to Mocha
            case R.id.mochaBox:
                if (checked){
                    consumedActivity.addPoint("Mocha");
                    consumedActivity.addPoint("iceMocha");
                    //if the point of Mocha is greater than the point of maxPoint, Mocha becomes the new maxPoint
                    if(consumedActivity.coffeePoint.getPoint("Mocha") > consumedActivity.coffeePoint.getPoint(consumedActivity.coffeePoint.maxPoint)){
                        consumedActivity.coffeePoint.maxPoint = "Mocha";
                    }
                    if(consumedActivity.coffeePoint.getPoint("iceMocha") > consumedActivity.coffeePoint.getPoint(consumedActivity.coffeePoint.maxPoint)){
                        consumedActivity.coffeePoint.maxPoint = "iceMocha";
                    }
                }
                break;

            //if cappBox is chosen, add one point to Capp
            case R.id.cappBox:
                if (checked){
                    consumedActivity.addPoint("Cappuccino");
                    consumedActivity.addPoint("iceCapp");
                    //if the point of Capp is greater than the point of maxPoint, Capp becomes the new maxPoint
                    if(consumedActivity.coffeePoint.getPoint("Cappuccino") > consumedActivity.coffeePoint.getPoint(consumedActivity.coffeePoint.maxPoint)){
                        consumedActivity.coffeePoint.maxPoint = "Cappuccino";;
                    }
                    if(consumedActivity.coffeePoint.getPoint("iceCapp") > consumedActivity.coffeePoint.getPoint(consumedActivity.coffeePoint.maxPoint)){
                        consumedActivity.coffeePoint.maxPoint = "iceCapp";
                    }
                }
                break;

            //if macBox is chosen, add one point to Mac
            case R.id.macBox:
                if (checked){
                    consumedActivity.addPoint("Macchiato");
                    consumedActivity.addPoint("iceCaramelMac");
                    consumedActivity.addPoint("iceLatteMac");
                    //if the point of Mac is greater than the point of maxPoint, Mac becomes the new maxPoint
                    if(consumedActivity.coffeePoint.getPoint("Macchiato") > consumedActivity.coffeePoint.getPoint(consumedActivity.coffeePoint.maxPoint)){
                        consumedActivity.coffeePoint.maxPoint = "Macchiato";
                    }
                    if(consumedActivity.coffeePoint.getPoint("iceCaramelMac") > consumedActivity.coffeePoint.getPoint(consumedActivity.coffeePoint.maxPoint)){
                        consumedActivity.coffeePoint.maxPoint = "iceCaramelMac";
                    }
                    if(consumedActivity.coffeePoint.getPoint("iceLatteMac") > consumedActivity.coffeePoint.getPoint(consumedActivity.coffeePoint.maxPoint)){
                        consumedActivity.coffeePoint.maxPoint = "iceLatteMac";
                    }
                }
                break;


            //if espBox is chosen, add one point to Esp
            case R.id.espBox:
                if (checked){
                    consumedActivity.addPoint("Espresso");
                    //if the point of Esp is greater than the point of maxPoint, Esp becomes the new maxPoint
                    if(consumedActivity.coffeePoint.getPoint("Espresso") > consumedActivity.coffeePoint.getPoint(consumedActivity.coffeePoint.maxPoint)){
                        consumedActivity.coffeePoint.maxPoint = "Espresso";
                    }
                }
                break;

            //if amBox is chosen, add one point to Am
            case R.id.amBox:
                if (checked){
                    consumedActivity.addPoint("Americano");
                    consumedActivity.addPoint("iceAmericano");
                    //if the point of Am is greater than the point of maxPoint, Am becomes the new maxPoint
                    if(consumedActivity.coffeePoint.getPoint("Americano") > consumedActivity.coffeePoint.getPoint(consumedActivity.coffeePoint.maxPoint)){
                        consumedActivity.coffeePoint.maxPoint = "Americano";
                    }
                    if(consumedActivity.coffeePoint.getPoint("iceAmericano") > consumedActivity.coffeePoint.getPoint(consumedActivity.coffeePoint.maxPoint)){
                        consumedActivity.coffeePoint.maxPoint = "iceAmericano";
                    }
                }
                break;
        }

        //jump to the next activity
        Intent i = new Intent(this, bedtimeActivity.class);
        startActivity(i);
    }
}
