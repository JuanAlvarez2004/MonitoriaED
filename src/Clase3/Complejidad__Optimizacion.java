package Clase3;

import java.util.Arrays;

public class Complejidad__Optimizacion {

    //PRÁCTICA 1

    public void printFirstElement(int[] arr) {
        if (arr.length > 0) { //O(1) [Temporal] O(1) [Espacial]
            System.out.println(arr[0]); //O(1) [Temporal] O(1) [Espacial]
        }
        //Complejidad constante O(1) tanto temporal como espacial
    }

    public void printAllElements(int[] arr) {
        for (int element : arr) { //O(n) [Temporal] O(1) [Espacial]
            System.out.println(element); //O(1) [Temporal] O(1) [Espacial]
        }
        //Complejidad lineal O(n) en términos de temporalidad
        //Complejidad constante O(1) en términos de espacio
    }

    public void printAllPairs(int[] arr) {
        for (int i = 0; i < arr.length; i++) { //O(n^2) [Temporal] O(1) [Espacial]
            for (int j = 0; j < arr.length; j++) {
                System.out.println(arr[i] + ", " + arr[j]); //O(1) [Temporal] O(1) [Espacial]
            }
        }
        //Complejidad cuadrática O(n^2) en términos de temporalidad
        //Complejidad constante O(1) en términos de espacio
    }

    public int binarySearch(int[] arr, int target) {
        int low = 0; //O(1) [Temporal] O(1) [Espacial]
        int high = arr.length - 1; //O(1) [Temporal] O(1) [Espacial]

        while (low <= high) { //O(n) [Temporal] O(1) [Espacial]
            int mid = (low + high) / 2; //O(1) [Temporal] O(1) [Espacial]
            if (arr[mid] == target) { //O(1) [Temporal] O(1) [Espacial]
                return mid; //O(1) [Temporal] O(1) [Espacial]
            } else if (arr[mid] < target) {
                low = mid + 1; //O(1) [Temporal] O(1) [Espacial]
            } else {
                high = mid - 1; //O(1) [Temporal] O(1) [Espacial]
            }
        }
        return -1; //O(1) [Temporal] O(1) [Espacial]

        //Complejidad lineal O(n) en términos de temporalidad
        //Complejidad constante O(1) en términos de espacio
    }

    public int fibonacci(int n) {
        if (n <= 1) { //O(1) [Temporal] O(1) [Espacial]
            return n; //O(1) [Temporal] O(1) [Espacial]
        } else {
            return fibonacci(n - 1) + fibonacci(n - 2); //O(1) [Temporal] O(1) [Espacial]
        }
        //Complejidad constante O(1) en términos de temporalidad
        //Complejidad constante O(1) en términos de espacio
    }

    public void sortAndPrint(int[] arr) {
        Arrays.sort(arr); // Complejidad O(n log n)
        for (int element : arr) { //O(n) [Temporal] O(1) [Espacial]
            System.out.println(element); //O(1) [Temporal] O(1) [Espacial]
        }
        //Complejidad lineal O(n) en términos de temporalidad
        //Complejidad constante O(1) en términos de espacio
    }

    //PRÁCTICA 2

    public boolean hasDuplicate(int[] arr) {
        for (int i = 0; i < arr.length; i++) { //O(n^2)
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] == arr[j]) { //O(1)
                    return true; //O(1)
                }
            }
        }
        return false; //O(1)
        //Complejidad cuadrática O(n^2)
    }

    public boolean hasDuplicatePlus(int[] arr) {
        Arrays.sort(arr); //O(n log n)
        for (int i = 0; i < arr.length-1; i++) { //O(n)
            if (arr[i] == arr[i+1]  ) { //O(1)
                return true; //O(1)
            }
        }
        return false; //O(1)
        //Complejidad casi lineal O(n log n)
    }


    public static void main(String[] args) {
        Complejidad__Optimizacion complejidad__optimizacion = new Complejidad__Optimizacion();
        int[] arr = {1,23,17,12,78,8,9,34,17};

        long tiempoInicio = System.nanoTime();
        boolean resultado = complejidad__optimizacion.hasDuplicate(arr);
        long tiempoFinal = System.nanoTime();
        long duracion = tiempoFinal - tiempoInicio;

        long tiempoInicio1 = System.nanoTime();
        boolean resultado1 = complejidad__optimizacion.hasDuplicatePlus(arr);
        long tiempoFinal1 = System.nanoTime();
        long duracion1 = tiempoFinal1 - tiempoInicio1;

        String mensaje = "A pesar de ser un poco mas rápido el original, " +
                "la complejidad del nuevo es mas baja y por tal mas óptimo";

        System.out.println("Resultado: " + resultado + "\nNormal -> " + duracion + " nanosegundos" +
                "\nResultado: " + resultado1 + "\nOptimizado -> " + duracion1 + " nanosegundos"+ "\n" + mensaje);
    }

}
