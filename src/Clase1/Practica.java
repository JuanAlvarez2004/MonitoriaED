package Clase1;

import java.util.ArrayList;
import java.util.Scanner;

//PARTE 3
public class Practica {

    // Método principal que se ejecuta al iniciar el programa
    public static void main(String[] args) {
        // Crear una instancia de la clase Practica
        Practica practica = new Practica();

        // Crear una lista para almacenar las tareas
        ArrayList<String> listaTareas = new ArrayList<>();

        // Bucle infinito para mostrar el menú y realizar operaciones basadas en la opción ingresada por el usuario
        while (true) {
            Scanner scanner = new Scanner(System.in);  // Crear un objeto Scanner para leer la entrada del usuario

            // Mostrar el menú de opciones
            System.out.println("\n================ MENÚ ==============" +
                    "\n1. Agregar Tarea." +
                    "\n2. Eliminar Tarea." +
                    "\n3. Mostrar Tareas." +
                    "\n4. Salir." +
                    "\n======================================");
            System.out.println("Ingrese la opción:");

            // Leer la opción ingresada por el usuario
            int opcion = scanner.nextInt();

            // Evaluar la opción ingresada utilizando un switch
            switch (opcion) {
                case 1:
                    // Llamar al método agregarTarea si la opción es 1
                    practica.agregarTarea(listaTareas);
                    break;
                case 2:
                    // Llamar al método eliminarTarea si la opción es 2
                    practica.eliminarTarea(listaTareas);
                    break;
                case 3:
                    // Llamar al método leerTareas si la opción es 3
                    practica.leerTareas(listaTareas);
                    break;
                case 4:
                    // Imprimir mensaje y salir del programa si la opción es 4
                    System.out.println("Saliendo...");
                    return;  // Termina el método main, y por ende, el programa
                default:
                    // Imprimir mensaje si la opción ingresada no es válida
                    System.out.println("La opción ingresada es incorrecta.");
                    break;
            }
        }
    }

    // Método para agregar una tarea a la lista
    public void agregarTarea(ArrayList<String> listaTareas) {
        Scanner scanner = new Scanner(System.in);  // Crear un objeto Scanner para leer la entrada del usuario
        System.out.println("Ingrese la tarea:");

        // Leer la tarea ingresada por el usuario
        String tarea = scanner.nextLine();

        // Agregar la tarea a la lista
        listaTareas.add(tarea);
    }

    // Método para mostrar las tareas en la lista
    public void leerTareas(ArrayList<String> listaTareas) {
        System.out.println("Tareas:");
        int nTarea = 1;  // Contador para numerar las tareas

        // Recorrer la lista de tareas e imprimir cada una con su número correspondiente
        for (String tareas : listaTareas) {
            System.out.println(nTarea + ". " + tareas);
            nTarea++;
        }
    }

    // Método para eliminar una tarea de la lista
    public void eliminarTarea(ArrayList<String> listaTareas) {
        Scanner scanner = new Scanner(System.in);  // Crear un objeto Scanner para leer la entrada del usuario
        System.out.println("Número de tarea a eliminar:");

        // Mostrar las tareas actuales antes de pedir el número de tarea a eliminar
        leerTareas(listaTareas);

        // Leer el número de tarea a eliminar ingresado por el usuario
        int tareaEliminar = scanner.nextInt();

        // Eliminar la tarea correspondiente (se resta 1 porque las listas son indexadas desde 0)
        listaTareas.remove(tareaEliminar - 1);

        // Imprimir mensaje de éxito
        System.out.println("La tarea se ha eliminado con éxito");
    }
}

