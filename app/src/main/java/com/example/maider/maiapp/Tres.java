package com.example.maider.maiapp;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.method.ScrollingMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import me.anwarshahriar.calligrapher.Calligrapher;


public class Tres extends Fragment {
    private static final String TAG = "FragmentTres";
    TextView scrollable;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_tres, container, false);
        Calligrapher cali = new Calligrapher(getActivity());
        cali.setFont(getActivity(),"font/Londrina.ttf",true);


        return view;
    }
}
