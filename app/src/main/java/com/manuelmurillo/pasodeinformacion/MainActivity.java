package com.manuelmurillo.pasodeinformacion;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText editnombre;
    EditText editid;

    TextView tvpoblacion;
    TextView tvpeso;
    TextView tvaltura;

    String poblacion;
    int peso;
    int altura;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editnombre = (EditText)findViewById(R.id.editTextNombre);
        editid = (EditText)findViewById(R.id.editTextId);

        tvpoblacion = (TextView)findViewById(R.id.textViewPoblacion);
        tvpeso = (TextView)findViewById(R.id.textViewPeso);
        tvaltura = (TextView)findViewById(R.id.textViewAltura);
    }

    public void funcioneditarperfil(View view) {
        String nombre;
        int id;
        nombre = editnombre.getText().toString();
        id = Integer.parseInt(editid.getText().toString());


       Intent intentedicion = new Intent(this, edicion.class);
       intentedicion.putExtra("clavenombre", nombre);
       intentedicion.putExtra("claveid", id);
       startActivityForResult(intentedicion, 3);

    }



    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if( resultCode==RESULT_OK){


            if( requestCode==1){
                int numerodevuelto = 0;
                numerodevuelto= data.getIntExtra("claveelemento1", 0);
                Toast.makeText(this, "Devuelto correcto, act1: "+numerodevuelto, Toast.LENGTH_SHORT).show();
            }

            if( requestCode==2){
                String cadenadevuelta;
                cadenadevuelta= data.getStringExtra("claveelemento2");
                Toast.makeText(this, "Devuelto correcto, act2: "+cadenadevuelta, Toast.LENGTH_SHORT).show();
            }

            if( requestCode==3){
                poblacion = data.getStringExtra("clavedevolverpoblacion");
                peso = data.getIntExtra("clavedevolverpeso", 0);
                altura = data.getIntExtra("clavedevolveraltura",0);
                tvpoblacion.setText(  poblacion );
                tvpeso.setText( Integer.toString(peso));
                tvaltura.setText( Integer.toString(altura));
            }


        }
        else{
            Toast.makeText(this, "Devuelto no correcto", Toast.LENGTH_SHORT).show();
        }


    }

    public void funcionactivity1(View view) {
        Intent intentedicion = new Intent(this, act1.class);
        startActivityForResult(intentedicion, 1);
    }

    public void funcionactivity2(View view) {
        Intent intentedicion = new Intent(this, act2.class);
        startActivityForResult(intentedicion, 2);
    }
}
