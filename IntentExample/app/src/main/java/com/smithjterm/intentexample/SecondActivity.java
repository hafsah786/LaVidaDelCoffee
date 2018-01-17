package com.smithjterm.intentexample;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        // GET POST TEXT FROM MAINACTIVITY
        Intent intent = getIntent();
        Bundle extras = intent.getExtras();

        String postText =  extras.getString(MainActivity.POST_KEY);

        // Displaying the post in the UI
        TextView text = (TextView) findViewById(R.id.post);
        text.setText(postText);

    }
}
