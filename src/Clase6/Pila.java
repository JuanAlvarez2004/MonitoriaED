package Clase6;

import java.util.Scanner;

public class Pila {
    private Nodo top;
    private Nodo bottom;
    private int length;

    public Pila() {
        this.top = null;
        this.bottom = null;
        this.length = 0;
    }

    // Ingresar dato
    public void push(String valor) {
        Nodo nuevoNodo = new Nodo(valor);

        if (bottom != null) {
            nuevoNodo.siguiente = top;
            top = nuevoNodo;
            length++;
            return;
        }
        bottom = nuevoNodo;
        top = nuevoNodo;
        length++;
    }

    // Eliminar el último elemento
    public void pop() {
        if (bottom == null) {
            System.out.println("La pila está vacía");
            return;
        }

        if (top.siguiente != null) { // Si hay nodos
            top = top.siguiente;
            length--;
        } else { // Si solo hay un nodo
            top = null;
            bottom = null;
            length = 0;
        }

    }

    // Mostrar el último elemento
    public Nodo peek() {
        return top;
    }

    public void leerPila() {
        Nodo nodoActual = top;
        System.out.println("TOP -> ");
        while (nodoActual != null) {
            System.out.println(nodoActual.valor);
            nodoActual = nodoActual.siguiente;
        }
        System.out.print("-> BOTTOM");
    }

    public void verificarEcuacion(Pila pila) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Ingrese una ecuación matemática con paréntesis: ");
        String ecuacion = sc.nextLine();

        for (char caracter : ecuacion.toCharArray()) {
            if (caracter == '(') {
                pila.push("(");
            } else if (caracter == ')') {
                if (pila.length == 0) {
                    System.out.println("Ecuación desbalanceada");
                    return;
                }
                pila.pop();
            }
        }

        if (pila.length == 0) {
            System.out.println("Ecuación balanceada");
        } else {
            System.out.println("Ecuacion desbalanceada");
        }
    }

    public void reiniciarPila() {
        while (top != null) {
            pop();
            top = top.siguiente;
        }
    }

    public void revertirFrase(Pila pila) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Ingrese una oración para revertirla frase: ");
        String frase = sc.nextLine();
        String[] palabras = frase.split(" ");

        for (String p: palabras) {
            pila.push(p);
        }

        Nodo n = pila.peek();
        System.out.println("La última palabra es: " + n.valor);

        System.out.println("Frase invertida: ");
        while (pila.length != 0) {
            n = pila.peek();
            System.out.print(n.valor + " ");
            pila.pop();
        }
    }

    public static void main(String[] args) {
        Pila pila = new Pila();
        System.out.println("\nEJERCICIO 1");
        pila.verificarEcuacion(pila);
        System.out.println("\n-------------------------------");
        System.out.println("EJERCICIO 2");
        pila.reiniciarPila();
        pila.revertirFrase(pila);


        /*String[] elementos = {"H","(",")","f","R"};
        for (String e : elementos) {
            pila.push(e);
        }
        pila.push("fdfdsf");
        pila.leerPila();

        System.out.println("\n-------------------------------");
        System.out.println("HACER POP");
        pila.pop();
        pila.leerPila();

        System.out.println("\n-------------------------------");
        System.out.println("HACER PEEK");
        Nodo n = pila.peek();
        System.out.println(n.valor);
         */
    }
}
