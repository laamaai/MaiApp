package com.example.maider.maiapp;

import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import me.anwarshahriar.calligrapher.Calligrapher;


public class Uno extends Fragment {
    private static final String TAG = "FragmentUno";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_uno, container, false);
        String font_path = "font/Londrina.ttf";
        Typeface font = Typeface.createFromAsset(getActivity().getAssets(), font_path);
        TextView title = (TextView)view.findViewById(R.id.txtPresentacion);
        title.setTypeface(font);
       // Calligrapher cali = new Calligrapher(getActivity());
       // cali.setFont(getActivity(),"font/Londrina.ttf",true);
        return view;
    }
   // public boolean onTouchEvent(MotionEvent event){
    //    Intent intent = new Intent(getActivity(), Dos.class);
      //  startActivity(intent);
     //   return super.onTouchEvent(event);
   // }
}
