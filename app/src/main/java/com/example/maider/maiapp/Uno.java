package com.example.maider.maiapp;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.VideoView;

import me.anwarshahriar.calligrapher.Calligrapher;

import static android.content.pm.ActivityInfo.SCREEN_ORIENTATION_PORTRAIT;


public class Uno extends Fragment {
    private static final String TAG = "FragmentUno";
    private VideoView videoView;
    private int position = 0;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        getActivity().setRequestedOrientation(SCREEN_ORIENTATION_PORTRAIT);
        View view = inflater.inflate(R.layout.fragment_uno, container, false);

        setUpVideoView(view);
       // Calligrapher cali = new Calligrapher(getActivity());
       // cali.setFont(getActivity(),"font/Londrina.ttf",true);
        return view;
    }
        // public boolean onTouchEvent(MotionEvent event){
         //    Intent intent = new Intent(getActivity(), Dos.class);
      //  startActivity(intent);
     //   return super.onTouchEvent(event);
   // }
        private void setUpVideoView(View v){
            String uriPath = "android.resource://" + getActivity().getPackageName()
                    + "/" + R.raw.video2;
            Uri uri = Uri.parse(uriPath);
            MediaController mediaController = new MediaController(getActivity());
            videoView = (VideoView)v.findViewById(R.id.videoView);
            videoView.setMediaController(mediaController);
            try{
                videoView.setVideoURI(uri);
                videoView.requestFocus();
            }catch (Exception e){
                Log.e("Error", e.getMessage());
                e.printStackTrace();
            }
            videoView.setOnPreparedListener(videoViewListener);
        }

    private MediaPlayer.OnPreparedListener videoViewListener = new MediaPlayer.OnPreparedListener() {
        @Override
        public void onPrepared(MediaPlayer mediaPlayer) {
            mediaPlayer.setLooping(false);
            if (position == 0) {
                videoView.pause();
            } else {
                videoView.pause();
            }
        }

    };

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);
        savedInstanceState.putInt("Position",
                videoView.getCurrentPosition());
        videoView.pause();
    }



}
