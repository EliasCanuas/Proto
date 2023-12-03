package com.example.proto;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;


public class Activity_inicio extends AppCompatActivity {


    //Crea e inicia la interfaz que vera el usuario
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicio);
    }

    //Al hacer clic en el botón pasa a la otra actividad
    public void bienvenido(View view) {
        Intent intent = new Intent(view.getContext(), Bienvenida.class);
        view.getContext().startActivity(intent);
    }
}
