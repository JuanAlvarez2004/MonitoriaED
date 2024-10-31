package Clase10;

import java.util.HashMap;
import java.util.Map;

/*
 * ACTIVIDAD 3
 */
public class WeightedGraph {
    // Mapa para almacenar la lista de adyacencia de cada vértice con sus pesos
    private Map<String, Map<String, Integer>> adjList;

    // Constructor: Inicializa adjList como un HashMap vacío
    public WeightedGraph() {
        adjList = new HashMap<>();
    }

    /**
     * Añade una arista ponderada entre dos vértices en el grafo no dirigido.
     * @param src  Vértice de origen
     * @param dest Vértice de destino
     * @param weight Peso de la arista
     */
    public void addEdge(String src, String dest, int weight) {
        // Si el vértice de origen no existe en el mapa, se añade con un mapa vacío.
        // Luego se agrega el vértice de destino al mapa interno con el peso especificado.
        adjList.computeIfAbsent(src, k -> new HashMap<>()).put(dest, weight);

        // Para el grafo no dirigido, se añade la arista en la dirección inversa.
        adjList.computeIfAbsent(dest, k -> new HashMap<>()).put(src, weight);
    }

    /**
     * Imprime el grafo mostrando cada vértice y su lista de adyacencia con los pesos.
     */
    public void printGraph() {
        // Itera sobre cada vértice en el mapa de adyacencias
        for (String vertex : adjList.keySet()) {
            // Imprime el vértice y luego el mapa de nodos conectados con sus pesos
            System.out.print(vertex + " -> ");
            System.out.println(adjList.get(vertex));
        }
    }

    public static void main(String[] args) {
        // Ejemplo de uso del grafo ponderado
        WeightedGraph grafoPonderado = new WeightedGraph();

        // Añadiendo aristas con pesos
        grafoPonderado.addEdge("A", "B", 10);
        grafoPonderado.addEdge("A", "C", 15);
        grafoPonderado.addEdge("B", "C", 5);
        grafoPonderado.addEdge("B", "D", 20);
        grafoPonderado.addEdge("C", "D", 30);

        // Imprime la representación del grafo
        grafoPonderado.printGraph();
    }
}



