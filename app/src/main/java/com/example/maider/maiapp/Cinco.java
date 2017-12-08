package com.example.maider.maiapp;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.text.method.ScrollingMovementMethod;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

import me.anwarshahriar.calligrapher.Calligrapher;


public class Cinco extends Fragment {
    private static final String TAG = "FragmentCinco";
    TextView scrollable;
    private EditText rp1, rp2;
    private Button btnAceptar;

    @SuppressLint("ResourceAsColor")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_cinco, container, false);
        String font_path = "font/Londrina.ttf";
        Typeface font = Typeface.createFromAsset(getActivity().getAssets(), font_path);
        TextView title = (TextView)view.findViewById(R.id.txtAcertijo1);
        title.setText(R.string.acertijo1);
        scrollable = (TextView) view.findViewById(R.id.txtAcertijo1);
        scrollable.setMovementMethod(new ScrollingMovementMethod());
        title.setTypeface(font);
        rp1 = (EditText)view.findViewById(R.id.primera);
        rp2 = (EditText)view.findViewById(R.id.segunda);
        btnAceptar = (Button) view.findViewById(R.id.btnAceptar);
        Calligrapher cali = new Calligrapher(getActivity());
        cali.setFont(getActivity(),"font/Londrina.ttf",true);
        //Mostramos el dialog para ver si ha acertado o no
        btnAceptar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String r1 = rp1.getText().toString().toUpperCase();
                String r2 = rp2.getText().toString().toUpperCase();
                String resp = getString(R.string.acertijoRespuesta1);
                String ellos = ""+r1+"-"+r2+"";
                if(resp.equals(ellos)){
                    SacarMensajeExito();
                    //btnAceptar.setVisibility(View.GONE);
                    //final ImageButton nxt = (ImageButton)view.findViewById(R.id.intro_btn_next);
                    //nxt.setVisibility(View.VISIBLE);
                }else{
                    SacarMensajeError();
                }
            }
        });

        return view;
    }
    public void SacarMensajeExito(){
        AlertDialog.Builder builder = new AlertDialog.Builder(Cinco.super.getActivity());
        View view = LayoutInflater.from(Cinco.super.getActivity()).inflate(R.layout.custom_layout, null);
        TextView title = (TextView) view.findViewById(R.id.title);
        TextView cuerpo = (TextView) view.findViewById(R.id.cuerpo);
        title.setText("Has acertado!");
        cuerpo.setText(R.string.respuesta1);

        //EL TOAST MEJOR SI LO QUITAMOS YO CREO
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(Cinco.super.getActivity(), "Has acertado", Toast.LENGTH_SHORT).show();
            }
        });
        builder.setView(view);
        builder.show();
    }
    public void SacarMensajeError(){
        AlertDialog.Builder builder = new AlertDialog.Builder(Cinco.super.getActivity());
        View view = LayoutInflater.from(Cinco.super.getActivity()).inflate(R.layout.custom_layout, null);
        TextView title = (TextView) view.findViewById(R.id.title);
        TextView cuerpo = (TextView) view.findViewById(R.id.cuerpo);
        title.setText("Error");
        cuerpo.setText("Has fallado, vuelve a intentarlo");

        //EL TOAST MEJOR SI LO QUITAMOS
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(Cinco.super.getActivity(), "Has fallado", Toast.LENGTH_SHORT).show();
            }
        });
        builder.setView(view);
        builder.show();
    }

    public void EscribirFichero(){
        try
        {
            OutputStreamWriter fout=
                    new OutputStreamWriter(
                            getActivity().openFileOutput("Posicion_Jugador.txt", Context.MODE_PRIVATE));

            //fout.write(txtNombre.getText().toString());
            Toast.makeText(Cinco.super.getActivity(), "Escritura correcta", Toast.LENGTH_SHORT).show();
            fout.close();
        }
        catch (Exception ex)
        {
            Log.e("Ficheros", "Error al escribir fichero a memoria interna");
        }
    }

    public void LeerFichero(){
        try
        {
            BufferedReader fin =
                    new BufferedReader(
                            new InputStreamReader(
                                    getActivity().openFileInput("Posicion_Jugador.txt")));

            String texto = fin.readLine();
            //txtNombre.setText(texto);
            Toast.makeText(Cinco.super.getActivity(), "Lectura correcta", Toast.LENGTH_SHORT).show();
            fin.close();
        }
        catch (Exception ex)
        {
            Log.e("Ficheros", "Error al leer fichero desde memoria interna");
        }
    }



}
