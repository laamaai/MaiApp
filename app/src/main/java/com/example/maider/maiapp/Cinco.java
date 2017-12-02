package com.example.maider.maiapp;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.text.method.ScrollingMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class Cinco extends Fragment {
    private static final String TAG = "FragmentCinco";
    TextView scrollable;
    private EditText rp1, rp2;

    @SuppressLint("ResourceAsColor")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_cinco, container, false);
        String font_path = "font/Londrina.ttf";
        Typeface font = Typeface.createFromAsset(getActivity().getAssets(), font_path);
        TextView title = (TextView)view.findViewById(R.id.txtAcertijo1);
        title.setText(R.string.acertijo1);
        scrollable = (TextView) view.findViewById(R.id.txtAcertijo1);
        scrollable.setMovementMethod(new ScrollingMovementMethod());
        title.setTypeface(font);
        Button btn = (Button)view.findViewById(R.id.button2);
        rp1 = (EditText)view.findViewById(R.id.primera);
        rp2 = (EditText)view.findViewById(R.id.segunda);

        // Calligrapher cali = new Calligrapher(getActivity());
        // cali.setFont(getActivity(),"font/Londrina.ttf",true);
        return view;
    }

    public void corregir(View v){
        //coger los valores que nos han escrito.
        String r1 = rp1.getText().toString().toUpperCase();
        String r2 = rp2.getText().toString().toUpperCase();
        String resp = getString(R.string.acertijoRespuesta1);
        String ellos = "" +r1+"-"+r2;




    }





}
