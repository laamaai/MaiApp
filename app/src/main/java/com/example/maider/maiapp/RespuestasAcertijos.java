package com.example.maider.maiapp;

import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.util.ArrayList;

import me.anwarshahriar.calligrapher.Calligrapher;

public class RespuestasAcertijos extends AppCompatActivity {
    ArrayList<String> respuesta = new ArrayList<String>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_respuestas_acertijos);

        Calligrapher cali = new Calligrapher(this);
        cali.setFont(this,"font/Londrina.ttf",true);

        if (respuesta.size() !=3){
            cargarArray();
            //TextView txt = (TextView)findViewById(R.id.txtAcertijo);
            //txt.setText(acertijos.get(0));
        }

    }


    public void cargarArray(){
        respuesta.add(getResources().getString(R.string.respuesta1));
        respuesta.add(getResources().getString(R.string.respuesta2));
        respuesta.add(getResources().getString(R.string.respuesta3));
        respuesta.add(getResources().getString(R.string.respuesta4));
    }

}
