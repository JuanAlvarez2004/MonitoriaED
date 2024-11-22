# =================== EJERCICIO 1: TABLA HASH PERSONALIZADA ===================
class HashTable:
    """Ejercicio 1: Tabla Hash con función hash basada en longitud de clave"""
    
    def __init__(self, size):
        self.size = size
        self.table = [None] * size
        self.num_items = 0

    def hash_function(self, key):
        return len(str(key)) % self.size

    def insert(self, key, value):
        index = self.hash_function(key)
        if not self.table[index]:
            self.table[index] = []
        
        for i, (k, v) in enumerate(self.table[index]):
            if k == key:
                self.table[index][i] = (key, value)
                return
        
        self.table[index].append((key, value))
        self.num_items += 1

    def search(self, key):
        index = self.hash_function(key)
        if self.table[index]:
            for k, v in self.table[index]:
                if k == key:
                    return v
        return None

    def __str__(self):
        return '\n'.join([f"{i}: {bucket}" for i, bucket in enumerate(self.table) if bucket])

# =================== EJERCICIO 2: ANÁLISIS DE COLISIONES ===================
class HashTableChaining:
    """Implementación con resolución de colisiones por encadenamiento"""
    
    def __init__(self, size):
        self.size = size
        self.table = [None] * size
        self.collision_count = 0

    def hash_function(self, key):
        return sum(ord(c) for c in str(key)) % self.size

    def insert(self, key, value):
        index = self.hash_function(key)
        if self.table[index] is not None:
            self.collision_count += 1
        if not self.table[index]:
            self.table[index] = []
        self.table[index].append((key, value))

    def __str__(self):
        return f"Colisiones totales: {self.collision_count}\n" + \
               '\n'.join([f"{i}: {bucket}" for i, bucket in enumerate(self.table) if bucket])

class HashTableOpenAddressing:
    """Implementación con resolución de colisiones por direccionamiento abierto"""
    
    def __init__(self, size):
        self.size = size
        self.table = [None] * size
        self.collision_count = 0

    def hash_function(self, key):
        return sum(ord(c) for c in str(key)) % self.size

    def insert(self, key, value):
        index = self.hash_function(key)
        original_index = index

        while True:
            if self.table[index] is None:
                self.table[index] = (key, value)
                return
            self.collision_count += 1
            index = (index + 1) % self.size
            if index == original_index:
                raise Exception("Tabla llena")

    def __str__(self):
        return f"Colisiones totales: {self.collision_count}\n" + \
               '\n'.join([f"{i}: {item}" for i, item in enumerate(self.table) if item])

# =================== EJERCICIO 3: SISTEMA DE AUTOCOMPLETADO ===================
class HashTableAutocomplete:
    """Sistema de autocompletado usando tabla hash"""
    
    def __init__(self, size):
        self.size = size
        self.table = [None] * size

    def hash_function(self, key):
        return sum(ord(c) for c in key) % self.size

    def insert(self, word):
        index = self.hash_function(word)
        if not self.table[index]:
            self.table[index] = []
        if word not in self.table[index]:
            self.table[index].append(word)

    def search(self, prefix):
        results = []
        for bucket in self.table:
            if bucket:
                results.extend([word for word in bucket if word.startswith(prefix)])
        return sorted(results)

    def __str__(self):
        return '\n'.join([f"{i}: {bucket}" for i, bucket in enumerate(self.table) if bucket])

# =================== EJERCICIO 4: CONTADOR DE FRECUENCIA DE PALABRAS ===================
class WordFrequencyCounter:
    """Contador de frecuencia de palabras usando tabla hash"""
    
    def __init__(self, size=100):
        self.size = size
        self.table = [None] * size

    def hash_function(self, word):
        return sum(ord(c) for c in word) % self.size

    def increment_count(self, word):
        index = self.hash_function(word)
        if not self.table[index]:
            self.table[index] = []
        
        for i, (w, count) in enumerate(self.table[index]):
            if w == word:
                self.table[index][i] = (word, count + 1)
                return
        
        self.table[index].append((word, 1))

    def get_frequencies(self):
        frequencies = {}
        for bucket in self.table:
            if bucket:
                for word, count in bucket:
                    frequencies[word] = count
        return frequencies

    def process_text(self, text):
        words = text.lower().split()
        for word in words:
            self.increment_count(word)
        return self.get_frequencies()

    def __str__(self):
        return str(self.get_frequencies())

# =================== FUNCIONES DE PRUEBA ===================
def test_ejercicio1():
    """Prueba la implementación básica de la tabla hash"""
    print("\n=== Test Ejercicio 1: Tabla Hash Básica ===")
    ht = HashTable(5)
    
    # Insertar elementos
    test_data = [("uno", 1), ("dos", 2), ("tres", 3), ("cuatro", 4)]
    for key, value in test_data:
        ht.insert(key, value)
    
    # Mostrar resultados
    print("Contenido de la tabla:")
    print(ht)
    print("\nBúsquedas:")
    print(f"Búsqueda 'uno': {ht.search('uno')}")
    print(f"Búsqueda 'cinco' (no existe): {ht.search('cinco')}")

def test_ejercicio2():
    """Prueba los métodos de resolución de colisiones"""
    print("\n=== Test Ejercicio 2: Análisis de Colisiones ===")
    
    # Datos de prueba
    test_data = ["apple", "banana", "grape", "pear", "peach", "cherry"]
    
    # Probar encadenamiento
    print("\nMétodo de Encadenamiento:")
    ht_chain = HashTableChaining(4)
    for item in test_data:
        ht_chain.insert(item, len(item))
    print(ht_chain)
    
    # Probar direccionamiento abierto
    print("\nMétodo de Direccionamiento Abierto:")
    ht_open = HashTableOpenAddressing(8)
    try:
        for item in test_data:
            ht_open.insert(item, len(item))
        print(ht_open)
    except Exception as e:
        print(f"Error: {e}")

def test_ejercicio3():
    """Prueba el sistema de autocompletado"""
    print("\n=== Test Ejercicio 3: Sistema de Autocompletado ===")
    auto = HashTableAutocomplete(10)
    
    # Insertar palabras de prueba
    test_words = ["apple", "application", "append", "banana", "ball", "cat"]
    for word in test_words:
        auto.insert(word)
    
    # Probar búsquedas
    print("\nContenido de la tabla:")
    print(auto)
    print("\nBúsquedas por prefijo:")
    print(f"Prefijo 'app': {auto.search('app')}")
    print(f"Prefijo 'ba': {auto.search('ba')}")
    print(f"Prefijo 'x' (no existe): {auto.search('x')}")

def test_ejercicio4():
    """Prueba el contador de frecuencia de palabras"""
    print("\n=== Test Ejercicio 4: Contador de Frecuencia de Palabras ===")
    counter = WordFrequencyCounter()
    
    # Texto de prueba
    texto = "gato perro perro gato ratón perro gato perro elefante"
    
    # Procesar texto y mostrar resultados
    frequencies = counter.process_text(texto)
    print("\nTexto analizado:", texto)
    print("\nFrecuencia de palabras:")
    print(counter)

def run_all_tests():
    """Ejecuta todas las pruebas de los ejercicios"""
    test_ejercicio1()
    test_ejercicio2()
    test_ejercicio3()
    test_ejercicio4()

# =================== FUNCIÓN PRINCIPAL ===================
def main():
    """Función principal que ejecuta todos los tests"""
    print("=== INICIANDO PRUEBAS DE TABLAS HASH ===")
    run_all_tests()
    print("\n=== PRUEBAS COMPLETADAS ===")

if __name__ == "__main__":
    main()