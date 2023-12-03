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

// Aqui se para recopilan datos como edad, género, peso y altura.
public class Datos extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    // Variables para almacenar los índices seleccionados en los spinners de peso y altura.
    private int pesoSeleccionadoIndex = -1;
    private int alturaSeleccionadaIndex = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_datos);

        // Configuración del Spinner para la selección de edad.
        Spinner spinnerEdad = findViewById(R.id.Edad);
        ArrayAdapter<CharSequence> adapterEdad = ArrayAdapter.createFromResource(this, R.array.Edad, android.R.layout.simple_spinner_item);
        adapterEdad.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerEdad.setAdapter(adapterEdad);
        spinnerEdad.setOnItemSelectedListener(this);

        // Configuración del Spinner para la selección de género.
        Spinner spinnerGenero = findViewById(R.id.Genero);
        ArrayAdapter<CharSequence> adapterGenero = ArrayAdapter.createFromResource(this, R.array.Genero, android.R.layout.simple_spinner_item);
        adapterGenero.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerGenero.setAdapter(adapterGenero);
        spinnerGenero.setOnItemSelectedListener(this);

        // Configuración del Spinner para la selección de peso.
        Spinner spinnerPeso = findViewById(R.id.Peso);
        ArrayAdapter<CharSequence> adapterPeso = ArrayAdapter.createFromResource(this, R.array.Peso, android.R.layout.simple_spinner_item);
        adapterPeso.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerPeso.setAdapter(adapterPeso);
        spinnerPeso.setOnItemSelectedListener(this);

        // Configuración del Spinner para la selección de altura.
        Spinner spinnerAltura = findViewById(R.id.Altura);
        ArrayAdapter<CharSequence> adapterAltura = ArrayAdapter.createFromResource(this, R.array.Altura, android.R.layout.simple_spinner_item);
        adapterAltura.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerAltura.setAdapter(adapterAltura);
        spinnerAltura.setOnItemSelectedListener(this);

        // Configuración del botón de enviar.
        Button enviarButton = findViewById(R.id.Enviar);
        enviarButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Registro de información de índices seleccionados en los spinners de peso y altura.
                Log.d("DatosActivity", "Índice Peso seleccionado: " + pesoSeleccionadoIndex);
                Log.d("DatosActivity", "Índice Altura seleccionado: " + alturaSeleccionadaIndex);

                // Lógica para determinar el mensaje y la actividad a iniciar en función de lo que se selecciono.
                if (pesoSeleccionadoIndex != -1 && alturaSeleccionadaIndex != -1 && pesoSeleccionadoIndex == alturaSeleccionadaIndex) {
                    // Mensaje y actividad sugeridos para un peso óptimo.
                    Toast.makeText(getApplicationContext(), "Estás en un peso óptimo, se sugiere aumentar tu masa muscular", Toast.LENGTH_LONG).show();
                    Intent intent = new Intent(Datos.this, masa.class);
                    startActivity(intent);
                } else {
                    // Mensaje y actividad sugeridos para un peso no óptimo.
                    Toast.makeText(getApplicationContext(), "No estás en buen peso, se sugiere ejercicio de cardio", Toast.LENGTH_LONG).show();
                    Intent intent = new Intent(Datos.this, dia.class);
                    startActivity(intent);
                }
            }
        });
    }

    // Método llamado cuando se selecciona un elemento en un Spinner.
    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        // Almacena el dato seleccionado en las variables correspondientes.
        if (adapterView.getId() == R.id.Peso) {
            pesoSeleccionadoIndex = i;
        } else if (adapterView.getId() == R.id.Altura) {
            alturaSeleccionadaIndex = i;
        }
    }

    // Método llamado cuando no se ha seleccionado ningún elemento en un Spinner.
    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {
    }
}
