package com.smithjterm.intentexample;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    public static final String POST_KEY = "postText";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void startNewActivity (View view){
        // First: Create an intent object
        Intent intent = new Intent(this, SecondActivity.class);

        TextView postView = (TextView) findViewById(R.id.postEntry);
        // have to chnage postView into a string, if not getText() will make into a charSequence
        intent.putExtra(POST_KEY, postView.getText().toString() );


        startActivity(intent);
    }
}
