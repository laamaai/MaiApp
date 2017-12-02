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

    static final int NUM_ITEMS = 5;
    ImageView zero, one, two, three, four;
    ImageView[] indicators;
    ViewPager mPager;
    SlidePagerAdapter mPagerAdapter;
    CoordinatorLayout mCoordinator;
    int page = 0;
    Button IrMapa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pasa_pagina);
        ImageButton mNextBtn = (ImageButton) findViewById(R.id.intro_btn_next);
        zero = (ImageView) findViewById(R.id.intro_indicator_0);
        one = (ImageView) findViewById(R.id.intro_indicator_1);
        two = (ImageView) findViewById(R.id.intro_indicator_2);
        three = (ImageView) findViewById(R.id.intro_indicator_3);
        four = (ImageView) findViewById(R.id.intro_indicator_4);
        indicators = new ImageView[]{zero, one, two, three, four};
        mPager = (ViewPager) findViewById(R.id.pager);
        mPagerAdapter = new SlidePagerAdapter(getSupportFragmentManager());
        mPager.setAdapter(mPagerAdapter);
        indicators[0].setBackgroundResource(R.drawable.indicator_selected);
        final ImageButton bck = (ImageButton)findViewById(R.id.intro_btn_back);
        final ImageButton nxt = (ImageButton)findViewById(R.id.intro_btn_next);

        mPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        }

        @Override
        public void onPageSelected(int position) {
            page = position;
            switch (position) {
                case 0:
                    indicators[0].setBackgroundResource(R.drawable.indicator_selected);
                    indicators[1].setBackgroundResource(R.drawable.indicator_unselected);
                    indicators[2].setBackgroundResource(R.drawable.indicator_unselected);
                    indicators[3].setBackgroundResource(R.drawable.indicator_unselected);
                    indicators[4].setBackgroundResource(R.drawable.indicator_unselected);
                    bck.setVisibility(View.GONE);
                    break;

                case 1:
                    indicators[1].setBackgroundResource(R.drawable.indicator_selected);
                    indicators[0].setBackgroundResource(R.drawable.indicator_unselected);
                    indicators[2].setBackgroundResource(R.drawable.indicator_unselected);
                    indicators[3].setBackgroundResource(R.drawable.indicator_unselected);
                    indicators[4].setBackgroundResource(R.drawable.indicator_unselected);
                    bck.setVisibility(View.VISIBLE);
                    break;

                case 2:
                    indicators[2].setBackgroundResource(R.drawable.indicator_selected);
                    indicators[1].setBackgroundResource(R.drawable.indicator_unselected);
                    indicators[0].setBackgroundResource(R.drawable.indicator_unselected);
                    indicators[3].setBackgroundResource(R.drawable.indicator_unselected);
                    indicators[4].setBackgroundResource(R.drawable.indicator_unselected);
                    bck.setVisibility(View.VISIBLE);
                    break;

                case 3:
                    indicators[3].setBackgroundResource(R.drawable.indicator_selected);
                    indicators[1].setBackgroundResource(R.drawable.indicator_unselected);
                    indicators[2].setBackgroundResource(R.drawable.indicator_unselected);
                    indicators[0].setBackgroundResource(R.drawable.indicator_unselected);
                    indicators[4].setBackgroundResource(R.drawable.indicator_unselected);
                    bck.setVisibility(View.VISIBLE);
                    break;
                case 4:
                    indicators[4].setBackgroundResource(R.drawable.indicator_selected);
                    indicators[1].setBackgroundResource(R.drawable.indicator_unselected);
                    indicators[2].setBackgroundResource(R.drawable.indicator_unselected);
                    indicators[0].setBackgroundResource(R.drawable.indicator_unselected);
                    indicators[3].setBackgroundResource(R.drawable.indicator_unselected);
                    bck.setVisibility(View.VISIBLE);
                    nxt.setVisibility(View.GONE);
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
                default:
                    return null;
            }
        }

        @Override
        public int getCount() {
            return 5;
        }
    }
}
