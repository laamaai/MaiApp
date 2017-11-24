package com.example.maider.maiapp;

import android.content.Context;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


public class main_dos extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_main_dos, container, false);

        String font_path = "font/Londrina.ttf";
        Typeface font = Typeface.createFromAsset(getActivity().getAssets(), font_path);

        TextView title = (TextView)rootView.findViewById(R.id.section_label);
        title.setTypeface(font);

        return rootView;
    }
}
