package com.example.maider.maiapp;

import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.method.ScrollingMovementMethod;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.MediaController;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.VideoView;

import me.anwarshahriar.calligrapher.Calligrapher;

import static android.content.pm.ActivityInfo.SCREEN_ORIENTATION_PORTRAIT;


public class Tres extends Fragment {
    private static final String TAG = "FragmentTres";
    TextView scrollable;
    private VideoView videoView;
    private int position = 0;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        //Poner la pantalla de forma vertical
        getActivity().setRequestedOrientation(SCREEN_ORIENTATION_PORTRAIT);

        View view = inflater.inflate(R.layout.fragment_tres, container, false);
        Calligrapher cali = new Calligrapher(getActivity());
        cali.setFont(getActivity(),"font/Londrina.ttf",true);

        setUpVideoView(view);

        return view;
    }


    private void setUpVideoView(View v){
        String uriPath = "android.resource://" + getActivity().getPackageName()
                + "/" + R.raw.video1;
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
                    mediaPlayer.setLooping(true);
                    if (position == 0) {
                        videoView.start();
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
/*
    @Override
    public void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        /*
         * Usamos onRestoreInstanceState para reproducir el vídeo
         * desde la posición guardada.
         */
       /* position = savedInstanceState.getInt("Position");
        videoView.seekTo(position);
    }

*/






}
