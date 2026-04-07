package Bloque2_colas.Interfaces;

public interface ColaRankingTDA {
    void InicializarCola();
    void AcolarPrioridad(int dato,int prioridad);
    void Desacolar();
    int Primero();
    int Prioridad();
    boolean ColaVacias();
}
