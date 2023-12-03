package com.example.proto;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Bienvenida extends AppCompatActivity {

    //Crea e inicia la interfaz que vera el usuario
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bienvenida);
    }

    //Al hacer clic en el botón pasa a la otra actividad
    public void Continue(View view) {
        Intent intent = new Intent(view.getContext(), Datos.class);
        view.getContext().startActivity(intent);
    }
}