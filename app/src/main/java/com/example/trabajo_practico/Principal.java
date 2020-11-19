package com.example.trabajo_practico;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Principal extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);
    }

    public void calculadora(View view){
        startActivity(new Intent(this, MiCalculadora.class));
    }

    public void formulario(View view){
        startActivity(new Intent(this, Formulario.class));
    }
}