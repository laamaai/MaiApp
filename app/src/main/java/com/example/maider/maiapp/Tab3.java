package com.example.maider.maiapp;

import android.annotation.TargetApi;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Typeface;
import android.media.MediaPlayer;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Locale;

//import java.util.Locale;

/**
 * Created by Maider on 14/10/2017.
 */

public class Tab3 extends Fragment{
    Button btn1;
    Button btn2;
    MediaPlayer mp;
    private Configuration config = new Configuration();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.tab3, container, false);

        //btn1 = (Button)rootView.findViewById(R.id.btnPlay);
       // btn2 = (Button)rootView.findViewById(R.id.btnPause);

      // btn1.setOnClickListener((View.OnClickListener) this);
       // btn2.setOnClickListener((View.OnClickListener) this);
       // mp = MediaPlayer.create(getActivity(),R.raw.supermario);
       // mp.start();

      /*  String font_path = "font/Londrina.ttf";
        Typeface font = Typeface.createFromAsset(getActivity().getAssets(), font_path);
        TextView title = (TextView)rootView.findViewById(R.id.btnPlay);
        title.setTypeface(font);
        TextView title1 = (TextView)rootView.findViewById(R.id.btnPause);
        title1.setTypeface(font);
       */

        Button button = ((Button)rootView.findViewById(R.id.button2));
        TextView textview = ((TextView)rootView.findViewById(R.id.textview));

        button.setOnClickListener(
                new View.OnClickListener() {
                    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
                    public void onClick(View view) {
                        showDialog();
                    }});
        //Boton para el idioma
        return rootView;
    }

    private void showDialog(){
        AlertDialog.Builder b = new AlertDialog.Builder(getActivity());
        b.setTitle(getResources().getString(R.string.str_button));
        //obtiene los idiomas del array de string.xml
        String[] types = getResources().getStringArray(R.array.languages);
        b.setItems(types, new DialogInterface.OnClickListener() {

            @TargetApi(Build.VERSION_CODES.N)
            @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();

                if (which==1){
                    //Aqui hacer referencia a la carpeta de euskera.xml

                    Locale locale = new Locale("euskera");
                    config.locale =locale;
                }else{
                    //Aqui hacer referencia a la carpeta de castellano.xml
                    Locale locale = new Locale("es");
                    config.locale =locale;
                }
                getResources().updateConfiguration(config, null);
                Intent refresh = new Intent(getActivity(), Tab3.class);
                startActivity(refresh);

            }




        });

        b.show();
    }




}

