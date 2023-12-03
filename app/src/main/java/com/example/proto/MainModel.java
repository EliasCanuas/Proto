package com.example.proto;

// Representa el modelo de datos para cada elemento de la lista.
public class MainModel {

    // Propiedades de un elemento.
    String Dia, Tipo, IMG;

    // Constructor vacío requerido para Firebase.
    MainModel() {

    }

    // Constructor que inicializa un objeto MainModel con valores específicos.
    public MainModel(String dia, String tipo, String IMG) {
        Dia = dia;
        Tipo = tipo;
        this.IMG = IMG;
    }

    // Métodos de acceso (getters y setters) para cada propiedad.

    public String getDia() {
        return Dia;
    }

    public void setDia(String dia) {
        Dia = dia;
    }

    public String getTipo() {
        return Tipo;
    }

    public void setTipo(String tipo) {
        Tipo = tipo;
    }

    public String getIMG() {
        return IMG;
    }

    public void setIMG(String IMG) {
        this.IMG = IMG;
    }
}