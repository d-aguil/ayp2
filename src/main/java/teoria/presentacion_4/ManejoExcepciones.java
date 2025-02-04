package teoria.presentacion_4;

import java.io.*;

public class ManejoExcepciones {
    public static void main(String[] args) {
        BufferedReader reader = null;

        try {
            // Intentar abrir un archivo para lectura
            reader = new BufferedReader(new FileReader("archivo.txt"));

            // Leer líneas del archivo
            String linea;
            System.out.println("Contenido del archivo:");
            while ((linea = reader.readLine()) != null) {
                System.out.println(linea);
            }
        } catch (FileNotFoundException e) {
            // Manejar el caso en que el archivo no existe
            System.out.println("Archivo no encontrado: " + e.getMessage());
        } catch (IOException e) {
            // Manejar otros errores de lectura/escritura
            System.out.println("Error de E/S: " + e.getMessage());
        } finally {
            // Cerrar el archivo en el bloque finally
            try {
                if (reader != null) {
                    reader.close();
                    System.out.println("Archivo cerrado correctamente.");
                }
            } catch (IOException e) {
                System.out.println("Error al cerrar el archivo: " + e.getMessage());
            }
        }
    }
}