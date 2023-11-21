package com.example.proto;

public class MainModel {

    String Dia,Tipo;

    MainModel(){

    }
    public MainModel(String dia, String tipo) {
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
