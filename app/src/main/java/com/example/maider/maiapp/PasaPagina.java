package com.example.maider.maiapp;

import android.annotation.TargetApi;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Configuration;
import android.media.MediaPlayer;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import java.util.Locale;

import me.anwarshahriar.calligrapher.Calligrapher;

import static android.content.pm.ActivityInfo.SCREEN_ORIENTATION_PORTRAIT;

public class PasaPagina extends AppCompatActivity{

    ViewPager mPager;
    SlidePagerAdapter mPagerAdapter;
    int page = 0;
    MediaPlayer mp;
    boolean m = true;
    boolean activada = true;
    Button btnMute;
    private Configuration config = new Configuration();
    int idioma;
    int num = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pasa_pagina);
        mp = MediaPlayer.create(this, R.raw.musicaf);
        mp.setLooping(true);
        mp.start();

        if (num == 1){
            mp.stop();
        }else{
            mp.start();
            mp.setLooping(true);
        }


        btnMute = (Button)findViewById(R.id.action_musica);

        //Poner la pantalla de forma vertical
        setRequestedOrientation(SCREEN_ORIENTATION_PORTRAIT);

        mPager = (ViewPager) findViewById(R.id.pager);
        mPagerAdapter = new SlidePagerAdapter(getSupportFragmentManager());
        mPager.setAdapter(mPagerAdapter);

        final ImageButton bck = (ImageButton)findViewById(R.id.intro_btn_back);
        final ImageButton nxt = (ImageButton)findViewById(R.id.intro_btn_next);
        final Button btn = (Button)findViewById(R.id.button2);

        Calligrapher cali = new Calligrapher(this);
        cali.setFont(this,"font/Londrina.ttf",true);

        mPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        }

        @Override
        public void onPageSelected(int position) {
            page = position;
            switch (position) {
                case 0:
                    bck.setVisibility(View.GONE);
                    nxt.setVisibility(View.VISIBLE);
                    btn.setVisibility(View.GONE);
                    break;
                case 1:
                    bck.setVisibility(View.VISIBLE);
                    nxt.setVisibility(View.VISIBLE);
                    btn.setVisibility(View.GONE);
                    break;
                case 2:
                    bck.setVisibility(View.VISIBLE);
                    nxt.setVisibility(View.VISIBLE);
                    btn.setVisibility(View.GONE);
                    break;
                case 3:
                    bck.setVisibility(View.VISIBLE);
                    nxt.setVisibility(View.VISIBLE);
                    btn.setVisibility(View.GONE);
                    break;
                case 4: //PRIMER ACERTIJO
                    bck.setVisibility(View.VISIBLE);
                    nxt.setVisibility(View.VISIBLE);
                    btn.setVisibility(View.GONE);
                    break;
                case 5: //ESTA NO ES SU POSICIÓN ORIGINAL--> SEGUNDO
                    //case 3
                    bck.setVisibility(View.VISIBLE);
                    nxt.setVisibility(View.VISIBLE);
                    btn.setVisibility(View.GONE);
                    break;
                case 6: //ESTA NO ES SU POSICIÓN ORIGINAL --> TERCERO
                    bck.setVisibility(View.VISIBLE);
                    nxt.setVisibility(View.VISIBLE);
                    btn.setVisibility(View.GONE);
                    break;
                case 7: //ESTA NO ES SU POSICIÓN ORIGINAL -->CUARTO
                    bck.setVisibility(View.VISIBLE);
                    nxt.setVisibility(View.VISIBLE);
                    btn.setVisibility(View.GONE);
                    break;
                case 8: //ESTA NO ES SU POSICIÓN ORIGINAL -->AZKENA
                    bck.setVisibility(View.VISIBLE);
                    nxt.setVisibility(View.VISIBLE);
                    btn.setVisibility(View.GONE);
                    break;
                case 9:
                    bck.setVisibility(View.VISIBLE);
                    nxt.setVisibility(View.VISIBLE);
                    btn.setVisibility(View.GONE);
                    break;
                case 10:
                    bck.setVisibility(View.VISIBLE);
                    nxt.setVisibility(View.VISIBLE);
                    btn.setVisibility(View.GONE);
                    break;
                case 11:
                    bck.setVisibility(View.VISIBLE);
                    nxt.setVisibility(View.VISIBLE);
                    btn.setVisibility(View.GONE);
                    break;
                case 12:
                    bck.setVisibility(View.VISIBLE);
                    nxt.setVisibility(View.GONE);
                    btn.setVisibility(View.VISIBLE);
                    break;
                default:
                    break;
            }
        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }
    });

        bck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                page -= 1;
                mPager.setCurrentItem(page, true);
            }
        });

        nxt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                page += 1;
                mPager.setCurrentItem(page, true);
            }
        });

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), CreditosActivity.class);
                startActivity(intent);
            }
        });

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.toolbar, menu);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.action_settings:
                showDialog();
                return true;
            case R.id.action_buscar:
                irGoogle();
                return true;
            case R.id.action_musica:
                showMusicaDialog();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private void showMusicaDialog() {
        boolean sonido = false;
        final String [] items = {"On", "Off"};
        AlertDialog.Builder b = new AlertDialog.Builder(this);
        b.setTitle(R.string.musica)
                .setItems(items, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                        if (which == 1){
                            num = 1;
                            mp.stop();
                        }else{
                            mp.start();
                            num = 0;
                            //mp.setLooping(true);
                        }

                    }
                });

                b.show();


    }


    private void showDialog() {
        AlertDialog.Builder b = new AlertDialog.Builder(this);
        b.setTitle(getResources().getString(R.string.str_button));
        String[] types = getResources().getStringArray(R.array.languages);
        b.setItems(types, new DialogInterface.OnClickListener() {

            @TargetApi(Build.VERSION_CODES.N)
            @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
                Intent refresh;
                if (which == 1) {
                    Locale locale = new Locale("eu");
                    config.locale = locale;
                    idioma = 1;
                } else {
                    Locale locale = new Locale("es");
                    config.locale = locale;
                    idioma = 0;
                }
                getResources().updateConfiguration(config, null);
                refresh = new Intent(PasaPagina.this, PasaPagina.class);
                startActivity(refresh);
                finish();
            }

        });
        b.show();
    }

    private void irGoogle() {
        Intent intent = new Intent(this, Google.class);
        startActivity(intent);
    }

    public class SlidePagerAdapter extends FragmentPagerAdapter {
        public SlidePagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {

            switch (position){
                case 12:
                    return new Uno();
                case 0:
                    return new Dos();
                case 1:
                    return new Tres();
                case 2:
                    return new Cuatro();
                case 3:
                    return new Cinco();
                case 4:
                    return new cuatro2();
                case 5:
                    return new Seis();
                case 6:
                    return new cuatro3();
                case 7:
                    return new Siete();
                case 8:
                    return new cuatro4();
                case 9:
                    return new Ocho();
                case 10:
                    return new cuatro5();
                case 11:
                    return new Nueve();
                    //case 13:
                // return new Tres(); //con el otro video o return una nueva con el video.
                default:
                    return null;
            }
        }

        @Override
        public int getCount() {
            return 13;
        }
    }

    public void onPause(){
        super.onPause();
        if (m == true){
            mp.stop();
            activada = true;
        }else{
            activada = false;
        }
    }

    public void onResume(){
        super.onResume();
        if (m == true){
            mp.start();
        }
    }

    public void onDestroy(){
        super.onDestroy();
        if (m == true){
            mp.stop();
        }
    }

    public void onRestart(){
        super.onRestart();
        if(activada == true){
            mp.start();
        }
    }



}
