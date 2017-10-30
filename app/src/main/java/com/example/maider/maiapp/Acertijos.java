package com.example.maider.maiapp;

import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.widget.TextView;

import java.util.ArrayList;

import me.anwarshahriar.calligrapher.Calligrapher;

public class Acertijos extends AppCompatActivity {
    TextView scrollable;
    ArrayList<String> acertijos = new ArrayList<String>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_acertijos);

        Calligrapher cali = new Calligrapher(this);
        cali.setFont(this,"font/Londrina.ttf",true);

        //scrollable = (TextView)findViewById(R.id.txtt);
        //scrollable.setMovementMethod(new ScrollingMovementMethod());

        if (acertijos.size() !=4){
            cargarArray();
            TextView txt = (TextView)findViewById(R.id.txtAcertijo);
            txt.setText(acertijos.get(0));
        }

    }

    public void cargarArray(){
        acertijos.add(getResources().getString(R.string.acertijo1));
        acertijos.add(getResources().getString(R.string.acertijo2));
        acertijos.add(getResources().getString(R.string.acertijo3));
        acertijos.add(getResources().getString(R.string.acertijo4));
        acertijos.add(getResources().getString(R.string.acertijo5));
    }

}
