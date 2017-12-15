package com.example.maider.maiapp;

import android.content.ClipData;
import android.content.Intent;
import android.media.MediaPlayer;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.CoordinatorLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;

import me.anwarshahriar.calligrapher.Calligrapher;

import static android.content.pm.ActivityInfo.SCREEN_ORIENTATION_PORTRAIT;

public class PasaPagina extends AppCompatActivity {

    ViewPager mPager;
    SlidePagerAdapter mPagerAdapter;
    int page = 0;
    MediaPlayer mp;
    boolean m = true;
    boolean activada = true;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pasa_pagina);
        mp = MediaPlayer.create(this, R.raw.musicaf);
        mp.setLooping(true);
        mp.start();
        m = true;


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
                return true;
            case R.id.action_buscar:
                irGoogle();
                return true;
            case R.id.action_musica:
                musica();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private void iniciarMusica() {
        findViewById(R.id.action_musica).setVisibility(View.VISIBLE);
        findViewById(R.id.action_mute).setVisibility(View.GONE);
        mp.start();
    }

    private void irGoogle() {
        Intent intent = new Intent(this, Google.class);
        startActivity(intent);
    }

    private void musica(){


        findViewById(R.id.action_mute).setVisibility(View.VISIBLE);
        findViewById(R.id.action_musica).setVisibility(View.GONE);
        mp.stop();
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
