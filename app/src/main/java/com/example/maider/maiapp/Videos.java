package com.example.maider.maiapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageButton;

import java.util.ArrayList;

import me.anwarshahriar.calligrapher.Calligrapher;

public class Videos extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_videos);
        Calligrapher cali = new Calligrapher(this);
        cali.setFont(this,"font/Londrina.ttf",true);




    }
    public boolean onTouchEvent(MotionEvent event){
        Intent intent = new Intent(this, Pistas.class);
        startActivity(intent);
        return super.onTouchEvent(event);
    }
}
