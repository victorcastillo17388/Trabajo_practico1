package com.example.trabajo_practico;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

public class Tab2  extends Fragment {

    //Declaracion de variables locales
    EditText et1, et2;
    RadioButton sumar, restar, producto, dividir;
    TextView tv1;
    Button btnCalcular;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        //Declaracion del objeto vista que servira como puente de comiunicacion entre las actividades
        View vista;
        vista = inflater.inflate(R.layout.activity_mi_calculadora, container, false);

        //Casteo de Variables con metodo para capturar vistas(findViewById) con la variable vista(puente)
        et1 = (EditText) vista.findViewById(R.id.txt_numero1);
        et2 = (EditText) vista.findViewById(R.id.txt_numero2);
        tv1 = (TextView) vista.findViewById(R.id.txt_resultado);
        sumar = (RadioButton) vista.findViewById(R.id.sumar);
        restar = (RadioButton) vista.findViewById(R.id.resta);
        producto = (RadioButton) vista.findViewById(R.id.producto);
        dividir = (RadioButton) vista.findViewById(R.id.division);//Casteo de Variables con metodo para capturar vistas(findViewById)
        btnCalcular = (Button) vista.findViewById(R.id.button);

        //Evento que escucha el click en el Boton Calcular
        btnCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Variables obtenidas de las cajas de texto
                String valor1_String = et1.getText().toString();
                String valor2_String = et2.getText().toString();

                //Conversion de Variables obtenidas
                Double valor1_double = Double.parseDouble(valor1_String);
                Double valor2_double = Double.parseDouble(valor2_String);

                //estructura condicional segun operacion
                if (sumar.isChecked() == true) { // Operación Suma
                    Double suma = valor1_double + valor2_double;
                    String resultado = String.valueOf(suma);
                    tv1.setText(resultado);
                } else if (restar.isChecked() == true) { //Operación Resta
                    Double resta = valor1_double - valor2_double;
                    String resultado = String.valueOf(resta);
                    tv1.setText(resultado);
                } else if (producto.isChecked() == true) { //Operacion Multiplicación
                    Double multiplicar = valor1_double * valor2_double;
                    String resultado = String.valueOf(multiplicar);
                    tv1.setText(resultado);
                } else if (dividir.isChecked() == true) { //Operacion División
                    //condicion no divisible por 0
                    if (valor2_double != 0) {
                        Double division = valor1_double / valor2_double;
                        String resultado = String.valueOf(division);
                        tv1.setText(resultado);
                    } else {
                        //Toast para mostrar mensaje en la app
                        Toast.makeText(getContext(), "No se puede dividir entre cero", Toast.LENGTH_LONG).show();
                    }

                }
            }
        });
        return vista;
    }
}
