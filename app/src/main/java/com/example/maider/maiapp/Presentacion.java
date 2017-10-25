package com.example.maider.maiapp;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;

public class Presentacion extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_presentacion);
        Typeface face=Typeface.createFromAsset(getAssets(),"font/MouseMemoirs-Regular.ttf");
        TextView txt = (TextView)findViewById(R.id.txtPresentacion);
        txt.setTypeface(face);

    }

    public boolean onTouchEvent(MotionEvent event){
        Intent intent = new Intent(this, pantalla2.class);
        startActivity(intent);
        return super.onTouchEvent(event);
    }
}
