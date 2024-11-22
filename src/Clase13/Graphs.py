from collections import defaultdict, deque
from typing import List, Set, Dict, Tuple
import heapq

class Graph:
    def __init__(self, directed=False):
        self.graph = defaultdict(list)
        self.weights = {}
        self.directed = directed
    
    def add_edge(self, u: str, v: str, weight: int = 1):
        # Asegurarnos de que ambos vértices existan en el grafo
        self.graph[u].append(v)
        self.weights[(u,v)] = weight
        # Si el grafo no es dirigido, añadir la arista en ambas direcciones
        if not self.directed:
            self.graph[v].append(u)
            self.weights[(v,u)] = weight
        # Inicializar una lista vacía para el vértice v si no existe
        if v not in self.graph:
            self.graph[v] = []
    
    def dfs(self, start: str) -> List[str]:
        visited = set()
        path = []
        
        def dfs_recursive(vertex):
            visited.add(vertex)
            path.append(vertex)
            for neighbor in self.graph[vertex]:
                if neighbor not in visited:
                    dfs_recursive(neighbor)
        
        dfs_recursive(start)
        return path
    
    def bfs(self, start: str) -> List[str]:
        visited = set([start])
        queue = deque([start])
        path = []
        
        while queue:
            vertex = queue.popleft()
            path.append(vertex)
            for neighbor in self.graph[vertex]:
                if neighbor not in visited:
                    visited.add(neighbor)
                    queue.append(neighbor)
        return path
    
    def has_cycle(self) -> bool:
        visited = set()
        rec_stack = set()
        
        def dfs_cycle(vertex):
            visited.add(vertex)
            rec_stack.add(vertex)
            
            for neighbor in self.graph[vertex]:
                if neighbor not in visited:
                    if dfs_cycle(neighbor):
                        return True
                elif neighbor in rec_stack:
                    return True
            
            rec_stack.remove(vertex)
            return False
        
        for vertex in self.graph:
            if vertex not in visited:
                if dfs_cycle(vertex):
                    return True
        return False
    
    def dijkstra(self, start: str) -> Dict[str, float]:
        # Inicializar todas las distancias como infinito
        distances = {vertex: float('infinity') for vertex in self.graph.keys()}
        distances[start] = 0
        pq = [(0, start)]
        
        while pq:
            current_distance, current_vertex = heapq.heappop(pq)
            
            if current_distance > distances[current_vertex]:
                continue
                
            for neighbor in self.graph[current_vertex]:
                weight = self.weights[(current_vertex, neighbor)]
                distance = current_distance + weight
                
                if distance < distances[neighbor]:
                    distances[neighbor] = distance
                    heapq.heappush(pq, (distance, neighbor))
        
        return distances

    def get_degree(self, vertex: str) -> int:
        return len(self.graph[vertex])
    
    def print_adjacency_list(self):
        for vertex in sorted(self.graph.keys()):  # Ordenamos las claves para una mejor presentación
            print(f"{vertex}: {sorted(self.graph[vertex])}")

def main():
    print("\n" + "="*50)
    print("RESULTADOS DEL TALLER DE GRAFOS")
    print("="*50)

    # Ejercicio 1: Representación de Grafos
    print("\nEjercicio 1: Representación de Grafos")
    print("-"*30)
    
    # Matriz de Adyacencia
    print("\nMatriz de Adyacencia:")
    matriz = [
        [0, 1, 1, 0],
        [1, 0, 1, 0],
        [1, 1, 0, 1],
        [0, 0, 1, 0]
    ]
    nodos = ['A', 'B', 'C', 'D']
    print("   " + "  ".join(nodos))
    for i, fila in enumerate(matriz):
        print(f"{nodos[i]}  {fila}")

    # Lista de Adyacencia
    print("\nLista de Adyacencia:")
    g = Graph(directed=False)
    g.add_edge('A', 'B')
    g.add_edge('A', 'C')
    g.add_edge('B', 'C')
    g.add_edge('C', 'D')
    g.print_adjacency_list()

    # Ejercicio 2: Implementación
    print("\nEjercicio 2: Implementación del Grafo")
    print("-"*30)
    print("Grafo creado con las siguientes conexiones:")
    g.print_adjacency_list()

    # Ejercicio 3: Recorridos
    print("\nEjercicio 3: Recorridos")
    print("-"*30)
    print(f"Recorrido DFS desde A: {g.dfs('A')}")
    print(f"Recorrido BFS desde A: {g.bfs('A')}")

    # Ejercicio 4: Detectar Ciclos
    print("\nEjercicio 4: Detección de Ciclos")
    print("-"*30)
    tiene_ciclo = g.has_cycle()
    print(f"¿El grafo tiene ciclos?: {tiene_ciclo}")
    print(f"Explicación: {'Hay un ciclo A-B-C-A' if tiene_ciclo else 'No hay ciclos'}")

    # Ejercicio 5: Dijkstra
    print("\nEjercicio 5: Algoritmo de Dijkstra")
    print("-"*30)
    g_weighted = Graph(directed=True)
    g_weighted.add_edge('A', 'B', 4)
    g_weighted.add_edge('A', 'C', 2)
    g_weighted.add_edge('B', 'C', 5)
    g_weighted.add_edge('B', 'D', 10)
    g_weighted.add_edge('C', 'D', 3)
    g_weighted.add_edge('D', 'E', 1)

    distances = g_weighted.dijkstra('A')
    print("Distancias más cortas desde el nodo A:")
    for node, distance in sorted(distances.items()):
        print(f"A -> {node}: {distance}")

    # Parte 3: Aplicaciones Prácticas
    print("\nParte 3: Aplicaciones Prácticas")
    print("-"*30)
    
    # Redes Sociales
    print("\nRedes Sociales:")
    most_popular = max(g.graph.keys(), key=lambda x: g.get_degree(x))
    print(f"Nodo más popular: {most_popular} con {g.get_degree(most_popular)} conexiones")

    # Mapas
    print("\nMapas:")
    ruta_mas_corta = find_shortest_route(g_weighted, 'A', 'E')
    print(f"Distancia más corta de A a E: {ruta_mas_corta}")

    print(""" -----------------------------------------
Parte 4: Evaluación

1.  Los principales tipos de grafos son:
    - No dirigidos: las aristas no tienen dirección
    - Dirigidos: las aristas tienen dirección
    - Ponderados: las aristas tienen pesos
    - No ponderados: todas las aristas tienen el mismo peso
    - Cíclicos: contienen al menos un ciclo
    - Acíclicos: no contienen ciclos

2.  La función del DFS ya está implementada como dfs().

3.  La función para calcular el grado ya está implementada como get_degree().

4.  Diferencias entre BFS y DFS:
    - BFS explora nivel por nivel, ideal para encontrar el camino más corto en grafos no ponderados
    - DFS explora hasta el final de cada rama antes de retroceder, ideal para explorar todas las posibles rutas
    - BFS usa más memoria pero garantiza el camino más corto
    - DFS usa menos memoria pero no garantiza el camino más corto
""")

def find_shortest_route(graph, start, end):
    distances = graph.dijkstra(start)
    return distances[end]

if __name__ == "__main__":
    main()