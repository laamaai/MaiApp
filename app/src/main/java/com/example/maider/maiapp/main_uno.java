package com.example.maider.maiapp;

import android.content.Context;
import android.content.Intent;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


public class main_uno extends Fragment {
    private TextView textView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_main_uno, container, false);
        TextView btn = (TextView)rootView.findViewById(R.id.button);

        btn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), PasaPagina.class);
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
