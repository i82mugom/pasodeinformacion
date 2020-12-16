package com.manuelmurillo.pasodeinformacion;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class edicion extends AppCompatActivity {
    TextView titulo;

    EditText etpoblacion;
    EditText etpeso;
    EditText etaltura;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edicion);

        titulo = (TextView)findViewById(R.id.textViewtitulo);

        Bundle informacion = getIntent().getExtras();
        String nuevonombre;
        int nuevoid;
        nuevonombre = informacion.getString("clavenombre");
        nuevoid = informacion.getInt("claveid");
        titulo.setText("Perfil de:"+nuevonombre+", "+nuevoid);

        etpoblacion = (EditText)findViewById(R.id.editTextPoblacion);
        etpeso = (EditText)findViewById(R.id.editTextpeso);
        etaltura = (EditText)findViewById(R.id.editTextAltura);


    }




    public void funcioncerraredicion(View view) {

        String poblacion;
        int peso, altura;

        poblacion = etpoblacion.getText().toString();
        peso = Integer.parseInt( etpeso.getText().toString());
        altura = Integer.parseInt(etaltura.getText().toString());

        Intent devolverdatos = new Intent(this, MainActivity.class);
        devolverdatos.putExtra("clavedevolverpoblacion", poblacion);
        devolverdatos.putExtra("clavedevolverpeso", peso);
        devolverdatos.putExtra("clavedevolveraltura", altura);
        Toast.makeText(this, "devuelto"+poblacion, Toast.LENGTH_SHORT).show();
        setResult(RESULT_OK,devolverdatos);

       finish();

    }


}
