package Clase1;

import java.util.ArrayList;
import java.util.Scanner;
//PARTE 1 Y 2
public class Taller {

    public static void main(String[] args) {
        Taller taller = new Taller();
        ArrayList<String> listaNombres = taller.agregarNombres();
        taller.leerNombres(listaNombres);
        taller.buscarNombre(listaNombres);
        taller.eliminarNombre(listaNombres);
    }

    // Método para agregar nombres a una lista
    public ArrayList<String> agregarNombres() {
        ArrayList<String> listaNombres = new ArrayList<>(); // Crear una nueva lista de nombre
        Scanner scanner = new Scanner(System.in); // Crear un objeto Scanner para leer la entrada del usuario
        boolean seguir = true; // Variable booleana para controlar el bucle
        int nNOmbres = 0; // Contador para el número de nombres ingresados

        // Bucle que se ejecuta mientras 'seguir' sea verdadero
        while (seguir) {
            System.out.println("Ingrese el nombre:"); // Solicitar al usuario que ingrese un nombre
            String nombre = scanner.nextLine(); // Leer el nombre ingresado por el usuario
            listaNombres.add(nombre); // Agregar el nombre a la lista
            nNOmbres++; // Incrementar el contador de nombres ingresados
            // Verificar si se ha alcanzado el mínimo de 5 nombres
            if (nNOmbres >= 5) {

                System.out.println("Ha alcanzado el mínimo de nombres a agregar (5)."); // Informar al usuario que ha alcanzado el mínimo de nombres
                System.out.println("¿Desea agregar otro nombre? (si/no)");
                String deseo = scanner.nextLine(); // Leer la respuesta del usuario
                // Si el usuario desea agregar otro nombre, continuar
                if (deseo.equals("si")) {
                    seguir = true;
                } else {
                    // De lo contrario, terminar el bucle
                    seguir = false;
                }
            }
        }
        return listaNombres; // Devolver la lista de nombres
    }

    // Método para leer y mostrar los nombres de una lista
    public void leerNombres(ArrayList<String> listaNombres) {
        System.out.println("Nombres de la lista:");
        // Bucle for-each para recorrer e imprimir la lista de nombres
        for (String nombres: listaNombres) {
            System.out.println(nombres + ",");
        }
    }

    public void buscarNombre(ArrayList<String> listaNombres) {
        // Crear un objeto Scanner para leer la entrada del usuario
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese el nombre a buscar en la lista:");

        // Leer el nombre que el usuario quiere buscar
        String nombreBuscado = scanner.nextLine();

        // Recorrer la lista de nombres
        for (String nombres : listaNombres) {
            // Comparar cada nombre en la lista con el nombre buscado
            if (nombres.equals(nombreBuscado)) {
                System.out.println("El nombre fue encontrado.");
                return;  // Salir del método si el nombre es encontrado
            }
        }

        // Si el nombre no fue encontrado, informar al usuario
        System.out.println("El nombre no fue encontrado.");
        System.out.println("Desea agregar este nombre a la lista (si/no)");

        // Leer la respuesta del usuario
        String deseo = scanner.nextLine();

        // Si el usuario desea agregar el nombre, agregarlo a la lista
        if (deseo.equals("si")) {
            listaNombres.add(nombreBuscado);

            // Llamar al método leerNombres para mostrar la lista actualizada
            leerNombres(listaNombres);
            System.out.println("Se ha agregado con éxito.");
        } else {
            return;  // Salir del método si el usuario no quiere agregar el nombre
        }
    }


    public void eliminarNombre(ArrayList<String> listaNombres) {
        // Crear un objeto Scanner para leer la entrada del usuario
        Scanner scanner = new Scanner(System.in);
        System.out.println("Que nombre desea eliminar:");

        // Leer el nombre que el usuario quiere eliminar
        String nombreEliminar = scanner.nextLine();

        // Recorrer la lista de nombres
        for (String nombres : listaNombres) {
            // Comparar cada nombre en la lista con el nombre a eliminar
            if (nombreEliminar.equals(nombres)) {
                listaNombres.remove(nombres);  // Eliminar el nombre de la lista

                // Llamar al método leerNombres para mostrar la lista actualizada
                leerNombres(listaNombres);
                System.out.println("Se ha eliminado con éxito.");
                return;  // Salir del método si el nombre es eliminado
            }
        }

        // Si el nombre no fue encontrado, informar al usuario
        System.out.println("El nombre no existe, por ende no se ha eliminado");
    }
}

