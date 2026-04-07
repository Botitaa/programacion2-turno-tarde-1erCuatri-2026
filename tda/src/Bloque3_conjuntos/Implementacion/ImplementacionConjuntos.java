package Bloque3_conjuntos.Implementacion;

import Bloque3_conjuntos.Interfaces.ConjuntosTDA;

public class ImplementacionConjuntos implements ConjuntosTDA {

    private static final int MAX = 100;
    private int[] datos;
    private int cantidad;


    @Override
    public void InicializarConjunto() {
        datos = new int [MAX];
        cantidad = 0;

    }

    @Override
    public void Agregar(int x) {
       if (cantidad < MAX && !Pertence(x)){
           datos[cantidad] = x;
           cantidad ++;
       }
    }

    @Override
    public void Sacar(int x) {

        for (int i = 0; i < cantidad; i ++){
            if (datos[i] == x){
                datos[i] = datos[cantidad-1];
                cantidad--;
                return;
            }
        }
    }

    @Override
    public boolean Pertence(int x) {

        for (int i = 0; i<cantidad;i++){
            if (datos[i] == x)
                return true;
        }

        return false;
    }

    @Override
    public int Elegir() {
        return datos[0];
    }

    @Override
    public boolean ConjuntoVacio() {
        return cantidad == 0;
    }
}
