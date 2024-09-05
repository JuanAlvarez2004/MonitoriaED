package Clase4;

public class ListaEnlazadaSimple {
    private Nodo cabeza;

    // Constructor
    public ListaEnlazadaSimple() {
        this.cabeza = null;
    }

    //Ejercicio 1
    public void insertarInicio(int valor) {
        Nodo nuevoNodo = new Nodo(valor);
        nuevoNodo.siguiente = cabeza;
        cabeza = nuevoNodo;
    }

    public void leerLista() {
        Nodo nodoActual = cabeza;
        int i = 1;
        while (nodoActual != null) {
            System.out.print("\nNodo" + "(" + i + "):" + nodoActual.valor);
            nodoActual = nodoActual.siguiente;
            i++;
        }
        System.out.println("\nnull");
    }

    //Ejercicio 2
    public boolean eliminarNodo(int valor) {
        Nodo nodoActual = cabeza;
        Nodo nodoAnterior = null;

        while (nodoActual != null) {
            if (nodoActual.valor == valor) { //Verificar que el nodo exista
                if (nodoAnterior != null) {
                    nodoAnterior.siguiente = nodoActual.siguiente;
                } else {
                    cabeza = nodoActual.siguiente;
                }
                return true;
            }
            //Seguir recorriendo los nodos
            nodoAnterior = nodoActual;
            nodoActual = nodoActual.siguiente;
        }
        return false;
    }

    //Ejercicio 3
    public boolean buscarNodo(int valor) {
        Nodo nodoActual = cabeza;
        while (nodoActual != null) {
            if (nodoActual.valor == valor) {
                return true;
            }
            nodoActual = nodoActual.siguiente;
        }
        return false;
    }


    //Ejercicio 4
    public boolean insertarNodoPosicion(int valor, int posicion) {
        if (posicion < 0) { //Posición incorrecta
            return false;
        }
        if (posicion == 0) { //Primera posición
            insertarInicio(valor);
            return true;
        }

        Nodo nuevoNodo = new Nodo(valor);
        Nodo nodoActual = cabeza;
        int indice = 0;
        //Encontrar el nodo actual que esta ocupando la posición requerida
        while (nodoActual != null && indice < posicion - 1) {
            nodoActual = nodoActual.siguiente;
            indice++;
        }
        if (nodoActual == null) {
            return false; // Posición fuera del rango
        }
        nuevoNodo.siguiente = nodoActual.siguiente;
        nodoActual.siguiente = nuevoNodo;
        return true;
    }


    public static void main(String[] args) {
        ListaEnlazadaSimple lista = new ListaEnlazadaSimple();
        int[] elementos = {17, 32, 22, 6, 99};


        System.out.println("\nInsertar los siguientes elementos al inicio:");
        for (int elemento : elementos) {
            System.out.println(elemento);
            lista.insertarInicio(elemento);
        }
        System.out.println("Lista con los elementos insertados:");
        lista.leerLista();
        System.out.println("------------------------------------------");

        System.out.println("\nSe va a eliminar el número 22 de la lista enlazada:");
        System.out.println("Resultado: " + lista.eliminarNodo(22));
        lista.leerLista();
        System.out.println("------------------------------------------");

        System.out.println("\nSe va a buscar el valor 6 y el 99:");
        System.out.println("Resultado al buscar el valor 6: " + lista.buscarNodo(6)); // Debe imprimir false
        System.out.println("Resultado al buscar el valor 99: " + lista.buscarNodo(99)); // Debe imprimir true
        System.out.println("------------------------------------------");

        System.out.println("\nInsertar en posiciones específicas");
        System.out.println("Se inserta el número 45 al inicio:");
        System.out.println("Resultado: "+ lista.insertarNodoPosicion(45, 0)); // Insertar al inicio
        lista.leerLista();
        System.out.println("------------------------------------------");
        System.out.println("Se inserta el número 98 en la posición 3:");
        System.out.println("Resultado: "+ lista.insertarNodoPosicion(98, 3)); // Insertar en la posición intermedia
        lista.leerLista();
        System.out.println("------------------------------------------");
        System.out.println("Se inserta el número 10 al final:");
        System.out.println("Resultado: "+ lista.insertarNodoPosicion(10, elementos.length+1)); // Intentar insertar fuera del rango actual
        lista.leerLista();
    }
}