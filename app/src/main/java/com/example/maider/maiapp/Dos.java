package com.example.maider.maiapp;

import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.text.method.ScrollingMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import me.anwarshahriar.calligrapher.Calligrapher;


public class Dos extends Fragment {
    private static final String TAG = "FragmentDos";
    TextView scrollable;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_dos, container, false);
        String font_path = "font/Londrina.ttf";
        Typeface font = Typeface.createFromAsset(getActivity().getAssets(), font_path);
        TextView title = (TextView) view.findViewById(R.id.txtt);
        title.setTypeface(font);
        //Calligrapher cali = new Calligrapher(getActivity());
       // cali.setFont(getActivity(),"font/Londrina.ttf",true);
        scrollable = (TextView) view.findViewById(R.id.txtt);
        scrollable.setMovementMethod(new ScrollingMovementMethod());

        ImageButton btn = (ImageButton)view.findViewById(R.id.btnPlay);
        btn.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent intent = new Intent(getActivity(), Tres.class);
                startActivity(intent);
            }
        });
        return view;
    }
}
