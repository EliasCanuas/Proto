package com.example.proto;

public class MainModel {

    String Dia,Tipo, IMG;

    MainModel(){

    }

    public MainModel(String dia, String tipo, String IMG) {
        Dia = dia;
        Tipo = tipo;
        this.IMG = IMG;
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

    public String getIMG() {
        return IMG;
    }

    public void setIMG(String IMG) {
        this.IMG = IMG;
    }
}
