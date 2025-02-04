package teoria.presentacion_4;

import java.io.*;

public class ArchivoSecuencial {
    public static void main(String[] args) {
        String ruta = "empleados.txt";

        // Escritura en el archivo (organización secuencial)
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(ruta))) {
            writer.write("1,Juan,30");
            writer.newLine();
            writer.write("2,María,25");
            writer.newLine();
            writer.write("3,Pedro,40");
        } catch (IOException e) {
            System.out.println("Error al escribir en el archivo: " + e.getMessage());
        }

        // Lectura del archivo (organización secuencial)
        try (BufferedReader reader = new BufferedReader(new FileReader(ruta))) {
            String linea;
            System.out.println("Leyendo empleados secuencialmente:");
            while ((linea = reader.readLine()) != null) {
                String[] datos = linea.split(",");
                int id = Integer.parseInt(datos[0]);
                String nombre = datos[1];
                int edad = Integer.parseInt(datos[2]);
                System.out.println("ID: " + id + ", Nombre: " + nombre + ", Edad: " + edad);
            }
        } catch (IOException e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
        }
    }
}