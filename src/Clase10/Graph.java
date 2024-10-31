package Clase10;

import java.util.*;

/*
 * ACTIVIDAD 1
 */
public class Graph {
    // Mapa para almacenar la lista de adyacencia de cada vértice
    private Map<String, List<String>> adjList;

    // Constructor: Inicializa el mapa adjList como un HashMap vacío
    public Graph() {
        adjList = new HashMap<>();
    }

    /**
     * Añade una arista entre dos vértices en el grafo no dirigido.
     *
     * @param src  Vértice de origen
     * @param dest Vértice de destino
     */
    public void addEdge(String src, String dest) {
        // Si el vértice de origen no existe en el mapa, se añade con una lista vacía.
        // Luego se agrega el vértice de destino a la lista de adyacencia del origen.
        adjList.computeIfAbsent(src, k -> new ArrayList<>()).add(dest);

        // Como el grafo es no dirigido, se añade la arista en la dirección contraria:
        // Se asegura de que el vértice de destino tenga una lista y añade el origen.
        adjList.computeIfAbsent(dest, k -> new ArrayList<>()).add(src);
    }

    /*
     * ACTIVIDAD 2
     */
    public void addDirectedEdge(String src, String dest) {
        adjList.computeIfAbsent(src, k -> new ArrayList<>()).add(dest);
        // No añadir la conexión inversa para grafo dirigido
    }

    /**
     * Imprime el grafo mostrando cada vértice y su lista de adyacencia.
     */
    public void printGraph() {
        // Itera sobre cada vértice en el mapa de adyacencias
        for (String vertex : adjList.keySet()) {
            // Imprime el vértice y luego la lista de nodos a los que está conectado
            System.out.print(vertex + " -> ");
            System.out.println(adjList.get(vertex));
        }
    }

    /**
     * ACTIVIDAD 4:
     * Realiza una búsqueda en anchura (BFS) desde el nodo de inicio proporcionado.
     * @param start El nodo desde el cual comenzar la BFS.
     */
    public void bfs(String start) {
        // Conjunto para rastrear nodos visitados
        Set<String> visited = new HashSet<>();

        // Cola para manejar el orden de los nodos en BFS
        Queue<String> queue = new LinkedList<>();

        // Añade el nodo inicial a la cola y lo marca como visitado
        queue.add(start);
        visited.add(start);

        // Bucle para procesar cada nodo en la cola
        while (!queue.isEmpty()) {
            // Extrae el nodo de la cola y lo imprime
            String node = queue.poll();
            System.out.print(node + " ");

            // Recorre los vecinos del nodo actual
            for (String neighbor : adjList.get(node)) {
                // Solo añade vecinos no visitados a la cola
                if (!visited.contains(neighbor)) {
                    queue.add(neighbor);
                    visited.add(neighbor);
                }
            }
        }
    }

    /**
     * ACTIVIDAD 5:
     * Realiza una búsqueda en profundidad (DFS) desde el nodo de inicio.
     * @param start El nodo desde el cual se comienza la DFS.
     * @param visited Conjunto que rastrea los nodos visitados.
     */
    public void dfs(String start, Set<String> visited) {
        // Marca el nodo actual como visitado e imprime su valor
        visited.add(start);
        System.out.print(start + " ");

        // Recorre cada vecino del nodo actual
        for (String neighbor : adjList.get(start)) {
            // Solo llama recursivamente a los vecinos no visitados
            if (!visited.contains(neighbor)) {
                dfs(neighbor, visited);
            }
        }
    }

    public static void main(String[] args) {
        // Ejemplo de uso del grafo
        Graph graph = new Graph();

        /*
         * ACTIVIDAD 1
         */
        // Añadiendo aristas
        graph.addEdge("A", "B");
        graph.addEdge("A", "C");
        graph.addEdge("B", "C");
        graph.addEdge("C", "D");

        // Imprime la representación del grafo
        graph.printGraph();

        System.out.println("-----------------------------------");

        /*
         * ACTIVIDAD 2
         */
        Graph graphAddressed = new Graph();
        graphAddressed.addDirectedEdge("Usuario 1", "Usuario 2");
        graphAddressed.addDirectedEdge("Usuario 1", "Usuario 3");
        graphAddressed.addDirectedEdge("Usuario 2", "Usuario 4");
        graphAddressed.addDirectedEdge("Usuario 3", "Usuario 2");
        graphAddressed.addDirectedEdge("Usuario 3", "Usuario 4");
        graphAddressed.addDirectedEdge("Usuario 4", "");
        graphAddressed.printGraph();

        System.out.println("-----------------------------------");

        /*
         * ACTIVIDAD 4
         */
        System.out.print("BFS desde A: ");
        graph.bfs("A");

        System.out.println("\n-----------------------------------");

        /*
         * ACTIVIDAD 5
         */
        Set<String> visited = new HashSet<>();
        System.out.print("DFS desde A: ");
        graph.dfs("A", visited);
    }
}