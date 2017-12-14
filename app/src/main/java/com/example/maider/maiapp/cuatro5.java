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
import android.widget.Button;
import android.widget.TextView;

import me.anwarshahriar.calligrapher.Calligrapher;

import static android.content.pm.ActivityInfo.SCREEN_ORIENTATION_PORTRAIT;


public class cuatro5 extends Fragment {
    Button IrMapa;
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        getActivity().setRequestedOrientation(SCREEN_ORIENTATION_PORTRAIT);
        View view = inflater.inflate(R.layout.fragment_cuatro5, container, false);
        Calligrapher cali = new Calligrapher(getActivity());
        cali.setFont(getActivity(), "font/Londrina.ttf", true);
        String font_path = "font/Londrina.ttf";
        Typeface font = Typeface.createFromAsset(getActivity().getAssets(), font_path);
        TextView title = (TextView) view.findViewById(R.id.txtPista);
        title.setTypeface(font);
        title.setText(getResources().getString(R.string.pista5));

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
}
