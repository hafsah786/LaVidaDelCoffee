package com.smithjterm.lavidadelcoffee;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class NameActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_name);
    }

    public String getName (){
        TextView inputName = (TextView) findViewById(R.id.nameInput_box);
        String inputString = inputName.getText().toString();
        return inputString;
    }
}
