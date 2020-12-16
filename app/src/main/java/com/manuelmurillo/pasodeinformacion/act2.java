package com.manuelmurillo.pasodeinformacion;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class act2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_act2);
    }

    public void funcioncerrarydevolver2(View view) {
        Intent devolverdatos = new Intent(this, MainActivity.class);
        devolverdatos.putExtra("claveelemento2", "Valor devuelto");
        setResult(RESULT_OK, devolverdatos);
        finish();
    }

    public void funcioncerrarynodevolver2(View view) {
        Intent devolverdatos = new Intent(this, MainActivity.class);
        setResult(RESULT_CANCELED, devolverdatos);
        finish();

    }
}
