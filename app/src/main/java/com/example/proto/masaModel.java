package com.example.proto;

public class masaModel {

    String Dia,Tipo;

    masaModel(){

    }

    public masaModel(String dia, String tipo) {
        Dia = dia;
        Tipo = tipo;
    }

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
}
