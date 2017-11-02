package com.example.maider.maiapp;

import android.content.Context;
import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
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
        cargarArray();
       // int numero = Integer.parseInt(getResources().getString(R.string.np));
        int n = 0;
        try{
            InputStreamReader in = new InputStreamReader(this.getResources().openRawResource(R.raw.numeros));
            BufferedReader br = new BufferedReader(in);
            String linea;
            StringBuilder texto = new StringBuilder();
            while ((linea = br.readLine())!=null){
                texto.append(linea);
            }
            br.close();
            in.close();
            n = Integer.parseInt(texto.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }

        TextView txt = (TextView)findViewById(R.id.txtPista);
        txt.setText(pistas.get(n));
/*
        try{
            OutputStreamWriter out = new OutputStreamWriter(openFileOutput("numeros.txt", Context.MODE_PRIVATE));
            out.write((n+1));
            out.close();
       } catch (IOException e) {
            e.printStackTrace();
        }
*/

    }

public void cargarArray(){
    pistas.add(0,getResources().getString(R.string.pista1)) ;
    pistas.add(1,getResources().getString(R.string.pista2));
    pistas.add(2,getResources().getString(R.string.pista3));
    pistas.add(3,getResources().getString(R.string.pista4));
    pistas.add(4,getResources().getString(R.string.pista5));
}





}
