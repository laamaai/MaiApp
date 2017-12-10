package com.example.maider.maiapp;

import android.content.Context;
import android.content.DialogInterface;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import static android.content.pm.ActivityInfo.SCREEN_ORIENTATION_PORTRAIT;


public class Nueve extends Fragment {
    private static final String TAG = "FragmentNueve";
    TextView scrollable;
    private EditText rp1, rp2;
    private Button btnAceptar;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        //Poner la pantalla de forma vertical
        getActivity().setRequestedOrientation(SCREEN_ORIENTATION_PORTRAIT);

        View view = inflater.inflate(R.layout.fragment_nueve, container, false);

        btnAceptar = (Button) view.findViewById(R.id.btnAceptar);

       /* btnAceptar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //String r1 = rp1.getText().toString().toUpperCase();
                //String r2 = rp2.getText().toString().toUpperCase();
                String resp = getString(R.string.acertijoRespuesta4);
                //String ellos = ""+r1+"-"+r2+"";
                if(resp.equals(ellos)){
                    SacarMensajeExito();

                }else{
                    SacarMensajeError();
                }
            }
        });*/
        return view;
    }







  /*  public void SacarMensajeExito(){
        AlertDialog.Builder builder = new AlertDialog.Builder(Ocho.super.getActivity());
        View view = LayoutInflater.from(Ocho.super.getActivity()).inflate(R.layout.custom_layout, null);
        TextView title = (TextView) view.findViewById(R.id.title);
        TextView cuerpo = (TextView) view.findViewById(R.id.cuerpo);
        title.setText("Has acertado!");
        cuerpo.setText(R.string.respuesta4);
        //EL TOAST MEJOR SI LO QUITAMOS YO CREO
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(Ocho.super.getActivity(), "Has acertado", Toast.LENGTH_SHORT).show();
            }
        });
        builder.setView(view);
        builder.show();
    }
    public void SacarMensajeError(){
        AlertDialog.Builder builder = new AlertDialog.Builder(Ocho.super.getActivity());
        View view = LayoutInflater.from(Ocho.super.getActivity()).inflate(R.layout.custom_layout, null);
        TextView title = (TextView) view.findViewById(R.id.title);
        TextView cuerpo = (TextView) view.findViewById(R.id.cuerpo);
        title.setText("Error");
        cuerpo.setText("Has fallado, vuelve a intentarlo");

        //EL TOAST MEJOR SI LO QUITAMOS
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(Ocho.super.getActivity(), "Has fallado", Toast.LENGTH_SHORT).show();
            }
        });
        builder.setView(view);
        builder.show();
    }*/
}
