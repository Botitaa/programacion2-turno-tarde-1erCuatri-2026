package Bloque2_colas.Implementacion;

import Bloque2_colas.Interfaces.ColaTDA;

public class ImplementacionCola implements ColaTDA {

    private static final int MAX = 100;
    private int[] datos;
    private int cantidad;

    @Override
    public void InicializarCola() {
        datos = new int[MAX];
        cantidad = 0;
    }

    @Override
    public void Acolar(int x) {
        datos[cantidad] = x;
        cantidad ++;
    }

    @Override
    public void Desacolar() {

        if (!ColaVacias()){
            for (int i = 0; i<cantidad-1; i++) {
                datos[i] = datos[i+1];
            }
            cantidad --;
        }

    }

    @Override
    public int Primero() {
        return datos[0];
    }

    @Override
    public boolean ColaVacias() {
        return cantidad == 0;
    }
}
