package com.example.maider.maiapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ScrollView;
import android.widget.TextView;

import me.anwarshahriar.calligrapher.Calligrapher;

public class presentacion2 extends AppCompatActivity {

    TextView scrollable;
    //Controlar que solo le tenga que dar una vez a atras para que pase a la pantalla anterior


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_presentacion2);

        Calligrapher cali = new Calligrapher(this);
        cali.setFont(this,"font/Londrina.ttf",true);

        scrollable = (TextView)findViewById(R.id.txtt);
        scrollable.setMovementMethod(new ScrollingMovementMethod());

        ImageButton btn = (ImageButton)findViewById(R.id.btnPlay);
        btn.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent intent = new Intent(presentacion2.this, Videos.class);
                startActivity(intent);
            }
        });

    }
}
