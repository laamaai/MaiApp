package com.example.maider.maiapp;

import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.gms.maps.SupportMapFragment;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

import me.anwarshahriar.calligrapher.Calligrapher;


public class Cuatro extends Fragment {
    private static final String TAG = "FragmentCuatro";
    ArrayList<String> pistas = new ArrayList<String>();
    Button IrMapa;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_cuatro, container, false);
        //Calligrapher cali = new Calligrapher(getActivity());
        //cali.setFont(getActivity(),"font/Londrina.ttf",true);
        String font_path = "font/Londrina.ttf";
        Typeface font = Typeface.createFromAsset(getActivity().getAssets(), font_path);
        TextView title = (TextView)view.findViewById(R.id.txtPista);
        title.setTypeface(font);

        cargarArray();
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
        TextView txt = (TextView)view.findViewById(R.id.txtPista);
        txt.setText(pistas.get(n));
        IrMapa = (Button)view.findViewById(R.id.btnAvanzarMapa);
        IrMapa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Fragment fr = new Mapa();
                //FragmentManager frm = getActivity().getSupportFragmentManager();
                //frm.beginTransaction().replace(R.id.frcambiar, fr).commit();
                //Fragment fr = getActivity().getSupportFragmentManager().findFragmentById(R.id.mapitaa);
               // FragmentTransaction transaction = getFragmentManager().beginTransaction();
              //  transaction.replace(R.id.frcambiar, fr);
               // transaction.addToBackStack(null);
                //transaction.commit();
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

    //ProgressBar progress = new ProgressBar(getActivity());

}
