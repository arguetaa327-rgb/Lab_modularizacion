package introduccion;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    // Variables globales (estado del programa)
    static List<String> estudiantes = new ArrayList<>();
    static List<Double> calificaciones = new ArrayList<>();
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        System.out.println("Bienvenido al sistema de gestión de estudiantes.");

        int opcion = 0;

        while (opcion != 5) {
            mostrarMenu();
            opcion = leerOpcion(); // aquí ya valida que sea número

            switch (opcion) {
                case 1:
                    agregarEstudiante();
                    break;

                case 2:
                    mostrarEstudiantes();
                    break;

                case 3:
                    calcularPromedio();
                    break;

                case 4:
                    mostrarMejorEstudiante();
                    break;

                case 5:
                    System.out.println("Saliendo del sistema...");
                    break;

                default:
                    System.out.println("Opción no válida. Debe intentar nuevamente.");
            }
        }

        scanner.close();
    }

    // Método para mostrar el menú
    public static void mostrarMenu() {
        System.out.println("\n1. Agregar estudiante");
        System.out.println("2. Mostrar lista de estudiantes");
        System.out.println("3. Calcular promedio de calificaciones");
        System.out.println("4. Mostrar estudiante con la calificación más alta");
        System.out.println("5. Salir");
        System.out.print("Seleccione una opción: ");
    }

    // Método para leer opción con validación (no deja avanzar hasta que sea número)
    public static int leerOpcion() {
        while (true) {
            String entrada = scanner.nextLine().trim();

            try {
                return Integer.parseInt(entrada);
            } catch (NumberFormatException e) {
                System.out.print("Error: Debe ingresar un número. Intente otra vez: ");
            }
        }
    }

    // Método para agregar estudiante (validación de nombre + calificación en rango)
    public static void agregarEstudiante() {

        // Validar que el nombre no sea vacío
        String nombre;
        do {
            System.out.print("Ingrese el nombre del estudiante: ");
            nombre = scanner.nextLine().trim();

            if (nombre.isEmpty()) {
                System.out.println("El nombre no puede ir vacío.");
            }
        } while (nombre.isEmpty());

        // Leer calificación con validación (número + rango)
        double calificacion;

        while (true) {
            System.out.print("Ingrese la calificación del estudiante (0-100): ");
            String entrada = scanner.nextLine().trim();

            try {
                calificacion = Double.parseDouble(entrada);

                if (calificacion < 0 || calificacion > 100) {
                    System.out.println("La calificación debe estar entre 0 y 100.");
                    continue;
                }

                break; // ya es válida

            } catch (NumberFormatException e) {
                System.out.println("Error: Debe ingresar un número válido (ej: 85 o 85.5).");
            }
        }

        estudiantes.add(nombre);
        calificaciones.add(calificacion);

        System.out.println("El estudiante fue agregado correctamente.");
    }

    // Método para mostrar estudiantes
    public static void mostrarEstudiantes() {

        if (estudiantes.isEmpty()) {
            System.out.println("No hay estudiantes registrados.");
            return;
        }

        System.out.println("\nLista de estudiantes:");

        for (int i = 0; i < estudiantes.size(); i++) {
            System.out.println(estudiantes.get(i) + " - Calificación: " + calificaciones.get(i));
        }
    }

    // Método para calcular promedio
    public static void calcularPromedio() {

        if (calificaciones.isEmpty()) {
            System.out.println("No hay calificaciones registradas.");
            return;
        }

        double suma = 0;

        for (double c : calificaciones) {
            suma += c;
        }

        double promedio = suma / calificaciones.size();

        // Más bonito: 2 decimales
        System.out.printf("El promedio de calificaciones es: %.2f%n", promedio);
    }

    // Método para mostrar estudiante con mejor calificación
    public static void mostrarMejorEstudiante() {

        if (calificaciones.isEmpty()) {
            System.out.println("No hay estudiantes registrados.");
            return;
        }

        double maxCalificacion = calificaciones.get(0);
        String estudianteMax = estudiantes.get(0);

        for (int i = 1; i < calificaciones.size(); i++) {
            if (calificaciones.get(i) > maxCalificacion) {
                maxCalificacion = calificaciones.get(i);
                estudianteMax = estudiantes.get(i);
            }
        }

        System.out.println("El estudiante con la calificación más alta es: "
                + estudianteMax + " con " + maxCalificacion);
    }
}