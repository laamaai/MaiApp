package com.example.maider.maiapp;

/**
 * Created by Maider on 14/10/2017.
 */
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TabWidget;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import me.anwarshahriar.calligrapher.Calligrapher;

import static android.support.v7.widget.TintTypedArray.obtainStyledAttributes;

public class Tab1 extends Fragment {
    private TextView textView;
    private String PREFS_KEY = "mispreferencias";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.tab1, container, false);
        TextView btn = (TextView)rootView.findViewById(R.id.button);

        btn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), Presentacion.class);
                startActivity(intent);
            }

        });

        String font_path = "font/Londrina.ttf";
        Typeface font = Typeface.createFromAsset(getActivity().getAssets(), font_path);

        TextView title = (TextView)rootView.findViewById(R.id.button);
        title.setTypeface(font);

        return rootView;
    }

    private void onCreating(){
        int[] attrs = new int[]{R.attr.selectableItemBackgroundBorderless};
        TypedArray typedArray = getContext().obtainStyledAttributes(attrs);
        int backgroundRes = typedArray.getResourceId(0,0);

        typedArray.recycle();
        textView.setBackgroundResource(backgroundRes);
        textView.setClickable(true);

    }


}
