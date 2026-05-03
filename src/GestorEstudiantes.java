import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class GestorEstudiantes {

    // Calcula la nota media de un estudiante
    public static double calcularNotaMedia(Estudiante estudiante) {
        if (estudiante.getNotas() == null || estudiante.getNotas().length == 0) {
            throw new IllegalArgumentException("No se puede calcular la media: el estudiante no tiene notas");
        }
        double suma = 0;
        for (int i = 0; i <= estudiante.getNotas().length - 1; i++) {
            suma += estudiante.getNotas()[i];
        }
        return suma / estudiante.getNotas().length; // Error si el array está vacío
    }

    // Encuentra al estudiante con la mejor nota media
    public static Estudiante encontrarMejorEstudiante(Estudiante[] estudiantes) {
        Estudiante mejor = null;
        double mejorNota = -1;

        for (Estudiante estudiante : estudiantes) {
            try {
                double media = calcularNotaMedia(estudiante);
                if (media > mejorNota) {
                    mejorNota = media;
                    mejor = estudiante;
                }
            } catch (IllegalArgumentException e) {
                System.out.println(estudiante.getNombre() + " no entrará en el ranking al no tener notas.");
            }
        }
        return mejor;
    }

    // Guarda los resultados en un fichero
    /*public static void guardarResultados(Estudiante[] estudiantes, String rutaFichero) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(rutaFichero))) {
            for (Estudiante estudiante : estudiantes) {
                writer.write("Nombre: " + estudiante.getNombre() + ", Nota Media: " +
                        calcularNotaMedia(estudiante)); // Posible fallo si calcularNotaMedia lanza una excepción
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error al guardar el fichero: " + e.getMessage());
        }
    }*/
    public static void guardarResultados(Estudiante[] estudiantes, String rutaFichero) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(rutaFichero))) {
            for (Estudiante estudiante : estudiantes) {
                try {
                    double media = calcularNotaMedia(estudiante);
                    writer.write("Nombre: " + estudiante.getNombre() + ", Nota Media: " + media);
                } catch (IllegalArgumentException e) {
                    writer.write("Nombre: " + estudiante.getNombre() + ", Nota Media: Sin notas");
                    System.out.println(estudiante.getNombre() + " no tiene notas y se han metido en el fichero.");
                }
                writer.newLine();
            }
            System.out.println("Proceso de guardado finalizado.");
        } catch (IOException e) {
            System.out.println("Error al acceder al fichero: " + e.getMessage());
        }
    }
}