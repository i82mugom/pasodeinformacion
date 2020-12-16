package com.manuelmurillo.pasodeinformacion;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class act1 extends AppCompatActivity {
    TextView titulo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_act1);
        titulo = (TextView)findViewById(R.id.textViewtitulo);


    }

    public void funcioncerrarydevolver(View view) {
        Intent devolverdatos = new Intent(this, MainActivity.class);
        devolverdatos.putExtra("claveelemento1", 3);
        setResult(RESULT_OK, devolverdatos);
        finish();

    }

    public void funcioncerrarynodevolver(View view) {
        Intent devolverdatos = new Intent(this, MainActivity.class);
        setResult(RESULT_CANCELED, devolverdatos);
        finish();

    }
}
