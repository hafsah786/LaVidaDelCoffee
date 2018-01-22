package com.smithjterm.lavidadelcoffee;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class NameActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_name);
    }

    public void getName (){
        TextView inputName = (TextView) findViewById(R.id.nameInput_box);
        String inputString = inputName.getText().toString();
        CoffeePoint.inputName = inputString;
    }

    public void NameApp(View view) {
        Intent i = new Intent(this, preferenceActivity.class);
        getName();
        startActivity(i);
    }
}
