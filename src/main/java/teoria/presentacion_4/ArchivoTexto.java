package teoria.presentacion_4;

import java.io.*;

public class ArchivoTexto {
    public static void main(String[] args) {
        String ruta = "ejemplo.txt";

        // Escritura en el archivo
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(ruta))) {
            writer.write("Hola, mundo!");
            writer.newLine();
            writer.write("Este es un archivo de texto.");
        } catch (IOException e) {
            System.out.println("Error al escribir en el archivo: " + e.getMessage());
        }

        // Lectura del archivo
        try (BufferedReader reader = new BufferedReader(new FileReader(ruta))) {
            String linea;
            System.out.println("Contenido del archivo:");
            while ((linea = reader.readLine()) != null) {
                System.out.println(linea);
            }
        } catch (IOException e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
        }
    }
}