package com.smithjterm.myfirstapp;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends Activity {

    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void rightButtonPress ( View view ){
        //cast findView to Button class; creates a button object for the right button
        Button rightButton = (Button) findViewById(R.id.right_button);

        //clicking the right button will change button text to "you did it!"
        rightButton.setText(R.string.pressed_button);
        Log.i(TAG, "We pressed the button!");
    }
}
