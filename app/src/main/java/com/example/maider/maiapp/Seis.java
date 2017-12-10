package com.example.maider.maiapp;

import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.text.method.ScrollingMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import me.anwarshahriar.calligrapher.Calligrapher;

import static android.content.pm.ActivityInfo.SCREEN_ORIENTATION_PORTRAIT;


public class Seis extends Fragment {
    private static final String TAG = "FragmentSeis";
    TextView scrollable;
    private Button btnAceptar;
    TextView t1, t2, t3, t4, t5, t6, t7, t8, t9;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        //Poner la pantalla de forma vertical
        getActivity().setRequestedOrientation(SCREEN_ORIENTATION_PORTRAIT);

        final View view = inflater.inflate(R.layout.fragment_seis, container, false);
        String font_path = "font/Londrina.ttf";
        Typeface font = Typeface.createFromAsset(getActivity().getAssets(), font_path);

        TextView title = (TextView)view.findViewById(R.id.txtAcertijo2);
        title.setText(R.string.acertijo2);
        scrollable = (TextView) view.findViewById(R.id.txtAcertijo2);
        scrollable.setMovementMethod(new ScrollingMovementMethod());
        title.setTypeface(font);
        btnAceptar = (Button) view.findViewById(R.id.btnAceptar);
        Calligrapher cali = new Calligrapher(getActivity());
        cali.setFont(getActivity(),"font/Londrina.ttf",true);




        t1 = (TextView)view.findViewById(R.id.n1);
        t2 = (TextView)view.findViewById(R.id.n2);
        t3 = (TextView)view.findViewById(R.id.n3);
        t4 = (TextView)view.findViewById(R.id.n4);
        t5 = (TextView)view.findViewById(R.id.n5);
        t6 = (TextView)view.findViewById(R.id.n6);
        t7 = (TextView)view.findViewById(R.id.n7);
        t8 = (TextView)view.findViewById(R.id.n8);
        t9 = (TextView)view.findViewById(R.id.n9);

        btnAceptar = (Button) view.findViewById(R.id.btnAceptar);
        btnAceptar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String r1 = t1.getText().toString().toUpperCase();
                String r2 = t2.getText().toString().toUpperCase();
                String r3 = t3.getText().toString().toUpperCase();
                String r4 = t4.getText().toString().toUpperCase();
                String r5 = t5.getText().toString().toUpperCase();
                String r6 = t6.getText().toString().toUpperCase();
                String r7 = t7.getText().toString().toUpperCase();
                String r8 = t8.getText().toString().toUpperCase();
                String r9 = t9.getText().toString().toUpperCase();
                String resp = getString(R.string.acertijoRespuesta2);
                String ellos = ""+r1+""+r2+""+r3+""+r4+""+r5+""+r6+""+r7+""+r8+""+r9;
                if(resp.equals(ellos)){
                    SacarMensajeExito();
                    btnAceptar.setVisibility(View.GONE);
                    final ImageButton nxt = (ImageButton)view.findViewById(R.id.intro_btn_next);
                    nxt.setVisibility(View.VISIBLE);
                }else{
                    SacarMensajeError();
                    t1.setText("");
                    t2.setText("");
                    t3.setText("");
                    t4.setText("");
                    t5.setText("");
                    t6.setText("");
                    t7.setText("");
                    t8.setText("");
                    t9.setText("");
                }
            }
        });
        return view;
    }

    public void SacarMensajeExito(){
        AlertDialog.Builder builder = new AlertDialog.Builder(Seis.super.getActivity());
        View view = LayoutInflater.from(Seis.super.getActivity()).inflate(R.layout.custom_layout, null);
        TextView title = (TextView) view.findViewById(R.id.title);
        TextView cuerpo = (TextView) view.findViewById(R.id.cuerpo);
        title.setText("Has acertado!");
        cuerpo.setText(R.string.respuesta2);
        //EL TOAST MEJOR SI LO QUITAMOS YO CREO
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(Seis.super.getActivity(), "Has acertado", Toast.LENGTH_SHORT).show();
            }
        });
        builder.setView(view);
        builder.show();
    }
    public void SacarMensajeError(){
        AlertDialog.Builder builder = new AlertDialog.Builder(Seis.super.getActivity());
        View view = LayoutInflater.from(Seis.super.getActivity()).inflate(R.layout.custom_layout, null);
        TextView title = (TextView) view.findViewById(R.id.title);
        TextView cuerpo = (TextView) view.findViewById(R.id.cuerpo);
        title.setText("Error");
        cuerpo.setText("Has fallado, vuelve a intentarlo");

        //EL TOAST MEJOR SI LO QUITAMOS
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(Seis.super.getActivity(), "Has fallado", Toast.LENGTH_SHORT).show();
            }
        });
        builder.setView(view);
        builder.show();
    }
}
