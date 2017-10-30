package com.example.maider.maiapp;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Switch;
import android.widget.TextView;

import java.util.ArrayList;

import me.anwarshahriar.calligrapher.Calligrapher;

public class Pistas extends AppCompatActivity {

    ArrayList<String> pistas = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pistas);

        Calligrapher cali = new Calligrapher(this);
        cali.setFont(this,"font/Londrina.ttf",true);

        if (pistas.size() != 4){
            cargarArray();
            TextView txt = (TextView)findViewById(R.id.txtPista);
            txt.setText(pistas.get(0));
        }else{
            //leer el fichero, coger el número de la pista y mostrar esa pista

        }


    }
    public void cargarArray(){
        pistas.add(getResources().getString(R.string.pista1)) ;
        pistas.add(getResources().getString(R.string.pista2));
        pistas.add(getResources().getString(R.string.pista3));
        pistas.add(getResources().getString(R.string.pista4));
        pistas.add(getResources().getString(R.string.pista5));
    }


}
