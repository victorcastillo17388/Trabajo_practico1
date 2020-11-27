package com.example.trabajo_practico;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

public class Tab3  extends Fragment {

    EditText et1, et2;
    Spinner spinner1, spinner2;
    Button btnRegistro, btnSalir;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        //Declaracion del objeto vista que servira como puente de comiunicacion entre las actividades
        View vista;
        vista = inflater.inflate(R.layout.activity_formulario, container, false);

        //Casteo de Variables con metodo para capturar vistas(findViewById) con la variable vista(puente)
        et1 = (EditText) vista.findViewById(R.id.txt_nombres);
        et2 = (EditText) vista.findViewById(R.id.txt_apellidos);

        //casteo de spinner
        spinner1 = (Spinner) vista.findViewById(R.id.spinner1);
        spinner2 = (Spinner) vista.findViewById(R.id.spinner2);

        //vectores para spinners personalizados
        String[] grado_i = {"Secundaria completa", "Pre_Universitario", "Egresado"};
        String[] sexo = {"Masculino", "Femenino"};

        //personalizado de Spinners
        ArrayAdapter<String> adapter1 = new ArrayAdapter<String>(getContext(), R.layout.spinner_item_grado, grado_i);
        spinner1.setAdapter(adapter1);
        ArrayAdapter <String> adapter2 = new ArrayAdapter<String>(getContext(), R.layout.spinner_item_sexo, sexo);
        spinner2.setAdapter(adapter2);

        btnRegistro = (Button) vista.findViewById(R.id.btn_registro);
        btnSalir = (Button) vista.findViewById(R.id.btn_salir);

        btnRegistro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                et1.setText("");
                et2.setText("");
                Toast.makeText(getContext(), "Alumno registrado", Toast.LENGTH_LONG).show();
            }
        });

        btnSalir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getContext(), Tab1.class));
            }
        });

        return vista;
    }
}
