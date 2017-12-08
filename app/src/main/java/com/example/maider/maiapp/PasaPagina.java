package com.example.maider.maiapp;

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
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;

import me.anwarshahriar.calligrapher.Calligrapher;

public class PasaPagina extends AppCompatActivity {

    ViewPager mPager;
    SlidePagerAdapter mPagerAdapter;
    int page = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pasa_pagina);

        mPager = (ViewPager) findViewById(R.id.pager);
        mPagerAdapter = new SlidePagerAdapter(getSupportFragmentManager());
        mPager.setAdapter(mPagerAdapter);

        final ImageButton bck = (ImageButton)findViewById(R.id.intro_btn_back);
        final ImageButton nxt = (ImageButton)findViewById(R.id.intro_btn_next);

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
                    break;
                case 1:
                    bck.setVisibility(View.VISIBLE);
                    nxt.setVisibility(View.VISIBLE);
                    break;
                case 2:
                    bck.setVisibility(View.VISIBLE);
                    nxt.setVisibility(View.VISIBLE);
                    break;
                case 3:
                    bck.setVisibility(View.VISIBLE);
                    nxt.setVisibility(View.VISIBLE);
                    break;
                case 4: //PRIMER ACERTIJO
                    bck.setVisibility(View.VISIBLE);
                    nxt.setVisibility(View.VISIBLE);
                    break;
                case 5: //ESTA NO ES SU POSICIÓN ORIGINAL--> SEGUNDO
                    //case 3
                    bck.setVisibility(View.VISIBLE);
                    nxt.setVisibility(View.VISIBLE);
                    break;
                case 6: //ESTA NO ES SU POSICIÓN ORIGINAL --> TERCERO
                    bck.setVisibility(View.VISIBLE);
                    nxt.setVisibility(View.VISIBLE);
                    break;
                case 7: //ESTA NO ES SU POSICIÓN ORIGINAL -->CUARTO
                    bck.setVisibility(View.VISIBLE);
                    nxt.setVisibility(View.VISIBLE);
                    break;
                case 8: //ESTA NO ES SU POSICIÓN ORIGINAL -->AZKENA
                    bck.setVisibility(View.VISIBLE);
                    nxt.setVisibility(View.VISIBLE);
                    break;
                case 9:
                    bck.setVisibility(View.VISIBLE);
                    nxt.setVisibility(View.VISIBLE);
                    break;
                case 10:
                    bck.setVisibility(View.VISIBLE);
                    nxt.setVisibility(View.VISIBLE);
                    break;
                case 11:
                    bck.setVisibility(View.VISIBLE);
                    nxt.setVisibility(View.VISIBLE);
                    break;
                case 12:
                    bck.setVisibility(View.VISIBLE);
                    nxt.setVisibility(View.VISIBLE);
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

    }

    public class SlidePagerAdapter extends FragmentPagerAdapter {
        public SlidePagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {

            switch (position){
                case 0:
                    return new Uno();
                case 1:
                    return new Dos();
                case 2:
                    return new Tres();
                case 3:
                    return new Cuatro();
                case 4:
                    return new Cinco();
                case 5:
                    return new Cuatro();
                case 6:
                    return new Seis();
                case 7:
                    return new Cuatro();
                case 8:
                    return new Siete();
                case 9:
                    return new Cuatro();
                case 10:
                    return new Ocho();
                case 11:
                    return new Cuatro();
                case 12:
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
}
