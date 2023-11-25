package com.example.proto;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

public class Datos extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    private int pesoSeleccionadoIndex = -1;
    private int alturaSeleccionadaIndex = -1;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_datos);

        Spinner spinnerPeso = findViewById(R.id.Peso);
        ArrayAdapter<CharSequence> adapterPeso = ArrayAdapter.createFromResource(this, R.array.Peso, android.R.layout.simple_spinner_item);
        adapterPeso.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerPeso.setAdapter(adapterPeso);
        spinnerPeso.setOnItemSelectedListener(this);

        Spinner spinnerAltura = findViewById(R.id.Altura);
        ArrayAdapter<CharSequence> adapterAltura = ArrayAdapter.createFromResource(this, R.array.Altura, android.R.layout.simple_spinner_item);
        adapterAltura.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerAltura.setAdapter(adapterAltura);
        spinnerAltura.setOnItemSelectedListener(this);

        Button enviarButton = findViewById(R.id.Enviar);
        enviarButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Log.d("DatosActivity", "Índice Peso seleccionado: " + pesoSeleccionadoIndex);
                Log.d("DatosActivity", "Índice Altura seleccionado: " + alturaSeleccionadaIndex);

                if (pesoSeleccionadoIndex != -1 && alturaSeleccionadaIndex != -1 &&
                        pesoSeleccionadoIndex == alturaSeleccionadaIndex) {
                    Toast.makeText(getApplicationContext(), "Estás en un peso óptimo", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(getApplicationContext(), "HORA DE EJERCITARSE", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        if (adapterView.getId() == R.id.Peso) {
            pesoSeleccionadoIndex = i;
        } else if (adapterView.getId() == R.id.Altura) {
            alturaSeleccionadaIndex = i;
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {
    }

    public void ejercicio(View view){
        Intent intent = new Intent(view.getContext(), dia.class);
        view.getContext().startActivity(intent);
    }

}

