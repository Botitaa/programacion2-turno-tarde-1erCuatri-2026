package Bloque1_pilas.Implementacion;

import Bloque1_pilas.Interfaces.PilaTDA;

public class Estrategia_1 implements PilaTDA {

    private static final int MAX = 100;
    private String[] datos;
    private int cantidad;


    @Override
    public void InicializarPila() {

        datos = new String[MAX];
        cantidad = 0;
    }

    @Override
    public void Apilar(String x) {
        if (cantidad < MAX){
        datos[cantidad] = x;
        cantidad++;
        }
    }

    @Override
    public void Desapilar() {
        cantidad --;
    }

    @Override
    public String Tope() {
        return datos[cantidad-1];
    }

    @Override
    public boolean PilaVacia() {
        return cantidad == 0;
    }
}
