package com.example.maider.maiapp;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.maps.SupportMapFragment;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

import me.anwarshahriar.calligrapher.Calligrapher;

import static android.content.pm.ActivityInfo.SCREEN_ORIENTATION_PORTRAIT;


public class Cuatro extends Fragment {
    private static final String TAG = "FragmentCuatro";
    public static int pistaActual = 0;
    ArrayList<String> pistas = new ArrayList<String>();

    Button IrMapa;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        getActivity().setRequestedOrientation(SCREEN_ORIENTATION_PORTRAIT);
        View view = inflater.inflate(R.layout.fragment_cuatro, container, false);
        Calligrapher cali = new Calligrapher(getActivity());
        cali.setFont(getActivity(), "font/Londrina.ttf", true);
        String font_path = "font/Londrina.ttf";
        Typeface font = Typeface.createFromAsset(getActivity().getAssets(), font_path);
        TextView title = (TextView) view.findViewById(R.id.txtPista);
        title.setTypeface(font);

        TextView btn = (TextView)view.findViewById(R.id.btnAvanzarMapa);
        btn.setTypeface(font);
        //cargarArray();
        title.setText(getResources().getString(R.string.pista1));

/*
        if (pistaActual == 0){
            this.leerEstado();
                if (pistaActual !=0){
                    pistaActual +=1;
                }else{
                    TextView txt = (TextView) view.findViewById(R.id.txtPista);
                    txt.setText(pistas.get(pistaActual));
                }
        }

        this.escribirEstado(pistaActual);*/


        IrMapa = (Button) view.findViewById(R.id.btnAvanzarMapa);
        IrMapa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), MapsActivity.class);
                startActivity(intent);

            }
        });
        return view;
    }

    public void cargarArray(){
        pistas.add(0,getResources().getString(R.string.pista1)) ;
        pistas.add(1,getResources().getString(R.string.pista2));
        pistas.add(2,getResources().getString(R.string.pista3));
        pistas.add(3,getResources().getString(R.string.pista4));
        pistas.add(4,getResources().getString(R.string.pista5));
    }

   /* public void leerEstado(){
        SharedPreferences sharedPref = getActivity().getPreferences(Context.MODE_PRIVATE);
        long highScore = sharedPref.getInt("pista", pistaActual);
        pistaActual = (int) highScore;
    }

    public void escribirEstado(int pista){
        SharedPreferences sharedPref = getActivity().getPreferences(Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putInt("pista", pista);
        editor.apply();
    }
*/
}
