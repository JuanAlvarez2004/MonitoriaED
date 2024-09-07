package Clase5;

public class NodoCircular {
    int valor;
    NodoCircular siguiente;
    NodoCircular anterior;

    public NodoCircular(int valor) {
        this.valor = valor;
        this.siguiente = this;
        this.anterior = this;
    }
}
