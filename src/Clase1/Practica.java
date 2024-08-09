package Clase1;

import java.util.ArrayList;
import java.util.Scanner;

//PARTE 3
public class Practica {

    public static void main(String[] args) {
        Practica practica = new Practica();
        ArrayList<String> listaTareas = new ArrayList<>();

        while (true) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("\n================ MENÚ ==============" + "\n1. Agregar Tarea." + "\n2. Eliminar Tarea." + "\n3. Mostrar Tareas." + "\n4. Salir." +"\n======================================");
            System.out.println("Ingrese la opción:");
            int opcion = scanner.nextInt();
            switch (opcion) {
                case 1:
                    practica.agregarTarea(listaTareas);
                    break;
                case 2:
                    practica.eliminarTarea(listaTareas);
                    break;
                case 3:
                    practica.leerTareas(listaTareas);
                    break;
                case 4:
                    System.out.println("Saliendo...");
                    return;
                default:
                    System.out.println("La opción ingresada es incorrecta.");
                    break;
            }
        }
    }

    public void agregarTarea(ArrayList<String> listaTareas) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese la tarea:");
        String tarea = scanner.nextLine();
        listaTareas.add(tarea);
    }

    public void leerTareas(ArrayList<String> listaTareas) {
        System.out.println("Tareas:");
        int nTarea = 1;
        for (String tareas: listaTareas) {
            System.out.println(nTarea + ". " + tareas);
            nTarea++;
        }
    }

    public void eliminarTarea(ArrayList<String> listaTareas) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Número de tarea a eliminar:");
        leerTareas(listaTareas);
        int tareaEliminar = scanner.nextInt();
        listaTareas.remove(tareaEliminar-1);
        System.out.println("La tarea se ha eliminado con éxito");
    }
}
