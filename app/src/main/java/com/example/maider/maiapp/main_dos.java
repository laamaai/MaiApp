package com.example.maider.maiapp;

import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import static android.content.pm.ActivityInfo.SCREEN_ORIENTATION_PORTRAIT;


public class main_dos extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        //Poner la pantalla de forma vertical
        getActivity().setRequestedOrientation(SCREEN_ORIENTATION_PORTRAIT);
        View rootView = inflater.inflate(R.layout.fragment_main_dos, container, false);
        String font_path = "font/Londrina.ttf";
        Typeface font = Typeface.createFromAsset(getActivity().getAssets(), font_path);
        TextView title = (TextView)rootView.findViewById(R.id.section_label);
        title.setTypeface(font);
        TextView btn =  (TextView)rootView.findViewById(R.id.btnWeb);
        btn.setTypeface(font);

        btn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), Web.class);
                startActivity(intent);
            }
        });


        return rootView;
    }
}
