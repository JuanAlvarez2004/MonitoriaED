package Clase8;

public class ArbolBinario {
    Nodo raiz;

    public ArbolBinario() {
        this.raiz = null;
    }

    /*public void insertar(int valor) {
        Nodo nuevoNodo = new Nodo(valor);

        if (this.raiz == null) {
            this.raiz = nuevoNodo;
        } else {
            Nodo nodoActual = this.raiz;

            while (true) {
                if (valor < nodoActual.valor) { //Reviso la izquierda
                    if (nodoActual.izquierda == null) {
                        nodoActual.izquierda = nuevoNodo;
                        return;
                    }
                    nodoActual = nodoActual.izquierda;
                } else { //Reviso la derecha
                    if (nodoActual.derecha == null) {
                        nodoActual.derecha = nuevoNodo;
                        return;
                    }
                    nodoActual = nodoActual.derecha;
                }
            }
        }
    }
     */

    public boolean buscar(int valor) {
        if (this.raiz == null) {
            System.out.println("No existe árbol");
            return false;
        }

        Nodo nodoActual = this.raiz;

        while (nodoActual != null) {
            if (valor == nodoActual.valor) {
                return true;
            } else if (valor < nodoActual.valor) { // Buscar en el subárbol izquierdo
                nodoActual = nodoActual.izquierda;
            } else { // Buscar en el subárbol derecho
                nodoActual = nodoActual.derecha;
            }
        }

        return false;
    }


    public void eliminar(int valor) {
        raiz = eliminarRec(raiz, valor);
    }

    public Nodo eliminarRec(Nodo nodo, int valor) {
        // Caso base: si el nodo es null, no hay nada que eliminar
        if (nodo == null) {
            return null;
        }

        // Buscar el nodo a eliminar
        if (valor < nodo.valor) {
            nodo.izquierda = eliminarRec(nodo.izquierda, valor);
        } else if (valor > nodo.valor) {
            nodo.derecha = eliminarRec(nodo.derecha, valor);
        } else {
            // Encontramos el nodo a eliminar

            // Caso 1: Nodo hoja (sin hijos)
            if (nodo.izquierda == null && nodo.derecha == null) {
                return null;
            }

            // Caso 2: Nodo con solo hijo derecho
            if (nodo.izquierda == null) {
                return nodo.derecha;
            }

            // Caso 3: Nodo con solo hijo izquierdo
            if (nodo.derecha == null) {
                return nodo.izquierda;
            }

            // Caso 4: Nodo con dos hijos
            // Encontrar el sucesor (el menor valor en el subárbol derecho)
            Nodo sucesor = encontrarMinimo(nodo.derecha);
            // Copiar el valor del sucesor al nodo actual
            nodo.valor = sucesor.valor;
            // Eliminar el sucesor del subárbol derecho
            nodo.derecha = eliminarRec(nodo.derecha, sucesor.valor);
        }

        return nodo;
    }

    public Nodo encontrarMinimo(Nodo nodo) {
        while (nodo.izquierda != null) {
            nodo = nodo.izquierda;
        }
        return nodo;
    }

    public Nodo darRaiz() {
        return raiz;
    }

    //Recorrer el árbol para mostrar resultados (I,R,D)
    public void inorden(Nodo raiz) {
        if (raiz != null) {
            inorden(raiz.izquierda);

            switch (raiz.valor) {
                case 11:
                    System.out.print("A" + ", ");
                    break;
                case 9:
                    System.out.print("B" + ", ");
                    break;
                case 12:
                    System.out.print("C" + ", ");
                    break;
                case 8:
                    System.out.print("D" + ", ");
                    break;
                case 10:
                    System.out.print("E" + ", ");
                    break;
                case 13:
                    System.out.print("F" + ", ");
                    break;
            }
            
            inorden(raiz.derecha);
        }
    }

    // Imprimir representación del árbol
    public void impArbol() {
        System.out.println("""
                    A
                   / \\
                  B   C
                 / \\   \\
                D   E   F""");
    }

    // Inicializar el árbol con valores iniciales
    public void iniArbol() {
        raiz = new Nodo(11); // A
        raiz.izquierda = new Nodo(9); // B
        raiz.derecha = new Nodo(12); // C
        raiz.izquierda.izquierda = new Nodo(8); // D
        raiz.izquierda.derecha = new Nodo(10); // E
        raiz.derecha.derecha = new Nodo(13); // F
    }

    /* public void reiniciar() {
        this.raiz = null;
        iniArbol();
    }
     */


    public static void main(String[] args) {
        ArbolBinario arbolito = new ArbolBinario();
        arbolito.impArbol();
        arbolito.iniArbol();
        System.out.println("Arbol en inorder: ");
        arbolito.inorden(arbolito.darRaiz());
        System.out.println("\n------------------------------------------");

        System.out.println("\nBuscar D");
        System.out.println("Resultado: " + arbolito.buscar(8));
        System.out.println("\nBuscar F");
        System.out.println("Resultado: " + arbolito.buscar(13));
        System.out.println("\nBuscar G");
        System.out.println("Resultado: " + arbolito.buscar(23));

        System.out.println("------------------------------------------");
        System.out.println("\nEliminar D");
        arbolito.eliminar(8);
        arbolito.inorden(arbolito.darRaiz());

        System.out.println("\nEliminar B");
        arbolito.eliminar(9);
        arbolito.inorden(arbolito.darRaiz());

        System.out.println("\nEliminar A");
        arbolito.eliminar(11);
        arbolito.inorden(arbolito.darRaiz());
    }

}
