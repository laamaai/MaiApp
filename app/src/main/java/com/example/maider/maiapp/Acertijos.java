package com.example.maider.maiapp;

import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Acertijos extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_acertijos);

        Typeface face=Typeface.createFromAsset(getAssets(),"font/MouseMemoirs-Regular.ttf");
        //TextView txt = (TextView)findViewById(R.id.txt_Present);
       // txt.setTypeface(face);
    }
}
