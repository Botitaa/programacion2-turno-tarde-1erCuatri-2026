package Bloque2_colas.Implementacion;

import Bloque2_colas.Interfaces.ColaRankingTDA;

import java.util.Arrays;

public class ImplementacionColaRanking implements ColaRankingTDA {

    private static final int MAX = 100;
    private int[] prio;
    private int[] data;
    private int cantidad;


    @Override
    public void InicializarCola() {
        prio = new int[MAX];
        data = new int[MAX];
        cantidad = 0;
    }

    @Override
    public void AcolarPrioridad(int new_datos, int new_prioridad) {
        prio[cantidad] = new_prioridad;
        data[cantidad] = new_datos;
        cantidad ++;
    }

    @Override
    public void Desacolar() {

        if (!ColaVacias()) {
            for (int i = 0; i < cantidad - 1; i++) {
                data[i] = data[i + 1];
                prio[i] = prio[i + 1];
            }
            cantidad--;
        }


    }

    @Override
    public int Primero() {

        int maximo = -1;

        for (int i = 0; i <cantidad; i++) {
            if (prio[i] > maximo) {
                maximo = i;
            }
        }

        return data[maximo];
    }

    @Override
    public int Prioridad() {

        int maximo = -1;

        for (int i = 0; i <cantidad; i++) {
            if (prio[i] > maximo) {
                maximo = prio[i];
            }
        }

        return maximo;
    }

    @Override
    public boolean ColaVacias() {
        return cantidad == 0;
    }
}
