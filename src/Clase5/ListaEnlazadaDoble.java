package Clase5;

public class ListaEnlazadaDoble {
    private NodoDoble cabeza;

    public ListaEnlazadaDoble() {
        this.cabeza = null;
    }

    public void leerLista() {
        NodoDoble nodoActual = cabeza;
        int i = 1;
        while (nodoActual != null) {
            System.out.print("Nodo" + "(" + i + "):" + nodoActual.valor + "; ");
            nodoActual = nodoActual.siguiente;
            i++;
        }
    }

    public void insertarInicio(int valor) {
        NodoDoble nuevoNodo = new NodoDoble(valor);
        if (cabeza != null) {
            nuevoNodo.siguiente = cabeza;
            cabeza.anterior = nuevoNodo;
        }
        cabeza = nuevoNodo;
    }

    //Ejercicio 1.1
    public boolean eliminarNodo(int valor) {
        NodoDoble nodoActual = cabeza;

        while (nodoActual != null) {
            if (nodoActual.valor == valor) {
                // Si no es el primer nodo
                if (nodoActual.anterior != null) {
                    nodoActual.anterior.siguiente = nodoActual.siguiente;
                    if (nodoActual.siguiente != null) {
                        nodoActual.siguiente.anterior = nodoActual.anterior;
                    }
                } else {
                    cabeza = nodoActual.siguiente; // Si es el primer nodo
                }

                return true; // Nodo encontrado y eliminado
            }
            nodoActual = nodoActual.siguiente; // Avanza al siguiente nodo
        }
        return false; // Nodo no encontrado
    }

    //Ejercicio 1.2
    public NodoDoble obtenerUltimoNodo() {
        NodoDoble nodoActual = cabeza;
        NodoDoble ultimoNodo = null;

        while (nodoActual != null) {
            ultimoNodo = nodoActual;
            nodoActual = nodoActual.siguiente;
        }
        return ultimoNodo;
    }

    public void leerListaAtras(NodoDoble ultimoNodo){
        while (ultimoNodo != null) {
            System.out.println("Nodo: " + ultimoNodo.valor + "; ");
            ultimoNodo = ultimoNodo.anterior;
        }
    }


    public static void main(String[] args) {
        ListaEnlazadaDoble lista = new ListaEnlazadaDoble();
        int[] elementos = {17, 32, 22, 6, 99};

        System.out.println("\nInsertar los siguientes elementos al inicio:");
        for (int elemento : elementos) {
            System.out.println(elemento);
            lista.insertarInicio(elemento);
        }
        System.out.println("Resultado: ");
        lista.leerLista();

        System.out.println("\n---------------------------------------------");
        System.out.println("\nElimiar el nodo con valor 32: ");
        System.out.println("Resultado: " + lista.eliminarNodo(32));
        lista.leerLista();

        System.out.println("\n---------------------------------------------");
        System.out.println("\nRecorrer la lista hacia atras: ");
        NodoDoble ultimoNodo = lista.obtenerUltimoNodo();
        lista.leerListaAtras(ultimoNodo);

    }



}
