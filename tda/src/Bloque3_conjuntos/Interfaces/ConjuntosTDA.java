package Bloque3_conjuntos.Interfaces;

public interface ConjuntosTDA {

    void InicializarConjunto();
    void Agregar(int x);
    void Sacar(int x);
    boolean Pertence(int x);
    int Elegir();
    boolean ConjuntoVacio();

}
