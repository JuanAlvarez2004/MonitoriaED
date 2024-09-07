package Clase5;

public class ListaCircular{
    private NodoCircular cabeza;

    public ListaCircular() {
        this.cabeza = null;
    }

    public void leerLista() {
        if (cabeza == null) {
            System.out.println("La lista está vacía");
            return;
        }

        NodoCircular nodoActual = cabeza;
        int i = 1;

        do {
            System.out.print("Nodo" + "(" + i + "):" + nodoActual.valor + "; ");
            nodoActual = nodoActual.siguiente;
            i++;
        } while (nodoActual != cabeza);
    }

    public void insetarInicio(int valor) {
        NodoCircular nuevoNodo = new NodoCircular(valor);
        if (cabeza != null) {
            nuevoNodo.siguiente = cabeza;
            nuevoNodo.anterior = cabeza.anterior;
            cabeza.anterior.siguiente = nuevoNodo;
            cabeza.anterior = nuevoNodo;
        }
        cabeza = nuevoNodo;
    }


    //Ejercicio 2.1
    public void insertarNodoPosicion(int valor, int posicion) {
        NodoCircular nodoActual = cabeza;
        NodoCircular nuevoNodo = new NodoCircular(valor);

        if (posicion == 1) {
            insetarInicio(valor);
            return;
        }

        int i = 1;
        do {
            nodoActual = nodoActual.siguiente;
            i++;
        } while(nodoActual != cabeza && i < posicion);
        //i saldría con el valor del tamaño de la lista

        if (i < posicion) { //si el tamaño de la lista es menor a la posición, quiere decir que la posición esta por fuera del tamaño
            System.out.println("Posición fuera de rango");
            return;
        }

        nuevoNodo.siguiente = nodoActual.siguiente;
        nuevoNodo.anterior = nodoActual;
        nodoActual.siguiente.anterior = nuevoNodo;
        nodoActual.siguiente = nuevoNodo;
    }

    //Ejercicio 2.2
    public boolean eliminarNodo(int valor) {
        if (cabeza == null) {
            return false; // Lista vacía
        }
        NodoCircular nodoActual = cabeza;
        do {
            if (nodoActual.valor == valor) {
                //Si es el único nodo en la lista
                if (nodoActual.siguiente == cabeza && nodoActual.anterior == cabeza) {
                    cabeza = null;
                } else {
                    if (nodoActual == cabeza) {// Si el nodo es la cabeza
                        cabeza = nodoActual.siguiente;
                    }
                    nodoActual.anterior.siguiente = nodoActual.siguiente;
                    nodoActual.siguiente.anterior = nodoActual.anterior;
                }
                return true;
            }

            nodoActual = nodoActual.siguiente;
        } while (nodoActual != cabeza);

        return false;
    }

    //Ejercicio 3
    public void leerPorVueltas(int numVueltas) {
        NodoCircular nodoActual = cabeza;
        int vueltas = 0;
        int indiceNodo = 1;

        while (vueltas < numVueltas) {
            System.out.print("Nodo" + "(" + indiceNodo + "):" + nodoActual.valor + "; ");
            nodoActual = nodoActual.siguiente;
            indiceNodo++;

            if (nodoActual == cabeza) {
                vueltas++;
                indiceNodo = 1;
                System.out.println();
            }
        }
    }


    public static void main(String[] args) {
        ListaCircular lista = new ListaCircular();
        int[] elementos = {17, 32, 22, 33, 99};

        System.out.println("\nInsertar los siguientes elementos al inicio:");
        for (int elemento : elementos) {
            System.out.print(elemento + "; ");
            lista.insetarInicio(elemento);
        }
        System.out.println("Resultado: ");
        lista.leerLista();

        System.out.println("\n---------------------------------------------");
        System.out.println("\nInsertar el valor 1 en la posición 1");
        lista.insertarNodoPosicion(1,1);
        System.out.println("Resultado: ");
        lista.leerLista();
        System.out.println("\nInsertar el valor 3 en la posición 3");
        lista.insertarNodoPosicion(3,3);
        System.out.println("Resultado: ");
        lista.leerLista();
        System.out.println("\nInsertar el valor 7 en la posición 7");
        lista.insertarNodoPosicion(7,7);
        System.out.println("Resultado: ");
        lista.leerLista();

        System.out.println("\n---------------------------------------------");
        System.out.println("\nEliminar el valor 1 (Primer elemento)");
        System.out.println("Resultado: " + lista.eliminarNodo(1));
        lista.leerLista();
        System.out.println("\nEliminar el valor 3 (Elemento intermedio)");
        System.out.println("Resultado: " + lista.eliminarNodo(3));
        lista.leerLista();
        System.out.println("\nEliminar el valor 7 (Ultimo elemento)");
        System.out.println("Resultado: " + lista.eliminarNodo(7));
        lista.leerLista();

        System.out.println("\n---------------------------------------------");
        System.out.println("\nListar nodos durante cierto número de vueltas (3 vueltas)");
        lista.leerPorVueltas(3);
    }

}
