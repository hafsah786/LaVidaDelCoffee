package com.smithjterm.lavidadelcoffee;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;

import java.util.ArrayList;


/**
 * a class that adds point to certain types of coffee based on the preference user chooses
 */

public class preferenceActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_preference);
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
            case R.id.milkBox:
                if (checked){
                    consumedActivity.addPoint("Latte");
                    //if the point of Latte is greater than the point of maxPoint, Latte becomes the new maxPoint
                    if(consumedActivity.coffeePoint.getPoint("Latte") > consumedActivity.coffeePoint.getPoint(consumedActivity.coffeePoint.maxPoint)){
                        consumedActivity.coffeePoint.maxPoint = "Latte";
                    }
                }
                break;

            //if chocolate is chosen, add one point to Mocha
            case R.id.chocBox:
                if (checked){
                    consumedActivity.addPoint("Mocha");
                    //if the point of Mocha is greater than the point of maxPoint, Mocha becomes the new maxPoint
                    if(consumedActivity.coffeePoint.getPoint("Mocha") > consumedActivity.coffeePoint.getPoint(consumedActivity.coffeePoint.maxPoint)){
                        consumedActivity.coffeePoint.maxPoint = "Mocha";
                    }
                }
                break;

            //if froth is chosen, add one point to Capp and Mac
            case R.id.frothBox:
                if (checked){
                    consumedActivity.addPoint("Cappuccino");
                    consumedActivity.addPoint("Macchiato");
                    //if the point of Capp is greater than the point of maxPoint, Capp becomes the new maxPoint
                    if(consumedActivity.coffeePoint.getPoint("Cappuccino") > consumedActivity.coffeePoint.getPoint(consumedActivity.coffeePoint.maxPoint)){
                        consumedActivity.coffeePoint.maxPoint = "Cappuccino";;
                    }
                    //if the point of Mac is greater than the point of maxPoint, Mac becomes the new maxPoint
                    if(consumedActivity.coffeePoint.getPoint("Macchiato") > consumedActivity.coffeePoint.getPoint(consumedActivity.coffeePoint.maxPoint)){
                        consumedActivity.coffeePoint.maxPoint = "Macchiato";
                    }
                }
                break;

            //if none is chosen, add one point to Esp and Am
            case R.id.noneBox:
                if (checked){
                    consumedActivity.addPoint("Espresso");
                    consumedActivity.addPoint("Americano");
                    //if the point of Esp is greater than the point of maxPoint, Esp becomes the new maxPoint
                    if(consumedActivity.coffeePoint.getPoint("Espresso") > consumedActivity.coffeePoint.getPoint(consumedActivity.coffeePoint.maxPoint)){
                        consumedActivity.coffeePoint.maxPoint = "Espresso";
                    }
                    //if the point of Am is greater than the point of maxPoint, Am becomes the new maxPoint
                    if(consumedActivity.coffeePoint.getPoint("Americano") > consumedActivity.coffeePoint.getPoint(consumedActivity.coffeePoint.maxPoint)){
                        consumedActivity.coffeePoint.maxPoint = "Americano";
                    }
                }
                break;
        }

        //jump to the next activity (consumed page)
        Intent i = new Intent(this, personalityActivity.class);
        startActivity(i);
    }

}
