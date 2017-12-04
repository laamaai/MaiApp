package com.example.maider.maiapp;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.graphics.Typeface;
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


public class Cinco extends Fragment {
    private static final String TAG = "FragmentCinco";
    TextView scrollable;
    private EditText rp1, rp2;
    private Button btnAceptar;

    @SuppressLint("ResourceAsColor")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_cinco, container, false);
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

        //Mostramos el dialog para ver si ha acertado o no
        btnAceptar.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
               corregir(Cinco.super.getView());
            }
        });




        // Calligrapher cali = new Calligrapher(getActivity());
        // cali.setFont(getActivity(),"font/Londrina.ttf",true);
        return view;
    }

    public void corregir(View v){
        //coger los valores que nos han escrito.
        String r1 = rp1.getText().toString().toUpperCase();
        String r2 = rp2.getText().toString().toUpperCase();
        String resp = getString(R.string.acertijoRespuesta1);
        String ellos = "" +r1+"-"+r2;
    }

    public void SacarMensajeExito(){
        AlertDialog.Builder builder = new AlertDialog.Builder(Cinco.super.getActivity());

        View view = LayoutInflater.from(Cinco.super.getActivity()).inflate(R.layout.custom_layout, null);

        TextView title = (TextView) view.findViewById(R.id.title);
        ImageButton imageButton = (ImageButton) view.findViewById(R.id.image);

        title.setText("Hello There!");

        imageButton.setImageResource(R.drawable.iconmap);

        builder.setPositiveButton("Chii", new DialogInterface.OnClickListener() {
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
        ImageButton imageButton = (ImageButton) view.findViewById(R.id.image);

        title.setText("Hello There!");

        imageButton.setImageResource(R.drawable.iconmap);

        builder.setPositiveButton("Chii", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(Cinco.super.getActivity(), "Has fallado, vuelve a intentarlo", Toast.LENGTH_SHORT).show();
            }
        });

        builder.setView(view);
        builder.show();
    }



}
