package com.example.trabajo_practico;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class Formulario extends AppCompatActivity {
    //Declaracion de variables
    private EditText et1, et2;
    private Spinner spinner1, spinner2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formulario);

        //Casteo de variables para capturar lo que ingresa por los componentes
        et1 = (EditText)findViewById(R.id.txt_nombres);
        et2 = (EditText)findViewById(R.id.txt_apellidos);

        //casteo de spinner
        spinner1 = (Spinner)findViewById(R.id.spinner1);
        spinner2 = (Spinner)findViewById(R.id.spinner2);

        //vectores para spinners personalizados
        String[] grado_i = {"Secundaria completa", "Pre_Universitario", "Egresado"};
        String[] sexo = {"Masculino", "Femenino"};

        //personalizado de Spinners
        ArrayAdapter<String> adapter1 = new ArrayAdapter<String>(this, R.layout.spinner_item_grado, grado_i);
        spinner1.setAdapter(adapter1);
        ArrayAdapter <String> adapter2 = new ArrayAdapter<String>(this, R.layout.spinner_item_sexo, sexo);
        spinner2.setAdapter(adapter2);
    }

    //Metodo del boton Registro
    public void Registro(View view){
        et1.setText("");
        et2.setText("");
        Toast.makeText(this, "Alumno registrado", Toast.LENGTH_LONG).show();
    }

    //Metodo del boton Salir
    public void salir(View view){
        finish();
    }
}