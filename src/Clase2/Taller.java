package Clase2;

public class Taller {
    /*
    En cuanto a la complejidad ambos tienen una complejidad lineal.
    Los dos algoritmos a pesar de tener diferentes tipos de bucles arrojan prácticamente el mismo tiempo de ejecución,
    algunas veces un mismo algoritmo arroja un tiempo mayor o menor que el otro.
    Por tal razón, no existe un algoritmo mas óptimo que otro.
     */

    public int fibonacci(int n) {
        int numeroFibo = 1; //O(1)

        int anterior = 1; //O(1)
        int siguiente = 1; //O(1)
        if (n>1) { //O(1)
            for (int i = 0; i < n; i++) { //O(n)
                numeroFibo = anterior + siguiente; //O(1)
                siguiente = anterior; //O(1)
                anterior = numeroFibo; //O(1)
            }
        }
        return numeroFibo; //O(1)
        //Complejidad lineal O(n)
    }

    public int fibonacciOptimizado(int n) {
        int numeroFibo = 1; //O(1)

        int anterior = 1; //O(1)
        int siguiente = 1; //O(1)
        if (n>1) { //O(1)
            int contador = 0; //O(1)
            while (contador < n) { //O(n)
                numeroFibo = anterior + siguiente; //O(1)
                siguiente = anterior; //O(1)
                anterior = numeroFibo; //O(1)
                contador++; //O(1)
            }
        }
        return numeroFibo; //O(1)
        //Complejidad lineal O(n)
    }

    public void testFibo(int n) {
        long startTime = System.nanoTime();
        int resultado = fibonacci(n);
        long endTime = System.nanoTime();

        long duracion = endTime - startTime;

        System.out.println("Método básico");
        System.out.println("Fibonacci de " + n + " es " + resultado);
        System.out.println("El tiempo de ejecución fue de " + duracion + " nanosegundos");
    }

    public void testFiboOpti(int n) {
        long startTime = System.nanoTime();
        int resultado = fibonacciOptimizado(n);
        long endTime = System.nanoTime();

        long duracion = endTime - startTime;

        System.out.println("\nMétodo Optimizado");
        System.out.println("Fibonacci de " + n + " es " + resultado);
        System.out.println("El tiempo de ejecución fue de " + duracion + " nanosegundos");
    }

    public static void main(String[] args) {
        Taller taller = new Taller();
        int n = 18;
        taller.testFibo(n);
        taller.testFiboOpti(n);
    }
}
