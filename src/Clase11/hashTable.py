# ============= EJERCICIO 1: Implementación Básica =============
class HashTable:
    def __init__(self, size=10):  # Cumple con el requisito de tamaño 10
        """Implementación del Ejercicio 1: Tabla hash básica con tamaño 10"""
        self.size = size
        self.table = [None] * size

    def hash_function(self, key):
        """Ejercicio 1: Función hash sencilla basada en módulo"""
        return hash(key) % self.size  # Función hash básica usando módulo

    # Métodos básicos requeridos en Ejercicio 1
    def insert(self, key, value):
        index = self.hash_function(key)
        if self.table[index] is None:
            self.table[index] = []
        
        # Actualizar valor si la clave existe
        for i, (k, v) in enumerate(self.table[index]):
            if k == key:
                self.table[index][i] = (key, value)
                return
        
        self.table[index].append((key, value))

    def retrieve(self, key):
        index = self.hash_function(key)
        if self.table[index] is not None:
            for k, v in self.table[index]:
                if k == key:
                    return v
        return None

    # ============= EJERCICIO 2: Resolución de Colisiones con Encadenamiento =============
    # El encadenamiento está implementado en los métodos insert y retrieve
    # usando listas enlazadas (representadas como listas de Python) en cada índice
    
    # ============= EJERCICIO 3: Direccionamiento Abierto =============
    def insert_linear_probing(self, key, value):
        """Ejercicio 3: Implementación de direccionamiento abierto con sondeo lineal"""
        index = self.hash_function(key)
        original_index = index
        
        while True:
            # Si encontramos un espacio vacío o la misma clave
            if self.table[index] is None or self.table[index][0][0] == key:
                self.table[index] = [(key, value)]
                return
            
            # Sondeo lineal: moverse al siguiente espacio
            index = (index + 1) % self.size
            
            # Si hemos dado la vuelta completa, la tabla está llena
            if index == original_index:
                raise Exception("Tabla hash llena")

    def retrieve_linear_probing(self, key):
        """Ejercicio 3: Búsqueda con sondeo lineal"""
        index = self.hash_function(key)
        original_index = index
        
        while True:
            # Si el espacio está vacío, el elemento no existe
            if self.table[index] is None:
                return None
            
            # Si encontramos la clave
            if self.table[index][0][0] == key:
                return self.table[index][0][1]
            
            # Sondeo lineal: moverse al siguiente espacio
            index = (index + 1) % self.size
            
            # Si hemos dado la vuelta completa, el elemento no existe
            if index == original_index:
                return None

# ============= DESAFÍO FINAL: Contador de Frecuencia de Palabras =============
def contar_frecuencia_palabras(texto):
    """
    Desafío Final: Utiliza la tabla hash para contar frecuencia de palabras
    """
    import string
    
    # Preprocesamiento del texto
    texto = texto.lower()
    texto = texto.translate(str.maketrans('', '', string.punctuation))
    palabras = texto.split()
    
    # Crear tabla hash para el conteo
    frecuencias = HashTable(len(palabras))
    
    # Contar frecuencias
    for palabra in palabras:
        freq_actual = frecuencias.retrieve(palabra) or 0
        frecuencias.insert(palabra, freq_actual + 1)
    
    return frecuencias

# Ejemplos de uso para todos los ejercicios
def ejecutar_ejemplos():
    # Ejemplo Ejercicio 1 y 2 (Tabla básica con encadenamiento)
    print("=== Ejemplos Ejercicio 1 y 2 ===")
    ht = HashTable(10)
    ht.insert("clave1", "valor1")
    ht.insert("clave2", "valor2")
    print(f"Valor de clave1: {ht.retrieve('clave1')}")

    # Ejemplo Ejercicio 3 (Direccionamiento abierto)
    print("\n=== Ejemplo Ejercicio 3 ===")
    ht_linear = HashTable(10)
    ht_linear.insert_linear_probing("clave1", "valor1")
    ht_linear.insert_linear_probing("clave2", "valor2")
    print(f"Valor de clave2: {ht_linear.retrieve_linear_probing('clave2')}")

    # Ejemplo Desafío Final
    print("\n=== Ejemplo Desafío Final ===")
    texto = "el gato come pescado y el perro come carne"
    freq = contar_frecuencia_palabras(texto)
    print("Frecuencia de palabras:")
    print(freq)

if __name__ == "__main__":
    ejecutar_ejemplos()